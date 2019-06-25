package AutoApi.base;

import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;

public class CookieStores {
	public static void CookieStores(){
		 // 全局请求设置
	    RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
	    // 创建cookie store的本地实例
	    CookieStore cookieStore = new BasicCookieStore();
	    // 创建HttpClient上下文
	    HttpClientContext context = HttpClientContext.create();
	    context.setCookieStore(cookieStore);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
