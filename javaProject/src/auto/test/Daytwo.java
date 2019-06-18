package auto.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Daytwo {
	public static void delay(int n){
		try {
				Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.baidu.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action=new Actions(driver);
		
		WebElement newselement=driver.findElement(By.id("kw"));
		action.sendKeys(newselement,"蜡笔小新");
		action.build().perform();
		delay(10);
		driver.quit();
//				try{
//					WebDriverWait wait=new WebDriverWait(driver,4);
//					wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("新闻")))；
//					driver.findElement(By.linkText("新闻")).click();
////					
//				driver.findElement(By.linkText("新闻")).click();
//				}catch(Exception e){
////				AutoTest.delay(3);
//				driver.quit();
//				e.printStackTrace();
//				
//				}

		
		

	}

}
