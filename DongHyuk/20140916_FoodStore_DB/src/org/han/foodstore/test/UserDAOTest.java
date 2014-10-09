package org.han.foodstore.test;

import static org.junit.Assert.*;

import org.han.foodstore.dao.UserDAO;
import org.han.foodstore.dao.UserDAOImpl;
import org.han.vo.StoreVO;
import org.han.vo.UserVO;
import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {
	
	UserDAO udao;

	@Before
	public void setUp() throws Exception {
		udao = new UserDAOImpl();
	}

	@Test
	public void userInsert() {
		try {
			UserVO uvo = new UserVO();
			uvo.setUserid("user01");
			uvo.setPassword("user01");
			uvo.setUsername("임꺽정");
			uvo.setEmail("GukJung@bit.co.kr");
			
			udao.create(uvo);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	
	@Test
	public void userSelect() {
		try{
			UserVO uvo = new UserVO();
			uvo = udao.read("user01");
			System.out.println(uvo);

		}catch(Exception e){
		fail(e.getMessage());
		}
	}
	
	@Test
	public void userUpdate() {
		try{
			UserVO uvo = new UserVO();
			uvo.setPassword("kim00");
			uvo.setUsername("강감찬");
			uvo.setEmail("Kang@naver.com");
			uvo.setUserid("user00");
			
			udao.update(uvo);

		}catch(Exception e){
		fail(e.getMessage());
		}
	}
	

	@Test
	public void userDelete() {
		try{
			udao.delete("user03");
		}catch(Exception e){
		fail(e.getMessage());
		}
	}
}
