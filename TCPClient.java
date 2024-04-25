import java.io.*;
import java.net.*;

class TCPClient
{
	public static void main(String argv[]) throws Exception
	{
		String A, B;
		String soma;
		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 8181);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  		System.out.println("Informe um número: ");
		A = inFromUser.readLine();
		System.out.println("Informe outro número: ");
		B = inFromUser.readLine();
		outToServer.writeBytes(A + "," + B + "\n");
		soma = inFromServer.readLine();
		System.out.println("= " + soma);
		clientSocket.close();
	}
}
