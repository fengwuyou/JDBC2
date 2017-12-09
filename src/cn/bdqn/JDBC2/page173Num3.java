package cn.bdqn.JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * 使用Statement查询MySQL里的数据
 * @author ly
 *
 */
public class page173Num3 {
	private static Logger logger=Logger.getLogger(page173Num3.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		//2.建立连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty","ly","luoyi");
			//3.查询信息
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select id,name from student");
			System.out.println("\t\t学生信息表");
			System.out.println("序号\t姓名");
			while(rs.next()){
				System.out.print(rs.getInt("id")+"\t");
				System.out.print(rs.getString(2)+"\n");
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		//4.关闭连接
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
			logger.error(e);		}
	}
}
