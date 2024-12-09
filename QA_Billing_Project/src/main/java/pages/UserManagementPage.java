package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class UserManagementPage {
	PageUtility pageutility=new PageUtility();
	public WebDriver driver;

	public UserManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize the elements
	}

	@FindBy(xpath = "//span[text()='User Management']")
	private WebElement usermanagementmenu;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users']")
	private WebElement usermenu;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users/create']")
	private WebElement addbutton;
	@FindBy(id = "surname")
	private WebElement surnamefield;
	@FindBy(id = "first_name")
	private WebElement firstnamefield;
	@FindBy(id = "email")
	private WebElement emailfield;
	@FindBy(id = "password")
	private WebElement passwordfield;
	@FindBy(id = "confirm_password")
	private WebElement confirmpasswordfield;
	@FindBy(id = "submit_user_button")
	private WebElement savebutton;
	@FindBy(xpath = "@FindBy(xpath=\"//div[text()='User added successfully']")
	private WebElement addAlert;
	public UserManagementPage clickOnUserManagementPage() {
	
		pageutility.javascriptClick(driver, usermanagementmenu);
		
		return this;
	}

	public UserManagementPage clickOnUsersMenu() {
		
		pageutility.javascriptClick(driver, usermenu);
	
		return this;
	}

	public UserManagementPage clickOnAddButton() {
	
		pageutility.javascriptClick(driver, addbutton);
		return this;
	}

	public UserManagementPage enterSurnameOnSurnameField(String surname) {
		surnamefield.sendKeys(surname);
		return this;
	}

	public UserManagementPage enterFirstnameOnFirstnameField(String firstname) {
		firstnamefield.sendKeys(firstname);
		return this;
		
	}

	public UserManagementPage enterEmailOnEmailField(String email) {
		emailfield.sendKeys(email);
		return this;
	}

	public UserManagementPage enterPasswordOnPasswordField(String accountpassword) {
		passwordfield.sendKeys(accountpassword);
		return this;
	}

	public UserManagementPage enterPasswordOnConfirmPasswordField(String confirmaccountpassword) {
		confirmpasswordfield.sendKeys(confirmaccountpassword);
		return this;
	}

	public UserManagementPage clickOnSaveButton() {

		pageutility.javascriptClick(driver, savebutton);
		return this;
	}
	public  boolean addAlertDisplayed() {
		return addAlert.isDisplayed();
	}
}