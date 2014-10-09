package thread1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MtoMclient extends Thread {
	
	Scanner inSc;
	Scanner keySc;
	InputStream in;
	OutputStream out;
	String ips = "192.168.0.77";
	DataInputStream din;
	DataOutputStream dos;
	String name;	// 사용자 이름을 받는 변수

	public MtoMclient(int port, String name) throws Exception {
		this.name = name;
	//	System.out.println("자신의 이름을 적어주세요");
	//	this.name = keySc.nextLine();
		keySc = new Scanner(System.in);
		waitClient();
	}

	private void waitClient() throws Exception {
		System.out.println("Ready.....");

		Socket socket = new Socket(ips,5555);
		inSc = new Scanner(socket.getInputStream());
		in = socket.getInputStream();
		out = socket.getOutputStream();
		din = new DataInputStream(in);
		dos = new DataOutputStream(out);

	}

	public void sendMsg() throws Exception {
		while (true) {
			System.out.println("보낼 메시지를 입력하세요");
			String myMsg = keySc.nextLine()+"\n";

			dos.writeUTF(name);
			out.write(myMsg.getBytes());
			out.flush();
		}

	}

	public void receiveMsg() throws Exception {
		while (true) {
			String userName = din.readUTF();
			String msg = inSc.nextLine();
			synchronized(System.out){
				System.out.println(userName + " : " + msg);
			}
		}

	} // end receiveMsg

	@Override
	public void run() {
		try {
			receiveMsg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		MtoMclient mClient = new MtoMclient(5555,"김동혁");
		mClient.start();
		mClient.sendMsg();

	}

}
