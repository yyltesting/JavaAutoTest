package changku.page;

import changku.base.DriverOption;
import changku.base.TouchDriver;
import changku.content.Logincontent;

public class Login {
	DriverOption tel;
	public void login(String name,String pwd){
		tel=new DriverOption(TouchDriver.driver);
		tel.inputText("id", Logincontent.user, name);
		tel.inputText("id", Logincontent.password, pwd);
		tel.sleep(2);
		tel.click("id", Logincontent.login);
//		tel.sleep(2);
		
	}
	public String success(String text){
		return tel.t(text);
	}
	public String fail(String text){
		return tel.t(text);
	}
	public void sure(){
		tel.sleep(5);
		tel.click("text", "以后再说");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
