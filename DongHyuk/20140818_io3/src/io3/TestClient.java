package io3;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class TestClient {

	public static void main(String[] args) throws Exception {

//		String[] ips = { "192.168.0.77", "192.168.0.24", "192.168.0.36",
//				"192.168.0.63" }; // 팀원들의 ip를 넣는다.
		String[] ips = {"192.168.0.36"};

		byte[] buffer = new byte[1024 * 8];
		// Server에서 전송해주는 속도랑 달라도 상관없지만 같으면 효율이 좋음

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
				// buffer에서부터 맨 앞부터 끝까지 읽어들인다.
			}
			in.close();
			fos.close();
			socket.close();
		}
	}

}