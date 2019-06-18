package TestNgX;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class Firstng {
  @Test(groups="SystemTesting")
  public void SystemTestingTwo() {
	  System.out.println("SystemTestingTwo");
  }
  
  @Test(groups="SystemTesting")
  @Parameters("username")
  public void firstngCassTwo(String username) {
	  System.out.println(username);
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
