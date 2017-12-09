package cn.bdqn.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * ʹ��Statement��ResultSet��ѯ���г���
 * @author ly
 *
 */
public class Test2 {
	private static Logger logger=Logger.getLogger(Test2.class.getName());
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rst=null;
		//1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		logger.error(e);
		}
		//2.��������
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty","ly","luoyi");
			//3.��ѯ�������Ϣ
			stmt=conn.createStatement();
			rst=stmt.executeQuery("SELECT bid,name,health,love,stain From animal");
			System.out.println("\t\t������Ϣ��");
			System.out.println("���\t����\t����ֵ\t���ܶ�\tƷ��");
			while(rst.next()){
				System.out.print(rst.getInt(1)+"\t");
				System.out.print(rst.getString("name")+"\t");
				System.out.print(rst.getInt(3)+"\t");
				System.out.print(rst.getInt(4)+"\t");
				System.out.print(rst.getString(5)+"\n");		
			}
		} catch (SQLException e) {
			logger.error(e);
		}finally{
			//�رս����statement�����ݿ�����
				try {
					if(null!=rst){
						rst.close();
					}
					if(null!=stmt){
						stmt.close();
					}
					if(null!=conn){
						conn.close();
					}
				} catch (SQLException e) {
					logger.error(e);
				}
			
		}
		
	}
}
