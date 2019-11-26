package com.itheima.test;

import org.junit.jupiter.api.Test;

import com.itheima.dao.t_userDao;
import com.itheima.dao.impl.UserDaoimpl;


public class TestDao {
	@Test
	public void testFindAll() {
		t_userDao dao = new UserDaoimpl();
		var list = dao.findAll();
		list.forEach(p -> System.out.println(p.getId()+p.getUsername() +p.getPassword() + p.getAddress()));
		
	}
	
	//@Test
	public void testLogin() {
		t_userDao dao = new UserDaoimpl();
		dao.login("admin", "1223");
	}
}
