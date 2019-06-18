package changku.page;

import org.openqa.selenium.SearchContext;

import changku.base.DriverOption;
import changku.base.TouchDriver;
import changku.content.Selectwuconten;

public class Selectwu {
	DriverOption tel;
	public void select(String text){
		tel=new DriverOption(TouchDriver.driver);
		tel.click("text", Selectwuconten.select);
		tel.inputText("id", Selectwuconten.name, text);
		tel.click("text", Selectwuconten.sure);
		
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
