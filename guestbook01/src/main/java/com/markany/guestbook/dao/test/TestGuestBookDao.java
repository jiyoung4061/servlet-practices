package com.markany.guestbook.dao.test;

import java.util.List;

import com.markany.guestbook.dao.GuestBookDao;
import com.markany.guestbook.vo.GuestBookVo;

public class TestGuestBookDao {
	public static void main(String[] args) {
		GuestBookVo vo = new GuestBookVo();
		
		vo.setName("오지영");
		vo.setPassword("4567");
		vo.setMessage("hello");
		testInsert(vo);
		
		testFindAll();
	}

	
	public static void testFindAll() {
		List<GuestBookVo> list = new GuestBookDao().findAll();
		
		for(GuestBookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static boolean testInsert(GuestBookVo vo) {
		return new GuestBookDao().insert(vo);
	}
}
