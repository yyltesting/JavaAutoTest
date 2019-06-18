package auto.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prj {
	WebDriver driver;
	public static void sleep(int n){
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.navigate().to("http://localhost:8080/JavaPrj_6/");
		driver.manage().window().maximize();
		
	}
	public void closeChrome(){
		driver.close();
	}
	public void loginFail(){
		driver.findElement(By.name("username")).sendKeys("ad");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.name("submit")).click();
		}
	public boolean loginSure(){
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		WebElement newselement=driver.findElement(By.name("main"));
		driver.switchTo().frame(newselement);
		if(driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/span")).getText().equals("欢迎使用报价管理系统")){
			return true;
		}else{
			return false;
		}		
	}
	public void login(){
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
	}
	public boolean useradd() throws InterruptedException{
		driver.switchTo().frame(driver.findElement(By.name("Links")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Bar_panel0_c']/a/font")).click();
		driver.findElement(By.xpath("//*[@id='Bar_panel0_b0']/img")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("main")));
		driver.findElement(By.xpath("/html/body/center/table[2]/tbody/tr[2]/td[2]")).click();
		Set<String> setWindows=driver.getWindowHandles();
		List<String> it = new ArrayList<String>(setWindows);
		driver.switchTo().window(it.get(1));
		driver.findElement(By.name("customerNO")).sendKeys("79148");
		driver.findElement(By.name("phone")).sendKeys("15929866869");
		driver.findElement(By.name("relationman")).sendKeys("李龙");
		driver.findElement(By.name("customerName")).sendKeys("李云老火");
		driver.findElement(By.name("address")).sendKeys("铜锣湾");
		driver.findElement(By.name("otherInfo")).sendKeys("null");
		driver.findElement(By.name("saveButton")).click();
		Thread.sleep(5000);
		driver.switchTo().window(it.get(0));
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("Links")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Bar_panel0_c']/a/font")).click();
		driver.findElement(By.xpath("//*[@id='Bar_panel0_b1']/img")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("main")));
		driver.findElement(By.name("customerNO")).sendKeys("79148");
		driver.findElement(By.name("saveButton")).click();
		if(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[2]/td[1]")).getText().equals("79148")){
			return true;
		}else{
			return false;
		}
		}
	public boolean usermove() throws InterruptedException{
		driver.switchTo().frame(driver.findElement(By.name("Links")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Bar_panel0_c']/a/font")).click();
		driver.findElement(By.xpath("//*[@id='Bar_panel0_b0']/img")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("main")));
		driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[5]/td[7]/a[2]")).click();
		Set<String> setWindows=driver.getWindowHandles();
		List<String> it = new ArrayList<String>(setWindows);
		driver.switchTo().window(it.get(1));
		driver.findElement(By.name("customerName")).clear();
		driver.findElement(By.name("customerName")).sendKeys("李云飞");
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("三星堆");
		driver.findElement(By.name("otherInfo")).clear();
		driver.findElement(By.name("otherInfo")).sendKeys("nu");
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys("15626262262");
		driver.findElement(By.name("relationman")).clear();
		driver.findElement(By.name("relationman")).sendKeys("渣渣辉");
		driver.findElement(By.name("saveButton")).click();
		Thread.sleep(5000);
		driver.switchTo().window(it.get(0));
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("Links")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Bar_panel0_c']/a/font")).click();
		driver.findElement(By.xpath("//*[@id='Bar_panel0_b1']/img")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("main")));
		driver.findElement(By.name("customerName")).sendKeys("李云飞");
		driver.findElement(By.name("saveButton")).click();
		if(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[4]/td[2]")).getText().equals("李云飞")){
			return true;
		}else{
			return false;
		}
	}
	public boolean pjadd() throws InterruptedException{
		driver.switchTo().frame(driver.findElement(By.name("Links")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Bar_panel1_c']/a/font")).click();
		driver.findElement(By.xpath("//*[@id='Bar_panel1_b0']/img")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("main")));
		driver.findElement(By.xpath("/html/body/center/table[2]/tbody/tr[2]/td[2]/a")).click();
		Set<String> setWindows=driver.getWindowHandles();
		List<String> it = new ArrayList<String>(setWindows);
		driver.switchTo().window(it.get(1));
		driver.findElement(By.name("producttypeNO")).sendKeys("99");
		driver.findElement(By.name("producttypeName")).sendKeys("飞啊飞");
		driver.findElement(By.name("saveButton")).click();
		Thread.sleep(5000);
		driver.switchTo().window(it.get(0));
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("Links")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Bar_panel1_c']/a/font")).click();
		driver.findElement(By.xpath("//*[@id='Bar_panel1_b1']/img")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("main")));
		driver.findElement(By.name("producttypeNO")).sendKeys("999");
		driver.findElement(By.name("saveButton")).click();
		if(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[2]/td[1]")).getText().equals("999")){
			return true;
		}else{
			return false;
		}
		}
	public boolean pjmove() throws InterruptedException{
		driver.switchTo().frame(driver.findElement(By.name("Links")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Bar_panel1_c']/a/font")).click();
		driver.findElement(By.xpath("//*[@id='Bar_panel1_b0']/img")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("main")));
		driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[2]/td[3]/a[2]")).click();
		Set<String> setWindows=driver.getWindowHandles();
		List<String> it = new ArrayList<String>(setWindows);
		driver.switchTo().window(it.get(1));
		driver.findElement(By.name("producttypeName")).clear();
		driver.findElement(By.name("producttypeName")).sendKeys("卧推器");
		driver.findElement(By.name("saveButton")).click();
		Thread.sleep(5000);
		driver.switchTo().window(it.get(0));
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("Links")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Bar_panel1_c']/a/font")).click();
		driver.findElement(By.xpath("//*[@id='Bar_panel1_b1']/img")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("main")));
		driver.findElement(By.name("producttypeName")).sendKeys("卧推器");
		driver.findElement(By.name("saveButton")).click();
		if(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[2]/td[2]")).getText().equals("卧推器")){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Prj p=new Prj();
		p.openChrome();
		p.login();
		p.useradd();
		p.closeChrome();
	}

}
