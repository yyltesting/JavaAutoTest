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
	  Assert.assertEquals(lo.fail(),"�����ڴ��˺ţ�");
  }
  @Test
  public void f2(){
	  lo.Sure("");
	  Assert.assertEquals(lo.kong(), "��Ա�Ų���Ϊ�գ�");
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
