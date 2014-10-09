package org.han.service;

import org.han.dao.TimeDAO;

public class TimeService {

	private TimeDAO dao;

	public void setDao(TimeDAO dao) {
		this.dao = dao;
	}
	
	public String getTime() throws Exception{
		return dao.getTime();
	}
	
	
}
