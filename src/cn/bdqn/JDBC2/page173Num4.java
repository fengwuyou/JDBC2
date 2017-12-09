package cn.bdqn.JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * ��ѯMySQL���ݿ���ļ�¼������
 * @author ly
 *
 */
public class page173Num4 {
	private static Logger logger=Logger.getLogger(page173Num4.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		//2.��������
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty","ly","luoyi");
			//3.��ѯ��Ϣ����
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from animal");
			int count=0;//��¼����
			while(rs.next()){
				count=count+1;
			}
			System.out.println("animal���е���������Ϊ"+count);
		} catch (SQLException e) {
			logger.error(e);
		}
		//4.�ر�����
		try {
			if(rs!=null){
			rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		
	}
}
