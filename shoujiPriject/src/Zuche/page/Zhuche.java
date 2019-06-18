package Zuche.page;

import Zuche.base.DriverOption;
import Zuche.base.Touchdriver;
import Zuche.content.zhuche.Zhuchecontent;

public class Zhuche {
	DriverOption tel;
	public void insert(){
		tel=new DriverOption(Touchdriver.driver);
		tel.click("text",Zhuchecontent.zhu );
		tel.sleep(3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
