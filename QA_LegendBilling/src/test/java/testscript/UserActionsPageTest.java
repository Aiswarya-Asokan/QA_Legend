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
import utilities.RandomDataUtility;

public class UserActionsPageTest extends Base_Class {
	
	@Test
	public void verify_ViewUser_Page() throws IOException
	{
		 String username=ExcelUtility.getStringData(0, 0, "UserActionsPageTest");
		 String password=ExcelUtility.getIntegerData(0, 1,"UserActionsPageTest");
		 String search_uname=ExcelUtility.getStringData(1, 0, "UserActionsPageTest");
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
