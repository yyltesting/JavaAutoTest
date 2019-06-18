package leiCrm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.gargoylesoftware.htmlunit.javascript.host.Window;

import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;

public class UserAdd {
	public void add(){
		Loginsuccess.changeFram("/html/frameset/frameset/frame[1]");
//		Loginsuccess.driver.findElement(By.xpath("//*[@id='imgmenu1']/table/tbody/tr/td[2]")).click();
		Loginsuccess.driver.findElement(By.xpath("//*[@id='submenu1']/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/span/a")).click();
		Loginsuccess.changeFram("/html/frameset/frameset/frame[2]");
		Loginsuccess.driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[4]/input")).click();
		}
	public void addSuccess(){
		Loginsuccess.driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[2]/td[2]/input")).sendKeys("°¢·É");
		Loginsuccess.driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[4]/td[4]/input")).sendKeys("791482765@qq.com");
//		JavascriptExecutor js =(JavascriptExecutor)Loginsuccess.driver;
//		js.executeScript(Window.)
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loginsuccess.openChrome();
		Loginsuccess log=new Loginsuccess();
		log.login("admin", "123456");
		UserAdd u=new UserAdd();
		Loginsuccess.sleep(3);
		u.add();
		u.addSuccess();
		Loginsuccess.closeChrome();
		

	}

}
