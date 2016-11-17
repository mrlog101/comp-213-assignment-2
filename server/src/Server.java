/**
 * Created by Simon on 11/11/2016.
 */
import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(34734);
            Socket connection = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);

            out.println("Welcome to server, enter EXIT to quit.");

            boolean done = false;

            while(!done){
                String line;
                while(!(line = in.readLine()).equals("EXIT")){
                    out.println(line);
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
