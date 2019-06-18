package crm.page.login;

import crm.base.BrowserOption;
import crm.base.UseBrowser;
import crm.content.login.LoginContent;

public class Loginpage {
	BrowserOption op;
	public void login(String username,String pwd){
		op=new BrowserOption(UseBrowser.driver);
		op.openUrl("http://localhost:8080/crm/login.jsp");
		op.inputText("name", LoginContent.username, username);
		op.inputText("name", LoginContent.pwd, pwd);
		op.click("id",LoginContent.submit);
		op.sleep(3);
	}
	public String al(){
		return op.changeAlterValues();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseBrowser use=new UseBrowser();
		Loginpage loginpage=new Loginpage();
		loginpage.login("admin","123456");
		use.quit();
		

	}

}
