package PpmUiTest.page.genp;

import PpmUiTest.base.BrowserOption;
import PpmUiTest.base.UseBrowser;
import PpmUiTest.content.genpcontent.GenpContent;
import PpmUiTest.page.login.Login;


public class GenpStatistics {
	BrowserOption br;
	//进入照片统计
	public void GetintoStatistics(){
		br = new BrowserOption(UseBrowser.driver);
		//悬停鼠标至左菜单
		br.DontmoveAction("xpath", GenpContent.Leftmenu);
		br.sleep(1);
		//点击滑动条
		br.click("xpath", GenpContent.Sliderbar);
		//鼠标拖拽滑动条
		br.RemoveElement(0, 294, "xpath", GenpContent.Scrollslider);
		br.sleep(2);
		//等待元素出现
		br.waitFor(20,"xpath",GenpContent.Genp);
		//点击进入无人机影像
		br.click("xpath",GenpContent.Genp);
		br.sleep(2);
		//点击进入照片统计
		br.click("xpath", "//*[@id='navbar-container']/div/ul/li[8]/a");
		//等待统计页面出现
//		br.waitFor(20, "xpath", "//*[@id='main-container']/div[2]/div[1]/div[2]/p[1]/span");
		br.sleep(2);
	}
	//获取表内容
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
