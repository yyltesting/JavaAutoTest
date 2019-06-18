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
		  //���Ե�web�����������ǲ�app�����
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

		//ƽ̨����iOS, Android, or FirefoxOS
		capabilities.setCapability("platformName", "Android");

		//�豸���к�����
		capabilities.setCapability("deviceName", "Android Emulator");

		//ϵͳ�汾������
		capabilities.setCapability("platformVersion", "8.0.0");

		//֧����������
		capabilities.setCapability("unicodeKeyboard","True");
		capabilities.setCapability("resetKeyboard", "True");

		//����
		capabilities.setCapability("appPackage", "com.bjnsc.csg");
		capabilities.setCapability("appActivity", "com.bjnsc.csg.ui.activity.SplashActivity");
		capabilities.setCapability("clearSystemFiles", "true");
		//��ȡtoast
		capabilities.setCapability("automationName","uiautomator2");

		//ʵ����driver
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		driver.quit();

	  }
	}


