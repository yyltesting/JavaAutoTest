package AutoApi.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;

import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CookieStores {
	public static void CookieStores(){

	    // ����cookie store�ı���ʵ��
//	    CookieStore cookieStore = new BasicCookieStore();
	    // ����HttpClient������
//	    HttpClientContext context = HttpClientContext.create();
//	    context.setCookieStore(cookieStore);
	    //cookieStore.getCookies();
//	    CookieStore cookieStore = new BasicCookieStore();
		//����COOkie����
//		CloseableHttpClient httpClient = HttpClients.custom()
//	             .setDefaultCookieStore(cookieStore)
//	             .build();
		//��ȡcookie
//		cookieStore.getCookies();
		//����
//		BasicClientCookie cookie = new BasicClientCookie("name", "zhaoke"); 
//        cookie.setVersion(0);  
//        cookie.setDomain("/pms/");   //���÷�Χ
//        cookie.setPath("/"); 
//        cookieStore.addCookie(cookie);

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Map<String, String> baseParam = new HashMap<String, String>();
//		HashMap<String, String> bodyParam = new HashMap<String, String>();
//		Map<String, String> headerMap = new HashMap<String, String>();
//		baseParam.put("url", "http://localhost:8899/getcookies");
//		baseParam.put("methodName", "Get");
//		System.out.println(RequestBase.request(baseParam, bodyParam, headerMap));
//		Map<String, String> base = new HashMap<String, String>();
//		HashMap<String, String> body = new HashMap<String, String>();
//		Map<String, String> header = new HashMap<String, String>();
//		base.put("url", "http://localhost:8899/postcookiesdemo");
//		base.put("methodName", "Post");
//		base.put("body", "1");
//		body.put("name", "yyl");
//		body.put("age", "22");
//		System.out.println(RequestBase.request(base, body, header));
	}

}
