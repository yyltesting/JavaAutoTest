package crm.webtest;

import org.testng.annotations.Test;

import crm.base.BrowserOption;
import crm.base.UseBrowser;
import crm.page.login.Loginpage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LoginTest {
	UseBrowser use;
	Loginpage loginfail;
  @Test
  public void logF1() {
	  loginfail.login("", "");
	  Assert.assertEquals(loginfail.al(), "- �û�������Ϊ��!\n- ���벻��Ϊ��!\n");
  }
  @Test
  public void logF2() {
	  loginfail.login("admin", "");
	  Assert.assertEquals(loginfail.al(), "- ���벻��Ϊ��!\n");
  }
  @Test
  public void logF3() {
	  loginfail.login("", "123456");
	  Assert.assertEquals(loginfail.al(), "- �û�������Ϊ��!\n");
  }
  @Test
  public void logF4() {
	  loginfail.login("ad", "12");
	  Assert.assertEquals(loginfail.al(), "�û�������������������룡");
  }
  @Test
  public void logF5() {
	  loginfail.login("admin", "12");
	  Assert.assertEquals(loginfail.al(), "�û�������������������룡");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }
  @BeforeClass
  public void beforeClass() {
	  use=new UseBrowser();
	  loginfail=new Loginpage();
  }

  @AfterClass
  public void afterClass() {
	  use.quit();
	  
  }
}
