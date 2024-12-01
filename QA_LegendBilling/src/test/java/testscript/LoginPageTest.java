package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base_Class;
import constants.Constants;
import constants.Messages;
import dataprovider.DataProviders;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base_Class {
	
		@Test(groups="Smoke")
		
		
			
		 public void verify_Login_With_Valid_Credentials() throws IOException
		 {
			String user_name=ExcelUtility.getStringData(0, 0,"LoginTest");
			String pass_word=ExcelUtility.getIntegerData(0, 1, "LoginTest");
		   	String expected_result=Constants.MESSAGE+ExcelUtility.getStringData(1, 0, Constants.LOGIN_PAGE)+Constants.LOGIN_PAGE_EXTENSION;
			 LoginPage login=new LoginPage(driver);
			 login.enter_Username(user_name);
			 login.enter_Password(pass_word);
			 HomePage home=login.click_onLogin_Button();  //import home page
			 String actual_result=home.get_MessageDisplay();
			 Assert.assertEquals(actual_result, expected_result, Messages.LOGINFAILED);
			
			 
			
			
			
		 }
		@Test(dataProvider="Invalidusercredentials", dataProviderClass=DataProviders.class, enabled=false)

		 public void verify_errorMessage_whileLogin_withInvalid_credentials(String username, String password) throws IOException
		 {
			 LoginPage login=new LoginPage(driver);
			 login.enter_Username(username);
			 login.enter_Password(password);
		     login.login_button_click();
		     String actual_result=login.get_DisplayMessage();
			 String expected_result=ExcelUtility.getStringData(2, 0, Constants.LOGIN_PAGE);
			 Assert.assertEquals(actual_result, expected_result, Messages.INVALIDCREDENTIAL);
			
		 }
}