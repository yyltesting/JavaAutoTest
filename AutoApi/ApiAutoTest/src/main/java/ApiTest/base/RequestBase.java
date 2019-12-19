package ApiTest.base;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class RequestBase {
	public static CookieStore cookieStore =new BasicCookieStore();;
	//返回两个结果 code和返回结果
    public static Map<String,String> request(Map<String,String>baseParam,HashMap<String,String>bodyParam,Map<String,String>headerMap) throws IOException {
    	//创建可带cookies容器的httpclient的客户端
    	CloseableHttpClient httpclient=HttpClients.custom()
	             .setDefaultCookieStore(cookieStore)
	             .build();
    	//创建一个返回数据的数组map
        Map<String,String> returnMap = new HashMap<String, String>();
        
        //获取输入参数的url
        String url = (String)baseParam.get("url");
        //判断url为空的情况
        if(isEmpty(url)){
            returnMap.put("returnBody","url不能为空");
            return returnMap;
        }        
        
        //获取请求的认证
        String Authorization = (String)baseParam.get("Authorization");
        //获取请求的用户名认证
        String username = (String)baseParam.get("username");
        //获取请求的密码认证
        String password = (String)baseParam.get("password");
        //获取请求参数建立服务器连接超时的时间
        String connectionTimeout = (String)baseParam.get("connectionTimeout");
        //获取请求参数数据传输超时的时间
        String socketTimeOut = (String)baseParam.get("socketTimeOut");
        //获取请求参数的ip地址
        String ip = (String)baseParam.get("ip");
        //获取请求参数的端口号
        String portStr = (String) baseParam.get("portStr");
        //获取是否有请求参数体
        String body = (String) baseParam.get("body");
        //获取是否有请求头
        String header = (String) baseParam.get("header");       
        //获取输入请求的方法
        String methodName = (String)baseParam.get("methodName");
        //获取输入请求的cookies
        String cookie = (String)baseParam.get("cookies");
        //定义一个请求方法为空
        org.apache.http.client.methods.HttpRequestBase method = null;
        
        //判断是否需要认证
        if(!isEmpty(Authorization)){
        	//UsernamePasswordCredentials creds = new UsernamePasswordCredentials("13378105523", "7c4a8d09ca3762af61e59520943dc26494f8941b");
        	// 创建HttpClientBuilder
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            // 设置BasicAuth
            CredentialsProvider provider = new BasicCredentialsProvider();
            // 创建身份验证范围
            AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM);
            // 创建证书对，在此处填写用户名和密码
            UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);
            // 注入的凭证
            provider.setCredentials(scope, creds);
            // 设置缺省凭据提供程序
            httpClientBuilder.setDefaultCredentialsProvider(provider);
            }
        
        //添加cookies
//        if(!isEmpty(cookie)){
//        BasicClientCookie cookies = new BasicClientCookie("name", "zhaoke"); 
//        cookies.setVersion(0);  
//        cookies.setDomain("/pms/");   //设置范围
//        cookies.setPath("/"); 
//        cookieStore.addCookie(cookies);
//        }

        //判断methodName请求方法 为空的情况
        if(isEmpty(methodName)){
            returnMap.put("returnBody","方法不能为空");
            return returnMap;
        }

        //判断请求的方法并创建
        if(methodName.equalsIgnoreCase("Post")){
        	HttpPost httpPost = new HttpPost(url);
        	//判断请求的参数体不为空的情况
            if(!isEmpty(body)){
            	//传输请求参数体
            	List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
     	        java.util.Set<String> Keyset = bodyParam.keySet();
     	        for(String key : Keyset){
     	        	parameters.add(new BasicNameValuePair(key, bodyParam.get(key)));
     	        }
     	        // form表单式的实体的请求方式
     	        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
     	        // 将请求实体设置到httpPost对象中
     	        httpPost.setEntity(formEntity);
            }
            method = httpPost;
        }if(methodName.equalsIgnoreCase("Get")) {
        	if(!isEmpty(body)){
//        		//
//        		//定义请求的参数
//        		URI uri = new URIBuilder(url);
//        		java.util.Set<String> Keyset = bodyParam.keySet();
//      	        for(String key : Keyset){
//   			 	uri.setParameter(key, bodyParam.get(key)).build();
//      	        }
        		//传输请求参数体
            	List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
     	        java.util.Set<String> Keyset = bodyParam.keySet();
     	        for(String key : Keyset){
     	        	parameters.add(new BasicNameValuePair(key, bodyParam.get(key)));
     	        }
        		String params = EntityUtils.toString(new UrlEncodedFormEntity(parameters,Consts.UTF_8));
        		//定义请求的参数
        		String uri = url+"?"+params;
        		HttpGet httpGet=new HttpGet(uri);
        		method = httpGet;
        	}else {
				HttpGet httpGet=new HttpGet(url);
				method = httpGet;
			}
           
        }

