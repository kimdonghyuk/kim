package org.han.foodstore.dao;

import org.han.foodstore.util.SqlAgent;
import org.han.vo.StoreVO;

public class FoodStoreDAOImpl implements FoodStoreDAO {
	
	enum SQL{
		
		INSERT(" insert into tbl_store(sno, sname, addr, keyword, tel, sdesc)"
				+ " values (sql_store.nextval, ?, ?, ?, ?, ?)"),
		SELECT("select * from tbl_store where sno = ? "),
		UPDATE(" update tbl_store"
				+ " set sname = ?, addr = ?, keyword = ?, tel= ?, sdesc = ?, regdate = to_date(sysdate,'yy/mm/dd')"
				+ " where sno = ?"),
		DELETE(" delete from tbl_store"
				+ " where sno = ?");
		
		
		String value;
		SQL(String value){
			this.value = value;
		}
	}

	@Override
	public void create(StoreVO vo) throws Exception {
		//sname, addr, keyword, tel, sdesc
		new SqlAgent(){	// �͸�Ŭ���� ���
			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.INSERT.value);
				pstmt.setString(1, vo.getSname());	// 1��° ����ǥ�� �� ����
				pstmt.setString(2, vo.getAddr());
				pstmt.setString(3, vo.getKeyword());
				pstmt.setString(4, vo.getTel());
				pstmt.setString(5, vo.getSdesc());
				
				int resultCount = pstmt.executeUpdate();
				// resultCount�� 1�϶� 1�� �Է��ߴٴ� ���̸� 0�̸� ������ �ִ� ����.
				
				if(resultCount < 1){
					throw new Exception("Insert Error");
				}
				
			}
			
		}.doExecute();

	}
	@Override
	public StoreVO read(Integer sno) throws Exception {
		
		final StoreVO vo = new StoreVO();
		
		new SqlAgent(){

			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.SELECT.value);
				pstmt.setInt(1, sno);
				rs = pstmt.executeQuery();
				rs.next();
				
				vo.setSno(rs.getInt(1));
				vo.setSname(rs.getString(2));
				vo.setAddr(rs.getString(3));
				vo.setKeyword(rs.getString(4));
				vo.setTel(rs.getString(5));
				
				}
		}.doExecute();		
		return vo;
	}

	@Override
	public void update(StoreVO vo) throws Exception {
		new SqlAgent(){
			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.UPDATE.value);
				pstmt.setString(1, vo.getSname());
				pstmt.setString(2, vo.getAddr());
				pstmt.setString(3, vo.getKeyword());
				pstmt.setString(4, vo.getTel());
				pstmt.setString(5, vo.getSdesc());
				pstmt.setInt(6, vo.getSno());
				
				int resultCount = pstmt.executeUpdate();
				
				if(resultCount < 1){
					throw new Exception("STORE_UPDATE ERROR");
				}
				
			}
		}.doExecute();
	}

	@Override
	public void delete(Integer sno) throws Exception {
		
		new SqlAgent(){
			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.DELETE.value);
				pstmt.setInt(1, sno);
				
				int resultCount = pstmt.executeUpdate();
				
				if(resultCount < 1){
					throw new Exception("STORE_DELETE ERROR");
				}
			}
			
		}.doExecute();

	}

}
