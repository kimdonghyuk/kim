package org.han.foodstore.dao;

import org.han.vo.StoreVO;

public interface FoodStoreDAO extends GenericDAO<StoreVO, Integer> {
	// create, update 할 때에는 전체적인 정보를 개설하거나 수정하는 것이므로 StoreVO 타입의 형식을 쓴다.
	// read하거나 delete 할 때에는 primary key만 알면 되기때문에 StoreVO의 sno만 parameter타입으로 받는다.
}
