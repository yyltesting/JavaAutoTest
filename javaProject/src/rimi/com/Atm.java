package rimi.com;

public class Atm {
	public static double banlance=10000;
	public static String id="800800";
	public static String pwd="822822";
	
	public void set_user(String id,String pwd,String newpwd,String confirmpwd){
		if(id.equals(Atm.id)&&pwd.equals(Atm.pwd)&&confirmpwd.equals(newpwd)){
			Atm.pwd=newpwd;
		}else{
			System.out.println("сп╢М");
		}
	
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atm atm=new Atm();
		atm.set_user("651561", "65156", "800800", "800800");
		

	}

}
