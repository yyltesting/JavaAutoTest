package auto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3*1000);
		driver.navigate().to("https://www.baidu.com/");
		String text = driver.findElement(By.name("tj_trxueshu")).getAttribute("class");
		System.out.println(text);
		String text1 = driver.findElement(By.name("tj_trxueshu")).getText();
		System.out.println(text1);
		driver.quit();
		
		
	}

}
