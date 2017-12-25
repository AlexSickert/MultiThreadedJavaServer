package http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

/* Responds to the /test URI. */
class TestHandler implements HttpHandler {

    boolean debug = Boolean.getBoolean("test.debug");

    public void handle(HttpExchange exchange) throws IOException {


        if(http.TestServer.initTime == 0){
            http.TestServer.initTime = System.currentTimeMillis();
            TestServer.totalCounter = (long) 1;
        }else{
            TestServer.totalCounter += 1;
            Long diff = System.currentTimeMillis() - http.TestServer.initTime;
            double t = diff / 1000;
            double rate = TestServer.totalCounter / t;

            if(TestServer.tmpCounter > 1000){
                System.out.println("Execution rate: " + Double.toString(rate));
                TestServer.tmpCounter = 0;
            }else{
                TestServer.tmpCounter += 1;
            }
        }




        //System.out.println(this);  // ALWAYS SAME THREAD!
        long threadId = Thread.currentThread().getId();
        //System.out.println("Thread id in TestHandler: " + Long.toString(threadId));

        //String response = "RESPONSE AT " + System.currentTimeMillis() + " from thread id: " + Long.toString(threadId) ;
        String response = "Thread-" + Long.toString(threadId) ;

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.flush();
        os.close();
    }
}
