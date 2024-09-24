package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import automation_core.Base_Class;
import constants.Constants;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.UserManagementPage;
import pageobjects.UsersPage;
import utilities.ExcelUtility;

public class UserActionsPageTest extends Base_Class {
	@Test
	public void verify_UserEdit_Action() throws IOException
	{
	 String username=ExcelUtility.getStringData(0, 0, Constants.ACTIONPAGE);
	 String password=ExcelUtility.getIntegerData(0, 1, Constants.ACTIONPAGE);
	 String search_uname=ExcelUtility.getStringData(1, 0, Constants.ACTIONPAGE);
	 String edit_lname=ExcelUtility.getStringData(2, 0, Constants.ACTIONPAGE);
	 
     LoginPage login=new LoginPage(driver); 
	 login.enter_Username(username);
	 login.enter_Password(password);
	 HomePage home=login.click_onLogin_Button();
	 home.clic_ONalertButton();
	 UserManagementPage usermanagement=home.clickON_UserManagement_Field();
	 UsersPage users=usermanagement.clickOn_users_field();
	 users.search_User(search_uname);

	 
	}
	
	@Test
	public void verify_ViewUser_Page() throws IOException
	{
		 String username=ExcelUtility.getStringData(0, 0, Constants.ACTIONPAGE);
		 String password=ExcelUtility.getIntegerData(0, 1, Constants.ACTIONPAGE);
		 String search_uname=ExcelUtility.getStringData(1, 0, Constants.ACTIONPAGE);
		 LoginPage login=new LoginPage(driver); 
		 login.enter_Username(username);
		 login.enter_Password(password);
		 HomePage home=login.click_onLogin_Button();
		 home.clic_ONalertButton();
		 UserManagementPage usermanagement=home.clickON_UserManagement_Field();
		 UsersPage users=usermanagement.clickOn_users_field();
		 users.search_User(search_uname);
	
	}
}
