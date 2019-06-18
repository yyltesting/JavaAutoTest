package changku.page;

import changku.base.DriverOption;
import changku.base.TouchDriver;
import changku.content.Addwucontent;


public class Addwu {
	DriverOption tel;
	public void add(String name,String danwei,String shuliang){
		tel=new DriverOption(TouchDriver.driver);
		tel.click("text", Addwucontent.ify);
		tel.sleep(2);
		tel.actionTappoint(250, 240);
		tel.click("text", Addwucontent.guanli);
		tel.click("text", Addwucontent.addw);
		tel.inputText("id", Addwucontent.name, name);
		tel.inputText("id", Addwucontent.danwei, danwei);
		tel.inputText("id", Addwucontent.shuliang, shuliang);
		tel.click("text", Addwucontent.sure);
	}
	public String fail(String text){
		return tel.t(text);
	}
	public String success(String name){
		return tel.m(name);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
