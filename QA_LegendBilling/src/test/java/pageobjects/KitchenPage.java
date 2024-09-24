package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitchenPage {

	WebDriver driver;
	public  KitchenPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@data-href='https://qalegend.com/billing/public/sells/347']")
	 WebElement order_details_fld;
	
	
	public void click_On_OrderDetails_Field()
	{
		order_details_fld.click();
	}
}
