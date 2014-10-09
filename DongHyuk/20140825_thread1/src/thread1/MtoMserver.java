package thread1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MtoMserver extends Thread {

	ServerSocket server;
	Socket socket;
	Scanner inSc;
	Scanner keySc;
	OutputStream out;

	public MtoMserver(int port) throws Exception {

		this.server = new ServerSocket(port);
		waitClient();
	}

	private void waitClient() throws Exception {
		System.out.println("Ready.....");

		socket = this.server.accept();
		inSc = new Scanner(socket.getInputStream());
		out = socket.getOutputStream();

	}

	public void sendMsg() throws Exception {

		while (true) {
			System.out.println("보낼 메시지를 입력하세요");
			String myMsg = keySc.nextLine() + "\n";

			out.write(myMsg.getBytes());
			out.flush();
		}

	}

	public void receiveMsg() {
		while (true) {

			String msg = inSc.nextLine();
			synchronized (System.out) {
				System.out.println(msg);
			}
		}

	} // end receiveMsg

	@Override
	public void run() {
		receiveMsg();
	}

	public static void main(String[] args) throws Exception {

		MtoMserver mServer = new MtoMserver(5555);
		mServer.start();
		mServer.sendMsg();

	}

}
