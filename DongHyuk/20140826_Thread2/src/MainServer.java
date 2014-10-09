import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainServer {

	private ServerSocket server;
	private List<ChatAgent> agentList;

	public MainServer(int port) throws Exception {

		this.server = new ServerSocket(port);
		this.agentList = new ArrayList<ChatAgent>();
		this.waitClient();
	}

	private void waitClient() {
		
		while(true){
			try {
				System.out.println("¥Î±‚¡ﬂ");
				Socket socket = server.accept();
				ChatAgent agent = new ChatAgent(socket, this);
				agentList.add(agent);
				agent.start();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	public synchronized void broadcast(String msg){
		
		for(ChatAgent chatAgent : agentList){
			try {
				chatAgent.writeMsg(msg);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				agentList.remove(chatAgent);
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		MainServer server = new MainServer(5555);
	}
}
