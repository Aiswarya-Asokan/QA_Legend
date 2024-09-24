package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockTransferPage {
	WebDriver driver;
	public StockTransferPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);   
	}
	
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/stock-transfers']")
	WebElement liststocktransfer;
	
	public ListAllStockTransferPage click_On_List_Stock_Transfer() 
	{
		liststocktransfer.click();
		return new ListAllStockTransferPage(driver);
	}
}
