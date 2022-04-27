import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    public static void main(String[] args){

        try {
            Socket socket = new Socket("localhost", 6969);
            System.out.println("Client connected.");

            // get the output stream from the socket
            OutputStream outputStream = socket.getOutputStream();
            // create object output stream, so we can send objects through the stream.
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            // make a bunch of messages
            ArrayList<Message> messages = new ArrayList<>();
            messages.add(new Message("Hello! Sent With a Type!", "Fuck"));
            messages.add(new Message("Hello! Sent Without a Type!"));

            System.out.println("Sending the messages to ServerSocket.");

            objectOutputStream.writeObject(messages);

            System.out.println("Closing socket and program.");
            socket.close();

        }
        catch (IOException e){
            System.out.println("Something broke :-(");
            e.printStackTrace();
        }





    }
}
