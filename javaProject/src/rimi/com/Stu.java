package rimi.com;

import java.util.ArrayList;
import java.util.List;

public class Stu {
	public static List xuesheng;
//	public static List number;
	
	public void addStudent(String name,String number){
		List<Stu> xuesheng=new ArrayList<Stu>();
		
		Stu.xuesheng.add(name);
		Stu.xuesheng.add(number);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stu student=new Stu();
		student.addStudent("zhangsan", "110");
		System.out.println(student.xuesheng);

	}

}
