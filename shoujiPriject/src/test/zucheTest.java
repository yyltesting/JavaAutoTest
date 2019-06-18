package test;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class zucheTest {
	AndroidDriver<WebElement> driver;
	
  @Test
  public void f() {
//	  TouchAction action=new TouchAction(driver);
	  driver.findElementById("mobi.kuaidian.qunakao:id/btn_yes").click();
	  String toast="��Ա�Ų���Ϊ�գ�";
	  String message=driver.findElementByXPath("//*[contains(@text,'"+toast+"')]").getText();
	  System.out.println(message);
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities capabilities=new DesiredCapabilities();
	  //���Ե�web�����������ǲ�app�����
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

	//ƽ̨����iOS, Android, or FirefoxOS
	capabilities.setCapability("platformName", "Android");

	//�豸���к�����
	capabilities.setCapability("deviceName", "Android Emulator");

	//ϵͳ�汾������
	capabilities.setCapability("platformVersion", "5.1.1");

	//֧����������
	capabilities.setCapability("unicodeKeyboard","True");
	capabilities.setCapability("resetKeyboard", "True");

	//����
	capabilities.setCapability("appPackage", "mobi.kuaidian.qunakao");
	capabilities.setCapability("appActivity", "app.ui.MainActivity");
	capabilities.setCapability("clearSystemFiles", "true");
	//��ȡtoast
	capabilities.setCapability("automationName","uiautomator2");

	//ʵ����driver
	driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
