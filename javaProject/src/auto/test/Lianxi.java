package auto.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lianxi {
	
	WebDriver driver;
	
	public static void sleep(int n){
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openchrome(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.navigate().to("D:\\我的东西\\jd\\jd_reg\\demo.html");
		driver.manage().window().maximize();
		Lianxi.sleep(1);
	}
	
	public void closechrome()
	{
		driver.quit();
	}
	
	public void clickzhuci(){
		driver.findElement(By.xpath("//*[@id='btn']")).click();
		}
	public void notongyi(){
		driver.findElement(By.xpath("//*[@id='ck']")).click();
		driver.findElement(By.xpath("//*[@id='ck']")).click();
		driver.findElement(By.xpath("//*[@id='btn']")).click();
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/div[2]/span")).getText());
	}
	public void clicktongyi(){
		driver.findElement(By.xpath("//*[@id='ck']")).click();	
	}
	public void usersure(){
		driver.findElement(By.xpath("//*[@id='userName']")).clear();
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("admin");
	}
	public void userfalse(){
		driver.findElement(By.xpath("//*[@id='userName']")).clear();
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("a");
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/span")).getText());
		}
	public void usernull(){
		driver.findElement(By.xpath("//*[@id='ck']")).click();
		driver.findElement(By.xpath("//*[@id='btn']")).click();
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/span")).getText());
		driver.findElement(By.xpath("//*[@id='ck']")).click();
		}
	public void pwdsure(){
		driver.findElement(By.xpath("//*[@id='pwd']")).clear();
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys("123456");
	}
	public void pwdnull(){
		driver.findElement(By.xpath("//*[@id='ck']")).click();
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='btn']")).click();
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/span")).getText());
		driver.findElement(By.xpath("//*[@id='ck']")).click();
		driver.findElement(By.xpath("//*[@id='userName']")).clear();
	}
	public void pwdfalse(){
		driver.findElement(By.xpath("//*[@id='pwd']")).clear();
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys("abc");
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/span")).getText());
	}
	public void surepwdsure(){
		driver.findElement(By.xpath("//*[@id='pwd2']")).clear();
		driver.findElement(By.xpath("//*[@id='pwd2']")).sendKeys("123456");
	}
	public void surepwdnull(){
		driver.findElement(By.xpath("//*[@id='ck']")).click();
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='btn']")).click();
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/span")).getText());
		driver.findElement(By.xpath("//*[@id='ck']")).click();
		driver.findElement(By.xpath("//*[@id='userName']")).clear();
		driver.findElement(By.xpath("//*[@id='pwd']")).clear();
	}
	public void surepwdfalse(){
		driver.findElement(By.xpath("//*[@id='pwd2']")).clear();
		driver.findElement(By.xpath("//*[@id='pwd2']")).sendKeys("12");
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/span")).getText());
	}
	public void sureT(){
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());
		alert.accept();
		}
	
	
	
	
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Lianxi jindong=new Lianxi();
		jindong.openchrome();
		jindong.usernull();
		jindong.userfalse();
		jindong.pwdnull();
		jindong.pwdfalse();
		jindong.surepwdnull();
		jindong.surepwdfalse();
		jindong.usersure();
		jindong.pwdsure();
		jindong.surepwdsure();
		jindong.notongyi();
		jindong.clicktongyi();
		jindong.sleep(1);
		jindong.clickzhuci();
		jindong.sureT();
		jindong.closechrome();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
      /*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("D:\\我的东西\\处理基本元素\\example.html");
		driver.manage().window().maximize();
		AutoTest.sleep(1);
		driver.findElement(By.name("attach[]")).sendKeys("D:\\我的东西\\处理基本元素\\example.html");
		WebElement selectElement=driver.findElement(By.id("Selector"));
		Select select = new Select(selectElement);
		select.selectByVisibleText("葡萄");
		AutoTest.sleep(1);
//		List<WebElement>webElements=driver.findElements(By.xpath("//*[@id='u1']/a"));
//		for(int i=0;i<webElements.size();i++){
//			System.out.println(webElements.get(i).getText());
//		}
//		driver.navigate().refresh();
//		AutoTest.sleep(3);
//		WebElement webElement = driver.findElement(By.xpath("//*[@id='u1']/a[1]"));
//		webElement.click();
//		AutoTest.sleep(3);
//		driver.navigate().back();
//		AutoTest.sleep(1);
//		driver.findElement(By.id("kw")).sendKeys("女神");
//		driver.findElement(By.id("su")).click();
////		driver.navigate().forward();
//		AutoTest.sleep(3);
		driver.quit();
*/

	}

}
