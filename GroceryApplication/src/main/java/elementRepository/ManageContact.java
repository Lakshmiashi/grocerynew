package elementRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageContact {

	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='phone']")
	WebElement phone;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement address;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliveryTime;
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement deliveryChargeLimit;
	@FindBy(xpath = "//li//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement manageContactLink;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement resetButton;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updateButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	WebElement actionLink;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement invalidMessage;

	public void openedit() {

		actionLink.click();
	}
	public String readInvalidmessage() {
		return invalidMessage.getText();
	}
	public void verifyUpdateContact() throws InterruptedException {
		phone.clear();
		email.clear();
		address.clear();
		deliveryTime.clear();
		deliveryChargeLimit.clear();
		phone.sendKeys("213");
		email.sendKeys("amy@gmail.com");
		address.sendKeys("TVM");
		deliveryTime.sendKeys("3");
		deliveryChargeLimit.sendKeys("300");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0, 1000);");
		 Thread.sleep(2000);
		 updateButton.click();
	}
	public void verifyResetContact()
	{
		resetButton.click();
	}
}
