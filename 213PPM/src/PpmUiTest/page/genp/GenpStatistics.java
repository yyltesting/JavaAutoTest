package PpmUiTest.page.genp;

import PpmUiTest.base.BrowserOption;
import PpmUiTest.base.UseBrowser;
import PpmUiTest.content.genpcontent.GenpContent;
import PpmUiTest.page.login.Login;


public class GenpStatistics {
	BrowserOption br;
	//������Ƭͳ��
	public void GetintoStatistics(){
		br = new BrowserOption(UseBrowser.driver);
		//��ͣ�������˵�
		br.DontmoveAction("xpath", GenpContent.Leftmenu);
		br.sleep(1);
		//���������
		br.click("xpath", GenpContent.Sliderbar);
		//�����ק������
		br.RemoveElement(0, 294, "xpath", GenpContent.Scrollslider);
		br.sleep(2);
		//�ȴ�Ԫ�س���
		br.waitFor(20,"xpath",GenpContent.Genp);
		//����������˻�Ӱ��
		br.click("xpath",GenpContent.Genp);
		br.sleep(2);
		//���������Ƭͳ��
		br.click("xpath", "//*[@id='navbar-container']/div/ul/li[8]/a");
		//�ȴ�ͳ��ҳ�����
//		br.waitFor(20, "xpath", "//*[@id='main-container']/div[2]/div[1]/div[2]/p[1]/span");
		br.sleep(2);
	}
	//��ȡ������
	public String Title(){
		return br.value("xpath", "//*[@id='table-unit-section']/caption");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseBrowser use=new UseBrowser();
		GenpStatistics loginpage=new GenpStatistics();
		loginpage.GetintoStatistics();
		System.out.println(loginpage.Title());
		use.quit();
		
	}

}
