package testscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.UserManagementPage;
import utility.ExcelUtility;

public class UserManagementTest extends Base {
@Test
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
	loginpage.enterUsernameOnUsernameField(username);
	loginpage.enterPasswordOnPasswordField(password);
	loginpage.clickOnLoginButton();
	UserManagementPage usermanagementpage=new UserManagementPage(driver);
	usermanagementpage.clickOnUserManagementPage();
	usermanagementpage.clickOnUsersMenu();
	usermanagementpage.clickOnAddButton();
usermanagementpage.enterSurnameOnSurnameField(surname);
usermanagementpage.enterFirstnameOnFirstnameField(firstname);
usermanagementpage.enterEmailOnEmailField(email);
usermanagementpage.enterPasswordOnPasswordField(confirmaccountpassword);
usermanagementpage.enterPasswordOnConfirmPasswordField(confirmaccountpassword);
usermanagementpage.clickOnSaveButton();

	}
}
