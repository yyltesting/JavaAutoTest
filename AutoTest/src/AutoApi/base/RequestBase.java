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
	//����������� code�ͷ��ؽ��
    public static Map<String,String> request(Map<String,String>baseParam,HashMap<String,String>bodyParam,Map<String,String>headerMap) throws IOException {
    	//����httpclient�Ŀͻ���
    	CloseableHttpClient httpclient=HttpClients.createDefault();
    	//����һ���������ݵ�����map
        Map<String,String> returnMap = new HashMap<String, String>();
        
        //��ȡ���������url
        String url = (String)baseParam.get("url");
        //�ж�urlΪ�յ����
        if(isEmpty(url)){
            returnMap.put("returnBody","url����Ϊ��");
            return returnMap;
        }        
        
        //��ȡ�������֤
        String Authorization = (String)baseParam.get("Authorization");
        //��ȡ��������������������ӳ�ʱ��ʱ��
        String connectionTimeout = (String)baseParam.get("connectionTimeout");
        //��ȡ����������ݴ��䳬ʱ��ʱ��
        String socketTimeOut = (String)baseParam.get("socketTimeOut");
        //��ȡ���������ip��ַ
        String ip = (String)baseParam.get("ip");
        //��ȡ��������Ķ˿ں�
        String portStr = (String) baseParam.get("portStr");
        //��ȡ���������
        String body = (String) baseParam.get("body");
        //��ȡ��������ķ���
        String methodName = (String)baseParam.get("methodName");
        
        //����һ�����󷽷�Ϊ��
        org.apache.http.client.methods.HttpRequestBase method = null;
        

        //�ж�methodName���󷽷� Ϊ�յ����
        if(isEmpty(methodName)){
            returnMap.put("returnBody","��������Ϊ��");
            return returnMap;
        }

        //�ж�����ķ���������
        if(methodName.equalsIgnoreCase("Post")){
        	HttpPost httpPost = new HttpPost(url);
        	//�ж�����Ĳ����岻Ϊ�յ����
            if(!isEmpty(body)){
            	//�������������
            	List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
     	        java.util.Set<String> Keyset = bodyParam.keySet();
     	        for(String key : Keyset){
     	        	parameters.add(new BasicNameValuePair(key, bodyParam.get(key)));
     	        }
     	        // form��ʽ��ʵ�������ʽ
     	        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
     	        // ������ʵ�����õ�httpPost������
     	        httpPost.setEntity(formEntity);
            }
            method = httpPost;
        }if(methodName.equalsIgnoreCase("Get")) {
        	if(!isEmpty(body)){
//        		//
//        		//��������Ĳ���
//        		URI uri = new URIBuilder(url);
//        		java.util.Set<String> Keyset = bodyParam.keySet();
//      	        for(String key : Keyset){
//   			 	uri.setParameter(key, bodyParam.get(key)).build();
//      	        }
        		//�������������
            	List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
     	        java.util.Set<String> Keyset = bodyParam.keySet();
     	        for(String key : Keyset){
     	        	parameters.add(new BasicNameValuePair(key, bodyParam.get(key)));
     	        }
        		String params = EntityUtils.toString(new UrlEncodedFormEntity(parameters,Consts.UTF_8));
        		//��������Ĳ���
        		String uri = url+"?"+params;
        		HttpGet httpGet=new HttpGet(uri);
        		method = httpGet;
        	}else {
				HttpGet httpGet=new HttpGet(url);
				method = httpGet;
			}
           
        }

//        //��̬����host
//        int port = 8080;
//        //ip�����Ϊ�գ�˵��Ҫ�ߴ���
//        if(!isEmpty(ip)){
//            //�˿ں�Ҳ�ж�һ��,����˿�Ϊ�գ�����Ĭ�ϸ���80�˿�
//            if(isEmpty(portStr)){
//                httpclient.getHostConfiguration().setProxy(ip,port);
//            }//����˿ںŲ�Ϊ��,��portStr ������
//            else{
//                httpclient.getHostConfiguration().setProxy(ip,Integer.parseInt(portStr));
//            }
//
//        }
        

        //���ó�ʱ
        RequestConfig requestConfig = null;
        
        if(isEmpty(connectionTimeout)){
            //���ڿյ�ʱ��Ĭ�ϸ���һ��10��
        	requestConfig=RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000).build();
        	
        }else{
            //��Ϊ�յ�ʱ���connectionTimeout ������
        	requestConfig=RequestConfig.custom().setConnectionRequestTimeout(Integer.parseInt(connectionTimeout)).setConnectTimeout(Integer.parseInt(connectionTimeout)).build();
        }

        if(isEmpty(socketTimeOut)){
        	requestConfig=RequestConfig.custom().setSocketTimeout(10000).build();
        } //��Ϊ�յ�ʱ���soTimeout ������
        else {
        	requestConfig=RequestConfig.custom().setSocketTimeout(Integer.parseInt(socketTimeOut)).build();
        }
        //���õ����󷽷�����
        method.setConfig(requestConfig);

        
        //������Ϣͷ�����ж�header�Ƿ�Ϊ�գ�Ȼ�����header
        if(null != headerMap){
            for(String key : headerMap.keySet()){
                method.setHeader(key,headerMap.get(key));
            }
        }
        
        //������Ӧ������
        
        String returnBody = "";
//        status = httpclient.executeMethod(method);
//        returnBody = method.getResponseBodyAsString();
        CloseableHttpResponse response=null;
        
        //�������󣬵õ���Ӧ
        response=httpclient.execute(method);
        returnBody =EntityUtils.toString(response.getEntity());
        
        //����һЩ��Ӧ��˵������
        Map<Integer,String> codeMap = new HashMap<Integer, String>();
            codeMap.put(401,"ִ�з���û����Ȩ");
            codeMap.put(405,"ִ�з�������,��ȷ����get����post");
            codeMap.put(415,"��ȷ��content-type�����Ƿ���ȷ");
        
        //�õ���Ӧ��
        int status = response.getStatusLine().getStatusCode();
        if(status!=200){
            String exceptionMsg=codeMap.get(status);
            if(isEmpty(exceptionMsg)){
                returnMap.put("returnBody","���쳣���󣬰ٶȲ�һ��code�뺬��");
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
