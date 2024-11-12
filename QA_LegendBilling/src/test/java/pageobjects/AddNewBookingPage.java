package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AddNewBookingPage {

	WebDriver driver;
	public AddNewBookingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li[@id='select2-booking_location_id-result-gmb6-1' and @aria-selected='true']")
	WebElement business_location;
	@FindBy(xpath="//li[@id='select2-booking_customer_id-result-59xs-1']")
	WebElement customer_fld;
	
	
	
	public void select_Location_Field()
	{
		business_location.sendKeys("Demo Company (BL0001)");	
		//PageUtility.select_IndexOperation(business_location, "0");
		
	}
	public void customer_Selection_fld()
	{
		PageUtility.selectByVisibleText(customer_fld, "Walk-In Customer (CO0001)");
	}
}
