import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ChatAgent extends Thread{
	
	private Socket socket;
	private DataInputStream din;
	private DataOutputStream dos;
	private MainServer mainServer;
	
	public ChatAgent(Socket socket, MainServer main) throws Exception{
		
		this.socket = socket;
		this.din = new DataInputStream(socket.getInputStream());
		this.dos = new DataOutputStream(socket.getOutputStream());
		this.mainServer = main;
	}

	@Override
	public void run() {
		try {
			readMsg();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readMsg() throws Exception {

		while(true){
			
			String msg = din.readUTF();
			mainServer.broadcast(msg);
		}
		
	}
	
	public void writeMsg(String msg)throws Exception{
		
		dos.writeUTF(msg);
	}
	

}
