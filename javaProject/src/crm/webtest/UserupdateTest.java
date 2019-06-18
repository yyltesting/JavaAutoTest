package crm.webtest;

import org.testng.annotations.Test;

import crm.base.UseBrowser;
import crm.page.login.Loginpage;
import crm.page.userupdate.Userupdate;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class UserupdateTest {
	UseBrowser use;
	Loginpage login;
	Userupdate update;
  @Test
  public void up1() {
	  update.update();
	  Assert.assertEquals(update.alter(),"客户修改成功");
	  
  }
  @BeforeClass
  public void beforeClass() {
	  use=new UseBrowser();
	  login=new Loginpage();
	  update=new Userupdate();
	  login.login("admin", "123456");
  }

  @AfterClass
  public void afterClass() {
	  use.quit();
  }

}
