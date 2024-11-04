package utilities;

import java.awt.Robot;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.Desktop.Action;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Robot;
import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public String selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public void checkCheckbox(WebElement checkbox) {
		if(!checkbox.isSelected()) {
			checkbox.click();
		}
	}
	
	public void uncheckCheckbox(WebElement checkbox) {
		if(checkbox.isSelected()) {
			checkbox.click();
		}
	}
	public void draganddropAction(WebElement source, WebElement target,WebDriver driver)
	{
		 Actions actionobj=new Actions(driver); 
		 actionobj.dragAndDrop(source,target).perform();
	}
	public void fileUploadByActioncls(WebElement element, String filepath,WebDriver driver)
	{
		 Actions actionobj=new Actions(driver); 
		 actionobj.moveToElement(element).click().perform();
	}
	public void fileUploadBySenkeys(WebElement element, String filepath)
	{
		element.sendKeys("C:\\Users\\ASUS\\Pictures\\pexels-pixabay-68507.jpg"); 
	}
	public void fileUploadByRobotcls(WebElement element, String filepath,WebDriver driver) throws AWTException
	{
		Robot robot = new Robot(); 
		StringSelection filePath = new StringSelection("C:\\Users\\ASUS\\Pictures\\pexels-pixabay-68507.jpg"); 
 		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null); 
  
 		
 		robot.keyPress(KeyEvent.VK_CONTROL); 
 		robot.delay(2000);
 		robot.keyPress(KeyEvent.VK_V); 
 		robot.delay(2000);
 		robot.keyRelease(KeyEvent.VK_V); 
 		robot.delay(2000);
 		robot.keyRelease(KeyEvent.VK_CONTROL); 
 		robot.delay(2000);
  
 		// Press Enter to confirm the file upload 
 		robot.keyPress(KeyEvent.VK_ENTER); 
 		robot.delay(2000);
 		robot.keyRelease(KeyEvent.VK_ENTER); 
 		robot.delay(2000);
  
 		WebElement check = driver.findElement(By.id("terms")); 
 		check.click(); 
 		WebElement submit = driver.findElement(By.id("submitbutton")); 
 		submit.click(); 
		  
	}
	//----------table------------
	public void firstRowPrinting( List<WebElement> element, String filepath)
	{
		for(int i=0;i<element.size();i++)
	       {
	    	   System.out.print(element.get(i).getText()+"  ");
	       }
	}
	//----------alert--------------------
	public void alertAccept(WebDriver driver)
	{
		 String alerttext=driver.switchTo().alert().getText();
	     System.out.println(alerttext);
	     driver.switchTo().alert().accept();
	}
	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	public String generateCurrentDateByPattern(String pattern) {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);	
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}
	
	
/*	public boolean isSelectedCheckbox(WebElement checkbox)
	{
		return checkbox.isSelected();
		
	}
	public boolean isEnabledCheckbox(WebElement checkbox)
	{
		return checkbox.isEnabled();
		
	}*/
	
	public void sendkeyFunction(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

}
