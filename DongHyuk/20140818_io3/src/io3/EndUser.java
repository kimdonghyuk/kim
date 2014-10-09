package io3;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EndUser {

	public void downloadMP3(){
		
		String serverName ="ÁØÇü\n";
		
		String serverIp = "192.168.0.36";
		
		int port = 8080;
		
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		
		FileOutputStream fos = null;
		
		byte[] buffer = new byte[1024*8];
		
		try{
			socket = new Socket(serverIp, port);
			out = socket.getOutputStream();
			in = socket.getInputStream();
			
			fos = new FileOutputStream("C:\\zzz\\aaa.mp3");
			
			out.write(serverName.getBytes());
			out.flush();
			
			while(true){
				int count = in.read(buffer);
				if(count == -1){ break;}
				System.out.println(count);
				
				fos.write(buffer,0,count);
				
			}
			
			fos.flush();
			
			fos.close();

			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{ out.close();}catch(Exception e){}
			try{ socket.close();}catch(Exception e){}
		}
	}
	
	public static void main(String[] args)throws Exception {
		EndUser obj = new EndUser();
		obj.downloadMP3();
	}
}








