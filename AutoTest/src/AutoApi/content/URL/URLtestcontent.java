package AutoApi.content.URL;

import AutoApi.base.ReadExl;

public class URLtestcontent {
//	public static  String url = "http://localhost:8899";
	public static  String url = ReadExl.ReadCell("Sheet1", 1, 1);
			
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(URLtestcontent.url);
	}

}
