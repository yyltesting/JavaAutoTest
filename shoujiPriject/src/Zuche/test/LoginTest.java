package Zuche.test;

import org.testng.annotations.Test;

import Zuche.base.DriverOption;
import Zuche.base.Touchdriver;
import Zuche.page.Login;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTest {
	Touchdriver use;
	Login lo;
  @Test
  public void f1() {
	  lo.Sure("123");
	  Assert.assertEquals(lo.fail(),"不存在此账号！");
  }
  @Test
  public void f2(){
	  lo.Sure("");
	  Assert.assertEquals(lo.kong(), "会员号不能为空！");
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  use=new Touchdriver();
	  use.open();
	  lo=new Login();
  }

  @AfterClass
  public void afterClass() {
	  use.quit();
  }

}
