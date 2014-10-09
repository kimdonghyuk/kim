package org.han.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class SQLExecutor {
	
	private static final String JDBC_APACHE_COMMONS_DBCP_POOL = "jdbc:apache:commons:dbcp:/pool";
	private static final String ORG_APACHE_COMMONS_DBCP_POOLING_DRIVER = "org.apache.commons.dbcp.PoolingDriver";
	private static final String ORACLE_JDBC_DRIVER_ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	protected Connection con;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public final void execute()throws Exception{
		
		try{
			makeConnection();
			doJob();
			
		}catch(Exception e){
			throw e;
		}finally{
			closeAll();
		}
		
	}
	
	protected abstract void doJob()throws Exception;

	private void makeConnection()throws Exception{
		Class.forName(ORACLE_JDBC_DRIVER_ORACLE_DRIVER);
		Class.forName(ORG_APACHE_COMMONS_DBCP_POOLING_DRIVER);

		this.con = DriverManager.getConnection(JDBC_APACHE_COMMONS_DBCP_POOL);
	}

	private void closeAll(){		
		if(rs != null){try{rs.close();}catch(Exception e){}};
		if(pstmt != null){try{rs.close();}catch(Exception e){}};
		if(con != null){try{rs.close();}catch(Exception e){}};
	}
}
