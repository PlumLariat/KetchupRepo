import java.io.*;
import java.net.Socket;
import java.util.Date;

public class HangmanClient {

    public static void main(String[] args) {


        // change if server is hosted on location other than local network
        String hostName = "localhost";

        try {

            Socket socket = new Socket(hostName,6969);
            System.out.println(new Date() + ": Client Connected.");

            InputStream inputStream = socket.getInputStream();
            OutputStream  outputStream = socket.getOutputStream();

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            Message msg = (Message) objectInputStream.readObject();

            System.out.println(msg.getText());


        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }


}
