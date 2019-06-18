package crm.page.useradd;

import org.openqa.selenium.JavascriptExecutor;

import crm.base.BrowserOption;
import crm.base.UseBrowser;
import crm.content.login.LoginContent;
import crm.content.useradd.UseraddContent;
import crm.page.login.Loginpage;

public class Useraddpage {
	BrowserOption op;
	public void userAdd(String name,String mil,String peipeo,String time){
		op=new BrowserOption(UseBrowser.driver);
		op.changeFram("/html/frameset/frameset/frame[1]");
		op.click("xpath",UseraddContent.userinformation);
		op.changeFram("/html/frameset/frameset/frame[2]");
		op.click("xpath", UseraddContent.userad);
		op.sleep(1);
		op.inputText("xpath",UseraddContent.username,name);
		op.inputText("xpath",UseraddContent.emil, mil);
		op.inputText("xpath", UseraddContent.person, peipeo);
		JavascriptExecutor js =(JavascriptExecutor)op.driver;
		js.executeScript("window.document.getElementById('customerBirthday').removeAttribute('readonly')"
);
		op.inputText("xpath", UseraddContent.time, time);
		op.click("name", "submit");
		op.sleep(2);
	}
	public String al(){
		return op.changeAlterValues();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseBrowser use=new UseBrowser();
		Loginpage login=new Loginpage();
		Useraddpage user=new Useraddpage();
		login.login("admin", "123456");
		user.userAdd("����", "79182765@qq.com", "����", "2018-10-10 16:23:22");
		
		use.quit();
		
		

	}

}
