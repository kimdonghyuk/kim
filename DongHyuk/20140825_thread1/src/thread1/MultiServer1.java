package thread1;

import java.io.DataInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MultiServer1 {
	
	private DataInputStream din;
	private ServerSocket serverSocket;
	private Map<String, String> ipMap;

	public MultiServer1() throws Exception {

		ipMap = new HashMap<String, String>();

		// ipMap.put("dh", "192.168.0.86"); // ����
//		ipMap.put("jy", "192.168.0.77"); // ����
//		ipMap.put("jh", "192.168.0.36"); // ����
//		ipMap.put("mj", "192.168.0.24"); // ����

		serverSocket = new ServerSocket(5555);

	}

	public void waitClient() {

		while (true) {
			try {
				System.out.println("Wait To Client");
				Socket socket = serverSocket.accept();
				System.out.println(socket);
				Scanner scanner = new Scanner(socket.getInputStream());

				// ������� ID, IP��ϸ� ipMap�� ���     , �Է°� : 
				String userMsg = scanner.nextLine();
				String[] msgArr = userMsg.split("\\|");
				String getIP = socket.getInetAddress().getHostAddress();
				RegistUser(msgArr, getIP);

				// �ٸ��������� ���ӽ� ������ �����͸� map�� �ִ� ��� ������� ������.
				String userData = "ID : " + msgArr[0] + "  IP : " + getIP;
				sendAllMsg(userData);

				// ph|yh|��Ծ���?\n
//				String userMsg = scanner.nextLine();
//				String[] msgArr = userMsg.split("\\|");

				// dh|ALL|message �Է½� ��� ������� �޽����� ����.
				if (msgArr[1].equals("all")) {
					sendAllMsg(userMsg);
					scanner.close();
					socket.close();
				}// end if

				// dh|Ư�����|message �Է½� Ư����󿡰� �޽����� ����
				else {
					String targetIp = ipMap.get(msgArr[1]);
					sendSingleMsg(userMsg, targetIp);
					scanner.close();
					socket.close();
				}// end else

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}// end finally
		}// end while
	}// end waitClient

	private void RegistUser(String[] firstMsgArr, String getIP)
			throws Exception {

		Iterator<String> it = ipMap.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (ipMap.get(key).equals(firstMsgArr[0])) {
				Socket regiSocket = new Socket(getIP, 5554);
				OutputStream regiOut = regiSocket.getOutputStream();
				regiOut.write(("�ٽ� �Է����ּ���." + "\n").getBytes());
				regiOut.flush();
				waitClient();
				} else {
				ipMap.put(firstMsgArr[0], getIP);
				Socket regiSocket = new Socket(getIP, 5554);
				OutputStream regiOut = regiSocket.getOutputStream();
				regiOut.write(("�޽����� �Է����ּ���  >> �����»�� �̴ϼ�|�޴»�� �̴ϼ�|���� " + "\n").getBytes());
				regiOut.flush();
			}
		}// end while

	}

	// ��ü���� Msg�����ִ� �Լ�
	public void sendAllMsg(String userMsg) throws Exception {

		Collection<String> ipInfo = ipMap.values();

		for (String aValue : ipInfo) {
			String allIp = aValue;

			Socket clientSocket = new Socket(allIp, 5554);
			OutputStream clientOut = clientSocket.getOutputStream();
			clientOut.write(("���� ������ ����  >>  " + userMsg + "\n").getBytes());
			clientOut.flush();

			clientOut.close();
			clientSocket.close();
		}
	}// end sendAllMsg

	// ���Ϸ� Msg�����ִ� �Լ�
	public void sendSingleMsg(String userMsg, String targetIP) throws Exception {
		Socket clientSocket = new Socket(targetIP, 5554);
		OutputStream clientOut = clientSocket.getOutputStream();
		clientOut.write((userMsg + "\n").getBytes());
		clientOut.flush();

		clientOut.close();
		clientSocket.close();
	}// end sendSingleMsg

	public static void main(String[] args) throws Exception {

		MultiServer1 server = new MultiServer1();
		server.waitClient();
	}
}