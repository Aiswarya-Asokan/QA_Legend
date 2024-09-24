package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base_Class;
import constants.Constants;
import constants.Messages;
import pageobjects.LoginPage;
import pageobjects.ResetPage;
import utilities.ExcelUtility;

public class ResetPageTest extends Base_Class {
	@Test
	 public void verify_errorMsg_withInvalid_emailAddress() throws IOException
	 {
		 String email=ExcelUtility.getStringData(0, 0, Constants.INVALIDRESETPAGE);
		 LoginPage login=new LoginPage(driver);
		 ResetPage reset=login.Click_Onforgot_password();
		 reset.enter_emailId(email);
		 reset.click_onReset_Button();
		 String actual_result=reset.getError_MessageText(email);
		 String expectederror_msg=ExcelUtility.getStringData(1, 0, Constants.INVALIDRESETPAGE);
		 String expected_result=expectederror_msg;
		 Assert.assertEquals(actual_result, expected_result, Messages.RESETFAILED);
		 
		 
		 
		 
	 }
	 @Test
	 public void verify_paswrdReset_withValid_emailAddress() throws IOException
	 {
		 String email_id=ExcelUtility.getStringData(0, 0, Constants.VALIDRESETPAGE);
		 LoginPage login=new LoginPage(driver);
		 ResetPage reset=login.Click_Onforgot_password();
		 reset.enter_emailId(email_id);
		 reset.click_onReset_Button();
		 String expected_result=ExcelUtility.getStringData(1, 0, Constants.VALIDRESETPAGE);
		 String actual_result=reset.get_SuccessMessage_Display();
		 Assert.assertEquals(actual_result,expected_result, Messages.RESETPASS);
		
		
		
		 
	 }
}
