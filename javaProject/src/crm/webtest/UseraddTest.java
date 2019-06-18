package crm.webtest;

import org.testng.annotations.Test;

import crm.base.UseBrowser;
import crm.page.login.Loginpage;
import crm.page.useradd.Useraddpage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class UseraddTest {
	UseBrowser use;
	Loginpage login;
	Useraddpage user;
  @Test
  public void addsuccess() {
	  user.userAdd("阿飞", "791482765@qq.com", "啊兰", "2018-10-10 16:28:28");
	  Assert.assertEquals(user.al(),"客户添加成功");
	   }
  @Test
  public void addF1() {
	  user.userAdd("", "791482765@qq.com", "啊兰", "2018-10-10 16:28:28");
	  Assert.assertEquals(user.al(),"- 客户姓名不能为空!\n");
	   }
  @Test
  public void addF2() {
	  user.userAdd("啊飞", "", "啊兰", "2018-10-10 16:28:28");
	  Assert.assertEquals(user.al(),"- Email不能为空\n");
	   }
  @Test
  public void addF3() {
	  user.userAdd("啊飞", "791482765@qq.com", "", "2018-10-10 16:28:28");
	  Assert.assertEquals(user.al(),"- 创建人不能为空!\n");
	   }
  @Test
  public void addF4() {
	  user.userAdd("啊飞", "791482765@qq.com", "a", "");
	  Assert.assertEquals(user.al(),"- 出生日期不能为空!\n");
	   }
  @Test
  public void addF5() {
	  user.userAdd("", "", "", "");
	  Assert.assertEquals(user.al(),"- 客户姓名不能为空!\n- Email不能为空\n- 出生日期不能为空!\n- 创建人不能为空!\n");
	   }
  @BeforeClass
  public void beforeClass() {
	  use=new UseBrowser();
	  login=new Loginpage();
	  user=new Useraddpage();
	  login.login("admin", "123456");
  }

  @AfterClass
  public void afterClass() {
	  use.quit();
  }

}
