package Tuozhan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
	
	private List<Student> studentList;
	
	ManagerStudent(){
		studentList=new ArrayList<>();
	}
	
	public void test(Student s){
	
		
	}
	
	public void addStudent(String name,String phoneNumber){
		Student student= new Student(name,phoneNumber);
		studentList.add(student);
	}
	
	public void searchStudent(String name){
		int count=0;
		for(int i=0;i<studentList.size();i++){
			if(studentList.get(i).getName().equals(name)){
				count+=1;
			System.out.println("name:"+studentList.get(i).getName()
					+" "+"phone:"+studentList.get(i).getPhoneNumber());
			}
		
		}
		if(count==0){
			System.out.println("nodata");
		}
//		System.out.println("nodate");
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ManagerStudent st = new ManagerStudent();
        while(true){
        	System.out.println("1、添加学生");
        	System.out.println("2、查看学生");
        	System.out.println("3、退出");
        	System.out.println("请选择");
        	Scanner sc = new Scanner(System.in);
        	String select=sc.nextLine();
        	if(select.equals("1")){
        		System.out.println("please your name");
        		String name=sc.nextLine();
        		System.out.println("please your phoneNubmer");
        		String phoneNumber=sc.nextLine();
        		st.addStudent(name, phoneNumber);
        	}else if(select.equals("2")){
        		System.out.println("please your name");
        		String name=sc.nextLine();
        		st.searchStudent(name);
        	}else if(select.equals("3")){
        		System.out.println("quit");
        		break;
        	}
        	
        	
        }
        
        
//        st.addStudent("zhangsan", "18899977");
//        st.addStudent("lisi", "18899977");
//        st.searchStudent();
////        System.out.println(st.studentList.get(1).getName());
	}

}
