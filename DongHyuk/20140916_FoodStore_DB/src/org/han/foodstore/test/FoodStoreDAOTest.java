package org.han.foodstore.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.han.foodstore.dao.FoodStoreDAO;
import org.han.foodstore.dao.FoodStoreDAOImpl;
import org.han.foodstore.util.SqlAgent;
import org.han.vo.StoreVO;
import org.junit.Before;
import org.junit.Test;

public class FoodStoreDAOTest {

	FoodStoreDAO dao;
	
	@Before
	public void setUp() throws Exception {
		dao = new FoodStoreDAOImpl();
	}

	@Test
	public void storeInsert() {
		try{
			StoreVO vo = new StoreVO();
			vo.setSname("낭만짬뽕");
			vo.setAddr("서울 중구 초동 골목기일~");
			vo.setKeyword("짬뽕,만두");
			vo.setSdesc("국물이 맛있지만 살이 많이 찔거같아요.");
			
			dao.create(vo);

		}catch(Exception e){
		fail(e.getMessage());
		}
	}
	
	@Test
	public void storetestSelect() {
		try{
			StoreVO vo = new StoreVO();
			vo = dao.read(4);
			System.out.println(vo);

		}catch(Exception e){
		fail(e.getMessage());
		}
	}
	

	@Test
	public void storeUpdate() {
		try{
			StoreVO vo = new StoreVO();
			vo.setSno(4);
			vo.setSname("한평커피");
			vo.setAddr("서울 중구 초동....");
			vo.setKeyword("쥬스");
			vo.setTel("02-456-7890");
			vo.setSdesc("청포도 쥬스 마시쪙");
			
			dao.update(vo);

		}catch(Exception e){
		fail(e.getMessage());
		}
	}
	
	@Test
	public void storeDelete() {
		try{		
			dao.delete(22);

		}catch(Exception e){
		fail(e.getMessage());
		}
	}
	
	@Test
	public void moveTest(){
		
		String query = "select  dept.deptno, dept.dname, empno"
				+ " from scott.dept, scott.emp"
				+ " where dept.deptno = emp.deptno";
		
		try{
			new SqlAgent(){

				@Override
				protected void doJob() throws Exception {
					// TODO Auto-generated method stub
					pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					rs = pstmt.executeQuery();
					
					rs.absolute(1);
					System.out.println(rs.getString(1));
					
					rs.updateString("dname","홍길동");
					
					rs.updateRow();
					
				}
				
			}.doExecute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
