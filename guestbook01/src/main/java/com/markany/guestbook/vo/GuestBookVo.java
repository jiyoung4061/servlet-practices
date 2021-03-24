package com.markany.guestbook.vo;

public class GuestBookVo {
	private long value;
	private String host;
	private String region;
	
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	@Override
	public String toString() {
		return "GuestBookVo [value=" + value + ", host=" + host + ", region=" + region + "]";
	}	
}
