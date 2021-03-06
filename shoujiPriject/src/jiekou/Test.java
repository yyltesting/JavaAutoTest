package jiekou;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.mime.Header;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.seleniumhq.jetty9.http.HttpHeader;

public class Test {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		
		String url="https://www.baidu.com/";
		//创建get请求
		HttpGet get = new HttpGet(url);
		//创建发送请求的客户端
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//通过客户端进行发包
		CloseableHttpResponse response = httpclient.execute(get);
		//接收响应包的响应行、状态码
		StatusLine StatusLine = response.getStatusLine();
		System.out.println(StatusLine.getStatusCode());
		System.out.println(StatusLine.getProtocolVersion());
		System.out.println(StatusLine.getReasonPhrase());
		//接受响应包的头
		org.apache.http.Header[] headers = response.getAllHeaders();
		for(org.apache.http.Header header : headers){
			System.out .println(header.getName()+":"+header.getValue());
		}
		//接收响应包的体
		HttpEntity entity = response.getEntity();
		String eneitys = EntityUtils.toString(entity);
		System.out.println(eneitys);
	}

}
