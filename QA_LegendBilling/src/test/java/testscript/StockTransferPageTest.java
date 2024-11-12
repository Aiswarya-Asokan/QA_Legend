package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base_Class;
import constants.Constants;
import constants.Messages;
import pageobjects.HomePage;
import pageobjects.ListAllStockTransferPage;
import pageobjects.LoginPage;
import pageobjects.StockTransferPage;
import utilities.ExcelUtility;

public class StockTransferPageTest extends Base_Class {
	
		@Test
			public void verify_list_StockTransfer() throws IOException 
			{

			String user_name=ExcelUtility.getStringData(0, 0,"LoginTest");
			String pass_word=ExcelUtility.getIntegerData(0, 1, "LoginTest");
			String stocks=ExcelUtility.getStringData(0, 0, "StockTransferPageTest");

			LoginPage login=new LoginPage(driver);
			 login.enter_Username(user_name);
			 login.enter_Password(pass_word);
			 HomePage home=login.click_onLogin_Button();
			 home.clic_ONalertButton();
			 StockTransferPage stocktransfer=home.click_On_Stock_Transfer();
			 ListAllStockTransferPage liststocktransfer=stocktransfer.click_On_List_Stock_Transfer();
			 liststocktransfer.Enter_Searh_Item(stocks);
			 String actualdata=liststocktransfer.get_Table_Data();
			 Assert.assertEquals(actualdata, stocks,Messages.INVALIDSTOCKSEARCH);
			}
}
