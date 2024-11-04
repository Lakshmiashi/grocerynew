package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageNews;
import elementRepository.SubCategory;
import utilities.GeneralUtilities;

public class ManageNewsTest extends BaseClass {
	ManageNews mp;
	LoginPage lp;
	HomePage hp;
	GeneralUtilities gu = new GeneralUtilities();

	@Test
	public void verifyAddNews() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginData(loginData(3, 1), loginData(4, 1));
		mp = hp.openManageNews();
		mp.openAddNews();
		mp.verifyAddNews("test news sample");
		Assert.assertEquals(lp.readInvalidmessage(), "Alert!", "Alert message  not As Expected");
	}

	@Test
	public void verifySearchNews() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginData(loginData(3, 1), loginData(4, 1));
		mp = hp.openManageNews();
		boolean value = mp.verifySearchNews("test news sample"); // here integer value value canot read check
		Assert.assertEquals(value,true, "Valid search not as expected");
	}
}
