package thread1;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MultiServer0 {

	private ServerSocket serverSocket;
	private Map<String, String> ipMap;

	public MultiServer0() throws Exception {

		ipMap = new HashMap<String, String>();

		// ipMap.put("dh", "192.168.0.86"); // ����
		ipMap.put("jy", "192.168.0.77"); // ����
		ipMap.put("jh", "192.168.0.36"); // ����
		ipMap.put("mj", "192.168.0.24"); // ����

		serverSocket = new ServerSocket(5555);

	}

	public void waitClient() {

		while (true) {
			try {
				System.out.println("�����");
				Socket socket = serverSocket.accept();
				System.out.println(socket);
				Scanner scanner = new Scanner(socket.getInputStream());

				// ph|yh|��Ծ���?\n
				String userMsg = scanner.nextLine();
				String[] msgArr = userMsg.split("\\|");
				String targetIp = ipMap.get(msgArr[1]);
				String getIP = socket.getInetAddress().getHostAddress();

				// IP��� �űԵ��
				ipMap.put(msgArr[0], getIP);

				// System.out.println(socket.getInetAddress().getHostAddress());
				// //Ŭ���̾�Ʈ ���� IP�ּ� �޴¹�

				// IP ��� ���
				// Iterator<String> it = ipMap.keySet().iterator();
				//
				// while(it.hasNext()){
				// String key = it.next();
				// System.out.println(key);
				// System.out.println(ipMap.get(key));
				// }

				// �ٸ��������� ���ӽ� ������ �����͸� map�� �ִ� ��� ������� ������.
				String userData = msgArr[0] + getIP;
				sendAllMsg(userData);

				// dh|ALL|message �Է½� ��� ������� �޽����� �����.
				if (msgArr[1].equals("all")) {
					sendAllMsg(userMsg);
					scanner.close();
					socket.close();
				}// end if
				else {
					sendSingleMsg(userMsg,targetIp);
					scanner.close();
					socket.close();
				}// end else

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}// end finally
		}// end while
	}// end waitClient

	public void sendAllMsg(String userMsg) throws Exception {
		Collection<String> ipInfo = ipMap.values();

		for (String aValue : ipInfo) {
			String allIp = aValue;

			Socket clientSocket = new Socket(allIp, 5554);
			OutputStream clientOut = clientSocket.getOutputStream();
			clientOut.write((userMsg + "\n").getBytes());
			clientOut.flush();

			clientOut.close();
			clientSocket.close();
		}
	}// end sendAllMsg

	public void sendSingleMsg(String userMsg, String targetIP) throws Exception {
		Socket clientSocket = new Socket(targetIP, 5554);
		OutputStream clientOut = clientSocket.getOutputStream();
		clientOut.write((userMsg + "\n").getBytes());
		clientOut.flush();

		clientOut.close();
		clientSocket.close();
	}// end sendSingleMsg

	public static void main(String[] args) throws Exception {

		MultiServer0 server = new MultiServer0();
		server.waitClient();
	}
}