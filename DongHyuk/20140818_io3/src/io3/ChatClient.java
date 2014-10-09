package io3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {
	private Socket socket;
	private DataInputStream din;
	private DataOutputStream dos;
	private Scanner keyScanner;
	private String user_nick;
	private String fileName;
	private double fileSize;
	private File file;

	public ChatClient(String ip, int port) throws Exception {
		this.socket = new Socket(ip, port);
		this.din = new DataInputStream(this.socket.getInputStream());
		this.dos = new DataOutputStream(this.socket.getOutputStream());
		this.keyScanner = new Scanner(System.in);
	}

	public void run() {
		try {
			readMsg();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readMsg() throws Exception {
		try {
			while (true) {
				String msg = din.readUTF();
				// RE_NICK:Y or RE_NICK:N
				String[] parsingMsg = msgParsing(msg);
				switch (parsingMsg[0]) {
				case "RE_NICK":
					System.out.println(parsingMsg[1]);
					break;

				case "RESULT_NICK":
					if (parsingMsg[1].equals("Y")) {
						System.out.println(parsingMsg[1]);
					} else {
						System.out.println(parsingMsg[1]);
					}
					break;
				// case "ALL":
				// System.out.println(parsingMsg[1]);
				// writeMsg();
				// break;
				case "RE_ROOM_MAKE":
					if (parsingMsg[1].equals("Y")) {
						System.out.println(parsingMsg[2]);
					} else {
						System.out.println(parsingMsg[2]);
					}
					break;
				case "RE_ROOM_LIST":
					System.out.println(parsingMsg[1]);
					break;
				case "RE_FILE":
					file = new File("C:\\zzz\\5.png");
					fileName = file.getName();
					fileSize = file.length();
					sendFile();
					break;
				default:
					if (parsingMsg[0].equals("RE_EXIT")) {
						socket.close();
					} else {
						System.out.println(parsingMsg[0]);
					}
				}

			}
		} catch (Exception e) {
			System.out.println("연결을 종료합니다.");
		}
	}

	// ㅍㅏ싱하기
	private String[] msgParsing(String msg) {
		String[] parsingMsg = msg.split(":");
		return parsingMsg;
	}

	public void sendFile() throws Exception {
		dos.writeUTF("FILE_SEND:" + this.fileName + ":" + this.fileSize);
		byte[] buffer = new byte[1024 * 8];
		FileInputStream fis = new FileInputStream("C:\\zzz\\5.png");
		while (true) {
			int count = fis.read(buffer);
			if (count == -1) {
				break;
			}
			dos.write(buffer, 0, count);
		}
		dos.flush();
	}

	// 메시지 뿌리기
	public void writeMsg() throws Exception {
		while (true) {
			dos.writeUTF(keyScanner.nextLine());
			dos.flush();
		}
	}

	public static void main(String[] args) throws Exception {
		ChatClient client = new ChatClient("192.168.0.77", 5555);
		client.start();
		client.writeMsg();
	}

}