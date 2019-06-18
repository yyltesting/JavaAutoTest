package changku.test;

import org.testng.annotations.Test;

import changku.base.Readexl;
import changku.base.TouchDriver;
import changku.page.Login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class loginTest {
	TouchDriver use;
	Login op;
  @Test
  public void Sure() {
	  op.login(Readexl.readCell("Sheet3", 1, 1), Readexl.readCell("Sheet3", 2, 1));
	  Assert.assertEquals(op.success("登录成功！"), "\n\n登录成功！\n\n");
	  op.sure();
  }
  @Test
  public void fail(){
	  op.login(Readexl.readCell("Sheet3", 1, 2), Readexl.readCell("Sheet3", 2, 2));
	  Assert.assertEquals(op.fail("请输入用户名！"), "\n\n请输入用户名！\n\n");
  }
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  use=new TouchDriver();
	  op=new Login();
	  use.open();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  use.quit();
  }

}
