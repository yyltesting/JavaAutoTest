package HunanApp.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DriverOption {
	//ʵ����driver
	public AndroidDriver<WebElement> driver;
    public DriverOption(AndroidDriver<WebElement> driver){
          this.driver=driver;
    }
    //�����ı�
    public void inputText(String type,String locator,String text){
          if(type.equals("id")){
                driver.findElementById(locator).clear();
                driver.findElementById(locator).sendKeys(text);
          }else if(type.equals("name")){
                driver.findElementByClassName(locator).clear();
                driver.findElementByClassName(locator).sendKeys(text);
          }else if(type.equals("xpath")){
                driver.findElementByXPath(locator).clear();
                driver.findElementByXPath(locator).sendKeys(text);
          }else if(type.equals("text")){
                driver.findElementByLinkText(locator).clear();
                driver.findElementByAndroidUIAutomator("text(\""+locator+"\")").sendKeys(text);
          }
    }
    //���Ԫ��
    public void click(String type,String locator){
          if(type.equals("id")){
                driver.findElementById(locator).click();
          }else if(type.equals("name")){
                driver.findElementByClassName(locator).click();
          }else if(type.equals("xpath")){
                driver.findElementByXPath(locator).click();
          }else if(type.equals("text")){
                driver.findElementByAndroidUIAutomator("text(\""+locator+"\")").click();
          }
    }
    //ǿ������
    public static void sleep(int n){
          try {
                Thread.sleep(n*1000);
          } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
          }
    }
    //��ָ���Ԫ��
    public  void actionTap(String type,String locator){
          if(type.equals("id")){
                TouchAction action=new TouchAction(driver);
                WebElement e=driver.findElementById(locator);
                action.tap(e);
                action.perform();
          }else if(type.equals("name")){
                TouchAction action=new TouchAction(driver);
                WebElement e=driver.findElementByClassName(locator);
                action.tap(e);
                action.perform();
          }else if(type.equals("xpath")){
                TouchAction action=new TouchAction(driver);
                WebElement e=driver.findElementByXPath(locator);
                action.tap(e);
                action.perform();
          }else if(type.equals("text")){
                TouchAction action=new TouchAction(driver);
                WebElement e=driver.findElementByAndroidUIAutomator("text(\""+locator+"\")");
                action.tap(e);
                action.perform();
          }
    }
    //��ָ���ĳ����λ
    public void actionTappoint(int x,int y){
          TouchAction actionpoint=new TouchAction(driver);
          actionpoint.tap(x,y);
          actionpoint.perform();
    }
    //����ĳ��Ԫ��
    public  void actionLangpress(String type,String locator,int time){
          if(type.equals("id")){
                TouchAction action=new TouchAction(driver);
                WebElement e=driver.findElementById(locator);
                action.longPress(e,time).release();
                action.perform();
          }else if(type.equals("name")){
                TouchAction action=new TouchAction(driver);
                WebElement e=driver.findElementByClassName(locator);
                action.longPress(e,time).release();
                action.perform();
          }else if(type.equals("xpath")){
                TouchAction action=new TouchAction(driver);
                WebElement e=driver.findElementByXPath(locator);
                action.longPress(e,time).release();
                action.perform();
          }else if(type.equals("text")){
                TouchAction action=new TouchAction(driver);
                WebElement e=driver.findElementByAndroidUIAutomator("text(\""+locator+"\")");
                action.longPress(e,time).release();
                action.perform();
          }
    }
    //��ָ�ƶ�
    public void actionMove(int startx,int starty,int endx,int endy,int time){
          TouchAction actionup=new TouchAction(driver);
          actionup.press(startx, starty).waitAction(time).moveTo(endx, endy).release().perform();
    }
    
    //�Ŵ��С����
    public void actionMax(int startx1,int starty1,int endx1,int endy1,int time,int startx2,int starty2,int
                endx2,int endy2){
          MultiTouchAction multiAction=new MultiTouchAction(driver);
          TouchAction actionXmove=new TouchAction(driver);
          actionXmove.press(startx1, starty1).waitAction(time).moveTo(endx1, endy1);
          TouchAction actionYmove=new TouchAction(driver);
          actionYmove.press(startx2, starty2).waitAction(time).moveTo(endx2, endy2);
          multiAction.add(actionXmove).add(actionYmove).perform();
    }
    //ֱ��ͨ�����껬����Ļ
    public void Move(int startx,int starty,int endx,int endy,int time){
          driver.swipe(startx, starty, endx, endy, time);
    }
    //��ȡ��Ϣ��������
    public String ToastText(String toast){
          try{ 
          String message=driver.findElementByXPath("//*[contains(@text,'"+toast+"')]").getText();
          return message;
          }catch(Exception e){
                return "��";
          }
    }
    //ͨ��text��λ��ȡԪ���ı�
    public String Text(String text){
          String message=driver.findElementByAndroidUIAutomator("text(\""+text+"\")").getText();
          return message;
    }
    
    //����JS���
    public void readJs(String JS ) {
          JavascriptExecutor js =(JavascriptExecutor)driver;
          js.executeScript(JS);
          }
    //��ʾ�ȴ�
    public void waitFor(int time,String type,String localtor) {
          WebDriverWait wait=new WebDriverWait(driver,time);
          if(type.equals("id")) {
          wait.until(ExpectedConditions.elementToBeClickable(By.id(localtor)));
          }else if(type.equals("name")) {
          wait.until(ExpectedConditions.elementToBeClickable(By.name(localtor)));   
          }else if(type.equals("text")) {
          wait.until(ExpectedConditions.elementToBeClickable(By.name(localtor))); 
          }else if(type.equals("xpath")) {
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath(localtor)));
          }         
    }

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		TouchDriver driver = new TouchDriver();
		driver.open();
		DriverOption option = new DriverOption(driver.driver);
		option .sleep(3);
		option.inputText("xpath", "//android.widget.EditText[@text='�������ֻ��Ż����֤��']", "15729866869");
		option.sleep(2);
		option.inputText("xpath", "//android.widget.EditText[@text='����������']", "yyl123456");
		option.sleep(10);
//		option.click("xpath", "//android.widget.TextView[@text='��¼']");
		option.sleep(3);
		option.waitFor(10, "xpath", "//android.widget.TextView[@text='�ຣ�ǻ۹���']");
		option.click("xpath", "//android.widget.TextView[@text='������']");
		option.sleep(2);
		option.click("xpath", "//android.widget.TextView[@text='������']");
		option.sleep(25);
		option.click("xpath", "//android.view.View[@text='ҵ����Ŀ��']");
//		option.actionTappoint(500, 500);
		option.sleep(3);
		driver.quit();
	}

}
