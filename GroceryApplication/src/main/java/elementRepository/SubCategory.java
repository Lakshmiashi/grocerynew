package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class SubCategory {

  GeneralUtilities gu=new GeneralUtilities(); 
  WebDriver driver; 
  public SubCategory(WebDriver driver) {
   this.driver=driver;
  PageFactory.initElements(driver, this);
  }
  
  @FindBy(name="cat_id") 
  WebElement categoryField;
  
  @FindBy(name="subcategory")
   WebElement subCategoryField;
  
  @FindBy(name="create")
   WebElement saveButton;
  
  @FindBy(xpath="//h5[text()=' Alert!']") 
  WebElement alertMessage;
  
  @FindBy(xpath="//li//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
  WebElement subcategoryPage;
  
  @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
  WebElement newitem;
  
  @FindBy(xpath="//h1[text()='Add Sub Category']")
   WebElement subCategoryPageHeading;
  
  @FindBy(xpath="//table//tbody//tr[1]//td[5]//a[2]")
   WebElement deleteButton;
   @FindBy(xpath ="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> subcategoryColoumn;
   @FindBy(xpath="//select[@name='un']")
   WebElement  categorySearch;
   @FindBy(xpath="//input[@name='ut']")
   WebElement subCategorySearch;
   @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
   WebElement searchTablecSubcategory;
   @FindBy(xpath="//a[text()=' Search']")
   WebElement searchButton;
   @FindBy(xpath="//button[@name='Search']")
   WebElement searchPageSearchButton;
  public void openAddSubCategory() {  
    newitem.click(); 
  } 
  
  public void openSearch() {
	  
	  searchButton.click();
	   }
  
  public String readAlertdmessage()
   { 
   return alertMessage.getText(); 
   }
    public void addNewItem(int i,String subcategory){
    	//String subcategory="tab"+gu.generateCurrentDateAndTime();
     String selectedCategory=gu.selectDropdownWithIndex(categoryField, i); //utility use 
  System.out.println(selectedCategory);
  subCategoryField.sendKeys(subcategory);
   saveButton.click(); 
   } 
   
    public String readTableElement(int row,int column) { 
        String path ="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["+ column + "]";
		WebElement element = driver.findElement(By.xpath(path));
		return element.getText();
  
  } 
   
   public void deleteTableElement(String subcategory) { 
   for (int i = 0; i < subcategoryColoumn.size(); i++) {
			if (subcategoryColoumn.get(i).getText().equals(subcategory)) {
				String path ="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//a[2]";
				WebElement element = driver.findElement(By.xpath(path));
				element.click();
				driver.switchTo().alert().accept();
				break;
			}
			}
  
  } 
  public boolean readTableDeleteElement(String subcategory) {

		List<WebElement> tableColumn = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		boolean value = true;
		for (int i = 0; i < tableColumn.size(); i++) {
			if (tableColumn.get(i).getText().equals(subcategory)) {

			
				value = false;
			}

		}
		return value;
	}
   public boolean searchValidTableElement(int i,String subcategory)
   {
	   searchButton.click();
	   String selectedCategory=gu.selectDropdownWithIndex(categorySearch, i); 
	   subCategorySearch.sendKeys(subcategory);
	   searchPageSearchButton.click();
	   return true;
	  
   }
   public boolean searchInvalidTableElement(int i,String subcategory)
   {
	   searchButton.click();
	   String selectedCategory=gu.selectDropdownWithIndex(categorySearch, i); 
	   subCategorySearch.sendKeys(subcategory);
	   searchPageSearchButton.click();
	   return true;
	}
  public String readHeading() { 
  return subCategoryPageHeading.getText(); 
      }
 
   }
 
