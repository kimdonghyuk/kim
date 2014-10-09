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

		// ipMap.put("dh", "192.168.0.86"); // 동혁
		ipMap.put("jy", "192.168.0.77"); // 종현
		ipMap.put("jh", "192.168.0.36"); // 준형
		ipMap.put("mj", "192.168.0.24"); // 명진

		serverSocket = new ServerSocket(5555);

	}

	public void waitClient() {

		while (true) {
			try {
				System.out.println("대기중");
				Socket socket = serverSocket.accept();
				System.out.println(socket);
				Scanner scanner = new Scanner(socket.getInputStream());

				// ph|yh|밥먹었냐?\n
				String userMsg = scanner.nextLine();
				String[] msgArr = userMsg.split("\\|");
				String targetIp = ipMap.get(msgArr[1]);
				String getIP = socket.getInetAddress().getHostAddress();

				// IP목록 신규등록
				ipMap.put(msgArr[0], getIP);

				// System.out.println(socket.getInetAddress().getHostAddress());
				// //클라이언트 소켓 IP주소 받는법

				// IP 목록 출력
				// Iterator<String> it = ipMap.keySet().iterator();
				//
				// while(it.hasNext()){
				// String key = it.next();
				// System.out.println(key);
				// System.out.println(ipMap.get(key));
				// }

				// 다른유저에게 접속시 유저의 데이터를 map에 있는 모든 사람에게 보내줌.
				String userData = msgArr[0] + getIP;
				sendAllMsg(userData);

				// dh|ALL|message 입력시 모든 사람에게 메시지를 띄어줌.
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