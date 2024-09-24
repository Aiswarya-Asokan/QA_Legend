package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     ///to initialize webdriver, page factorty in selenium package
	}
	@FindBy(xpath="//section[@class='content-header']")
	WebElement message_field;
	@FindBy(xpath="//button[@data-role='end']")
	WebElement alert_btn;
	@FindBy(xpath="//span[text()='User Management']")
	WebElement user_management_fld;
	@FindBy(xpath="//a[@data-toggle='dropdown' and  @class='dropdown-toggle']")
	WebElement admin_name;
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/logout']")
	WebElement signout_field;
	@FindBy(xpath="//section[@class='content-header']")
	WebElement user_result;
	@FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement login_date;
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement admin ;
	@FindBy(xpath="//a[text()='Profile']")
	WebElement profilefield ;
	@FindBy(xpath="//i[@class='fa fa-truck']")
	WebElement clickstocktransfer;
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/modules/kitchen']")
	WebElement kitchen_fld;

	
	
	
	
	
	public String get_MessageDisplay()
	{
		String messagetext=message_field.getText();
		return messagetext;
	}
	public void  clic_ONalertButton()
	{
		alert_btn.click();
	}
	public UserManagementPage clickON_UserManagement_Field()
	{
		user_management_fld.click();
		return new UserManagementPage(driver);
	}
	public void clicOn_adminName()
	{
		admin_name.click();
	}
	public LoginPage clickOn_SignOut_Button()
	{
		signout_field.click();
		return new LoginPage(driver);
	}
	public String user_LoginResult()
	{
		String result=user_result.getText();
		return result;
	}
	public String get_LoginDate()
	{
		String logindate=login_date.getText();
		return logindate;
	}
	public String get_CurrentDate()
	{
		return DateUtility.get_UserLogin_Date("dd-MM-YYYY");
	}
	public void click_On_Adminabc()
	{
		admin.click();
	}
	public AdminUpdateProfilePage click_On_Profile_Field()
	{
		profilefield.click();
		return new AdminUpdateProfilePage(driver);
	}
	public StockTransferPage click_On_Stock_Transfer() 
	{
		clickstocktransfer.click();
		return new StockTransferPage(driver);
	}
	public KitchenPage click_on_Kitchen_Field()
	{
		kitchen_fld.click();
		return null;
		
	}

}
