package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mysql {
			//��������
			Connection conn;
			//���巢��sql ����
			PreparedStatement ps;
			//��������
			ResultSet rs;
			
			
			public List<Rap>  readDb() throws ClassNotFoundException, SQLException{
				//��������
				Class.forName("com.mysql.jdbc.Driver");
				//��������
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/em", "root", "123456");
				//����sql���� ����sql
				ps=conn.prepareStatement("select * from rap");
				//ִ�в����ؽ��
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
