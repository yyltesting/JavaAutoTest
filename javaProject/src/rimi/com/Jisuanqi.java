package rimi.com;

public class Jisuanqi {
//	public double a;
//	public double b;
//	Jisuanqi(double a,double b){
//		this.a=a;
//		this.b=b;
//	}
	
	public double jiaFa(double a,double b){
		return a+b;
	}
	public double jianfa(double a,double b){
		return a-b;
	}
	public double chenfa(double a,double b){
		return a*b;
	}
	public double chufa(double a,double b){
		return a/b;
	}
	public double cul(double a,double b,String c){
		if(c.equals("+")){
			return a+b;
		}else if(c.equals("-")){
			return a-b;
		}else if(c.equals("*")){
			return a*b;
		}else if(c.equals("/")){
			return a/b;
		}else{
			System.out.println("²Ù×÷·û²»¶Ô");
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jisuanqi q = new Jisuanqi();
		System.out.println(q.chenfa(5,5.5));

	}

}
