package AutoApi.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import AutoApi.base.ReadExl;
import AutoApi.base.RequestBase;
import AutoApi.content.Login.Logincontent;

public class LoginPage {
	RequestBase requestBase ;
	public Map<String,String> Login(String url,String methodName) throws IOException{
		requestBase = new RequestBase();
		Map<String, String> baseParam = new HashMap<String, String>();
		HashMap<String, String> bodyParam = new HashMap<String, String>();
		Map<String, String> headerMap = new HashMap<String, String>();
		baseParam.put("url", url);
		baseParam.put("methodName", methodName);
		return requestBase.request(baseParam, bodyParam, headerMap);
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		LoginPage loginPage = new LoginPage();
		System.out.println(loginPage.Login(Logincontent.Uri(ReadExl.ReadCell("Sheet1", 2, 1)),ReadExl.ReadCell("Sheet1", 3, 1)));
//		System.out.println(loginPage.Login("http://localhost:8899/getcookies", "Get"));
//		System.out.println(loginPage.Login(Logincontent.Uri(ReadExl.ReadCell("Sheet1", 2, 1)), ReadExl.ReadCell("Sheet1", 3, 1)));
	}

}
