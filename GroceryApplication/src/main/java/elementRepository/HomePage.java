package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
   {
		this.driver=driver;
		PageFactory.initElements(driver, this);//with pagefactory
	}
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement homePageHeading;
	@FindBy(xpath="//li//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	  WebElement subcategoryPage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement manageNewsPage;
	@FindBy(xpath = "//li//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement manageContactLink;
	public SubCategory openSubCategory() {
		  		  subcategoryPage.click();
		  		  return new SubCategory(driver);
		   }
	public String readHeading()
	{
		return homePageHeading.getText();
	}
	public ManageNews openManageNews() {

		manageNewsPage.click();
		return new  ManageNews(driver);
	}
	public ManageContact openManageContact() {

		manageContactLink.click();
		return new  ManageContact(driver);

	}
	
}
