package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//to initialize the elements
	}
	@FindBy(id="username") private WebElement loginField;
	@FindBy(id="password") private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;
	@FindBy(xpath="//label[@class='btn btn-info active']") private WebElement isTodayButtonDisplayed;
	
	public void enterUsernameOnUsernameField(String username)
	{
		loginField.sendKeys(username);
	}
	public void enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);	
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	public boolean isTodayButtonDisplayed()
	{
		return isTodayButtonDisplayed.isDisplayed();
	
	}
}
