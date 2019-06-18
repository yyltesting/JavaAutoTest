package changku.test;

import org.testng.annotations.Test;

import changku.base.Readexl;
import changku.base.TouchDriver;
import changku.page.Addwu;
import changku.page.Login;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class addwuTest {
	TouchDriver use;
	Login login;
	Addwu ad;
	@Test
	  public void success() {
		  ad.add(Readexl.readCell("Sheet3", 4, 4),Readexl.readCell("Sheet3", 5, 4),Readexl.readCell("Sheet3", 6, 4));
		  Assert.assertEquals(ad.success(Readexl.readCell("Sheet3", 4, 4)), Readexl.readCell("Sheet3", 4, 4));
	  }
  @Test
  public void fail1() {
	  ad.add(Readexl.readCell("Sheet3", 4, 7),Readexl.readCell("Sheet3", 5, 7),Readexl.readCell("Sheet3", 6, 7));
	  Assert.assertEquals(ad.fail("请输入物品名称！"), "\n\n请输入物品名称！\n\n");
  }
  @Test
  public void fail2() {
	  ad.add(Readexl.readCell("Sheet3", 4, 5),Readexl.readCell("Sheet3", 5, 5),Readexl.readCell("Sheet3", 6, 5));
	  Assert.assertEquals(ad.fail("请输入物品单位！"), "\n\n请输入物品单位！\n\n");
  }
  @Test
  public void fail3() {
	  ad.add(Readexl.readCell("Sheet3", 4, 6),Readexl.readCell("Sheet3", 5, 6),Readexl.readCell("Sheet3", 6, 6));
	  Assert.assertEquals(ad.fail("请输入库存数量！"), "\n\n请输入库存数量！\n\n");
  }
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  use=new TouchDriver();
	  login=new Login();
	  ad=new Addwu();
	  use.open();
	  login.login("sa", "sa");
	  login.sure();
  }

  @AfterMethod
  public void afterMethod() {
	  use.quit();
  }

}
