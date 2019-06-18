package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NanW {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<WebElement> driver;
		DesiredCapabilities capabilities=new DesiredCapabilities();
		  //测试的web浏览器，如果是测app则忽略
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

		//平台设置iOS, Android, or FirefoxOS
		capabilities.setCapability("platformName", "Android");

		//设备序列号设置
		capabilities.setCapability("deviceName", "Android Emulator");

		//系统版本号设置
		capabilities.setCapability("platformVersion", "8.0.0");

		//支持中文输入
		capabilities.setCapability("unicodeKeyboard","True");
		capabilities.setCapability("resetKeyboard", "True");

		//包名
		capabilities.setCapability("appPackage", "com.bjnsc.csg");
		capabilities.setCapability("appActivity", "com.bjnsc.csg.ui.activity.SplashActivity");
		capabilities.setCapability("clearSystemFiles", "true");
		//获取toast
		capabilities.setCapability("automationName","uiautomator2");

		//实例化driver
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		driver.quit();

	  }
	}


