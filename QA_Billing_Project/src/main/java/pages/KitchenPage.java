package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class KitchenPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public KitchenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize the elements
	}

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/modules/kitchen']")
	private WebElement kitchenmenu;
	@FindBy(xpath = "//a[@data-href='https://qalegend.com/billing/public/sells/340']")
	private WebElement singleorderdetail;
	@FindBy(xpath="//a[@data-href='https://qalegend.com/billing/public/modules/kitchen/mark-as-cooked/1294\']") private WebElement cookedbtn;
	@FindBy(xpath="//a[@data-href='https://qalegend.com/billing/public/sells/340']" ) private WebElement detailbtn;
	public void clickOnKitchenMenu() {

		
		pageutility.javascriptClick(driver, kitchenmenu);
	}

	public void clickOnOrderDetailsMenu() {
		pageutility.javascriptClick(driver, singleorderdetail);
	}
	
	public boolean isCookedButtonDisplayed()
	{
		return cookedbtn.isDisplayed();
	}
	public boolean isDetailButtonDisplayed() {
		return detailbtn.isDisplayed();
	}
}