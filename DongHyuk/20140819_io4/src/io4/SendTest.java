package io4;

import java.io.FileOutputStream;

public class SendTest extends ClientAgent {

	public SendTest(String ip, int port) {
		super(ip, port);
	}
	//상위 클래스가 생성자를 생성하였으므로 상속된 클래스도 생성자 생성

	@Override
	protected void sendMsg() throws Exception {
		// Message보내는 함수로 dos = outputStream 빨대
		dos.writeUTF("받아");
		dos.flush();
	}
	

	@Override
	protected void receiveMsg() throws Exception {
		// Message를 받아주는 함수로 din은 inputStream 빨대 
		String title = din.readUTF();

		FileOutputStream fos = new FileOutputStream("C:\\zzz\\copy_" + title);

		byte[] buffer = new byte[1024 * 8];

		while (true) {

			int count = din.read(buffer);
			if (count == -1) {
				break;
			}
			fos.write(buffer, 0, count);

		}
	}

	public static void main(String[] args) throws Exception {

		SendTest obj = new SendTest("192.168.86.1", 5555);
		obj.doExecute();
	}

}