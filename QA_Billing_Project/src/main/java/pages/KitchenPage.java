package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KitchenPage {
	public WebDriver driver;
	public KitchenPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//to initialize the elements
	}
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/modules/kitchen']") private WebElement kitchenmenu;
@FindBy(xpath="//a[@data-href='https://qalegend.com/billing/public/sells/1294']")private WebElement singleorderdetail;
public void clickOnKitchenMenu()
{
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", kitchenmenu);
}
public void clickOnOrderDetailsMenu() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", singleorderdetail);
}
}