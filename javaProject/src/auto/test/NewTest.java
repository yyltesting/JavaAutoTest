package auto.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest {
	Prj prj;
  @Test
  public void loginF() {
	  prj.loginFail();
  }
  @Test
  public void loginS() {
	  Assert.assertEquals(prj.loginSure(),true);
  }
  @Test
  public void useraddS() throws InterruptedException {
	  prj.login();
	  Assert.assertEquals(prj.useradd(),true);
  }
  @Test
  public void usersava() throws InterruptedException {
	  prj.login();
	  Assert.assertEquals(prj.usermove(),true);
  }
  @Test
  public void pjAdd() throws InterruptedException {
	  prj.login();
	  Assert.assertEquals(prj.pjadd(),true);
  }
  @Test
  public void pjSave() throws InterruptedException {
	  prj.login();
	  Assert.assertEquals(prj.pjmove(),true);
  }
  @BeforeMethod
  public void beforeMethod() {
	  prj=new Prj();
	  prj.openChrome();	  
  }

  @AfterMethod
  public void afterMethod() {
	  prj.closeChrome();
	  
  }

}
