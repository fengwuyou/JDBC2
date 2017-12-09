package cn.bdqn.JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * 查询MySQL数据库里的记录的总数
 * @author ly
 *
 */
public class page173Num4 {
	private static Logger logger=Logger.getLogger(page173Num4.class.getName());
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
			//3.查询信息条数
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from animal");
			int count=0;//记录条数
			while(rs.next()){
				count=count+1;
			}
			System.out.println("animal表中的数据条数为"+count);
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
			logger.error(e);
		}
		
	}
}
