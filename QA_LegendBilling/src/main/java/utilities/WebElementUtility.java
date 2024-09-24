package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {
public void key_operation(WebElement element,String text)
{
	element.sendKeys("Text");
}
public void clickable_operation(WebElement element)
{
	element.click();
}
public void radio_check_dropdown(WebElement element,boolean isboolean)
{
	isboolean=element.isSelected();
	
}
public void visibility_operation(WebElement element,boolean isboolean)
{
	isboolean=element.isDisplayed();
}
public void enable_operation(WebElement element,boolean isboolean)
{
	isboolean=element.isEnabled();
}
}
