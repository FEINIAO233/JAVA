package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itheima.dao.t_userDao;
import com.itheima.util.JDBCUtil;

public class UserDaoimpl implements t_userDao {

	@Override
	public ArrayList<USER> findAll() {
		Connection conn = null;
        Statement st = null;
        ResultSet result = null;
        var List = new ArrayList<USER>();

        try {
            conn = JDBCUtil.GetConn();
            //3.����statement
            st = conn.createStatement();
            //4.ִ�в�ѯ
            result = st.executeQuery("SELECT * FROM t_user");

            //5.������ѯÿһ����¼
            while (result.next()) {
                //int id = result.getInt("id");
                //String username = result.getString("username");
                //System.out.println("ID:" + id + "USERNAME:" + username);
            	var e = new USER();
            	e.setId(result.getInt("id"));
            	e.setUsername(result.getString("username"));
            	e.setPassword(result.getString("password"));
            	e.setAddress(result.getString("address"));
            	List.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn, st, result);
        }
		return List;
	}

	@Override
	public void login(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet result = null;

        try {
            conn = JDBCUtil.GetConn();
            String sql = " SELECT * FROM  t_user WHERE username = ? AND password = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            //4.ִ�в�ѯ
            result = ps.executeQuery();
            
            if(result.next()) {
            	System.out.println("��½�ɹ�");
            }else {
            	System.out.println("��½ʧ��");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn, ps, result);
        }
		
	}

}
