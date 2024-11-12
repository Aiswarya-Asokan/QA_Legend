package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class UsersPage {
	 WebDriver driver;
	 public UsersPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
	 @FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users/create']")
	 WebElement add_field;
	 @FindBy(xpath="//input[@class='form-control input-sm']")
	 WebElement search_field;
	 @FindBy(xpath="//table[@id='users_table']/tbody/tr[1]/td[1]")
	 WebElement result_table;
	 @FindBy(xpath="//a[@href='https://qalegend.com/billing/public/home']")
	 WebElement home_page_field;
	 @FindBy(xpath="//i[@class='glyphicon glyphicon-edit']")
	 WebElement edit_field;
	 @FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users/3661']")
	 WebElement view_field;
	 @FindBy(xpath="//li[@class='dt-button buttons-pdf buttons-html5 bg-info' and @aria-controls='users_table']")
	 WebElement action_fld;

	 
	 public AddUserPage button_Add()
	 {
		 add_field.click();
		return new AddUserPage(driver);
		 
	 }
	 public void search_User(String searchdata)
	 {
		 search_field.sendKeys(searchdata);
	 }
	 public String display_Table()
	 { 
		 WaitUtility.waitForElement(driver, result_table);
		 String result=result_table.getText();
	  	return result;
		
	 }
	 public HomePage backTo_HomePage()
	 {
		 home_page_field.click();
		return new HomePage(driver);
	 }
	 
	
}
