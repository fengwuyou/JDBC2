package cn.bdqn.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * ʹ��Statement������Ϣ
 * @author ly
 *
 */
public class Test4 {
	private static Logger logger=Logger.getLogger(Test4.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		//1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		try {
			//2.��������
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty","ly","luoyi");
			//3.���¹���������Ϣ
			stmt=conn.createStatement();
			stmt.executeUpdate("update animal set love=99,health=99 where bid=04");
			logger.info("��Ϣ���³ɹ���");
		} catch (SQLException e) {
			logger.error(e);
		}finally{
			//4.�ر�Statement�����ݿ�����
				try {
					if(stmt!=null){
					stmt.close();
					}
				} catch (SQLException e) {
					logger.error(e);
				}
			try {
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
}
