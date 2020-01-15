package PpmAPP.test;

import org.testng.annotations.Test;

import PpmAPP.base.TouchDriver;
import PpmAPP.page.AppLogin;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;

public class LoginTest {
	TouchDriver touchDriver;
	AppLogin login;
  @Test
  public void f() {
	  login.Loginto("15729866869", "yyl123456");
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  touchDriver = new TouchDriver();
	  login = new AppLogin();
	  touchDriver.open();
  }

  @AfterMethod
  public void afterMethod() {
	  touchDriver.quit();
  }

}
