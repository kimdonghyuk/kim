package org.han.foodstore.dao;

import org.han.vo.UserVO;

public interface UserDAO {
	
	public void create(UserVO uvo) throws Exception;
	
	public UserVO read(String userid) throws Exception;
	
	public void update(UserVO uvo) throws Exception;
	
	public void delete(String userid) throws Exception;
	
	

}