//        //动态代理host
//        int port = 8080;
//        //ip如果不为空，说明要走代理
//        if(!isEmpty(ip)){
//            //端口号也判断一下,如果端口为空，我们默认给他80端口
//            if(isEmpty(portStr)){
//                httpclient.getHostConfiguration().setProxy(ip,port);
//            }//如果端口号不为空,把portStr 传进来
//            else{
//                httpclient.getHostConfiguration().setProxy(ip,Integer.parseInt(portStr));
//            }
//
//        }
        

        //设置超时
        RequestConfig requestConfig = null;
        
        if(isEmpty(connectionTimeout)){
            //等于空的时候默认给他一个10秒
        	requestConfig=RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000).build();
        	
        }else{
            //不为空的时候把connectionTimeout 传进来
        	requestConfig=RequestConfig.custom().setConnectionRequestTimeout(Integer.parseInt(connectionTimeout)).setConnectTimeout(Integer.parseInt(connectionTimeout)).build();
        }

        if(isEmpty(socketTimeOut)){
        	requestConfig=RequestConfig.custom().setSocketTimeout(10000).build();
        } //不为空的时候把soTimeout 传进来
        else {
        	requestConfig=RequestConfig.custom().setSocketTimeout(Integer.parseInt(socketTimeOut)).build();
        }
        //配置到请求方法里面
        method.setConfig(requestConfig);

        
        //设置消息头，先判断header是否为空，然后遍历header
        if(null != headerMap){
            for(String key : headerMap.keySet()){
                method.setHeader(key,headerMap.get(key));
            }
        }
        
        //定义响应的内容
        String returnBody = "";
        CloseableHttpResponse response=null;
        try{
			
        //发送请求，得到响应
        response=httpclient.execute(method);
        //得到响应体
        returnBody =EntityUtils.toString(response.getEntity());
        
        //定义一些响应码说明内容
        Map<Integer,String> codeMap = new HashMap<Integer, String>();
            codeMap.put(401,"执行方法没有授权");
            codeMap.put(405,"执行方法不对,请确认是get或是post");
            codeMap.put(415,"请确认content-type类型是否正确");
            codeMap.put(300, "请求重定向");
            codeMap.put(500, "服务器报错500");
        
        //得到响应码
        int status = response.getStatusLine().getStatusCode();
        
        //获取到cookies
        
        cookieStore.getCookies();
        System.err.println(cookieStore);
    
        //判断响应码非200
        if(status!=200){
        	//在定义的响应内容中获取body
            String exceptionMsg=codeMap.get(status);
            //非200的响应码且不存在在定义的响应码中
            if(isEmpty(exceptionMsg)){
                returnMap.put("returnBody","有异常错误，百度查一下code码含义");
            //非200的响应码存在在定义的响应码中
            }else{
            	//返回内容中加入body 
                returnMap.put("returnBody",codeMap.get(status));
            }
            //返回内容中加入状态吗
            returnMap.put("status",status+"");
        //判断响应码200    
        }else {
            returnMap.put("status",status+"");
            returnMap.put("returnBody",returnBody);
        }
        //返回响应的结果数组
        return returnMap;
    }
        //关闭容器
        finally {
        	if (response != null) {
        		response.close();
        	}
        	httpclient.close();
        }
    }
        
    
    //如果输入的string类型中存在空值
    private static boolean isEmpty(String n){
        boolean f = true;
        if(null!=n&&!"".equals(n)){
            f = false;
        }
        return f;
    }



	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
//		Map<String, String> baseParam = new HashMap<String, String>();
//		HashMap<String, String> bodyParam = new HashMap<String, String>();
//		Map<String, String> headerMap = new HashMap<String, String>();
//		baseParam.put("url", "http://localhost:8899/getcookies");
//		baseParam.put("methodName", "Get");
////		headerMap.put("Authorization", "Basic MTMzNzgxMDU1MjM6N2M0YThkMDljYTM3NjJhZjYxZTU5NTIwOTQzZGMyNjQ5NGY4OTQxYg==");
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
		Map<String, String> baseParam = new HashMap<String, String>();
		  HashMap<String, String> bodyParam = new HashMap<String, String>();
		  Map<String, String> headerMap = new HashMap<String, String>();
		  baseParam.put("url", ReadExl.ReadCell("baseParam", 1, 1)+ReadExl.ReadCell("baseParam", 1, 2));
		  baseParam.put("methodName", ReadExl.ReadCell("baseParam", 1, 3));
		  baseParam.put("header", ReadExl.ReadCell("baseParam", 1, 4));
		  baseParam.put("body", ReadExl.ReadCell("baseParam", 1, 5));
		  baseParam.put("Authorization", ReadExl.ReadCell("baseParam", 1, 6));
		  baseParam.put("cookies", ReadExl.ReadCell("baseParam", 1, 7));
		  bodyParam.put(ReadExl.ReadCell("bodyParam", 1, 0),ReadExl.ReadCell("bodyParam", 1, 1));
		  bodyParam.put(ReadExl.ReadCell("bodyParam", 2, 0),ReadExl.ReadCell("bodyParam", 2, 1));
		  RequestBase.request(baseParam, bodyParam, headerMap);
	}

}
