import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable {
    private int thisServerPort;

    /**
     * This constructor forces port to be passed in which is necessary for server startup.
     * @param iPort
     */
    public SocketServer(int iPort){
        thisServerPort = iPort;
    }

    /**
     * This thread listens for connecting clients, receives message, and replies with sent message.
     */
    public void run(){
        try(ServerSocket oServerSocket = new ServerSocket(thisServerPort)){
            System.out.println("Server is listening on port " + thisServerPort);

            while(true){
//                Server will pause on this line waiting for client to connect to it.
                Socket oSocket = oServerSocket.accept();
                System.out.println("[server]: New client connected: " + oSocket.getRemoteSocketAddress());

//                Build a reader.
                InputStream input = oSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

//                Build a writer.
                OutputStream output = oSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String sReceivedMessage = reader.readLine();

                int a;
                int b;
                int c;
                int iResult;
                String[] sMessageArray = sReceivedMessage.split(",");
                a = Integer.parseInt(sMessageArray[0]);
                b = Integer.parseInt(sMessageArray[1]);
                c = Integer.parseInt(sMessageArray[2]);
                iResult = a + b + c;
                System.out.println("[server]: Message received: " + iResult);

                writer.println("Your sum: " + iResult);
//                writer.println("Your message was received (" + sReceivedMessage + ")");
                writer.flush(); // Guarantees that message is sent immediately.
            }
        }
        catch(IOException e){
            System.out.println("[server]: Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
