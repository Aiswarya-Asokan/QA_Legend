package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
	WebDriver driver;
	 public ResetPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this );
	 }
	 @FindBy(id="email")
	 WebElement email_fld;
	 @FindBy(xpath="//button[@type='submit']")
	 WebElement snd_passwd_rsetlnk;
	 @FindBy(xpath="//div[@class='alert alert-success']")
	 WebElement success_msg;
	 @FindBy (xpath="//span[@class='help-block']")
	 WebElement error_msgtext;


	 
	 
	 public void enter_emailId(String emaild)
	 {
		 email_fld.sendKeys(emaild);
	 }
	 public void click_onReset_Button()
	 {
		 snd_passwd_rsetlnk.click();
	 }
	 public String get_SuccessMessage_Display()
	 {
		 String display_message=success_msg.getText();
		return display_message;
	 }
	 public String getError_MessageText(String text)
	 {
		 String text_error_message=error_msgtext.getText();
		 return text_error_message;
		 		 
	 }
}
