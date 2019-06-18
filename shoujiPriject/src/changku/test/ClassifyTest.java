package changku.test;

import org.testng.annotations.Test;

import changku.base.Readexl;
import changku.base.TouchDriver;
import changku.page.Classify;
import changku.page.Login;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ClassifyTest {
	TouchDriver use;
	Login login;
	Classify ify;
  @Test
  public void success() {
	  ify.insertClassify(Readexl.readCell("Sheet3", 1, 4),Readexl.readCell("Sheet3", 2, 4));
	  Assert.assertEquals(ify.success(Readexl.readCell("Sheet3", 1, 4)),Readexl.readCell("Sheet3", 1, 4));
	  
  }
  @Test
  public void fail() {
	  ify.insertClassify(Readexl.readCell("Sheet3", 1, 5),Readexl.readCell("Sheet3", 2, 5));
	  Assert.assertEquals(ify.fail("请输入分类名称！"),"\n\n请输入分类名称！\n\n");
	  
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  use=new TouchDriver();
	  login=new Login();
	  ify=new Classify();
	  use.open();
	  login.login("sa", "sa");
	  login.sure();
  }

  @AfterMethod
  public void afterMethod() {
	  use.quit();
  }

}
