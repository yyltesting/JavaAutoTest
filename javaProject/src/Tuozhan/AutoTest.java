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
		
		//��������
		driver.manage().window().maximize();
		AutoTest.delay(3);
		//driverǿ��ת��js
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
					getTitle().contains("�ٶ�һ�£����֪��")){
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
	    //�˳�
		driver.quit();
		
		//���������ť
//		driver.findElement(By.name("promptbutton")).click();
//		//�л�ΪAlert ����
//		Alert alert=driver.switchTo().alert();
//		//����������
//		alert.sendKeys("888888999");
//		AutoTest.delay(3);
//	    alert.dismiss();
//		System.out.println(alert.getText());
//	    AutoTest.delay(3);
//	    alert.accept();

		
//		driver.findElement(By.name("attach[]")).sendKeys("D:\\selenium\\example.html");
		//id��λѡ���
//		WebElement selectElement=
//				driver.findElement(By.id("Selector"));
//		//ʵ����select��
//		Select select = new Select(selectElement);
//		//����VisibleTextʵ���ı�ѡ��
////		select.selectByVisibleText("����");
//		//����VisibleByValueʵ��valueѡ��
////		select.selectByValue("grape");
//		//����VisibleByIndexʵ���±�ѡ��
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
//		driver.findElement(By.className("s_ipt")).sendKeys("Ů��");
		
		//id��λ
//		driver.findElement(By.id("kw")).sendKeys("Ů��");
		//name��λ
//		driver.findElement(By.name("wd")).sendKeys("Ů��");

		
		
		
		
	    //ˢ��
//	    driver.navigate().refresh();
	    //ͨ��findElement����Ԫ��
//	    WebElement webElement= driver.findElement(By.xpath("//*[@id='u1']/a[1]"));
//	    //Ԫ�ص������
//	    webElement.click();
	    
//	    driver.findElement(By.xpath("//*[@id='u1']/a[1]")).click();
//	    driver.navigate().back();
//	    AutoTest.delay(3);
//	    driver.navigate().forward();
*/
		
	}

}
