package com.markany.guestbook.vo;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Measurement(name="memory")
public class GuestBookVo {
	
	@Column(name="value")
	private long value;
	
	@Column(name="host")
	private String host;
	
	@Column(name="region")
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
