package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.KitchenPage;
import utility.ExcelUtility;

public class KitchenTest extends Base {
	@Test(description="verification of all the orders")
	public void verifyViewAllOrders() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Kitchen");
		String password = ExcelUtility.getIntegerData(1, 1, "Kitchen");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		KitchenPage kitchenpage = new KitchenPage(driver);
		kitchenpage.clickOnKitchenMenu();
		Boolean actualresult = kitchenpage.isCookedButtonDisplayed();
		Boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, "Cooked button is not displayed");
	}

	@Test(description=" verification of each order detail")

	public void verifyViewEachOrderDetail() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Kitchen");
		String password = ExcelUtility.getIntegerData(1, 1, "Kitchen");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		KitchenPage kitchenpage = new KitchenPage(driver);
		kitchenpage.clickOnKitchenMenu();
		Boolean actualresult = kitchenpage.isDetailButtonDisplayed();
		Boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, "Deails button is not displayed");
	}
}
