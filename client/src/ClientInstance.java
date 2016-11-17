import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by GamerPC on 16/11/2016.
 */
public class ClientInstance {
    private final int PORT_NUMBER = 34734;
    private String serverAddress;
    private Socket connection;
    private PrintWriter output;
    private BufferedReader inputBuffer;

    public ClientInstance() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the address of the server you wish to connect to:");
        serverAddress = scanner.nextLine();
        connect();
        System.out.println(inputBuffer.readLine());
        String userInput = scanner.nextLine();
        while(!userInput.equals(null)){
            output.println(userInput);
            System.out.println(inputBuffer.readLine());
            userInput = scanner.nextLine();
        }
    }

    public void connect(){
        try{
            connection = new Socket(serverAddress, PORT_NUMBER);
            output = new PrintWriter(connection.getOutputStream(), true);
            inputBuffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
