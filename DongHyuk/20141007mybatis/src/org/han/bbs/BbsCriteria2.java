package org.han.bbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BbsCriteria2 {
	
	private Map<String, String> crimap;
	private Map<String, String> colMap;

	private List<String> values;
	
	

	public BbsCriteria2() {
		
		crimap = new HashMap<String, String>();
		colMap = new HashMap<String, String>();
		//컬럼명 map을 만들어준다
		colMap.put("t", "title");
		colMap.put("w", "writer");
		colMap.put("c", "content");
		
	}
	
	
	public String getSql(){
		//문자열 사용하지 말고  stringbuilder나 버퍼 써라.
		StringBuilder builder = new StringBuilder(" AND ");
		
		Iterator<String> it = crimap.keySet().iterator();
		this.values = new ArrayList<String>();
		
		for (int i = 0; i < crimap.size(); i++) {
			this.values.add("DUMMY");
			
		}
		
		while(it.hasNext()){
			
			String key = it.next();
			this.values.add(crimap.get(key));
			
			builder.append(colMap.get(key) +" = #{key}");
			builder.append(" AND ");
			
		}	
		return builder.substring(0, builder.length()-4);
	}
	
	
	public String getKey(){
		System.out.println("SIZE : " + this.values.size());
		return this.values.remove(0);
	}
	
	public void addCri(String key, String value){
		
		crimap.put(key, value);
		
	}
	
/*
	public Map<String, String> getCrimap() {
		return crimap;
	}
	
	public String getKey(){
	      return "aaaa";
	   }
	
	
	public String getVal(String key){
		
		return "AAA";
	}
	
	public String getSql(){
		return "where title =#{key} and writer =#{key}";
	}
	
	*/
	
	
	@Override
	public String toString() {
		return "BbsCriteria2 [crimap=" + crimap + "]";
	}
	
	

}
