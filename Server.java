package MultiThreaded;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class Server {
    
    public Consumer<Socket> getConsumer(){
        return (clientSocket)->{
            try(PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(),true);
                BufferedReader fileReader = new BufferedReader(new FileReader("./test.txt"))
                ) {
                StringBuilder fileContent = new StringBuilder();
                String line;
                while ((line = fileReader.readLine()) != null) {
                    fileContent.append(line).append("\n");
                }
                toClient.println("File content:\n" + fileContent);
                toClient.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try {
                    clientSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }   
    
    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try(ServerSocket serverSocket = new ServerSocket(port);) {
            // serverSocket.setSoTimeout(10000);
            System.out.println("Server is running on port "+port);
            while(true){
                Socket acceptSocket = serverSocket.accept();
                executor.submit(()->server.getConsumer().accept(acceptSocket));
            }
        } catch (Exception e) {
            e.printStackTrace();    
        }finally {
            executor.shutdown();
        }
    }
}
