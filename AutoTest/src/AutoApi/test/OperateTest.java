package AutoApi.test;

import org.testng.annotations.Test;

import AutoApi.base.ReadExl;
import AutoApi.content.Login.Logincontent;
import AutoApi.content.Operate.Operatecontent;
import AutoApi.page.LoginPage;
import AutoApi.page.OperatePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class OperateTest {
  @Test
  public void f() throws IOException {
	  //引用需要cookie认证的请求
	  OperatePage operatePage = new OperatePage();
	  //输入参数
	  HashMap<String, String> body = new HashMap<String, String>();
	  Map<String, String> header = new HashMap<String, String>();
	  String url = ReadExl.ReadCell("Sheet1", 6, 1);
	  String methodname = ReadExl.ReadCell("Sheet1", 7, 1);
	  String Body =ReadExl.ReadCell("Sheet1", 8, 1);
	  body.put(ReadExl.ReadCell("Sheet1", 8, 1), ReadExl.ReadCell("Sheet1", 8, 2));
	  body.put(ReadExl.ReadCell("Sheet1", 9, 1), ReadExl.ReadCell("Sheet1", 9, 2));
	  //进行方法引用
	  System.out.println(operatePage.ToLogin(Operatecontent.Uri(url), methodname,Body, header,body));
	  Assert.assertEquals(operatePage.ToLogin(Operatecontent.Uri(url), methodname,Body, header,body).get("status"), "200");
	  }
  @BeforeClass
  public void beforeMethod() throws IOException {
	  //获取cookie
	  LoginPage loginPage = new LoginPage();
	  HashMap<String, String> body = new HashMap<String, String>();
	  Map<String, String> header = new HashMap<String, String>();
	  String uri = ReadExl.ReadCell("Sheet1", 2, 1);
	  String methodname = ReadExl.ReadCell("Sheet1", 3, 1);
	  String Body =ReadExl.ReadCell("Sheet1", 4, 1);
	  loginPage.Login(Logincontent.Uri(uri),methodname,Body,header,body);
  }

  @AfterClass
  public void afterMethod() {
  }

}
