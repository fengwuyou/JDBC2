package cn.bdqn.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * ʹ��Statement��ӳ���
 * @author ly
 *
 */
public class Test3 {
	private static Logger logger=Logger.getLogger(Test3.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		int bid=4;
		String name="ŷŷ";
		int health=100;
		int love=20;
		String stain="̩��";
		//1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		//2.��������
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			//3.������Ϣ
			stmt=conn.createStatement();
			//insert into animal(bid,name,health,love,stain)value(
			//3,"
			//ŷŷ",
			//100,
			//20��"
			//̩��");
			StringBuffer sbql=new StringBuffer("insert into animal(bid,name,health,love,stain)value(");
			sbql.append(bid+",'");
			sbql.append(name+"',");
			sbql.append(health+",");
			sbql.append(love+",'");
			sbql.append(stain+"');");
			stmt.execute(sbql.toString());
			logger.info("���빷����Ϣ�ɹ���");
		} catch (SQLException e) {
			logger.error(e);
		}finally{
			 //�ر�����
				try {
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
}
