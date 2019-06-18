package changku.page;

import changku.base.DriverOption;
import changku.base.TouchDriver;
import changku.content.Classifycontent;

public class Classify {
	DriverOption tel;
	public void insertClassify(String name,String sort){
		tel =new DriverOption(TouchDriver.driver);
		tel.click("text", Classifycontent.ify);
		tel.sleep(2);
		tel.click("text", Classifycontent.addify);
		tel.inputText("xpath", Classifycontent.ifyname, name);
		tel.inputText("id", Classifycontent.sort, sort);
		tel.click("text", Classifycontent.sure);
		tel.sleep(3);
		
	}
	public String success(String name){
		 return tel.m(name);
	}
	public String fail(String text){
		return tel.t(text);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
