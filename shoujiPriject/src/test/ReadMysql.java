package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadMysql {
	//��������
	Connection conn;
	//���巢��sql ����
	PreparedStatement ps;
	//��������
	ResultSet rs;
	
	
	public void readDb() throws ClassNotFoundException, SQLException{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quote", "root", "123456");
		//����sql���� ����sql
		ps=conn.prepareStatement("select * from tb_order");
		//ִ�в����ؽ��
		rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("orderNO"));
		}
		rs.close();
		ps.close();
		conn.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ReadMysql db=new ReadMysql();
		db.readDb();

	}

}
