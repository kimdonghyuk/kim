package io4;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class DataOutEx {

	// bad code
	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("192.168.0.77", 5555);
		// Socket ����
		
		DataInputStream din =
				new DataInputStream(socket.getInputStream());
		// ���븦 �Ⱦ����� ������ DataIn���� title�� �������Ƿ� title�� ���Ƶ��̰Ե�.
		
		String title = din.readUTF();
		System.out.println(title);
		// title�� �о�帲
		
		FileOutputStream fos
		= new FileOutputStream("C:\\zzz\\copy_" + title);
		// ��ο� output���븦 ����
		
		byte[] buffer = new byte[1024*8];
		
		while(true){
			int count = din.read(buffer);
			if(count == -1){break;}
			fos.write(buffer,0,count);
		}
		

	}
}
