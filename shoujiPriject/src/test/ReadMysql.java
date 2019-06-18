package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadMysql {
	//定义连接
	Connection conn;
	//定义发送sql 对象
	PreparedStatement ps;
	//定义结果集
	ResultSet rs;
	
	
	public void readDb() throws ClassNotFoundException, SQLException{
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quote", "root", "123456");
		//创建sql对象 发送sql
		ps=conn.prepareStatement("select * from tb_order");
		//执行并返回结果
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
