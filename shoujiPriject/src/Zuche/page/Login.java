package Zuche.page;

import Zuche.base.DriverOption;
import Zuche.base.Touchdriver;
import Zuche.content.login.Logincontent;


public class Login {
	DriverOption tel;
	public void Sure(String number){
		tel=new DriverOption(Touchdriver.driver);
		tel.inputText("id", Logincontent.vip, number);
		tel.click("id", Logincontent.sure);
		tel.sleep(3);
	}
	public String kong(){
		return tel.t("��Ա�Ų���Ϊ�գ�");
	}
	public String fail(){
		return tel.t("�����ڴ��˺ţ�");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Touchdriver q=new Touchdriver();
		Login w=new Login();
		w.Sure("123");
		System.out.println(w.fail());
		q.quit();

	}

}
