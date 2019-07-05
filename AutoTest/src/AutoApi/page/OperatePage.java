package AutoApi.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import AutoApi.base.ReadExl;
import AutoApi.base.RequestBase;
import AutoApi.content.Login.Logincontent;
import AutoApi.content.Operate.Operatecontent;

public class OperatePage {
	RequestBase requestBase ;
	public Map<String,String> ToLogin(String url,String methodName,String Body,Map<String, String> headerMap,HashMap<String,String>bodyParam) throws IOException{
		requestBase = new RequestBase();
		Map<String, String> baseParam = new HashMap<String, String>();
		baseParam.put("url", url);
		baseParam.put("methodName", methodName);
		baseParam.put("body", Body);		
		return requestBase.request(baseParam, bodyParam, headerMap);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}

}
