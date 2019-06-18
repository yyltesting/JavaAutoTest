package changku.test;

import org.testng.annotations.Test;

import changku.base.Readexl;
import changku.base.TouchDriver;
import changku.page.Register;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RegisterTest {
	TouchDriver use;
	Register tel;
  @Test
  public void success() {
	  tel.register(Readexl.readCell("Sheet3", 4,1 ),Readexl.readCell("Sheet3", 5,1 ),Readexl.readCell("Sheet3", 6,1 ));
	  Assert.assertEquals(tel.success("用户注册成功！"), "\n\n用户注册成功！\n\n");
  }
  @Test
  public void fail() {
	  tel.register(Readexl.readCell("Sheet3", 4,2 ),Readexl.readCell("Sheet3", 5,2 ),Readexl.readCell("Sheet3", 6,2 ));
	  Assert.assertEquals(tel.Fail("请输入用户名！"), "\n\n请输入用户名！\n\n");
	  }
  @BeforeClass
  public void beforeMethod() throws MalformedURLException {
	  use=new TouchDriver();
	  tel=new Register();
	  use.open();
  }

  @AfterClass
  public void afterMethod() {
	  use.quit();
  }

}
