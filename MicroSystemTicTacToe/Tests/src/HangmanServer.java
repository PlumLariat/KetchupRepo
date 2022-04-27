import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HangmanServer {
    public static void main(String[] args) {
        new Thread( () -> {
            // Create the Server Socket
           try {
               ServerSocket sSocket = new ServerSocket(6969);
               System.out.println(new Date() + ": Server Spawned.");

               // After creation have it, look for connections in the port indefinitely.
               while (true) {
                   System.out.println(new Date() + ": Listening for client.");

                   // Connect the first player.
                   Socket player1 = sSocket.accept();       // usually this would be a bottleneck, but this whole
                                                            // block is threaded.
                   System.out.println(new Date() + ": Client connected.\n\tConnection from " +
                                      player1.getInetAddress().getHostAddress() + " is now player 1.");

                   // Send a message to the client to let them know that they are the first person to connect.
                   new ObjectOutputStream(player1.getOutputStream()).writeObject(new Message("If you received this message you must be player 1."));


                   // Connect the second player.
                   Socket player2 = sSocket.accept();
                   System.out.println(new Date() + ": Client connected.\n\tConnection from " +
                           player1.getInetAddress().getHostAddress() + " is now player 2.");

                   // Send a message to the client to let them know that they are the first person to connect.
                   new ObjectOutputStream(player2.getOutputStream()).writeObject(new Message("If you received this message you must be player 2."));


                   // now that we have two players we can launch a game thread for them
                   // new Thread(new HangmanController(player1,player2)).start();
               }

           }
           // ServerSockets can create an IO EXCEPTION.
           catch (IOException e){
               e.printStackTrace();
           }
        }).start();
    }
}
