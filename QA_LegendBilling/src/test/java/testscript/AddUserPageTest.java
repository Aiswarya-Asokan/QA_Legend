package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base_Class;
import constants.Constants;
import constants.Messages;
import pageobjects.AddUserPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.UserManagementPage;
import pageobjects.LoginPage;
import pageobjects.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends Base_Class {
	 @Test
	 public void verify_add_user() throws IOException
	 {
		     String username=ExcelUtility.getStringData(0, 0, Constants.ADDUSERSPAGE);
			 String password=ExcelUtility.getIntegerData(0, 1, Constants.ADDUSERSPAGE);
			 
			 String fst_name=RandomDataUtility.get_Firstname();
			 String lst_name=RandomDataUtility.get_Lastname();
			 String email_fld=fst_name+Constants.ADDUSERSPAGEDOTEXTENSION+lst_name+Constants.ADDUSERSPAGEEMAILEXTENSION;
			 String user_name=fst_name+lst_name;
			 String passwd=fst_name+lst_name;
			 
			 LoginPage login=new LoginPage(driver); 
			 login.enter_Username(username);
			 login.enter_Password(password);
			 HomePage home=login.click_onLogin_Button();
			 home.clic_ONalertButton();
			 UserManagementPage usermanagement=home.clickON_UserManagement_Field();
			 UsersPage users=usermanagement.clickOn_users_field();
			 AddUserPage adduser=users.button_Add();
			 adduser.add_userDatas(fst_name, lst_name, email_fld, user_name, passwd, passwd);
			 adduser.ClickOn_SaveButton();
			 users.search_User(user_name);
			 String actual_result=users.display_Table();
			 Assert.assertEquals(actual_result, user_name, Messages.USERADD);
	 }
	 
	 @Test
	 public void verify_userLogin_withNewly_Added_user() throws IOException
	 {
		 String username=ExcelUtility.getStringData(0, 0, Constants.ADDUSERSPAGE);
		 String password=ExcelUtility.getIntegerData(0, 1, Constants.ADDUSERSPAGE);
		 
		 String fst_name=RandomDataUtility.get_Firstname();
		 String lst_name=RandomDataUtility.get_Firstname();
		 String email_fld=fst_name+Constants.ADDUSERSPAGEDOTEXTENSION+lst_name+Constants.ADDUSERSPAGEEMAILEXTENSION;
		 String user_name=fst_name+lst_name;
		 String passwd=fst_name+lst_name;
		 
		 LoginPage login=new LoginPage(driver); 
		 login.enter_Username(username);
		 login.enter_Password(password);
		 HomePage home=login.click_onLogin_Button();
		 home.clic_ONalertButton();
		 UserManagementPage usermanagement=home.clickON_UserManagement_Field();
		 UsersPage users=usermanagement.clickOn_users_field();
		 AddUserPage adduser=users.button_Add();
		 adduser.add_userDatas(fst_name, lst_name, email_fld, user_name, passwd, passwd);
		 users.backTo_HomePage();
		 home.clicOn_adminName();
		 home.clickOn_SignOut_Button();
		 login.enter_Username(user_name);
		 login.enter_Password(passwd);
		 login.click_onLogin_Button();
		 String actual_result=home.user_LoginResult();
		 String expected_result=Constants.MESSAGE+fst_name+Constants.ADDUSERPAGEEXTENSION;
		 Assert.assertEquals(actual_result, expected_result, Messages.INVALIDUSERADD);
		 

	 }
}
