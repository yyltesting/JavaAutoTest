package AutoApi.test;

import org.testng.annotations.Test;

import AutoApi.base.ReadExl;
import AutoApi.content.Login.Logincontent;
import AutoApi.page.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	LoginPage loginPage;
  @Test
  public void f() throws IOException {
	  System.out.println(loginPage.Login(Logincontent.Uri(ReadExl.ReadCell("Sheet1", 2, 1)),ReadExl.ReadCell("Sheet1", 3, 1)));
	  Assert.assertEquals(loginPage.Login(Logincontent.Uri(ReadExl.ReadCell("Sheet1", 2, 1)),ReadExl.ReadCell("Sheet1", 3, 1)).get("status"),"200");
  }
  @BeforeMethod
  public void beforeMethod() {
	  loginPage = new LoginPage();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
