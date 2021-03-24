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

import com.markany.guestbook.vo.GuestBookVo;

public class GuestBookDao {
	
	public List<GuestBookVo> findAll() {
		
		InfluxDB influxDB = getConnection();
		QueryResult queryResult = influxDB.query(new Query("SELECT * FROM memory"));
		
		System.out.println("res:" + queryResult);
		
		return null;
//		List<GuestBookVo> list = new ArrayList<>();
//		Connection conn = null;
//		ResultSet rs = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = getConnection();
//			String sql = " select no, name, password, message, reg_date " + " from guestbook " + " order by no desc ";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				Long no = rs.getLong(1);
//				String name = rs.getString(2);
//				String password = rs.getString(3);
//				String message = rs.getString(4);
//				String reg_date = rs.getString(5);
//				GuestBookVo vo = new GuestBookVo();
//				vo.setNo(no);
//				vo.setName(name);
//				vo.setPassword(password);
//				vo.setMessage(message);
//				vo.setReg_date(reg_date);
//				list.add(vo);
//			}
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
	}

	public void insert(GuestBookVo vo) {
//		boolean result = false;
		
		InfluxDB influxDB = getConnection();
		
		influxDB.write(Point.measurement("memory")
			    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
			    .tag("host", vo.getHost())
			    .tag("region", vo.getRegion())
			    .addField("value", vo.getValue())
			    .build());
		try {
			Thread.sleep(5_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = getConnection(); // sqlexception 여기서 처리
//			// 3-1. SQL 준비
//			String sql = " insert " + " into guestbook " + " values(null, ?, ?, ?, now())";
//			pstmt = conn.prepareStatement(sql);
//
//			// 4. 바인딩
//			pstmt.setString(1, vo.getName());
//			pstmt.setString(2, vo.getPassword());
//			pstmt.setString(3, vo.getMessage());
//
//			// 5. sql문 실행
//			int count = pstmt.executeUpdate();
//
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
	
//	public boolean delete(String no, String password) {
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
//	}
//	
	private InfluxDB getConnection() throws InfluxDBException{
		
		final String serverURL = "http://127.0.0.1:8086", username = "markany", password = "markany2021";
		InfluxDB influxDB = InfluxDBFactory.connect(serverURL, username, password);
		
		String databaseName = "test";
		influxDB.setDatabase(databaseName);
		
		// Enable batch writes to get better performance.
		influxDB.enableBatch(BatchOptions.DEFAULTS);
		
		System.out.println("db 연결");
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
