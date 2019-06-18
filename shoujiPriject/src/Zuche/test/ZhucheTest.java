package Zuche.test;

import org.testng.annotations.Test;

import Zuche.base.Touchdriver;
import Zuche.page.Zhuche;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;

public class ZhucheTest {
	Touchdriver use;
	Zhuche z;
	 @Test
	  public void f() {
		  z.insert();
	 
	 }  
	  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  use=new Touchdriver();
	  z=new Zhuche();
	  use.open();
  }

  @AfterClass
  public void afterClass() {
	  use.quit();
  }
}
