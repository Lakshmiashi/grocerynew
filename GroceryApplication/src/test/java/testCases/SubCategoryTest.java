package testCases;

import static org.testng.Assert.assertFalse;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategory;
import utilities.GeneralUtilities;

public class SubCategoryTest extends BaseClass {
	SubCategory sp;
	LoginPage lp;
	HomePage hp;
	GeneralUtilities gu = new GeneralUtilities();

	@Test(priority = 1)
	public void verifySubcategory() throws IOException {
		sp = new SubCategory(driver);
		lp = new LoginPage(driver);
		hp = lp.loginData(loginData(3, 1), loginData(4, 1));
		sp = hp.openSubCategory();
		sp.openAddSubCategory();
		String actual = sp.readHeading();
		String expected = "Add Sub Category";
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.sp_verifySubcategory);
	}

	@Test(priority = 2)
	public void verifyAddNewItem() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginData(loginData(3, 1), loginData(4, 1));
		sp = hp.openSubCategory();
		sp.openAddSubCategory();
		String subcategory = "tab" + gu.generateCurrentDateAndTime();
		sp.addNewItem(3, subcategory);
		Assert.assertEquals(sp.readAlertdmessage(), "Alert!", Constant.sp_verifyAddNewItem);
		hp.openSubCategory();
		Assert.assertEquals(sp.readTableElement(1, 1), subcategory, Constant.sp_verifyAddNewItemmsg);

	}

	@Test(priority = 5)
	public void verifyDeleteItem() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginData(loginData(3, 1), loginData(4, 1));
		sp = hp.openSubCategory();
		String subCategory = sp.readTableElement(1, 1);
		sp.deleteTableElement(subCategory);
		Assert.assertEquals(sp.readAlertdmessage(), "Alert!", Constant.sp_verifyDeleteItem);
		hp.openSubCategory();
		boolean TableStatus = sp.readTableDeleteElement(subCategory);
		Assert.assertEquals(TableStatus, true, Constant.sp_verifyDeleteItemmsg);
	}

	@Test(priority = 3)
	public void verifyValidSearch() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginData(loginData(3, 1), loginData(4, 1));
		sp = hp.openSubCategory();
		sp.openSearch();
		boolean value = sp.searchValidTableElement(3, "tab"); // here integer value value canot read check
		Assert.assertEquals(value, true, "Valid search not as expected");
	}

	@Test(priority = 4)
	public void verifyInvalidSearch() throws IOException {
		sp = new SubCategory(driver);
		lp = new LoginPage(driver);
		hp = lp.loginData(loginData(3, 1), loginData(4, 1));
		sp = hp.openSubCategory();
		sp.openSearch();
		boolean value = sp.searchInvalidTableElement(2, "zzzzzzzzzzzz");
		Assert.assertEquals(value, true, "InValid search not as expected");
	}

}
