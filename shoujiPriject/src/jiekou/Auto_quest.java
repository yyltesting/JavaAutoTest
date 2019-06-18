package jiekou;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Auto_quest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		//设置请求行、参数
		String url = "";
		HashMap<String, String> paramsMap =new HashMap<>();
		paramsMap.put("", "");
		//建立Httpclient连接，模拟客户端
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//实例化一个post的请求
		HttpPost post = new HttpPost(url);
		//设置请求头
		post.setHeader("", "");
		//设置请求参数
		List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        java.util.Set<String> Keyset = paramsMap.keySet();
        for(String key : Keyset){
        	parameters.add(new BasicNameValuePair(key, paramsMap.get(key)));
        }
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        post.setEntity(formEntity);
        //发送请求传回一个容器
		CloseableHttpResponse response = httpclient.execute(post);
		//获取状态码
		StatusLine statusLine = response.getStatusLine();
		System.out.println(statusLine.getStatusCode());
		//获取响应体
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));
		
		
	}

}
