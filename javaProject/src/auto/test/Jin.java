package auto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jin {
WebDriver driver;
	
	public static void sleep(int n){
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String id=null;
	
	public void openchrome(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.navigate().to("D:\\�ҵĶ���\\jd\\jd_reg\\demo.html");
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
	public void user(String id){   //������ô��ο���Ϊ��
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys(id);
		if(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/span")).getText().equals("�û�������Ϊ��")){
			System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/span")).getText());
		}
		else if(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/i")).isDisplayed()){
			System.out.println("pass");
		}else{
			System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/span")).getText());
		}
	}
	public void zhuci(){
		driver.findElement(By.xpath("//*[@id='btn']")).click();
		}
	public void tongyi(){
		driver.findElement(By.xpath("//*[@id='ck']")).click();	
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jin jindong1=new Jin();
		jindong1.openchrome();
		jindong1.tongyi();
		jindong1.zhuci();
		jindong1.sleep(2);
		jindong1.user("123");
		jindong1.closechrome();
	

	}

}
