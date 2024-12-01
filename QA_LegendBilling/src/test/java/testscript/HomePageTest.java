package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base_Class;
import constants.Constants;
import constants.Messages;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base_Class{
	@Test(groups="Smoke")
	
	 public void verify_userLogin_date() throws IOException
	 {
			String user_name=ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
			String pass_word=ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		   	String expected_result=Constants.MESSAGE+ExcelUtility.getStringData(1, 0, Constants.LOGIN_PAGE)+Constants.LOGIN_PAGE_EXTENSION;
			 LoginPage login=new LoginPage(driver);
			 login.enter_Username(user_name);
			 login.enter_Password(pass_word);
			 HomePage home=login.click_onLogin_Button();
			 home.clic_ONalertButton();
			 String homepage_Date=home.get_LoginDate();
			 String current_date=home.get_CurrentDate();
			 Assert.assertEquals(homepage_Date, current_date, Messages.DATE);
			 
	 }
		
			
}
