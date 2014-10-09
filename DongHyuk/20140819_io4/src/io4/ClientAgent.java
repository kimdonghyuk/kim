package io4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

// Templet Method Pattern First Class

public abstract class ClientAgent {

	private String ip;
	private int port;
	protected Socket socket;
	protected DataInputStream din;
	protected DataOutputStream dos;
	// socket을 만들어주는 connect()에서 사용하는 ip와 port번호,socket을 변수선언해줌
	// input빨대,output빨대를 변수선언 해줌
	
	public ClientAgent(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}	// socket을 만들어주기 위한 함수 connect에서 ip와 port번호가 필요하여 생성자로 선언
	
	
	public final void doExecute(){
		// final하면 다른곳에서 override할 수 없음.
		
		try{ // connect(), sendMsg(), receiveMsg() 가 잘못되면 finally로 빠짐
			connect();
			sendMsg();
			receiveMsg();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{	closeAll();}
	}
	protected abstract void receiveMsg()throws Exception;	
	protected abstract void sendMsg() throws Exception;
	// 추상 클래스로 잡은 이유 : 동일한 코드가 아니라 변형되는 코드이므로 상속시켜서 override해줌.
	
	private void connect() throws Exception {
		// ip번호와 port번호를 socket에 담는다.
		this.socket = new Socket(this.ip, this.port);
		this.din = new DataInputStream(this.socket.getInputStream());
		this.dos = new DataOutputStream(this.socket.getOutputStream());
		
	}

	private void closeAll() {
		// TODO Auto-generated method stub
		if(this.din!=null){
			try{din.close();}catch(Exception e){}
		}
	}
	// 안되도 어쩔 수 없으므로 굳이 throws해줄 필요 없음.


}
