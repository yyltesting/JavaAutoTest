package AutoApi.test;

import org.testng.annotations.Test;

import AutoApi.base.ReadExl;
import AutoApi.content.Login.Logincontent;
import AutoApi.page.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	LoginPage loginPage;
  @Test
  public void f() throws IOException {
	  HashMap<String, String> body = new HashMap<String, String>();
	  Map<String, String> header = new HashMap<String, String>();
	  String uri = ReadExl.ReadCell("Sheet1", 2, 1);
	  String methodname = ReadExl.ReadCell("Sheet1", 3, 1);
	  String Body =ReadExl.ReadCell("Sheet1", 4, 1);
	  System.out.println(loginPage.Login(Logincontent.Uri(uri),methodname,Body,header,body));
	  Assert.assertEquals(loginPage.Login(Logincontent.Uri(uri),methodname,Body,header,body).get("status"),"200");
  }
  @BeforeMethod
  public void beforeMethod() {
	  loginPage = new LoginPage();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
