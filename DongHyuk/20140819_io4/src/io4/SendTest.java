package io4;

import java.io.FileOutputStream;

public class SendTest extends ClientAgent {

	public SendTest(String ip, int port) {
		super(ip, port);
	}
	//���� Ŭ������ �����ڸ� �����Ͽ����Ƿ� ��ӵ� Ŭ������ ������ ����

	@Override
	protected void sendMsg() throws Exception {
		// Message������ �Լ��� dos = outputStream ����
		dos.writeUTF("�޾�");
		dos.flush();
	}
	

	@Override
	protected void receiveMsg() throws Exception {
		// Message�� �޾��ִ� �Լ��� din�� inputStream ���� 
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