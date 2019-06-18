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

public class jindongTest {
	AndroidDriver<WebElement> driver;
  @Test
  public void f() throws InterruptedException {
	  driver.findElementById("com.jingdong.app.mall:id/bs1").click();
	  Thread.sleep(3000);
//	  driver.findElementById("com.jingdong.app.mall:id/a3o").click();
//	  driver.findElementById("com.jd.lib.search:id/search_text").sendKeys("空军一号");
//	  driver.findElementById("com.jingdong.app.mall:id/atf").click();
//	  Thread.sleep(10000);
////	  int width=driver.manage().window().getSize().width;
////	  int height=driver.manage().window().getSize().height;
////	  System.out.println("width"+width+" "+"heigth"+height);
////	  driver.swipe(width/2, height/2, width/2, height/9,1000);
//	  
////	  driver.swipe(300, 1000, 300, 100,1000);
////	  Thread.sleep(1000);
////	  driver.swipe(300, 300, 300, 1000,1000);
////	  Thread.sleep(3000);
//	  driver.findElementByXPath("//android.widget.TextView[@text='耐克NIKE AIR FORCE 1 AF1空军一号Just Do It JDI男子休闲板鞋篮球鞋 882096-200（限量） 44']").click();
//	  Thread.sleep(2000);
//	  int width=driver.manage().window().getSize().width;
//	  int height=driver.manage().window().getSize().height;
//	  System.out.println("width"+width+" "+"heigth"+height);
//	  for(int i=0;i<6;i++){
//		  driver.swipe(width/2, 200, width/5, 200, 500);
//	  }
//	  driver.swipe(300, 1000, 300, 100, 1000);
//	  Thread.sleep(2000);
//	  WebElement marketElement=driver.findElementById("com.jingdong.app.mall:id/gf");
//	  driver.findElementById("com.jingdong.app.mall:id/blp").click();
	  TouchAction action=new TouchAction(driver);
//	  action.press(marketElement).release();
//	  action.tap(marketElement);
//	  action.tap(70,600);
//	  Thread.sleep(10000);
	  action.tap(500,1250);
	  Thread.sleep(10000);
	  WebElement  e=driver.findElementByXPath("//android.widget.TextView[@text='耐克NIKE AIR FORCE 1 AF1空军一号Just Do It JDI男子休闲板鞋篮球鞋 882096-200（限量） 44']");
	  action.longPress(e,3000).release();
	  action.perform();
	  Thread.sleep(2000);
	  WebElement b=driver.findElementByLinkText("已经买了");
	  action.tap(b);
	  action.perform();
	  Thread.sleep(20000);
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities capabilities=new DesiredCapabilities();
	  //测试的web浏览器，如果是测app则忽略
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

	//平台设置iOS, Android, or FirefoxOS
	capabilities.setCapability("platformName", "Android");

	//设备序列号设置
	capabilities.setCapability("deviceName", "Android Emulator");

	//系统版本号设置
	capabilities.setCapability("platformVersion", "5.1.1");

	//支持中文输入
	capabilities.setCapability("unicodeKeyboard","True");
	capabilities.setCapability("resetKeyboard", "True");

	//包名
	capabilities.setCapability("appPackage", "com.jingdong.app.mall");
	capabilities.setCapability("appActivity", "com.jingdong.app.mall.main.MainActivity");
	capabilities.setCapability("clearSystemFiles", "true");
	//获取toast
	capabilities.setCapability("automationName","uiautomator2");

	//实例化driver
	driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
