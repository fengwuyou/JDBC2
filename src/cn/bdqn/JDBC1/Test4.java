package cn.bdqn.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * 使用Statement更新信息
 * @author ly
 *
 */
public class Test4 {
	private static Logger logger=Logger.getLogger(Test4.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		//1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		try {
			//2.建立连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty","ly","luoyi");
			//3.更新狗狗数据信息
			stmt=conn.createStatement();
			stmt.executeUpdate("update animal set love=99,health=99 where bid=04");
			logger.info("信息更新成功！");
		} catch (SQLException e) {
			logger.error(e);
		}finally{
			//4.关闭Statement和数据库连接
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
