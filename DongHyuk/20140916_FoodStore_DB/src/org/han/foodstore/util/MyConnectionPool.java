package org.han.foodstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class MyConnectionPool {

	List<Connection> conList;
	
	private int idx = 0;

	private static MyConnectionPool instance = new MyConnectionPool();

	public static MyConnectionPool getInstance() {
		return instance;
	}

	private MyConnectionPool(){
		try {
			conList = new Vector<Connection>();
			Class.forName("oracle.jdbc.OracleDriver");

			String urlPath = "jdbc:oracle:thin:@61.72.16.181:5021:ORCL";
			String userName = "han07";
			String pw = "han07";

			for (int i = 0; i < 10; i++) {

				conList.add(DriverManager.getConnection(urlPath, userName, pw));	// Myconnection�� connection �������̽��� �����ؼ� ������.
			
//				conList.add(
//						new MyConnection(
//								DriverManager.getConnection(urlPath, userName, pw),
//								this));	// Myconnection�� connection �������̽��� �����ؼ� ������.
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()throws Exception{		
		//return conList.get(idx++/10)
		return conList.remove(0);	// ������		
	}

	public void returnConnection(Connection con)throws Exception{
		conList.add(con);	// ������ add���Ѽ� ����־���
	}
	
}
