import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {

	private Socket socket;
	private DataInputStream din;
	private DataOutputStream dos;
	private Scanner keySc;

	public ChatClient(String ip, int port) throws Exception {
		this.socket = new Socket(ip, port);
		this.din = new DataInputStream(this.socket.getInputStream());
		this.dos = new DataOutputStream(this.socket.getOutputStream());
		this.keySc = new Scanner(System.in);
	}

	public void readMsg() throws Exception {
		while (true) {

			System.out.println(din.readUTF());

		}

	}

	public void writeMsg() throws Exception {

		while (true) {
			System.out.println("입력하세요");
			String msg = keySc.nextLine();
			dos.writeUTF("Kim Dong Hyuk : " + msg);
			dos.flush();
		}
	}

	@Override
	public void run() {
		try {
			readMsg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		ChatClient client = new ChatClient("192.168.0.77",5555);
		client.start();
		client.writeMsg();
		
	}

}
