package AutoApi.content.Login;

import AutoApi.base.ReadExl;
import AutoApi.content.URL.URLtestcontent;

public class Logincontent {
	public static String Uri(String uri){
		return URLtestcontent.url+uri;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Logincontent.Uri(ReadExl.ReadCell("Sheet1", 2, 1)));
	}

}
