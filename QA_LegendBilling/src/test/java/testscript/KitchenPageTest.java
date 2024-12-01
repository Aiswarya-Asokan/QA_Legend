package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import automation_core.Base_Class;
import constants.Constants;
import pageobjects.HomePage;
import pageobjects.KitchenPage;
import pageobjects.LoginPage;
import utilities.ExcelUtility;

public class KitchenPageTest extends Base_Class {
	@Test(groups="Smoke")
	public void verify_kitchen_Order() throws IOException
	{
		

	String user_name=ExcelUtility.getStringData(0, 0,"LoginTest");
	String pass_word=ExcelUtility.getIntegerData(0, 1,"LoginTest" );


	LoginPage login=new LoginPage(driver);
	login.enter_Username(user_name);
	 login.enter_Password(pass_word);
	 HomePage home=login.click_onLogin_Button();
	 home.clic_ONalertButton();
	 KitchenPage kitchen=home.click_on_Kitchen_Field();
	 kitchen.click_On_OrderDetails_Field();
	 
	}
}
