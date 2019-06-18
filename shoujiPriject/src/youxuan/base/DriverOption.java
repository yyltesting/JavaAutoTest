package youxuan.base;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DriverOption {
	public AndroidDriver<WebElement> driver;
	public DriverOption(AndroidDriver<WebElement> driver){
		this.driver=driver;
	}
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
	public static void sleep(int n){
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
	public void actionTappoint(int x,int y){
		TouchAction actionpoint=new TouchAction(driver);
		actionpoint.tap(x,y);
		actionpoint.perform();
	}
	
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
	public void actionMove(int startx,int starty,int endx,int endy,int time){
		TouchAction actionup=new TouchAction(driver);
		actionup.press(startx, starty).waitAction(time).moveTo(endx, endy).perform();
	}
	public void actionMax(int startx1,int starty1,int endx1,int endy1,int time,int startx2,int starty2,int
			endx2,int endy2){
		MultiTouchAction multiAction=new MultiTouchAction(driver);
		TouchAction actionXmove=new TouchAction(driver);
		actionXmove.press(startx1, starty1).waitAction(time).moveTo(endx1, endy1);
		TouchAction actionYmove=new TouchAction(driver);
		actionYmove.press(startx2, starty2).waitAction(time).moveTo(endx2, endy2);
		multiAction.add(actionXmove).add(actionYmove).perform();
	}
	public void Move(int startx,int starty,int endx,int endy,int time){
		driver.swipe(startx, starty, endx, endy, time);
	}
	public String t(String text){
		String toast=text;
//		try{  
		String message=driver.findElementByXPath("//*[contains(@text,'"+toast+"')]").getText();
		return message;
//		}catch(Exception e){
//			return "нч";
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
