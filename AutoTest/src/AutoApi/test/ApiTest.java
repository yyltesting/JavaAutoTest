package AutoApi.test;

import org.testng.annotations.Test;

import AutoApi.base.ReadExl;
import AutoApi.base.RequestBase;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ApiTest {
	RequestBase request;
  @Test
  public void Tologin() throws IOException {
	  Map<String, String> baseParam = new HashMap<String, String>();
	  HashMap<String, String> bodyParam = new HashMap<String, String>();
	  Map<String, String> headerMap = new HashMap<String, String>();
	  baseParam.put("url", ReadExl.ReadCell("baseParam", 1, 1)+ReadExl.ReadCell("baseParam", 1, 2));
	  baseParam.put("methodName", ReadExl.ReadCell("baseParam", 1, 3));
	  baseParam.put("header", ReadExl.ReadCell("baseParam", 1, 4));
	  baseParam.put("body", ReadExl.ReadCell("baseParam", 1, 5));
	  baseParam.put("Authorization", ReadExl.ReadCell("baseParam", 1, 6));
	  baseParam.put("cookies", ReadExl.ReadCell("baseParam", 1, 7));
//		  baseParam.put("username", ReadExl.ReadCell("Authorization", 2, 0));
//		  baseParam.put("password", ReadExl.ReadCell("Authorization", 2, 1));
	  bodyParam.put(ReadExl.ReadCell("bodyParam", 1, 0),ReadExl.ReadCell("bodyParam", 1, 1));
	  bodyParam.put(ReadExl.ReadCell("bodyParam", 2, 0),ReadExl.ReadCell("bodyParam", 2, 1));
//		  headerMap.put(ReadExl.ReadCell("headerMap", 1, 0),ReadExl.ReadCell("headerMap", 1, 1));
	  System.out.println(request.request(baseParam, bodyParam, headerMap));
	  Assert.assertEquals(request.request(baseParam, bodyParam, headerMap).get("status"), "200");
  }
  @Test(dependsOnMethods = { "Tologin"})
  public void Topass() throws IOException {
	  Map<String, String> baseParam = new HashMap<String, String>();
	  HashMap<String, String> bodyParam = new HashMap<String, String>();
	  Map<String, String> headerMap = new HashMap<String, String>();
	  baseParam.put("url", ReadExl.ReadCell("baseParam", 2, 1)+ReadExl.ReadCell("baseParam", 2, 2));
	  baseParam.put("methodName", ReadExl.ReadCell("baseParam", 2, 3));
	  baseParam.put("header", ReadExl.ReadCell("baseParam", 2, 4));
	  baseParam.put("body", ReadExl.ReadCell("baseParam", 2, 5));
	  baseParam.put("Authorization", ReadExl.ReadCell("baseParam", 2, 6));
	  baseParam.put("cookies", ReadExl.ReadCell("baseParam", 2, 7));
	  bodyParam.put(ReadExl.ReadCell("bodyParam", 1, 2),ReadExl.ReadCell("bodyParam", 1, 3));
	  bodyParam.put(ReadExl.ReadCell("bodyParam", 2, 2),ReadExl.ReadCell("bodyParam", 2, 3));
	  System.out.println(request.request(baseParam, bodyParam, headerMap));
	  Assert.assertEquals(request.request(baseParam, bodyParam, headerMap).get("status"), "200");
  }
  @BeforeClass
  public void beforeClass() {
	  request = new RequestBase();
  }

  @AfterClass
  public void afterClass() {
  }

}
