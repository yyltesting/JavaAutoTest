package leiCrm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginsuccess {
	public static WebDriver driver;
	
	public static void openChrome(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.navigate().to("http://localhost:8080/crm/login.jsp");
		driver.manage().window().maximize();
		Loginsuccess.sleep(2);
	}
	public static void closeChrome(){
		driver.close();
	}
	public static void sleep(int n){
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void loginsure(){
		driver.findElement(By.name("userNum")).sendKeys("admin");
		driver.findElement(By.name("userPw")).sendKeys("123456");
		driver.findElement(By.id("in1")).click();
		
	}
	public void login(String userNum,String userPw){
		driver.findElement(By.name("userNum")).sendKeys(userNum);
		driver.findElement(By.name("userPw")).sendKeys(userPw);
		driver.findElement(By.id("in1")).click();
		
	}
	public static void changeFram(String Framname){
		driver.switchTo().parentFrame();
		WebElement newselement=driver.findElement(By.xpath(Framname));
		driver.switchTo().frame(newselement);
	}
	public static void changeWindow(int i){
		Set<String> setWindows=driver.getWindowHandles();
		List<String> it = new ArrayList<String>(setWindows);
		driver.switchTo().window(it.get(i));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loginsuccess l =new Loginsuccess();
		l.openChrome();
		l.closeChrome();

	}

}
