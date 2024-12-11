import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket;
    BufferedOutputStream out;
    public Client() throws Exception {
        System.out.println("print IP:");
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        System.out.println("print port:");
        int port = sc.nextInt();
        socket=new Socket(ip,port);
        SendMessage();
    }
    public void SendMessage() throws Exception {
        if(socket.isConnected()) {
            out = new BufferedOutputStream(socket.getOutputStream());
            while  (true) {

                System.out.println("send message");
                Scanner sc = new Scanner(System.in);
                String message = sc.nextLine();
                out.write(message.getBytes());
                out.close();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Client client = new Client();
    }
}
