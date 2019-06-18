package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Jisuanji {
	AndroidDriver<WebElement> driver;
  @Test
  public void f() throws InterruptedException {
//	  driver.findElementByAndroidUIAutomator("text(\"3\")").click();
//	  driver.findElementById("com.example.calculator:id/jia").click();
//	  driver.findElementById("com.example.calculator:id/button1").click();
//	  driver.findElementById("com.example.calculator:id/jia").click();
//	  driver.findElementById("com.example.calculator:id/button9").click();
//	  driver.findElementById("com.example.calculator:id/deng").click();
	  List<WebElement> list=driver.findElementsByClassName("android.widget.Button");
//	  System.out .println(list);
	  for(int i=0;i<list.size();i++){
		  System.out.print(list.get(i).getText()+" ");
	  }
	  Thread.sleep(3000);
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
capabilities.setCapability("appPackage", "com.example.calculator");
capabilities.setCapability("appActivity", "com.example.calculator.MainActivity");
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
