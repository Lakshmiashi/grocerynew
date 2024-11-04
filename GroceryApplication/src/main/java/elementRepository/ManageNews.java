package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageNews {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsField;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement newsAddField;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchtfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchnewsbutton;
	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement invalidMessage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement managenewsLink;


	

	public void openAddNews() {

		newsAddField.click();
	}

	public void verifyAddNews(String news) {

		newsField.sendKeys(news);
		saveButton.click();
	}

	public boolean verifySearchNews(String news) {
		searchButton.click();
		searchtfield.sendKeys(news);
		searchnewsbutton.click();
		return true;
		//resetButton.click();
	}

	public String readInvalidmessage() {
		return invalidMessage.getText();
	}

}
