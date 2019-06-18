package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mysql {
			//定义连接
			Connection conn;
			//定义发送sql 对象
			PreparedStatement ps;
			//定义结果集
			ResultSet rs;
			
			
			public List<Rap>  readDb() throws ClassNotFoundException, SQLException{
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				//建立连接
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/em", "root", "123456");
				//创建sql对象 发送sql
				ps=conn.prepareStatement("select * from rap");
				//执行并返回结果
				rs=ps.executeQuery();
				List<Rap> list=new ArrayList<>();
				while(rs.next()){
					Rap rapper=new Rap();
					rapper.setId(rs.getString("id"));
					rapper.setName(rs.getString("name"));
					rapper.setFlow(rs.getString("flow"));
					list.add(rapper);
				}
				rs.close();
				ps.close();
				conn.close();
				return list;
					
					
				}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Mysql sql= new Mysql();
		System.out.println(sql.readDb().get(1).getName());

	}

}
