package MultiThreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    
    public Runnable getRunnable(){
        return () -> {
            int port = 8010;
            try {
                InetAddress address = InetAddress.getByName("localhost");
                try (Socket socket = new Socket(address, port);
                        PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    toServer.println("Hello from client " + socket.getLocalSocketAddress());
                    toServer.flush();
                    
                    String line = fromServer.readLine();
                    if (line != null) {
                        System.out.println("Response from the server: " + line);
                    } else {
                        System.out.println("Server closed the connection.");
                    }
                }
            } catch (Exception ex) {
                System.err.println("Error initializing client: " + ex.getMessage());
                ex.printStackTrace();
            }
        };
    }
    
    public static void main(String[] args) {
        Client client = new Client();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i = 0;i<100;i++){
            executor.submit(client.getRunnable());
        }
        executor.shutdown();
    }
}
