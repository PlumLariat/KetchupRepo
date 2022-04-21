import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {


    public static void main(String[] args) {
        try{
            // if we dont include other param it'll default to host machine which is what we want.
            ServerSocket serverSocket = new ServerSocket(6969);
            System.out.println("Server spawned and awaiting connections");
            // blocking call, program will hang until a connection is attempted on the port specified
            Socket socket = serverSocket.accept();
            System.out.println("Connection accepted from " + socket + "!");

            // get the connected socket's input stream
            InputStream inputStream = socket.getInputStream();
            // create an object input stream so we can read data from it.
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            // Read all messages sent.
            ArrayList<Message> messages = (ArrayList<Message>) objectInputStream.readObject();
            messages.forEach((msg)->System.out.println(msg.getText() + " type: " + msg.getType()));

            System.out.println("Closing Everything.");
            serverSocket.close();
            socket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
