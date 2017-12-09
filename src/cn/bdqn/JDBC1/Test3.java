package cn.bdqn.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * 使用Statement添加宠物
 * @author ly
 *
 */
public class Test3 {
	private static Logger logger=Logger.getLogger(Test3.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		int bid=4;
		String name="欧欧";
		int health=100;
		int love=20;
		String stain="泰迪";
		//1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		//2.建立连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			//3.插入信息
			stmt=conn.createStatement();
			//insert into animal(bid,name,health,love,stain)value(
			//3,"
			//欧欧",
			//100,
			//20，"
			//泰迪");
			StringBuffer sbql=new StringBuffer("insert into animal(bid,name,health,love,stain)value(");
			sbql.append(bid+",'");
			sbql.append(name+"',");
			sbql.append(health+",");
			sbql.append(love+",'");
			sbql.append(stain+"');");
			stmt.execute(sbql.toString());
			logger.info("插入狗狗信息成功！");
		} catch (SQLException e) {
			logger.error(e);
		}finally{
			 //关闭连接
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
