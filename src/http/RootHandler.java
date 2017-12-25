package http;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;


public  class RootHandler implements HttpHandler {

    //        @Override
//        public void handle(HttpExchange he) throws IOException {
//            Logger.log("info", "in RootHandler");
//            String response = "<h1>Server start success if you see this message</h1>" + "<h1>Port: " + Main.port + "</h1><br><a href='./echoHeader'> link</a>";
//            he.sendResponseHeaders(200, response.length());
//            OutputStream os = he.getResponseBody();
//            os.write(response.getBytes());
//            os.close();
//        }
    @Override
    public void handle(HttpExchange he) throws IOException {

//            String response = "<h1>Server start success if you see this message</h1>" + "<h1>Port: " + Main.port + "</h1><br><a href='./echoHeader'> link</a>";
        FileActions u = new FileActions();
        String response = u.getFileAsString("C:\\Users\\alex\\IdeaProjects\\MultiTreadedServer\\src\\" + "client.html");
        //long threadId = Thread.currentThread().getId();
        //String response = "Thread-" + Long.toString(threadId) ;

        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();


        //System.out.println("Thread id in RootHandler: " + Long.toString(threadId));


    }

}
