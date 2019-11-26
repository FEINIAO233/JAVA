package com.itheima.dao;

import java.util.ArrayList;

import com.itheima.dao.impl.USER;

public interface t_userDao {
	//²éÑ¯ËùÓĞ
    ArrayList<USER> findAll();
	
	//µÇÂ½
	void login(String username,String password);
}
