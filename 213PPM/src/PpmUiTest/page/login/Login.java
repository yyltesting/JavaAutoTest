package PpmUiTest.page.login;

import PpmUiTest.base.BrowserOption;
import PpmUiTest.base.UseBrowser;
import PpmUiTest.content.logincontent.LoginContent;

public class Login {
	BrowserOption browser;
	//绕过登录进入后台
	public void Login(){
		browser = new BrowserOption(UseBrowser.driver);
		//打开浏览器传入cookie跳过登录验证
		browser.openUrl("https://ppm.yunget.com/toLogin");
		browser.AddCookie(LoginContent.Cookiename, LoginContent.Cookievalue);
		browser.Reflush();
		browser.sleep(1);
		//点击工程管理
		browser.click("id", LoginContent.ProjectAdministration);
		browser.sleep(3);
		//等待元素出现
		browser.waitFor(60, "xpath", LoginContent.Backstage);
		System.out.println(browser.value("xpath", LoginContent.Backstage));
		//进入后台
		browser.click("xpath", LoginContent.Backstage);
		browser.sleep(3);
		System.out.println(browser.title());
		//切换窗口
		browser.changeWindow(1);
		System.out.println(browser.title());
//		browser.openUrl("https://ppm.yunget.com/project/93cd0b9a23a43286cb8f564ef27e0879/index");
		browser.sleep(2);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseBrowser useBrowser = new UseBrowser();
		Login login = new Login();
		login.Login();
		useBrowser.quit();

	}

}
