package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContact;
import elementRepository.ManageNews;
import utilities.GeneralUtilities;

public class ManageContactTest extends BaseClass {
	ManageContact mp;
	LoginPage lp;
	HomePage hp;
	GeneralUtilities gu=new GeneralUtilities(); 
@Test(priority=1)
public void verifyContact() throws IOException, InterruptedException {
	lp=new LoginPage(driver);
	hp=lp.loginData(loginData(3,1),loginData(4,1));
	mp=hp.openManageContact();
	mp.openedit();
	mp.verifyUpdateContact();
	Assert.assertEquals( lp.readInvalidmessage(),"Alert!","Alert message  not As Expected");  
}
@Test(priority=2)
public void verifyContactReset() throws IOException{
	lp=new LoginPage(driver);
	hp=lp.loginData(loginData(3,1),loginData(4,1));
	mp=hp.openManageContact();
	mp.openedit();
	mp.verifyResetContact();
	String expectedurl="https://groceryapp.uniqassosiates.com/admin/list-contact";
	Assert.assertEquals(driver.getCurrentUrl(), expectedurl, "URL should match");  
}

  }
