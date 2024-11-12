package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;
import utilities.PageUtility;

public class AddUserPage {
	 WebDriver driver;


	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='surname']")
	WebElement prefix_fld;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname_field;
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastname_field;
	@FindBy(xpath="//input[@id='email']")
	WebElement email_field;
	@FindBy(xpath="//select[@class='form-control select2 select2-hidden-accessible' and @id='role']")
	WebElement role_field;
	@FindBy(xpath="//input[@id='username']")
	WebElement username_field;
	@FindBy(xpath="//input[@id='password']")
	WebElement password_field;
	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement confirm_passwordfield;
	@FindBy(xpath="//button[@id='submit_user_button']")
	WebElement save_button_field;
	
	
	public void add_userDatas(String fname, String lname, String email, String uname, String passwd, String confirmpasswd )
	{
		prefix_fld.sendKeys("Mrs");
		firstname_field.sendKeys(fname);
		lastname_field.sendKeys(lname);
		email_field.sendKeys(email);
		PageUtility.selectByVisibleText(role_field,"Admin");
		username_field.sendKeys(uname);
		password_field.sendKeys(passwd);
		confirm_passwordfield.sendKeys(confirmpasswd);
	}
	
	public UsersPage ClickOn_SaveButton()
	{
		save_button_field.click();
		return new UsersPage(driver) ;
	}

}
