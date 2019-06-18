package changku.test;

import org.testng.annotations.Test;

import changku.base.Readexl;
import changku.base.TouchDriver;
import changku.page.Login;
import changku.page.Selectwu;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class selectwuTest {
	TouchDriver use;
	Login login;
	Selectwu s;
  @Test
	  public void success() {
		  s.select(Readexl.readCell("Sheet3", 8, 1));
		  Assert.assertEquals(s.success(Readexl.readCell("Sheet3", 8, 1)),Readexl.readCell("Sheet3", 8, 1));
		  
	  }
//  @Test
//  public void fail1() {
//	  s.select(Readexl.readCell("Sheet3", 8, 2));
//	  Assert.assertEquals(s.fail("请点击添加物品!"), "\n\n请点击添加物品!\n\n");
//	  
//  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  use=new TouchDriver();
	  login=new Login();
	  s=new Selectwu();
	  use.open();
	  login.login("sa", "sa");
	  login.sure();
  }

  @AfterMethod
  public void afterMethod() {
	  use.quit();
  }

}
