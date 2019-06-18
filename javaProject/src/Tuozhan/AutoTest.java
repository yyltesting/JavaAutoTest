package Tuozhan;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class AutoTest {
	
	WebDriver driver;
	public void OpenBrowser(){
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("D:\\selenium\\example.html");
		delay(5);
		
	}
	
	public void userNameError(){
		
	}
	
	public void closeBrowser(){
		driver.quit();
		
	}
	
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
		
		AutoTest auto =new AutoTest();
		auto.OpenBrowser();
		auto.closeBrowser();
		/*
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "D:\\Program Files (x86)\\weixing\\Mozilla Firefox\\geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();
//		driver.get("https://www.baidu.com");
		driver.navigate().to("D:\\selenium\\example.html");
		
		//浏览器最大化
		driver.manage().window().maximize();
		AutoTest.delay(3);
		//driver强制转换js
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(1,1000)");
		System.out.println(driver.getWindowHandle());
		WebElement selectManu=driver.
				findElement(By.id("jumpMenu"));
		Select select =new Select(selectManu);
		select.selectByIndex(1);
		AutoTest.delay(4);
		Set<String> setWindows=driver.getWindowHandles();
		for(String window:setWindows){
			if(driver.switchTo().window(window).
					getTitle().contains("百度一下，你就知道")){
				break;
			}
		}
		System.out.println(driver.getWindowHandle());
//		System.out.println(setWindows.size());
//		set.add("a");
//		set.add("b");
//		for(String str:set){
//			System.out.println(str);
//		}
//		driver.getWindowHandles();
//		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.id("kw")).sendKeys("12321");
	    AutoTest.delay(4);
	    //退出
		driver.quit();
		
		//点击弹出框按钮
//		driver.findElement(By.name("promptbutton")).click();
//		//切换为Alert 对象
//		Alert alert=driver.switchTo().alert();
//		//弹出框输入
//		alert.sendKeys("888888999");
//		AutoTest.delay(3);
//	    alert.dismiss();
//		System.out.println(alert.getText());
//	    AutoTest.delay(3);
//	    alert.accept();

		
//		driver.findElement(By.name("attach[]")).sendKeys("D:\\selenium\\example.html");
		//id定位选择框
//		WebElement selectElement=
//				driver.findElement(By.id("Selector"));
//		//实例化select类
//		Select select = new Select(selectElement);
//		//调用VisibleText实现文本选择
////		select.selectByVisibleText("葡萄");
//		//调用VisibleByValue实现value选择
////		select.selectByValue("grape");
//		//调用VisibleByIndex实现下标选择
//		select.selectByIndex(4);
		
		
		
		
//		List<WebElement> webElementsA=driver.
//				findElements(By.tagName("a"));
//		System.out.println(webElementsA.size());
//		List<WebElement> webElementsInput=driver.
//				findElements(By.tagName("input"));
//		for(WebElement element:webElementsInput){
//			element.sendKeys("243243243432");
//		}
		
//		int[] arr={3,4,7,8,0};
//		for(int number:arr){
//			System.out.println(number);
//		}
//		
		
//		List<WebElement> webElements=driver.
//				findElements(By.xpath("//*[@id='u1']/a"));
//		System.out.println(webElements.size());

		
//		for(int i=1;i<=7;i++){
//		String text=driver.
//				findElement(By.xpath("//*[@id='u1']/a["+i+"]")).
//				getText();
//		System.out.println(text);
//		}
//		List<WebElement> webElements=driver.
//				findElements(By.xpath("//*[@id='u1']/a"));
//		for(int i=0;i<webElements.size();i++){
////			System.out.println(webElements.get(i).getText());
//			if(webElements.get(i).getText().equals("hao123")){
//				webElements.get(i).click();
//				break;
//			}
//		}
		
		
		//css
//		driver.findElement(By.cssSelector("html > body > a:nth-child(1)")).click();
		
		//className
//		driver.findElement(By.className("s_ipt")).sendKeys("女神");
		
		//id定位
//		driver.findElement(By.id("kw")).sendKeys("女神");
		//name定位
//		driver.findElement(By.name("wd")).sendKeys("女神");

		
		
		
		
	    //刷新
//	    driver.navigate().refresh();
	    //通过findElement查找元素
//	    WebElement webElement= driver.findElement(By.xpath("//*[@id='u1']/a[1]"));
//	    //元素点击操作
//	    webElement.click();
	    
//	    driver.findElement(By.xpath("//*[@id='u1']/a[1]")).click();
//	    driver.navigate().back();
//	    AutoTest.delay(3);
//	    driver.navigate().forward();
*/
		
	}

}
