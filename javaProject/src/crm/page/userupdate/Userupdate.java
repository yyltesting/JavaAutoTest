package crm.page.userupdate;

import crm.base.BrowserOption;
import crm.base.UseBrowser;
import crm.content.useradd.UseraddContent;
import crm.content.useradd.UserupdateContent;

public class Userupdate {
	BrowserOption op;
	public void update(){
		op=new BrowserOption(UseBrowser.driver);
		op.changeFram("/html/frameset/frameset/frame[1]");
		op.click("xpath",UseraddContent.userinformation);
		op.changeFram("/html/frameset/frameset/frame[2]");
		op.click("xpath", UserupdateContent.update);
		op.sleep(1);
		op.click("xpath", UserupdateContent.upload);
		op.sleep(3);
		}
	public String alter(){
		return op.changeAlterValues();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
