package PpmAPP.page;

import java.net.MalformedURLException;

import PpmAPP.base.DriverOption;
import PpmAPP.base.TouchDriver;
import PpmAPP.content.AppLoginContent;

public class AppLogin {
	DriverOption option;
	public void Loginto(String phone,String password){
		option = new DriverOption(TouchDriver.driver);
		option.sleep(1);
		option.inputText("xpath", AppLoginContent.phone, phone);
		option.sleep(1);
		option.inputText("xpath", AppLoginContent.password, password);
		option.sleep(1);
		option.click("xpath", AppLoginContent.signin);
		option.sleep(2);
		option.waitFor(30, "xpath" , AppLoginContent.verification);
		option.actionMove(340, 1631, 1100, 1631, 1500);
		option.sleep(5);
		System.out.print(option.Text("”¶”√"));
		}

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		TouchDriver touchDriver = new TouchDriver();
		AppLogin login = new AppLogin();
		touchDriver.open();
		login.Loginto("15729866869", "yyl123456");
		touchDriver.quit();

	}

}
