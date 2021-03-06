package petiteAnnonce.message;

import java.net.*;
import java.util.Scanner;

/**
 * @author KABA
 *
 */
public class ClientCommunication{

	private static int port_dest;
	private static String hostname;
	private static String seller;

	public ClientCommunication(int port, String host, String vendeur) {
		port_dest = port;
		hostname = host;
		seller = vendeur;

	}

	@SuppressWarnings("resource")
	public static void execute() throws Exception {
		/*
		 * port_dest = 1010; hostname = "localhost";
		 */
		String toSend = "", receive = "";
		System.out.println("\n============= Communication Acheteur: "+port_dest+" =====================\n");
		
		DatagramSocket clientSocket;
		
		do {
			System.out.print("\nMoi: ");
			Scanner inFromMe = new Scanner(System.in);
			clientSocket = new DatagramSocket();
			clientSocket.connect(InetAddress.getByName(hostname), port_dest);
			
			toSend = inFromMe.nextLine();
			byte[] sendData = toSend.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientSocket.getInetAddress(), clientSocket.getPort());
			clientSocket.send(sendPacket);

			if(toSend.equals("bye"))
				break;
			
			byte[] receiveData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
			receive = new String(receivePacket.getData());
			
			System.out.println("\n"+seller+": "+receive);
			
		}while(true);
		
		System.out.println("\nAurevoir");
		clientSocket.disconnect();
		clientSocket.close();
		
	}
	public static void main(String args[]) throws Exception {
		ClientCommunication.execute();
	}

}