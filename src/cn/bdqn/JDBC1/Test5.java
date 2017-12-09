package cn.bdqn.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * ʹ��Statement��֤��ȫ�ԣ�����SQLע������
 * @author ly
 *
 */
public class Test5 {
	private static Logger logger=Logger.getLogger(Test5.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//��ȡ�˺ź�����
		Scanner input=new Scanner(System.in);
		System.out.println("\t\t�������˵�¼");
		System.out.println("����������");
		String name=input.next();
		System.out.println("����������");
		String pwd=input.next();
		//1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		//2.��������
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			//�жϳ������˵�¼�Ƿ�ɹ�
			stmt=conn.createStatement();
			String sql="select * from master where name='"+name+"'and pwd='"+pwd+"'";
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				System.out.println("��¼�ɹ�����ӭ��");
			}else{
				System.out.println("��¼ʧ�ܣ�����������");
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
