package thread1;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class MultiClient1 {
	
	Scanner keyScanner;
	
	public MultiClient1() {
		keyScanner = new Scanner(System.in);
	}

	public void sendMsg()throws Exception{
		while(true){
			System.out.println("보낼 메시지 입력");
			String msg = keyScanner.nextLine()+"\n";
			
			Socket socket = new Socket("192.168.0.77", 5555);
			OutputStream out = socket.getOutputStream();
			out.write(msg.getBytes());
			out.flush();
			
			out.close();
			socket.close();
			
		}		
	}
	
	public void receiveMsg()throws Exception{
		
		final ServerSocket myServer = new ServerSocket(5554);
		
		new Thread(){

			@Override
			public void run() {
				while(true){
					try{
						Socket socket = myServer.accept();
						Scanner scanner = new Scanner(socket.getInputStream());
						System.out.println(scanner.nextLine());
						scanner.close();
						socket.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}
			
			
			
		}.start();
		
	}
	
	public static void main(String[] args) throws Exception{
	
		MultiClient1 cl = new MultiClient1();
		cl.receiveMsg();
		cl.sendMsg();
	}
}