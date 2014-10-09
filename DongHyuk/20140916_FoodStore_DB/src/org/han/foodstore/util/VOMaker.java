package org.han.foodstore.util;

import java.sql.ResultSetMetaData;

public class VOMaker {
	
	public static void main(String[] args) throws Exception{
		
		final String query = "select * from tbl_menu where rownum = 1";
		
		new SqlAgent(){

			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				ResultSetMetaData meta = rs.getMetaData();
				
				int colCount = meta.getColumnCount();
				System.out.printf("ÄÃ·³¼ö %d \n",colCount);
				
				for(int i = 1; i <= colCount; i++){
					int type = meta.getColumnType(i);
					//System.out.println(type);
					String javaType = getType(type);
					
					String name = meta.getColumnName(i).toLowerCase();
					//System.out.println(name);
					
					System.out.printf("private %s %s; \n", javaType, name);
				}
				
			}

			private String getType(int type) {
				String result = "String";
				
				switch (type){
				case 2:
					result = "Integer";
					break;
				case 93:
					result = "Date";
					break;
				default:
					break;
				}
				return result;
			}		
		}.doExecute();
	}

}
