package AutoApi.base;

import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;

public class CookieStores {
	public static void CookieStores(){
		 // ȫ����������
	    RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
	    // ����cookie store�ı���ʵ��
	    CookieStore cookieStore = new BasicCookieStore();
	    // ����HttpClient������
	    HttpClientContext context = HttpClientContext.create();
	    context.setCookieStore(cookieStore);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
