package cn.bdqn.JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * �ڷ�ע���ǰ���µ�¼master
 * @author ly
 *
 */
public class page173Num5 {
	private static Logger logger=Logger.getLogger(page173Num5.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		System.out.println("\t\t���˵�¼��Ϣ��");
		Scanner input=new Scanner(System.in);
		System.out.println("�������û���");
		String uName=input.next();
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
				System.out.println("��¼�ɹ���");
			}else{
				System.out.println("��½ʧ�ܣ�");
			}
		} catch (SQLException e) {
			logger.error(e);
		}
	}
}
