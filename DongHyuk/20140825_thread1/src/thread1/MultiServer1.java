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

		// ipMap.put("dh", "192.168.0.86"); // 동혁
//		ipMap.put("jy", "192.168.0.77"); // 종현
//		ipMap.put("jh", "192.168.0.36"); // 준형
//		ipMap.put("mj", "192.168.0.24"); // 명진

		serverSocket = new ServerSocket(5555);

	}

	public void waitClient() {

		while (true) {
			try {
				System.out.println("Wait To Client");
				Socket socket = serverSocket.accept();
				System.out.println(socket);
				Scanner scanner = new Scanner(socket.getInputStream());

				// 사용자의 ID, IP등록를 ipMap에 등록     , 입력값 : 
				String userMsg = scanner.nextLine();
				String[] msgArr = userMsg.split("\\|");
				String getIP = socket.getInetAddress().getHostAddress();
				RegistUser(msgArr, getIP);

				// 다른유저에게 접속시 유저의 데이터를 map에 있는 모든 사람에게 보내줌.
				String userData = "ID : " + msgArr[0] + "  IP : " + getIP;
				sendAllMsg(userData);

				// ph|yh|밥먹었냐?\n
//				String userMsg = scanner.nextLine();
//				String[] msgArr = userMsg.split("\\|");

				// dh|ALL|message 입력시 모든 사람에게 메시지를 전송.
				if (msgArr[1].equals("all")) {
					sendAllMsg(userMsg);
					scanner.close();
					socket.close();
				}// end if

				// dh|특정대상|message 입력시 특정대상에게 메시지를 전송
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
				regiOut.write(("다시 입력해주세요." + "\n").getBytes());
				regiOut.flush();
				waitClient();
				} else {
				ipMap.put(firstMsgArr[0], getIP);
				Socket regiSocket = new Socket(getIP, 5554);
				OutputStream regiOut = regiSocket.getOutputStream();
				regiOut.write(("메시지를 입력해주세요  >> 보내는사람 이니셜|받는사람 이니셜|내용 " + "\n").getBytes());
				regiOut.flush();
			}
		}// end while

	}

	// 전체에게 Msg보내주는 함수
	public void sendAllMsg(String userMsg) throws Exception {

		Collection<String> ipInfo = ipMap.values();

		for (String aValue : ipInfo) {
			String allIp = aValue;

			Socket clientSocket = new Socket(allIp, 5554);
			OutputStream clientOut = clientSocket.getOutputStream();
			clientOut.write(("현재 접속자 정보  >>  " + userMsg + "\n").getBytes());
			clientOut.flush();

			clientOut.close();
			clientSocket.close();
		}
	}// end sendAllMsg

	// 단일로 Msg보내주는 함수
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