package cn.bdqn.JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * 在防注入的前提下登录master
 * @author ly
 *
 */
public class page173Num5 {
	private static Logger logger=Logger.getLogger(page173Num5.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		System.out.println("\t\t主人登录信息表");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入用户名");
		String uName=input.next();
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
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty","ly","luoyi");
			String sql="select *from master ";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
//			while(rs.next()){
//				System.out.println(rs.getInt("id"));
//				System.out.println(rs.getString("name"));
//				System.out.println(rs.getString("pwd"));
//			}
			if(rs.next()){
				System.out.println("登录成功！");
			}else{
				System.out.println("登陆失败！");
			}
		} catch (SQLException e) {
			logger.error(e);
		}
	}
}
