package com.markany.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBException;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;

import com.markany.guestbook.vo.GuestBookVo;

public class GuestBookDao {
	
	public List<GuestBookVo> findAll() {
		InfluxDB influxDB = getConnection();
		QueryResult queryResult = influxDB.query(new Query("SELECT * FROM memory"));
		
		InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
		List<GuestBookVo> list = resultMapper.toPOJO(queryResult, GuestBookVo.class);

		return list;
	}

	public void insert(GuestBookVo vo) {
		InfluxDB influxDB = getConnection();
		
		influxDB.write(Point.measurement("memory")
			    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
			    .tag("host", vo.getHost())
			    .tag("region", vo.getRegion())
			    .addField("value", vo.getValue())
			    .build());
	}
	
	public boolean delete(String host, String region) {
		
		System.out.println("host:" + host);
		System.out.println("region:" + region);
		
		return true;
//		boolean result = false;
//		Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = getConnection(); 
//			// delete from guestbook where no=10 and password = '1234'
//			String sql = " delete " + " from guestbook " + " where no="+no+" and password= '"+password+"'";
//			pstmt = conn.prepareStatement(sql);
//			int count = pstmt.executeUpdate();
//			result = count == 1;
//
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		} finally {
//			try {
//				// 3. 자원정리
//				if (stmt != null) {
//					stmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
	}
	
	private InfluxDB getConnection() throws InfluxDBException{
		
		final String serverURL = "http://127.0.0.1:8086", username = "markany", password = "markany2021";
		InfluxDB influxDB = InfluxDBFactory.connect(serverURL, username, password);
		
		String databaseName = "test";
		influxDB.setDatabase(databaseName);
		
		// Enable batch writes to get better performance.
		influxDB.enableBatch(BatchOptions.DEFAULTS);
		
		return influxDB;
//		Connection conn = null;
//		try {
//		Class.forName("org.mariadb.jdbc.Driver");
//
//		// 2. 연결하기-> driverManager 클래스
//		String url = "jdbc:mysql://192.168.43.232:3307/webdb?characterEncoding=utf8";
//		conn = DriverManager.getConnection(url, "webdb", "apfhd123"); // webdb, password
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패:" + e);
//		} 
//		return conn;
	}
}
