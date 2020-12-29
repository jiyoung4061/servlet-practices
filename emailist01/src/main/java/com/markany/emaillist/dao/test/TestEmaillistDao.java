package com.markany.emaillist.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.markany.emaillist.dao.EmaillistDao;
import com.markany.emaillist.vo.EmaillistVo;

public class TestEmaillistDao {

	public static void main(String[] args) {
		EmaillistVo vo = new EmaillistVo();
//		vo.setFirstName("마");
//		vo.setLastName("이콜");
//		vo.setEmail("michol@gmail.com");
//		testInsert(vo);
		testFindAll();
	}
	
	public static void testFindAll() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		
		for(EmaillistVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static boolean testInsert(EmaillistVo vo) {
		return new EmaillistDao().insert(vo);
	}

}
