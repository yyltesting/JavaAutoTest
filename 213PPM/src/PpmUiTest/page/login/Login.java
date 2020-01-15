package PpmUiTest.page.login;

import PpmUiTest.base.BrowserOption;
import PpmUiTest.base.UseBrowser;
import PpmUiTest.content.logincontent.LoginContent;

public class Login {
	BrowserOption browser;
	//�ƹ���¼�����̨
	public void Login(){
		browser = new BrowserOption(UseBrowser.driver);
		//�����������cookie������¼��֤
		browser.openUrl("https://ppm.yunget.com/toLogin");
		browser.AddCookie(LoginContent.Cookiename, LoginContent.Cookievalue);
		browser.Reflush();
		browser.sleep(1);
		//������̹���
		browser.click("id", LoginContent.ProjectAdministration);
		browser.sleep(3);
		//�ȴ�Ԫ�س���
		browser.waitFor(60, "xpath", LoginContent.Backstage);
		System.out.println(browser.value("xpath", LoginContent.Backstage));
		//�����̨
		browser.click("xpath", LoginContent.Backstage);
		browser.sleep(3);
		System.out.println(browser.title());
		//�л�����
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
