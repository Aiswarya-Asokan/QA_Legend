package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {
	public WebDriver driver;
	public UserManagementPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//to initialize the elements
	}
	@FindBy(xpath="//span[text()='User Management']") private WebElement usermanagementmenu;
@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users']") private WebElement usermenu;
@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users/create']") private WebElement addbutton;
@FindBy(id="surname") private WebElement surnamefield;
@FindBy(id="first_name") private WebElement firstnamefield;
@FindBy(id="email") private WebElement emailfield;
@FindBy(id="password") private WebElement passwordfield;
@FindBy(id="confirm_password") private WebElement confirmpasswordfield;
@FindBy(id="submit_user_button") private WebElement savebutton;
public void clickOnUserManagementPage()
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", usermanagementmenu);	
}
public void clickOnUsersMenu()
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", usermenu);	
}
public void clickOnAddButton()
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", addbutton);
}
public void enterSurnameOnSurnameField(String surname)
{
	surnamefield.sendKeys(surname);
}
public void enterFirstnameOnFirstnameField(String firstname)
{
	firstnamefield.sendKeys(firstname);
}
public void enterEmailOnEmailField(String email)
{
	emailfield.sendKeys(email);
}
public void enterPasswordOnPasswordField(String accountpassword)
{
	passwordfield.sendKeys(accountpassword);
}
public void enterPasswordOnConfirmPasswordField(String confirmaccountpassword) {
	confirmpasswordfield.sendKeys(confirmaccountpassword);
}
public void clickOnSaveButton()
{

	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", savebutton);
}
}