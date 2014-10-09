package org.han.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.han.bbs.BbsCriteria;
import org.han.bbs.BbsCriteria2;
import org.han.bbs.BbsVO;
import org.han.dao.GenericDAO;
import org.han.member.MemberVO;

public class TimeTest {
	
	SqlSessionFactory sqlMapper;
	
	@Before
	public void setup()throws Exception{
		Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
		sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	}
	
	@Test
	public void dynamicTest2(){
		try(SqlSession session = sqlMapper.openSession()){
			
			BbsCriteria2 cri = new BbsCriteria2();
			cri.addCri("t", "123");
			cri.addCri("c", "내용");
			
			
			List<BbsVO> list = session.selectList("org.thinker.bbs.BbsMapper.selectDynamic2",cri);
			
			System.out.println(list);
			session.commit();
		}
	}
	
	@Test
	public void dynamicTest(){
		try(SqlSession session = sqlMapper.openSession()){
			
			BbsCriteria cri = new BbsCriteria(new String[]{"t","w","c"},"123");
			List<BbsVO> list = session.selectList("org.thinker.bbs.BbsMapper.selectDynamic",cri);
			
			System.out.println(list);
			session.commit();
		}
	}
	@Test
	public void deleteTest(){
		
		try(SqlSession session = sqlMapper.openSession()){
			
			session.delete("org.thinker.member.MemberMapper.delete", "user00");
			
			session.commit();
		}
		
	}
	
	@Test
	public void readTest(){
		
		try(SqlSession session = sqlMapper.openSession()){
			
			MemberVO vo = 
				session.selectOne("org.thinker.member.MemberMapper.read", "user00");
			
			System.out.println(vo);
			
		}
		
	}
	
	@Test
	public void insertTest3(){
		
		GenericDAO<BbsVO, Integer> dao = new GenericDAO<BbsVO, Integer>("org.thinker.bbs.BbsMapper");
		
		BbsVO vo = new BbsVO();
		vo.setTitle("테스트로 한번...");
		vo.setContent("이것도 테스트");
		vo.setWriter("user03");
		
		try {
			dao.create(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void insertTest2(){
		
		GenericDAO<MemberVO, String> dao 
		= new GenericDAO<MemberVO, String>("org.thinker.member.MemberMapper");
		
		
		MemberVO vo  = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("pw00");
		vo.setUsername("강요천");
		vo.setPhone("01010330333");
		vo.setEmail("ddasdfasd@daame.net");
		
		try {
			dao.create(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	@Test
	public void insertTest(){
		
		try(SqlSession session = sqlMapper.openSession()){
			
			MemberVO vo  = new MemberVO();
			vo.setUserid("eseer00");
			vo.setUserpw("pw00");
			vo.setUsername("강요천");
			vo.setPhone("01010330333");
			vo.setEmail("ddasdfasd@daame.net");
			
			session.insert("org.thinker.member.MemberMapper.create",vo);
			session.commit();
			session.close();
			
		}
		
	}

	@Test
	public void test() {
		System.out.println(sqlMapper);
		
		SqlSession session = sqlMapper.openSession();
		String time = session.selectOne("org.thinker.time.TimeMapper.getTime");
		System.out.println(time);
		session.close();
		
	}

}
