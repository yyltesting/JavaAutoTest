package youxuan.page;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;

import youxuan.base.DriverOption;
import youxuan.base.Touchdriver;
import youxuan.content.Logincontent;

public class Login {
	DriverOption tel;
	public void log(){
		tel=new DriverOption(Touchdriver.driver);
		tel.sleep(2);
		for(int i=0;i<=1;i++){
		tel.Move(600, 500, 100, 500, 500);
		}
		tel.sleep(3);
		tel.actionTappoint(700, 1000);
		tel.sleep(3);
		tel.click("id", Logincontent.man);
		tel.sleep(2);
		tel.click("text", Logincontent.know);
		tel.sleep(2);
		
//		tel.click("xpath", "//android.widget.ImageView[@index='2']");
//		tel.sleep(2);
//		tel.actionTappoint(200, 300);
//		tel.sleep(2);
//		tel.actionTappoint(300, 400);
//		tel.sleep(2);
//		tel.actionMax(300, 500, 100, 500, 500, 400, 500, 600, 500);
//		tel.sleep(2);
		}
		
		
	

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		Touchdriver u=new Touchdriver();
		Login l=new Login();
		u.open();
		l.log();
		u.quit();

	}

}
