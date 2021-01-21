package com.attendance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	/**
	 * ��װ�������ݿ�Ļ�������
	 */

	/*
	 * ��������
	 */

	Connection conn = null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//����������Ϣ���ַ�������
	static String driverName="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String user="scott";
	String password="ren372930";

	/*
	 * ���巽��
	 */
	//��������
	static{
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��ȡjdbc�����Ӷ���
	public Connection getConn(){
		try {
			conn=DriverManager.getConnection(url, user, password);
			if(conn!=null){
				//�����Զ��ύΪ��
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//��ȡsql״̬����
	public PreparedStatement getPs(Connection conn,String sql){
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	//�ر�������
	public void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//��װ�ֶ��ύ����
	public void commit(Connection conn){
		try {
			if(conn!=null){
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//��װ���˲���
	public void rollback(Connection conn){
		try {
			if(conn!=null){
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
