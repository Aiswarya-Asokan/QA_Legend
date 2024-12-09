package testscript;

import java.io.IOException;
import java.time.Duration;


import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.UserManagementPage;
import utility.ExcelUtility;

public class UserManagementTest extends Base {
	UserManagementPage usermanagementpage;
@Test(retryAnalyzer=retry.Retry.class,description="to add new user")
	public void verifyAddNewUser() throws IOException
	{
	String username=ExcelUtility.getStringData(1, 0,"UserManagement");
	String password=ExcelUtility.getIntegerData(1, 1,"UserManagement");
	String surname=ExcelUtility.getStringData(1, 2,"UserManagement");
	String firstname=ExcelUtility.getStringData(1,3 ,"UserManagement");
	String email=ExcelUtility.getStringData(1,4,"UserManagement");
	String accountpassword=ExcelUtility.getStringData(1, 5,"UserManagement" );
	String confirmaccountpassword=ExcelUtility.getStringData(1, 5,"UserManagement" );
	
	
	
	LoginPage loginpage=new LoginPage(driver);	
	usermanagementpage=loginpage.enterUsernameOnUsernameField(username)
			.enterPasswordOnPasswordField(confirmaccountpassword)
			.clickOnLoginButton().clickOnUserManagementPage().clickOnUsersMenu().clickOnAddButton()
			.enterSurnameOnSurnameField(surname).enterFirstnameOnFirstnameField(firstname)
			.enterEmailOnEmailField(email).enterPasswordOnPasswordField(confirmaccountpassword)
			.enterPasswordOnConfirmPasswordField(confirmaccountpassword).clickOnSaveButton();
	boolean expectedAddAlert = true;
	boolean actualAddAlert = usermanagementpage.addAlertDisplayed();
	Assert.assertEquals(expectedAddAlert, actualAddAlert,"Couldn't add new user");
	
	

	}
}
