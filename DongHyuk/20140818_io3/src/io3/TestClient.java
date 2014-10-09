package io3;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class TestClient {

	public static void main(String[] args) throws Exception {

//		String[] ips = { "192.168.0.77", "192.168.0.24", "192.168.0.36",
//				"192.168.0.63" }; // �������� ip�� �ִ´�.
		String[] ips = {"192.168.0.36"};

		byte[] buffer = new byte[1024 * 8];
		// Server���� �������ִ� �ӵ��� �޶� ��������� ������ ȿ���� ����

		for (String ip : ips) {

			Socket socket = new Socket(ip, 5555);

			System.out.println(socket);

			InputStream in = socket.getInputStream();
			FileOutputStream fos =
					new FileOutputStream("C:\\zzz\\"+ip+".mp3");

			while (true) {

				int count = in.read(buffer);

				if (count == -1) {
					break;
				}

				System.out.println(count);
				fos.write(buffer,0,count);
				// buffer�������� �� �պ��� ������ �о���δ�.
			}
			in.close();
			fos.close();
			socket.close();
		}
	}

}