package org.han.vo;

import java.util.Date;

public class MenuVO {
	
	private Integer mno; 
	private Integer sno; 
	private String mname; 
	private String price; 
	private Date regdate;
	
	
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "MenuVO [mno=" + mno + ", sno=" + sno + ", mname=" + mname
				+ ", price=" + price + ", regdate=" + regdate + "]";
	} 

}
