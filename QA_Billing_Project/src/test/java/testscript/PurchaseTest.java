/*package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.PurchasePage;
import utility.ExcelUtility;

public class PurchaseTest extends Base {
@Test
public void verifyAddNewPurchaseDetail() throws IOException, AWTException
{
	String username = ExcelUtility.getStringData(1, 0, "Purchase");
	String password = ExcelUtility.getIntegerData(1, 1, "Purchase");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsernameOnUsernameField(username);
	loginpage.enterPasswordOnPasswordField(password);
	loginpage.clickOnLoginButton();
	PurchasePage purchase=new PurchasePage(driver);
	purchase.clickOnPurchaseMenu();
	purchase.clickOnAddPurchaseMenu();
	purchase.clickOnAddSupplierButton();
	purchase.addSuppliernameOnNameField();
	purchase.addSupplierMobileNumber();
	purchase.addLocation();
	purchase.fileUpload();
	purchase.addproduct();
	purchase.addProductOnProductNameField();
	purchase.addquantity();
	purchase.exTax();
	purchase.inTax();
	purchase.addAmountInAmountField();
	purchase.clickOnSubmitButton();
	
}
}*/
