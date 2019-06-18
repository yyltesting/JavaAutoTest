package rimi.com;

public class Changfangx {
	public double chang;
	public double kuan;
	Changfangx(double chang,double kuan){
		this.chang=chang;
		this.kuan=kuan;
	}
	public void zhouchang(){
		System.out.println((this.chang+this.kuan)*2);
	}
	public void mianji(){
		System.out.println(this.chang*this.kuan);
	}
	public double setchang(double chang){
		 return this.chang=chang;
		 }
	public double setkuan(double kuan){
		 return this.kuan=kuan;
		 }
	public void get(){
		System.out.println("chang:"+this.chang+" "+"kuan:"+this.kuan);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Changfangx s = new Changfangx(19,25);
		s.zhouchang();
		s.mianji();
		s.get();

	}

}
