package org.han.bbs;

import java.util.Arrays;

public class BbsCriteria {

	private String[] types;
	private String keyword;
	
	public BbsCriteria(String[] types, String keyword) {
		super();
		this.types = types;
		this.keyword = keyword;
	}

	public String[] getTypes() {
		return types;
	}

	public String getKeyword() {
		return keyword;
	}

	@Override
	public String toString() {
		return "BbsCriteria [types=" + Arrays.toString(types) + ", keyword="
				+ keyword + "]";
	}
	
	
	
	
}
