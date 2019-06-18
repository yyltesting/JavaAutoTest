package crm.page.userselect;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import crm.base.BrowserOption;
import crm.base.UseBrowser;
import crm.content.useradd.UseraddContent;
import crm.content.useradd.UserselectContent;
import crm.page.login.Loginpage;

public class UserSelect {
	BrowserOption op;
	public void select(String text,String way){
		op=new BrowserOption(UseBrowser.driver);
		op.changeFram("/html/frameset/frameset/frame[1]");
		op.click("xpath",UseraddContent.userinformation);
		op.changeFram("/html/frameset/frameset/frame[2]");
		op.inputText("xpath", UserselectContent.userinformation, text);
		op.selectWay("xpath", UserselectContent.way, way);
		op.click("xpath", UserselectContent.select);
		op.sleep(2);
	}
	public void have(){
		String content=UseBrowser.driver.findElement(By.xpath(UserselectContent.selectcontent)).getText().substring(4, 5);
		System.out.println(content);
	}

//		String xpath;
//		
//			if(UserselectContent.userinformation.equals("¡ıª∂")){
//				int j=0;
//				for(int i=2;i<=5;i++){
//					xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td[1]/div/span";
//					if(xpath.equals("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/div/span")){
//						j=1;
//						break;
//					}
//				}
//				if(j==1){
//					return true;
//				}else if(j==0){
//					return false;
//				}
//			}
//			if(UserselectContent.userinformation.equals("∞°ª∆")){
//				int j=0;
//				for(int i=2;i<=5;i++){
//					xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td[1]/div/span";
//					if(xpath.equals("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td[1]/div/span")){
//						j=1;
//						break;
//					}
//				}
//				if(j==1){
//					return true;
//				}else if(j==0){
//					return false;
//				}
//			}
//			if(UserselectContent.userinformation.equals("ª∆œ˛æ¸")){
//				int j=0;
//				for(int i=2;i<=5;i++){
//					xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td[1]/div/span";
//					if(xpath.equals("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]/div/span")){
//						j=1;
//						break;
//					}
//				}
//				if(j==1){
//					return true;
//				}else if(j==0){
//					return false;
//				}
//			}
//			if(UserselectContent.userinformation.equals("Œ¬«Ï–ƒ")){
//				int j=0;
//				for(int i=2;i<=5;i++){
//					xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td[1]/div/span";
//					if(xpath.equals("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td[1]/div/span")){
//						j=1;
//						break;
//					}
//				}
//				if(j==1){
//					return true;
//				}else if(j==0){
//					return false;
//				}
//			}
//			
//		}

										
					
					
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseBrowser use=new UseBrowser();
		Loginpage login=new Loginpage();
		UserSelect select=new UserSelect();
		login.login("admin", "123456");
		select.select("¡ıª∂", "øÕªß–’√˚");
//		System.out.println(select.have());
		use.quit();

	}

}
