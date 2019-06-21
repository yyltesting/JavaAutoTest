package AutoApi.base;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.Get;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.remote.server.handler.SetScriptTimeout;

public class RequestBase {
	//返回两个结果 code和返回结果
    public static Map<String,String> request(Map<String,String>baseParam,HashMap<String,String>bodyParam,Map<String,String>headerMap) throws IOException {
    	//创建httpclient的客户端
    	CloseableHttpClient httpclient=HttpClients.createDefault();
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
        //获取请求参数建立服务器连接超时的时间
        String connectionTimeout = (String)baseParam.get("connectionTimeout");
        //获取请求参数数据传输超时的时间
        String socketTimeOut = (String)baseParam.get("socketTimeOut");
        //获取请求参数的ip地址
        String ip = (String)baseParam.get("ip");
        //获取请求参数的端口号
        String portStr = (String) baseParam.get("portStr");
        //获取请求参数体
        String body = (String) baseParam.get("body");
        //获取输入请求的方法
        String methodName = (String)baseParam.get("methodName");
        
        //定义一个请求方法为空
        org.apache.http.client.methods.HttpRequestBase method = null;
        

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
//        status = httpclient.executeMethod(method);
//        returnBody = method.getResponseBodyAsString();
        CloseableHttpResponse response=null;
        
        //发送请求，得到响应
        response=httpclient.execute(method);
        returnBody =EntityUtils.toString(response.getEntity());
        
        //定义一些响应码说明内容
        Map<Integer,String> codeMap = new HashMap<Integer, String>();
            codeMap.put(401,"执行方法没有授权");
            codeMap.put(405,"执行方法不对,请确认是get或是post");
            codeMap.put(415,"请确认content-type类型是否正确");
        
        //得到响应码
        int status = response.getStatusLine().getStatusCode();
        if(status!=200){
            String exceptionMsg=codeMap.get(status);
            if(isEmpty(exceptionMsg)){
                returnMap.put("returnBody","有异常错误，百度查一下code码含义");
            }else{
                returnMap.put("returnBody",codeMap.get(status));
            }
            returnMap.put("status",status+"");


        }else {
            returnMap.put("status",status+"");
            returnMap.put("returnBody",returnBody);
        }

        return returnMap;


    }

    private static boolean isEmpty(String n){
        boolean f = true;
        if(null!=n&&!"".equals(n)){
            f = false;
        }
        return f;
    }



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> baseParam = new HashMap<String, String>();
		HashMap<String, String> bodyParam = new HashMap<String, String>();
		Map<String, String> headerMap = new HashMap<String, String>();
		baseParam.put("url", "http://localhost:8899/getcookies");
		baseParam.put("methodName", "Get");
		Map<String,String> returnMap = new HashMap<String, String>();
		System.out.println(RequestBase.request(baseParam, bodyParam, headerMap));

	}

}
