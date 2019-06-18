package rimi.com;

public class Teacher {
	public String name;
	public String kechen;
	public String zhuanye;
	public int jiaoning;
	public int number;
	Teacher(String name,String kechen,String zhuanye,int jiaoning,int number){
		this.name=name;
		this.kechen=kechen;
		this.zhuanye=zhuanye;
		this.jiaoning=jiaoning;
		this.number=number;
	}
	public int getNumber(){
		return this.number;
	}
	public void tongban(Student g){
		if(this.number==g.number){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student gl=new Student("xiaoming",22,"pingpang",1805);
		Teacher n=new Teacher("laobai","internete","sawg",10,1804);
		n.tongban(gl);

	}

}
