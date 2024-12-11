import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    BufferedReader reader;
    ServerSocket server;
    Socket socket;
    public Server() {}
    public void StartServer() throws Exception {
        System.out.println("Server started");
        server =new ServerSocket(8808);
        socket = server.accept();
        System.out.println("Client connected");
        reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        GetMessage();
    }
    public void GetMessage() throws Exception {
        while(true) {
            String message=reader.readLine();
            reader.close();
            System.out.println(message);
        }

    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.StartServer();
    }

}
