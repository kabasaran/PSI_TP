package petiteAnnonce.server;


import java.io.*;
import java.net.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Server {

	final static int PORT_TCP = 1028;
	private static int port;
	static Informations info;
	ServerSocket serverSocket;
	private PrivateKey private_key;
	private PublicKey public_key;

	public Server(int port) {
		this.port = port;
		info = new Informations();
	}

	public void execute() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {

			System.out.println("--------------- Gestionnaire is listening on port " + port + " --------------");

			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		      keyGen.initialize(1024);
		      KeyPair key_pair = keyGen.generateKeyPair();
		      private_key = key_pair.getPrivate();
		      public_key = key_pair.getPublic();
			
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("\nWhat's your name?? "+socket.getPort()+"\n");

				UserThread newUser = new UserThread(socket, info );
				info.getUserThreads().add(newUser);
				newUser.start();
				
			}

		} catch (IOException | NoSuchAlgorithmException ex) {
			System.out.println("Error in the server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			port = PORT_TCP;
		} else {
			port = Integer.parseInt(args[0]);
		}

		Server server = new Server(port);
		server.execute();
	}
}