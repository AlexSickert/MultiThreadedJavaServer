# MultiThreadedJavaServer

A http server in Java - Multithreaded with a stress test using AJAX

For a project I need a Java HTTP server. Java offer a simple HTTP server but the examples I had were not multithreaded. So I searched for code examples and found a few. But what I missed then was a kind of s stress test to see how many parallel requests the server can handle and how they are distributed across the threads in the thread pool. This is what this server here is doing. The server itself starts by executing TestServ.java. Then, in browser just type http://localhost:8800/ The server will send a html/js file. You will see two buttons. A start button and a Stop button. Please open the console of the browser. Once you press start and wait a few seconds you see how the various thredas handle the requests and how many requests were handled and what the average request per second are. 




