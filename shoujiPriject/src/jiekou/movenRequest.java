package jiekou;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class movenRequest {	

	public void httpGet(String url) throws ClientProtocolException, IOException{
		//实例化httpclient对象
		CloseableHttpClient httpclient=HttpClients.createDefault();
		//创建Get请求
		HttpGet httpGet=new HttpGet(url);
		
		CloseableHttpResponse response=null;
		try{
			response=httpclient.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == 200){
				System.out.println(response.getStatusLine().getStatusCode());
				//System.out.println("响应头为"+response.getAllHeaders());
				System.out.println("响应内容为"+EntityUtils.toString(response.getEntity(), "UTF-8"));
				System.out.println(response.getStatusLine().getStatusCode());
			}else{
				//System.out.println("响应头为"+response.getAllHeaders());
				System.out.println("响应内容为"+EntityUtils.toString(response.getEntity(), "UTF-8"));
				System.out.println("请求接口有误");
				System.out.println(response.getStatusLine().getStatusCode());
			}
		}finally{
			if(response != null){
				response.close();
			}
		}
		httpclient.close();
	}
	
	//有参数的httpget请求
		public void HttpGet(String url,String param,String values) throws ClientProtocolException, IOException, URISyntaxException{
			//实例化httpclient对象
			CloseableHttpClient httpclient=HttpClients.createDefault();
			//定义请求的参数
			 URI uri = new URIBuilder(url).setParameter(param, values).build();
			//创建Get请求
			 HttpGet httpGet=new HttpGet(uri);
			CloseableHttpResponse response=null;
			try{
				response=httpclient.execute(httpGet);
				if(response.getStatusLine().getStatusCode() == 200){
					//System.out.println("响应头为"+response.getAllHeaders());
					System.out.println("响应内容为"+EntityUtils.toString(response.getEntity(), "UTF-8"));
					System.out.println(response.getStatusLine().getStatusCode());
				}else{
					System.out.println("请求接口有误");
					//System.out.println("响应头为"+response.getAllHeaders());
					System.out.println("响应内容为"+EntityUtils.toString(response.getEntity(), "UTF-8"));
					System.out.println(response.getStatusLine().getStatusCode());
				}
			}finally{
				if(response != null){
					response.close();
				}
			}
			httpclient.close();
		}
		
		//无参数的普通post请求
		public void httpPost(String url) throws ClientProtocolException, IOException{
			// 创建Httpclient对象
	        CloseableHttpClient httpclient = HttpClients.createDefault();
	        // 创建http POST请求
	        HttpPost httpPost = new HttpPost(url);
	        //伪装浏览器请求
	        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
	        CloseableHttpResponse response = null;
	        try {
	            // 执行请求
	            response = httpclient.execute(httpPost);
	            // 判断返回状态是否为200
	            if (response.getStatusLine().getStatusCode() == 200) {
	            	System.out.println("响应内容为"+EntityUtils.toString(response.getEntity(), "UTF-8"));
					System.out.println(response.getStatusLine().getStatusCode());
	            }else{
	            	System.out.println("请求接口有误");
//	            	System.out.println("响应头为"+response.getAllHeaders());
					System.out.println("响应内容为"+EntityUtils.toString(response.getEntity(), "UTF-8"));
					System.out.println(response.getStatusLine().getStatusCode());
	        } 
	        }finally {
	            if (response != null) {
	                response.close();
	            }
	            httpclient.close();
	        }
		}
		//有参数的post请求
		public void HttpPost(String url,HashMap<String, String> paramsMap) throws ClientProtocolException, IOException{
			// 创建Httpclient对象
	        CloseableHttpClient httpclient = HttpClients.createDefault();
	        
	        // 创建http POST请求
	        HttpPost httpPost = new HttpPost(url);
	        
	        //伪装浏览器请求，设置请求头
	        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
	        httpPost.setHeader("Accept", "application/json");
	        httpPost.setHeader("Cookie","JSESSIONID=CD7CFE85E5281CA6793EEF53C9B0501A");
	        httpPost.setHeader("Connection","keep-alive");
	        httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
	        
	        // 设置参数
	        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
	        java.util.Set<String> Keyset = paramsMap.keySet();
	        for(String key : Keyset){
	        	parameters.add(new BasicNameValuePair(key, paramsMap.get(key)));
	        }
	        // 构造一个form表单式的实体
	        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
	        // 将请求实体设置到httpPost对象中
	        httpPost.setEntity(formEntity);
	        
	        //创建一个响应容器
	        CloseableHttpResponse response = null;
	        try {
	            // 执行请求
	            response = httpclient.execute(httpPost);
	            // 判断返回状态是否为200
	            if (response.getStatusLine().getStatusCode() == 200) {
	            	//打印响应体
	            	System.out.println("响应内容为"+EntityUtils.toString(response.getEntity(), "UTF-8"));
	            	//打印状态码
					System.out.println(response.getStatusLine().getStatusCode());
	            }else{
	            	System.out.println("请求接口有误");
					System.out.println("响应内容为"+EntityUtils.toString(response.getEntity(), "UTF-8"));
					System.out.println(response.getStatusLine().getStatusCode());
	        } 
	            //最后任何结果都执行容器关闭
	        }finally {
	            if (response != null) {
	                response.close();
	            }
	            httpclient.close();
	        }
		}


	public static void main(String[] args) throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
//		movenRequest request=new movenRequest();
//		HashMap<String,String> paramsMap =new HashMap<>();
//		paramsMap.put("path", "0");
//		paramsMap.put("version", "0");
//		paramsMap.put("sortName", "name");
//		paramsMap.put("order", "asc");
//		String url = "http://192.168.2.139:8080/colligate/exchange/0/list/0";
//		request.HttpPost(url, paramsMap);
		movenRequest getcookies = new movenRequest();
		getcookies.httpGet("http://localhost:8899/getcookies");


	}
}

