package org.han.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeDAO {
	
	private static Logger logger = LoggerFactory.getLogger("TimeDAO");

	public String getTime()throws Exception{
		
		final String sql ="select sysdate from dual";
		final StringBuffer buffer = new StringBuffer();
		
		new SQLExecutor(){
			@Override
			protected void doJob()throws Exception {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs.next();
				buffer.append(rs.getString(1));
				logger.info(buffer.toString());
			}
		}.execute();
		
		return buffer.toString();
	}
}





