package AutoApi.base;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class RequestBase {
	public void httpGet(String url) throws ClientProtocolException, IOException{
		//ʵ����httpclient����
		CloseableHttpClient httpclient=HttpClients.createDefault();
		//����Get����
		HttpGet httpGet=new HttpGet(url);
		
		CloseableHttpResponse response=null;
		try{
			response=httpclient.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == 200){
				System.out.println(response.getStatusLine().getStatusCode());
				//System.out.println("��ӦͷΪ"+response.getAllHeaders());
				System.out.println("��Ӧ����Ϊ"+EntityUtils.toString(response.getEntity(), "UTF-8"));
				System.out.println(response.getStatusLine().getStatusCode());
			}else{
				//System.out.println("��ӦͷΪ"+response.getAllHeaders());
				System.out.println("��Ӧ����Ϊ"+EntityUtils.toString(response.getEntity(), "UTF-8"));
				System.out.println("����ӿ�����");
				System.out.println(response.getStatusLine().getStatusCode());
			}
		}finally{
			if(response != null){
				response.close();
			}
		}
		httpclient.close();
	}
	
	//�в�����httpget����
		public void HttpGet(String url,String param,String values) throws ClientProtocolException, IOException, URISyntaxException{
			//ʵ����httpclient����
			CloseableHttpClient httpclient=HttpClients.createDefault();
			//��������Ĳ���
			 URI uri = new URIBuilder(url).setParameter(param, values).build();
			//����Get����
			 HttpGet httpGet=new HttpGet(uri);
			CloseableHttpResponse response=null;
			try{
				response=httpclient.execute(httpGet);
				if(response.getStatusLine().getStatusCode() == 200){
					//System.out.println("��ӦͷΪ"+response.getAllHeaders());
					System.out.println("��Ӧ����Ϊ"+EntityUtils.toString(response.getEntity(), "UTF-8"));
					System.out.println(response.getStatusLine().getStatusCode());
				}else{
					System.out.println("����ӿ�����");
					//System.out.println("��ӦͷΪ"+response.getAllHeaders());
					System.out.println("��Ӧ����Ϊ"+EntityUtils.toString(response.getEntity(), "UTF-8"));
					System.out.println(response.getStatusLine().getStatusCode());
				}
			}finally{
				if(response != null){
					response.close();
				}
			}
			httpclient.close();
		}
		
		//�޲�������ͨpost����
		public void httpPost(String url) throws ClientProtocolException, IOException{
			// ����Httpclient����
	        CloseableHttpClient httpclient = HttpClients.createDefault();
	        // ����http POST����
	        HttpPost httpPost = new HttpPost(url);
	        //αװ���������
	        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
	        CloseableHttpResponse response = null;
	        try {
	            // ִ������
	            response = httpclient.execute(httpPost);
	            // �жϷ���״̬�Ƿ�Ϊ200
	            if (response.getStatusLine().getStatusCode() == 200) {
	            	System.out.println("��Ӧ����Ϊ"+EntityUtils.toString(response.getEntity(), "UTF-8"));
					System.out.println(response.getStatusLine().getStatusCode());
	            }else{
	            	System.out.println("����ӿ�����");
//	            	System.out.println("��ӦͷΪ"+response.getAllHeaders());
					System.out.println("��Ӧ����Ϊ"+EntityUtils.toString(response.getEntity(), "UTF-8"));
					System.out.println(response.getStatusLine().getStatusCode());
	        } 
	        }finally {
	            if (response != null) {
	                response.close();
	            }
	            httpclient.close();
	        }
		}
		//�в�����post����
		public void HttpPost(String url,HashMap<String, String> paramsMap) throws ClientProtocolException, IOException{
			// ����Httpclient����
	        CloseableHttpClient httpclient = HttpClients.createDefault();
	        
	        // ����http POST����
	        HttpPost httpPost = new HttpPost(url);
	        
	        //αװ�����������������ͷ
	        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
	        httpPost.setHeader("Accept", "application/json");
//	        httpPost.setHeader("Cookie","JSESSIONID=CD7CFE85E5281CA6793EEF53C9B0501A");
	        httpPost.setHeader("Connection","keep-alive");
	        httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
	        
	        // ���ò���
	        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
	        java.util.Set<String> Keyset = paramsMap.keySet();
	        for(String key : Keyset){
	        	parameters.add(new BasicNameValuePair(key, paramsMap.get(key)));
	        }
	        // ����һ��form��ʽ��ʵ��
	        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
	        // ������ʵ�����õ�httpPost������
	        httpPost.setEntity(formEntity);
	        
	        //����һ����Ӧ����
	        CloseableHttpResponse response = null;
	        try {
	            // ִ������
	            response = httpclient.execute(httpPost);
	            // �жϷ���״̬�Ƿ�Ϊ200
	            if (response.getStatusLine().getStatusCode() == 200) {
	            	//��ӡ��Ӧ��
	            	System.out.println("��Ӧ����Ϊ"+EntityUtils.toString(response.getEntity(), "UTF-8"));
	            	//��ӡ״̬��
					System.out.println(response.getStatusLine().getStatusCode());
	            }else{
	            	System.out.println("����ӿ�����");
					System.out.println("��Ӧ����Ϊ"+EntityUtils.toString(response.getEntity(), "UTF-8"));
					System.out.println(response.getStatusLine().getStatusCode());
	        } 
	            //����κν����ִ�������ر�
	        }finally {
	            if (response != null) {
	                response.close();
	            }
	            httpclient.close();
	        }
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
