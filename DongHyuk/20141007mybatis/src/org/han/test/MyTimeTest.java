package org.han.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.han.dao.GenericDAO;
import org.han.member.MemberVO;
import org.junit.Before;
import org.junit.Test;

public class MyTimeTest {

	SqlSessionFactory sqlMapper;

	@Before
	public void setup() throws Exception {
		Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
		sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	}
	
	@Test
	public void ifTest() {
		try (SqlSession session = sqlMapper.openSession()) {

			GenericDAO<MemberVO, String> dao = new GenericDAO<MemberVO, String>(
					"org.han.member.MemberMapper");

			MemberVO vo = new MemberVO();
			vo.setUserpw("pw12");
			
			try {
				vo = dao.iftest(vo);
				System.out.println(vo.toString());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	public void ifTest2_EUNAE() {
	{
		try (SqlSession session = sqlMapper.openSession()) {

//			GenericDAO<MemberVO, String> dao = new GenericDAO<MemberVO, String>(
//					"org.han.member.MemberMapper");

			MemberVO vo = new MemberVO();
			MemberVO vo2 = new MemberVO();
			vo.setUserpw("pw12");
			
			try {
				
				vo2 = session.selectOne("org.han.member.MemberMapper.read", vo);
				System.out.println(vo.toString());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		}
	}
	
	
	@Test
	public void readTestGeneric() {
		try (SqlSession session = sqlMapper.openSession()) {

			GenericDAO<MemberVO, String> dao = new GenericDAO<MemberVO, String>(
					"org.han.member.MemberMapper");

			try {
				MemberVO vo = dao.read("user00");
				System.out.println(vo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.commit();
		}
	}

	@Test
	public void insertTestGeneric() {
		try (SqlSession session = sqlMapper.openSession()) {

			GenericDAO<MemberVO, String> dao = new GenericDAO<MemberVO, String>(
					"org.han.member.MemberMapper");

			MemberVO vo = new MemberVO();
			vo.setUserid("user55");
			vo.setUserpw("pw12");
			vo.setUsername("�͸�");
			vo.setPhone("01012345678");
			vo.setEmail("bit@bit.com");

			try {
				dao.create(vo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.commit();
		}

	}
	
	@Test
	public void updateTestGeneric() {
		try (SqlSession session = sqlMapper.openSession()) {

			GenericDAO<MemberVO, String> dao = new GenericDAO<MemberVO, String>(
					"org.han.member.MemberMapper");

			MemberVO vo = new MemberVO();
			vo.setUserid("user48");
			vo.setUserpw("pw48");
			vo.setUsername("KimDongHyuk");
			vo.setPhone("01023570709");
			vo.setEmail("kimadsle@hanmail.net");

			try {
				dao.update(vo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.commit();
		}
	}
	
	
	

	@Test
	public void deleteTest() throws Exception {
		try (SqlSession session = sqlMapper.openSession()) {
			session.delete("org.han.member.MemberMapper.delete", "user12");

			session.commit();
		}
	}

	@Test
	public void readTest() throws Exception {
		try (SqlSession session = sqlMapper.openSession()) {

			// List<MemberVO> list =
			// session.selectList("org.han.member.MemberMapper.read");
			// System.out.println(list);

			MemberVO vo = session.selectOne("org.han.member.MemberMapper.read",
					"user12");
			System.out.println(vo);
		}

	}


	@Test
	public void insertTest() {
		try (SqlSession session = sqlMapper.openSession()) {

			MemberVO vo = new MemberVO();
			vo.setUserid("againuser12");
			vo.setUserpw("pw12");
			vo.setUsername("�赿��");
			vo.setPhone("01023570709");
			vo.setEmail("kimadsle@naver.com");

			session.insert("org.han.member.MemberMapper.create", vo);
			session.commit();
			session.close();
		}
	}

	@Test
	public void test() {
		System.out.println(sqlMapper);

		SqlSession session = sqlMapper.openSession();
		String time = session.selectOne("org.han.time.TimeMapper.getTime");
		System.out.println(time);
		session.close();
	}
	
	@Test
	public void dynamicTest() {
		try (SqlSession session = sqlMapper.openSession()) {

			session.commit();
		}
	}

}
