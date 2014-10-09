package org.han.foodstore.dao;

import org.han.vo.StoreVO;

public interface GenericDAO<E, K> {
	
	public void create(E vo)throws Exception;
	
	public E read(K sno)throws Exception;
	
	public void update(E vo)throws Exception;
	
	public void delete(K sno)throws Exception;
}
