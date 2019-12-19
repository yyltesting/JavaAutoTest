package PpmUiTest.test;

import org.testng.annotations.Test;

import PpmUiTest.base.ReadExl;
import PpmUiTest.base.UseBrowser;
import PpmUiTest.page.genp.GenpStatistics;
import PpmUiTest.page.login.Login;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GenpTest {
	UseBrowser browser;
	GenpStatistics genp;
	Login login;
  @Test
  //成功的测试，内容相匹配
  public void Successful() {
	  genp.GetintoStatistics();
	  Assert.assertEquals(genp.Title(), ReadExl.ReadCell("sheet1", 1, 1));
  }
  @BeforeClass
  public void beforeClass() {
	  browser = new UseBrowser();
	  genp = new GenpStatistics();
	  login = new Login();
	  login.Login();
  }

  @AfterClass
  public void afterClass() {
	  browser.quit();
  }

}
