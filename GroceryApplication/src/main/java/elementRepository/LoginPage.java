package elementRepository;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.GeneralUtilities;

public class LoginPage {
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtility eu = new ExcelUtility();
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement userNameField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement loginButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement invalidMessage;

	public String readInvalidmessage() {
		return invalidMessage.getText();
	}

	public HomePage loginData(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginButton.click();
		return new HomePage(driver);
	}

}
