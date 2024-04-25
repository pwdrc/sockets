import java.io.*;
import java.net.*;

class TCPServer
{
   public static void main(String argv[]) throws Exception
      {
         String clientSentence;
         ServerSocket welcomeSocket = new ServerSocket(8181);

         while(true)
         {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
               new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            String[] numbers = clientSentence.split(",");
            int A = Integer.parseInt(numbers[0]);
            int B = Integer.parseInt(numbers[1]);
            int soma = A + B;
            outToClient.writeBytes(Integer.toString(soma) + '\n');
         }
      }
}
