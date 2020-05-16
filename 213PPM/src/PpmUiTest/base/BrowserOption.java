package PpmUiTest.base;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.Args;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.javafx.scene.paint.GradientUtils.Point;

public class BrowserOption {
	public WebDriver driver;
    //传driver
    public BrowserOption(WebDriver driver){
          this.driver=driver;
    }
    //打开URL
    public void openUrl(String url){
    	//driver.manage().deleteAllCookies();
        driver.navigate().to(url);
    }
    
    //写入cookie
    public void AddCookie(String name,String value){    	
    	Cookie c1 = new Cookie(name, value);
    	driver.manage().addCookie(c1);
    }
    //刷新网页
    public void Reflush(){
    	driver.navigate().refresh();
    }
    //获取页面title
    public String title() {
          String title;
          return title=driver.getTitle();
    }
    //寻找元素
    public WebElement element(String type,String locator){
    	WebElement element = null;
    	if(type.equals("id")){
            element = driver.findElement(By.id(locator));
            return element;
      }else if(type.equals("name")){
    	  element = driver.findElement(By.name(locator));
    	  return element;
      }else if(type.equals("xpath")){
    	  element = driver.findElement(By.xpath(locator));
    	  return element;
      }else{
    	  return element;
      }
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
//        return values;
          
    }
    //调用JS语句
    public void readJs(String JS ) {
          JavascriptExecutor js =(JavascriptExecutor)driver;
          js.executeScript(JS);
          }
    //鼠标拖动移动元素
    public void RemoveElement(int x , int y ,String type,String localtor){
    	Actions action = new Actions(driver);  
    	if(type.equals("id")) {
    	WebElement element = driver.findElement(By.id(localtor));
        action.dragAndDropBy(element, x, y).perform();
    	}else if(type.equals("name")) {
    		WebElement element = driver.findElement(By.name(localtor));
    		action.dragAndDropBy(element, x, y).perform();
    	}else if(type.equals("xpath")) {
    		WebElement element = driver.findElement(By.xpath(localtor));
    		action.dragAndDropBy(element, x, y).perform();   	
    	}
    }
    //鼠标悬停
    public void DontmoveAction(String type,String localtor){
    	Actions action = new Actions(driver); 
    	if(type.equals("id")) {
        	WebElement element = driver.findElement(By.id(localtor));
        	action.moveToElement(element).perform(); 
        	}else if(type.equals("name")) {
        		WebElement element = driver.findElement(By.name(localtor));
        		action.moveToElement(element).perform(); 
        	}else if(type.equals("xpath")) {
        		WebElement element = driver.findElement(By.xpath(localtor));
        		action.moveToElement(element).perform();   	
        	}
    }
    //显示等待
    public void waitFor(int time,String type,String localtor) {
          WebDriverWait wait=new WebDriverWait(driver,time);
          if(type.equals("id")) {
          wait.until(ExpectedConditions.elementToBeClickable(By.id(localtor)));
          }else if(type.equals("name")) {
          wait.until(ExpectedConditions.elementToBeClickable(By.name(localtor)));   
          }else if(type.equals("xpath")) {
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath(localtor)));  
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
    	System.out.println(driver.getCurrentUrl());
          Set<String> setWindows=driver.getWindowHandles();
          System.out.println(setWindows);
          List<String> it = new ArrayList<String>(setWindows);
          driver.switchTo().window(it.get(i));
          System.out.println(driver.getCurrentUrl());
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
    //截图指定图片
    public void GetImg(String localtion,String imgLocation,String name) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//OutputType.FILE--截幕保存为图片
            BufferedImage fullImg = ImageIO.read(scrFile); //读取截屏图片
            WebElement element = driver.findElement(By.xpath(localtion)); //获取具体元素图片位置
            org.openqa.selenium.Point point = element.getLocation();  //读取元素图片的位置
            //获取宽高
            int elewidth = element.getSize().getWidth();  //获取元素图片的宽
            int eleheight = element.getSize().getHeight();  //获取元素图片的高
            //得到的图片是整个屏幕的截图，我们可以处理一下，对图片进行截取，只保留验证码那一部分
            BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
            		elewidth, eleheight);
            	ImageIO.write(eleScreenshot, "png", scrFile);
            	File screenshotLocation = new File(imgLocation + name + ".png");//把图片保存到指定路径并命名
            	FileUtils.copyFile(scrFile, screenshotLocation);
        } catch (IOException e) {
            System.out.println("截图出现错误");
        }
    }
     //截屏
        public void takeScreenshot(String screenPath,String name) {
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//OutputType.FILE--截幕保存为图片
                	File screenshotLocation = new File(scrFile + name + ".png");//把图片保存到指定路径并命名
                	FileUtils.copyFile(scrFile, screenshotLocation);
            } catch (IOException e) {
                System.out.println("截图出现错误");
            }   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
