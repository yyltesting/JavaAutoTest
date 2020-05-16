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
    //��driver
    public BrowserOption(WebDriver driver){
          this.driver=driver;
    }
    //��URL
    public void openUrl(String url){
    	//driver.manage().deleteAllCookies();
        driver.navigate().to(url);
    }
    
    //д��cookie
    public void AddCookie(String name,String value){    	
    	Cookie c1 = new Cookie(name, value);
    	driver.manage().addCookie(c1);
    }
    //ˢ����ҳ
    public void Reflush(){
    	driver.navigate().refresh();
    }
    //��ȡҳ��title
    public String title() {
          String title;
          return title=driver.getTitle();
    }
    //Ѱ��Ԫ��
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
    //����������ı�����
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
    //���Ԫ��
    public void click(String type,String locator){
          if(type.equals("id")){
                driver.findElement(By.id(locator)).click();
          }else if(type.equals("name")){
                driver.findElement(By.name(locator)).click();
          }else if(type.equals("xpath")){
                driver.findElement(By.xpath(locator)).click();
          }
    }
    //ҳ��ǿ������
    public static void sleep(int n){
          try {
                Thread.sleep(n*1000);
          } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
          }
    }
    //��ȡ����ֵ
    public String getvalues(String locator,String value) {
                String getvalues=driver.findElement(By.xpath(locator)).getAttribute(value);
                return getvalues;
                
    }
    //��ȡ�ı�����
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
                return "û���ҵ��ı�����";
          }
//        return values;
          
    }
    //����JS���
    public void readJs(String JS ) {
          JavascriptExecutor js =(JavascriptExecutor)driver;
          js.executeScript(JS);
          }
    //����϶��ƶ�Ԫ��
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
    //�����ͣ
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
    //��ʾ�ȴ�
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
    //��ȡ����������
    public String changeAlterValues() {
            Alert alert=driver.switchTo().alert();
            String changeAlterValues=alert.getText();
            alert.accept();
            BrowserOption.sleep(1);
            return changeAlterValues;          
    }
    //�л�Fram
    public void changedownFram(String Framname){
          WebElement newselement=driver.findElement(By.xpath(Framname));
          driver.switchTo().frame(newselement);
    }
    //������һ��Fram
    public void changeupFram(){
          driver.switchTo().parentFrame();
    }
    //���������Fram
    public void changedefaultFram(){
          driver.switchTo().defaultContent();
    }
    //�л�����
    public void changeWindow(int i){
    	System.out.println(driver.getCurrentUrl());
          Set<String> setWindows=driver.getWindowHandles();
          System.out.println(setWindows);
          List<String> it = new ArrayList<String>(setWindows);
          driver.switchTo().window(it.get(i));
          System.out.println(driver.getCurrentUrl());
    }
    //ͨ������ѡ��ѡ�������
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
    //ͨ��·���ϴ��ļ�
    public void UploadFile(String type,String localor,String cd) {
          if(type.equals("id")){
                driver.findElement(By.id(localor)).sendKeys(cd);
          }else if(type.equals("name")){
                driver.findElement(By.name(localor)).sendKeys(cd);
          }else if(type.equals("xpath")){
                driver.findElement(By.xpath(localor)).sendKeys(cd);
    }
    }
    //��ק
    public void DragandDrop(String localorone,String localortwo) {
          WebElement one=driver.findElement(By.xpath(localorone));    
          WebElement two=driver.findElement(By.xpath(localortwo));    
          (new Actions(driver)).dragAndDrop(one, two).perform();
    }
    //��ͼָ��ͼƬ
    public void GetImg(String localtion,String imgLocation,String name) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//OutputType.FILE--��Ļ����ΪͼƬ
            BufferedImage fullImg = ImageIO.read(scrFile); //��ȡ����ͼƬ
            WebElement element = driver.findElement(By.xpath(localtion)); //��ȡ����Ԫ��ͼƬλ��
            org.openqa.selenium.Point point = element.getLocation();  //��ȡԪ��ͼƬ��λ��
            //��ȡ���
            int elewidth = element.getSize().getWidth();  //��ȡԪ��ͼƬ�Ŀ�
            int eleheight = element.getSize().getHeight();  //��ȡԪ��ͼƬ�ĸ�
            //�õ���ͼƬ��������Ļ�Ľ�ͼ�����ǿ��Դ���һ�£���ͼƬ���н�ȡ��ֻ������֤����һ����
            BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
            		elewidth, eleheight);
            	ImageIO.write(eleScreenshot, "png", scrFile);
            	File screenshotLocation = new File(imgLocation + name + ".png");//��ͼƬ���浽ָ��·��������
            	FileUtils.copyFile(scrFile, screenshotLocation);
        } catch (IOException e) {
            System.out.println("��ͼ���ִ���");
        }
    }
     //����
        public void takeScreenshot(String screenPath,String name) {
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//OutputType.FILE--��Ļ����ΪͼƬ
                	File screenshotLocation = new File(scrFile + name + ".png");//��ͼƬ���浽ָ��·��������
                	FileUtils.copyFile(scrFile, screenshotLocation);
            } catch (IOException e) {
                System.out.println("��ͼ���ִ���");
            }   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
