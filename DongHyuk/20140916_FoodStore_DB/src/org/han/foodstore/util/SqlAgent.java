package org.han.foodstore.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class SqlAgent {
	
	static{
		MyConnectionPool.getInstance();
	}
	
	protected Connection con;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	private void makeConnection()throws Exception{
		
		con = MyConnectionPool.getInstance().getConnection();
	}
	
	public final void doExecute()throws Exception{
		try{
			makeConnection();
			doJob();
		}
		catch(Exception e){
			throw e;
		}finally{closeAll();}
	}
	
	
	protected abstract void doJob()throws Exception;	// 작업마다 달라짐.
	
	
	private void closeAll()throws Exception{
		if(rs != null){try{rs.close();}catch(Exception e){}};
		if(pstmt != null){try{pstmt.close();}catch(Exception e){}};
		if(con != null){try{con.close();}catch(Exception e){}};
	}
}
