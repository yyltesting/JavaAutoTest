package rimi.com;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserOption {
public WebDriver driver;
	//传driver
	public BrowserOption(WebDriver driver){
		this.driver=driver;
	}
	//打开URL
	public void openUrl(String url){
		driver.navigate().to(url);
	}
	//获取页面title
	public String title() {
		String title;
		return title=driver.getTitle();
	}
	//输入框输入文本内容
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
	//点击元素
	public void click(String type,String locator){
		if(type.equals("id")){
			driver.findElement(By.id(locator)).click();
		}else if(type.equals("name")){
			driver.findElement(By.name(locator)).click();
		}else if(type.equals("xpath")){
			driver.findElement(By.xpath(locator)).click();
		}
	}
	//页面强制休眠
	public static void sleep(int n){
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取属性值
	public String getvalues(String locator,String value) {
			String getvalues=driver.findElement(By.xpath(locator)).getAttribute(value);
			return getvalues;
			
	}
	//获取文本内容
	public String value(String type,String localtor) {
		if(type.equals("id")){
			String values=driver.findElement(By.id(localtor)).getText();
			return values;
		}else if(type.equals("name")){
			String values= driver.findElement(By.name(localtor)).getText();
			return values;
		}else if(type.equals("xpath")){
			String values=driver.findElement(By.xpath(localtor)).getText();
			return values;
		}else {
			return "没有找到文本内容";
		}
//		return values;
		
	}
	//调用JS语句
	public void readJs(String JS) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript(JS);
	}
	//显示等待
	public void waitFor(int time,String type,String localtor) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		if(type.equals("id")) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(localtor)));
		}else if(type.equals("name")) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(localtor)));	
		}else if(type.equals("xpath")) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(localtor)));	
		}
	}
	//获取弹出框内容
	public String changeAlterValues() {
		  Alert alert=driver.switchTo().alert();
		  String changeAlterValues=alert.getText();
		  alert.accept();
		  BrowserOption.sleep(1);
		  return changeAlterValues;		  
	}
	//切换Fram
	public void changedownFram(String Framname){
		WebElement newselement=driver.findElement(By.xpath(Framname));
		driver.switchTo().frame(newselement);
	}
	//返回上一级Fram
	public void changeupFram(){
		driver.switchTo().parentFrame();
	}
	//返回最初级Fram
	public void changedefaultFram(){
		driver.switchTo().defaultContent();
	}
	//切换窗口
	public void changeWindow(int i){
		Set<String> setWindows=driver.getWindowHandles();
		List<String> it = new ArrayList<String>(setWindows);
		driver.switchTo().window(it.get(i));
	}
	//通过内容选择选择框内容
	public void selectWay(String type,String localor,String text){
		if(type.equals("id")){
		WebElement selectElement=driver.findElement(By.id(localor));
		Select select = new Select(selectElement);
		select.selectByVisibleText(text);}
		else if(type.equals("name")){
			WebElement selectElement=driver.findElement(By.name(localor));
			Select select = new Select(selectElement);
			select.selectByVisibleText(text);}
		else if(type.equals("xpath")){
			WebElement selectElement=driver.findElement(By.xpath(localor));
			Select select = new Select(selectElement);
			select.selectByVisibleText(text);}
		} 
	//通过路径上传文件
	public void UploadFile(String type,String localor,String cd) {
		if(type.equals("id")){
			driver.findElement(By.id(localor)).sendKeys(cd);
		}else if(type.equals("name")){
			driver.findElement(By.name(localor)).sendKeys(cd);
		}else if(type.equals("xpath")){
			driver.findElement(By.xpath(localor)).sendKeys(cd);
	}
	}
	//拖拽
	public void DragandDrop(String localorone,String localortwo) {
		WebElement one=driver.findElement(By.xpath(localorone));	
		WebElement two=driver.findElement(By.xpath(localortwo));	
		(new Actions(driver)).dragAndDrop(one, two).perform();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
