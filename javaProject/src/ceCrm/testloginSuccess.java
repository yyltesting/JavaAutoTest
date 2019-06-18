package ceCrm;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import leiCrm.Loginsuccess;

public class testloginSuccess {
	Loginsuccess logincrm;
  @Test
  public void loginSure() {
	  logincrm.login("admin","123456");
	  logincrm.sleep(2);
	  logincrm.changeFram("//*[@id='topFrame']");
	  String newelement=logincrm.driver.findElement
	  (By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div")).getText();
	  Assert.assertEquals(newelement,"当前用户：张三");
  }
  @BeforeMethod
  public void beforeMethod() {
	  logincrm=new Loginsuccess();
	  logincrm.openChrome();
  }

  @AfterMethod
  public void afterMethod() {
	  logincrm.closeChrome();
  }
  
}
