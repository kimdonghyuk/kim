package io3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BroadCastServer {

	ServerSocket mainServer;
	
	Map<String, String> ipMap;
	
	
	public BroadCastServer()throws Exception{
		
		ipMap = new HashMap<String, String>();
		
		ipMap.put("À±È£","192.168.0.73");
		ipMap.put("Àº¾Ö","192.168.0.85");
		
		mainServer = new ServerSocket(8080);
		System.out.println("ready......main ");
		waitEndUser();
	}

	private void waitEndUser() {
		
		Socket endUser = null;
		InputStream in = null;
		OutputStream out = null;
		Scanner scanner = null;
		
		byte[] buffer = new byte[1024*8];
		
		try{
			endUser = mainServer.accept();
			System.out.println("EndUser: " + endUser);
			
			in = endUser.getInputStream();
			out = endUser.getOutputStream();
			scanner = new Scanner(in);
			

			String serverName = scanner.nextLine();
			
			String targetIp = ipMap.get(serverName);
			
			
			Socket mp3Socket = new Socket(targetIp,5555);
			InputStream mp3In = mp3Socket.getInputStream();
			
			System.out.println("mp3In" +mp3In);
			
			while(true){
				
				int mp3Count = mp3In.read(buffer);
				if(mp3Count == -1){ break;}
				out.write(buffer,0, mp3Count);
				
			}
			out.flush();
			mp3In.close();
			mp3Socket.close();
			
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try{ scanner.close();}catch(Exception e){}
			try{ in.close();}catch(Exception e){}
			try{ out.close();}catch(Exception e){}
			try{ endUser.close();}catch(Exception e){}
		}
		
		waitEndUser();
	}
	
	public static void main(String[] args)throws Exception {
		
		BroadCastServer server = new BroadCastServer();
	}
	
}





