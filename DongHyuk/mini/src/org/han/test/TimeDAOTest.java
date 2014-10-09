package org.han.test;

import static org.junit.Assert.fail;

import org.han.dao.TimeDAO;
import org.junit.Before;
import org.junit.Test;

public class TimeDAOTest {
		
	TimeDAO dao;
	
	@Before
	public void setUp() throws Exception {
		dao = new TimeDAO();
	}

	@Test
	public void test() throws Exception {
		
		dao.getTime();
	}

}
