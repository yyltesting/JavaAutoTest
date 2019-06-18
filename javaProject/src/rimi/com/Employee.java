package rimi.com;

public class Employee {
	public String name;
	public double nianxin;
	public MyDate time;
	Employee(String name,double nianxin,MyDate time){
		this.name=name;
		this.nianxin=nianxin;
		this.time=time;
	}
	public void distime(MyDate m){
		System.out.println("date:"+this.time.nian+"-"+this.time.yue+"-"+this.time.ri);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate t1=new MyDate("1999","01","27");
		Employee boss = new Employee("laobai",19999999,t1);
		boss.distime(t1);
		
		
	}

}
