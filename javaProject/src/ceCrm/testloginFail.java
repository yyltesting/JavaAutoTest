package ceCrm;

import org.testng.annotations.Test;

import leiCrm.LoginFail;
import leiCrm.Loginsuccess;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class testloginFail {
	LoginFail unlogin;
  @Test
  public void f1() {
	  unlogin.loginF1();
	  Alert alert=Loginsuccess.driver.switchTo().alert();
	  String a=alert.getText();
	  Assert.assertEquals(a,"用户或密码错误！请重新输入！");
	  alert.accept();
	  Loginsuccess.sleep(2);

  }
  @Test
  public void f2() {
	  unlogin.loginF2();
	  Alert alert=Loginsuccess.driver.switchTo().alert();
	  String a=alert.getText();
	  Assert.assertEquals(a,"用户或密码错误！请重新输入！");
	  alert.accept();
	  Loginsuccess.sleep(2);
  }
  @Test
  public void f3() {
	  unlogin.loginF3();
	  Alert alert=Loginsuccess.driver.switchTo().alert();
	  String a=alert.getText();
	  Assert.assertEquals(a,"用户或密码错误！请重新输入！");
	  alert.accept();
	  Loginsuccess.sleep(2);
  }
  @Test
  public void f4() {
	  unlogin.loginF4();
	  Loginsuccess.sleep(3);
	  Alert alert=Loginsuccess.driver.switchTo().alert();
	  String a=alert.getText();
	  Assert.assertEquals(a,"- 用户名不能为空!\n- 密码不能为空!\n");
	  alert.accept();
	  Loginsuccess.sleep(2);
  }
  @Test
  public void f5() {
	  unlogin.loginF5();
	  Loginsuccess.sleep(3);
	  Alert alert=Loginsuccess.driver.switchTo().alert();
	  String a=alert.getText();
	  Assert.assertEquals(a,"- 用户名不能为空!\n");
	  alert.accept();
	  Loginsuccess.sleep(2);
  }
  @Test
  public void f6() {
	  unlogin.loginF6();
	  Loginsuccess.sleep(3);
	  Alert alert=Loginsuccess.driver.switchTo().alert();
	  String a=alert.getText();
	  Assert.assertEquals(a,"- 密码不能为空!\n");
	  alert.accept();
	  Loginsuccess.sleep(2);
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
	  
  }
  @BeforeClass
  public void beforeClass() {
	  unlogin = new LoginFail();
	  Loginsuccess.openChrome();
  }

  @AfterClass
  public void afterClass() {
	  Loginsuccess.closeChrome();
  }

}
