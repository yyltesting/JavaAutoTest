package leiCrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFail {
	
	public void loginF1(){
		Loginsuccess.driver.findElement(By.name("userNum")).clear();
		Loginsuccess.driver.findElement(By.name("userPw")).clear();
		Loginsuccess.driver.findElement(By.name("userNum")).sendKeys("ad");		
		Loginsuccess.driver.findElement(By.name("userPw")).sendKeys("123456");
		Loginsuccess.driver.findElement(By.id("in1")).click();
	}
	public void loginF2(){
		Loginsuccess.driver.findElement(By.name("userNum")).clear();
		Loginsuccess.driver.findElement(By.name("userPw")).clear();
		Loginsuccess.driver.findElement(By.name("userNum")).sendKeys("admin");
		Loginsuccess.driver.findElement(By.name("userPw")).sendKeys("12");
		Loginsuccess.driver.findElement(By.id("in1")).click();
	}
	public void loginF3(){
		Loginsuccess.driver.findElement(By.name("userNum")).clear();
		Loginsuccess.driver.findElement(By.name("userPw")).clear();
		Loginsuccess.driver.findElement(By.name("userNum")).sendKeys("ad");
		Loginsuccess.driver.findElement(By.name("userPw")).sendKeys("12");
		Loginsuccess.driver.findElement(By.id("in1")).click();
	}
	public void loginF4(){
		Loginsuccess.driver.findElement(By.name("userNum")).clear();
		Loginsuccess.driver.findElement(By.name("userPw")).clear();
		Loginsuccess.driver.findElement(By.id("in1")).click();
	}
	public void loginF5(){
		Loginsuccess.driver.findElement(By.name("userNum")).clear();
		Loginsuccess.driver.findElement(By.name("userPw")).clear();
		Loginsuccess.driver.findElement(By.name("userPw")).sendKeys("123456");
		Loginsuccess.driver.findElement(By.id("in1")).click();
	}
	public void loginF6(){
		Loginsuccess.driver.findElement(By.name("userNum")).clear();
		Loginsuccess.driver.findElement(By.name("userPw")).clear();
		Loginsuccess.driver.findElement(By.name("userNum")).sendKeys("admin");
		Loginsuccess.driver.findElement(By.id("in1")).click();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
