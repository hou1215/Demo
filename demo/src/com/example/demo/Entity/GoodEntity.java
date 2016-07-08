package com.example.demo.Entity;

/**
 * @author hx *****************************
 *
 */
public class GoodEntity 
{
	private String msg;
	private boolean good;
	private int price;
	private String isrc;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isGood() {
		return good;
	}
	public void setGood(boolean good) {
		this.good = good;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIsrc() {
		return isrc;
	}
	public void setIsrc(String isrc) {
		this.isrc = isrc;
	}
	@Override
	public String toString() {
		return "GoodEntity [msg=" + msg + ", good=" + good + ", price=" + price
				+ ", isrc=" + isrc + "]";
	}
	
	
}
