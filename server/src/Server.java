/**
 * Created by Simon on 11/11/2016.
 */
import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args){
        class Client implements Runnable{
            Socket clientSocket;
            PrintWriter out;
            BufferedReader in;

            public Client(Socket clientSocket) throws IOException {
                this.clientSocket = clientSocket;
                this.out = new PrintWriter(clientSocket.getOutputStream(), true);
                this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }

            @Override
            public void run() {
                System.out.println("Hello");
                boolean done = false;

                try {
                    while(!done){
                        String line;
                        while(!(line = in.readLine()).equals("EXIT")){
                            out.println(line);
                        }
                        done = true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            Thread clientThread;
            ServerSocket serverSocket = new ServerSocket(34734);
            while(true){
                Socket clientSocket = serverSocket.accept();
                clientThread = new Thread(new Client(clientSocket));
                clientThread.run();
            }
//            ServerSocket serverSocket = new ServerSocket(34734);
//            Socket connection = serverSocket.accept();
//            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
//
//            out.println("Welcome to server, enter EXIT to quit.");
//
//            boolean done = false;
//
//            while(!done){
//                String line;
//                while(!(line = in.readLine()).equals("EXIT")){
//                    out.println(line);
//                    done = true;
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
