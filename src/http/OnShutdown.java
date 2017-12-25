package http;

/* Responds to a JVM shutdown by stopping the server. */
class OnShutdown extends Thread {
    public void run() {
        http.TestServer.shutdown();
    }
}