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
		//�ȴ�Ԫ�س���
		browser.waitFor(3, "xpath", LoginContent.Backstage);
		//�����̨
		browser.click("xpath", LoginContent.Backstage);
		browser.sleep(1);
		//�л�����
		browser.changeWindow(1);
		browser.sleep(2);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
