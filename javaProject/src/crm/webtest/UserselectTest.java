package crm.webtest;

import org.testng.annotations.Test;

import crm.base.UseBrowser;
import crm.page.login.Loginpage;
import crm.page.userselect.UserSelect;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class UserselectTest {
	UseBrowser use;
	Loginpage login;
	UserSelect select;
  @Test
  public void s1() {
	  select.select("Áõ»¶", "¿Í»§ÐÕÃû");
	  select.have();
  }
  @BeforeClass
  public void beforeClass() {
	  use=new UseBrowser();
	  login=new Loginpage();
	  select=new UserSelect();
	  login.login("admin", "123456");
	  
  }

  @AfterClass
  public void afterClass() {
	  use.quit();
  }

}
