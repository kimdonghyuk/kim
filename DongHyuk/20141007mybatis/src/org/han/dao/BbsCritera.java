package org.han.dao;

import java.util.Arrays;

public class BbsCritera {
	
	private String[] type;
	private String keyword;
	
	
	public BbsCritera(String[] type, String keyword) {
		super();
		this.type = type;
		this.keyword = keyword;
	}


	public String[] getType() {
		return type;
	}


	public String getKeyword() {
		return keyword;
	}


	@Override
	public String toString() {
		return "BbsCritera [type=" + Arrays.toString(type) + ", keyword="
				+ keyword + "]";
	}	

}
