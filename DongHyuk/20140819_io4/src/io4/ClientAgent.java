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
	// socket�� ������ִ� connect()���� ����ϴ� ip�� port��ȣ,socket�� ������������
	// input����,output���븦 �������� ����
	
	public ClientAgent(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}	// socket�� ������ֱ� ���� �Լ� connect���� ip�� port��ȣ�� �ʿ��Ͽ� �����ڷ� ����
	
	
	public final void doExecute(){
		// final�ϸ� �ٸ������� override�� �� ����.
		
		try{ // connect(), sendMsg(), receiveMsg() �� �߸��Ǹ� finally�� ����
			connect();
			sendMsg();
			receiveMsg();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{	closeAll();}
	}
	protected abstract void receiveMsg()throws Exception;	
	protected abstract void sendMsg() throws Exception;
	// �߻� Ŭ������ ���� ���� : ������ �ڵ尡 �ƴ϶� �����Ǵ� �ڵ��̹Ƿ� ��ӽ��Ѽ� override����.
	
	private void connect() throws Exception {
		// ip��ȣ�� port��ȣ�� socket�� ��´�.
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
	// �ȵǵ� ��¿ �� �����Ƿ� ���� throws���� �ʿ� ����.


}
