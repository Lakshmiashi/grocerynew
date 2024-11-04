package testCases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategory;
import utilities.ExcelUtility;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
		
	
  @Test(priority=1)
  public void verifyLoginWithValidCredentials() throws IOException{
	  
	lp=new LoginPage(driver);
	//hp=new HomePage(driver);
	String userName=loginData(3,1);
	String password=loginData(4,1);
	System.out.println(userName+ password);
	hp=lp.loginData(loginData(3,1),loginData(4,1));
	String actual=hp.readHeading();
	String expected="7rmart supermarket";
	System.out.println(actual);
	Assert.assertEquals(actual, expected,Constant.lp_verifyLoginWithValidCredentials);  
	}
  @Test(dataProvider="data-provider",priority=2)
  public void verifyLoginWithInValidCredentials(String userName, String password) {
	lp=new LoginPage(driver);
	lp.loginData(userName,password);
	Assert.assertEquals( lp.readInvalidmessage(),"Alert!",Constant.lp_verifyLoginWithInValidCredentials);  
  }
  
  
  @DataProvider (name = "data-provider")
 	public Object[][] dpMethod(){
 	return new Object[][] {{"admin", "adm" }, {"abcd", "admin"},{"abcd","abcde"}};
 	}
  
}
