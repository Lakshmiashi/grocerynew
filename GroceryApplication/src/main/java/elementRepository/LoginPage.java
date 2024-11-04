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
	GeneralUtilities gu=new GeneralUtilities(); //utilities use eg
    ExcelUtility eu=new ExcelUtility();
	WebDriver driver;
	public LoginPage(WebDriver driver)
   {
		this.driver=driver;
		PageFactory.initElements(driver, this);//with pagefactory
	}
/* By UserNameField=By.name("username");//with out pagefactory
 WebElement element=driver.findElement(UserNameField).click();*/

//element find with page factory for that we use @FindBy	
@FindBy(name="username")
WebElement userNameField;

@FindBy(name="password")
WebElement passwordField;

@FindBy(xpath="//button[text()='Sign In']")
WebElement loginButton;
@FindBy(xpath="//h5[text()=' Alert!']")
WebElement invalidMessage;
public String readInvalidmessage()
{
	return invalidMessage.getText();
}

/*public void loginWithValidCredentials() throws IOException{
	//gu.sendkeyFunction(userNameField, userName);  //utility use eg
	String userName=eu.getStringData(3,1);
	String password=eu.getStringData(4,1);
	userNameField.sendKeys(userName);
	passwordField.sendKeys(password);
	loginButton.click();
}*/
public HomePage loginData(String userName,String password){
	//gu.sendkeyFunction(userNameField, userName);  //utility use eg
	userNameField.sendKeys(userName);

	passwordField.sendKeys(password);
	loginButton.click();
	return new HomePage(driver);
}


}
