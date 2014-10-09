package io4;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class DataInEx {

	// bad code
	public static void main(String[] args)throws Exception {
		
		ServerSocket server = new ServerSocket(5555);	// 서버소켓 개설
		System.out.println("ready server....");
		
		Socket socket = server.accept();
		
		System.out.println("client connected..."+socket);
		
		DataOutputStream clientDos
		= new DataOutputStream(socket.getOutputStream());
		// clientDos가 앞에서 제목 데이터를 보내주고 getOutputStream을 사용하여 데이터를 또 보냄
		// 우리가 원래 쓰던 getOutputStream이라는 빨대에서 DataOutputStream이라는 빨대를 사용
		// socket 연결, 보내는 빨대 꽂기 끝
		
		String title = "005 현아 - 빨개요.mp3";	// 보낼 파일 이름
		
		clientDos.writeUTF(title);		// 보내는 빨대로 제목 보냄
		
		InputStream in 
		= new FileInputStream("C:\\zzz\\005 현아 - 빨개요.mp3");
		// Mp3파일에 빨대 꽂음.

		byte[] buffer = new byte[1024*8];
		
		while(true){
			int count = in.read(buffer);
			if(count == -1){break;}
			clientDos.write(buffer,0,count);
		}
		clientDos.flush();	// 데이터를 밀어줌
		clientDos.close();	// close시켜줌.
	}

}
