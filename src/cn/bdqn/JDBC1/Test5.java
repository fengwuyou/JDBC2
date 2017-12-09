package cn.bdqn.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * 使用Statement验证安全性，存在SQL注入隐患
 * @author ly
 *
 */
public class Test5 {
	private static Logger logger=Logger.getLogger(Test5.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//获取账号和密码
		Scanner input=new Scanner(System.in);
		System.out.println("\t\t宠物主人登录");
		System.out.println("请输入姓名");
		String name=input.next();
		System.out.println("请输入密码");
		String pwd=input.next();
		//1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		//2.建立连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			//判断宠物主人登录是否成功
			stmt=conn.createStatement();
			String sql="select * from master where name='"+name+"'and pwd='"+pwd+"'";
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				System.out.println("登录成功！欢迎您");
			}else{
				System.out.println("登录失败！请重新输入");
			}
		} catch (SQLException e) {
			logger.error(e);
		}finally{
			try {
				if(rs!=null){
				rs.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
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
