package com.itheima.dao;

import java.util.ArrayList;

import com.itheima.dao.impl.USER;

public interface t_userDao {
	//��ѯ����
    ArrayList<USER> findAll();
	
	//��½
	void login(String username,String password);
}
