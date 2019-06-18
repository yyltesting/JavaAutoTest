package changku.page;

import changku.base.DriverOption;
import changku.base.TouchDriver;
import changku.content.Registercontent;

public class Register {
	DriverOption tel;
	public void register(String name,String password,String sure){
		tel=new DriverOption(TouchDriver.driver);
		tel.click("text", Registercontent.zhuche);
		tel.sleep(2);
		tel.inputText("id", Registercontent.user,name);
		tel.inputText("id", Registercontent.pwd, password);
		tel.inputText("id", Registercontent.surepwd,sure);
		tel.click("text", Registercontent.sureR);
		}
	public String Fail(String text){
		return tel.t(text);
	}
	public String success(String text){
		return tel.t(text);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
