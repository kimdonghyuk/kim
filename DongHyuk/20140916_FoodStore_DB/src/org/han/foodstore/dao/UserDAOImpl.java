package org.han.foodstore.dao;

import org.han.foodstore.util.SqlAgent;
import org.han.vo.UserVO;

public class UserDAOImpl implements UserDAO {

	enum SQL {

		USER_INSERT(
				"  insert into tbl_suser(userid, pasword, username, mail)"
				+ " values (?,?,?,?)"),
		SELECT("select * from tbl_suser where userid = ? "),
		UPDATE(" update tbl_suser"
				+ " set pasword = ?, username = ?, mail = ?"
				+ " where userid = ?"),
		DELETE(" delete from tbl_suser"
				+ " where userid = ?");

		String value;

		SQL(String value) {
			this.value = value;
		}
	}

	@Override
	public void create(UserVO uvo) throws Exception {
		// userid, date, ansercnt, username
		new SqlAgent() {
			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.USER_INSERT.value);
				pstmt.setString(1, uvo.getUserid());
				pstmt.setString(2, uvo.getPassword());
				pstmt.setString(3, uvo.getUsername());
				pstmt.setString(4, uvo.getEmail());

				int resultCount = pstmt.executeUpdate();

				if (resultCount < 1) {
					throw new Exception("USER_INSERT ERROR");
				}
			}
		}.doExecute();

	}

	@Override
	public UserVO read(String userid) throws Exception {
		
		final UserVO uvo = new UserVO();
		
		new SqlAgent(){

			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.SELECT.value);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				rs.next();
				
				uvo.setUserid(rs.getString(1));
				uvo.setPassword(rs.getString(2));
				uvo.setUsername(rs.getString(3));
				uvo.setEmail(rs.getString(4));
			}			
		}.doExecute();
		
		return uvo;
	}

	@Override
	public void update(UserVO uvo) throws Exception {
		new SqlAgent(){

			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.UPDATE.value);
				pstmt.setString(1, uvo.getPassword());
				pstmt.setString(2, uvo.getUsername());
				pstmt.setString(3, uvo.getEmail());
				pstmt.setString(4, uvo.getUserid());
				
				int resultCount = pstmt.executeUpdate();
				
				if(resultCount < 1){
					throw new Exception("USER_UPDATE ERROR");
				}
			}			
		}.doExecute();
	}

	@Override
	public void delete(String userid) throws Exception {
		new SqlAgent() {
			
			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.DELETE.value);
				pstmt.setString(1, userid);
				
				int resultCount = pstmt.executeUpdate();
				
				if(resultCount < 1){
					throw new Exception("USER_DELETE ERROR");
				}
			}
		}.doExecute();

	}

}
