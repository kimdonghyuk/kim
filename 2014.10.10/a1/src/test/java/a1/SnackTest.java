package a1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:applicationContext.xml"})
public class SnackTest {
//	@RunWith(SpringJUnit4ClassRunner.class)
//	@ContextConfiguration(locations = {"file:applicationContext.xml"})
//  설정된 파일을 메모리로 끌어올리는 코드
	
	@Autowired
	// Autowired : 지금 이 Runwith에서 불러온 세상에 아래에 설정한 녀석 있으면 데려와!
	People p1;
//	ApplicationContext ctx;
	
	@Test
	public void test() {
		System.out.println(p1);
//		System.out.println(ctx.getBean("p1"));
	}

}