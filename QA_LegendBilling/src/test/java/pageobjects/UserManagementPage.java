package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {
	WebDriver driver;
	 public UserManagementPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
	 @FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users']")
	 WebElement user_field;
	 
	 
	 public UsersPage clickOn_users_field()
	 {
		 user_field.click();
		return new UsersPage(driver);
	 }
}
