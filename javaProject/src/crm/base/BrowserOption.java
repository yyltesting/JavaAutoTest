package crm.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;






public class BrowserOption {
	public WebDriver driver;
	
	public BrowserOption(WebDriver driver){
		this.driver=driver;
	}
	public void openUrl(String url){
		driver.navigate().to(url);
	}
	public void inputText(String type,String locator,String text){
		if(type.equals("id")){
			driver.findElement(By.id(locator)).clear();
			driver.findElement(By.id(locator)).sendKeys(text);
		}else if(type.equals("name")){
			driver.findElement(By.name(locator)).clear();
			driver.findElement(By.name(locator)).sendKeys(text);
		}else if(type.equals("xpath")){
			driver.findElement(By.xpath(locator)).clear();
			driver.findElement(By.xpath(locator)).sendKeys(text);
		}
	}
	public void click(String type,String locator){
		if(type.equals("id")){
			driver.findElement(By.id(locator)).click();
		}else if(type.equals("name")){
			driver.findElement(By.name(locator)).click();
		}else if(type.equals("xpath")){
			driver.findElement(By.xpath(locator)).click();
		}
	}
	public static void sleep(int n){
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String changeAlterValues() {
		  Alert alert=driver.switchTo().alert();
		  String changeAlterValues=alert.getText();
		  alert.accept();
		  BrowserOption.sleep(1);
		  return changeAlterValues;		  
	}
	public void changeFram(String Framname){
		driver.switchTo().parentFrame();
		WebElement newselement=driver.findElement(By.xpath(Framname));
		driver.switchTo().frame(newselement);
	}
	public void changeWindow(int i){
		Set<String> setWindows=driver.getWindowHandles();
		List<String> it = new ArrayList<String>(setWindows);
		driver.switchTo().window(it.get(i));
	}
	public void selectWay(String type,String localor,String text){
		if(type.equals("id")){
		WebElement selectElement=driver.findElement(By.id(localor));
		Select select = new Select(selectElement);
		select.selectByVisibleText(text);}
		if(type.equals("name")){
			WebElement selectElement=driver.findElement(By.name(localor));
			Select select = new Select(selectElement);
			select.selectByVisibleText(text);}
		if(type.equals("xpath")){
			WebElement selectElement=driver.findElement(By.xpath(localor));
			Select select = new Select(selectElement);
			select.selectByVisibleText(text);}
		} 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseBrowser use =new UseBrowser();
		BrowserOption op=new BrowserOption(UseBrowser.driver);
		op.openUrl("http://localhost:8080/crm/login.jsp");
		op.inputText("name", "userNum", "admin");
		op.click("id","in1");
		System.out.println(op.changeAlterValues());
		op.sleep(2);
		use.quit();

	}

}
