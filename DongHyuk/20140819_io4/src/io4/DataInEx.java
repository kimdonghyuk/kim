package io4;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class DataInEx {

	// bad code
	public static void main(String[] args)throws Exception {
		
		ServerSocket server = new ServerSocket(5555);	// �������� ����
		System.out.println("ready server....");
		
		Socket socket = server.accept();
		
		System.out.println("client connected..."+socket);
		
		DataOutputStream clientDos
		= new DataOutputStream(socket.getOutputStream());
		// clientDos�� �տ��� ���� �����͸� �����ְ� getOutputStream�� ����Ͽ� �����͸� �� ����
		// �츮�� ���� ���� getOutputStream�̶�� ���뿡�� DataOutputStream�̶�� ���븦 ���
		// socket ����, ������ ���� �ȱ� ��
		
		String title = "005 ���� - ������.mp3";	// ���� ���� �̸�
		
		clientDos.writeUTF(title);		// ������ ����� ���� ����
		
		InputStream in 
		= new FileInputStream("C:\\zzz\\005 ���� - ������.mp3");
		// Mp3���Ͽ� ���� ����.

		byte[] buffer = new byte[1024*8];
		
		while(true){
			int count = in.read(buffer);
			if(count == -1){break;}
			clientDos.write(buffer,0,count);
		}
		clientDos.flush();	// �����͸� �о���
		clientDos.close();	// close������.
	}

}
