package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;

public class LoginPage extends BaseClass{
	@Test
public void verify_LoginPage_with_valid_username_and_valid_password()
{
		
	WebElement loginField=driver.findElement(By.id("username"));
	loginField.sendKeys("admin");
	WebElement passwordField=driver.findElement(By.id("password"));
	passwordField.sendKeys("123456");
	WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
	loginButton.click();
}
	@Test
	public void verify_LoginPage_with_invalid_username_and_valid_password()
	{
		String expectedResult="These credentials do not match our records.";
		WebElement loginField=driver.findElement(By.id("username"));
		loginField.sendKeys("admin123");
		WebElement passwordField=driver.findElement(By.id("password"));
		passwordField.sendKeys("123456");
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		String errorMessage=driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']")).getText();
		Assert.assertEquals(errorMessage, expectedResult);
	}
	@Test
	public void verify_LoginPage_with_valid_username_and_invalid_password()
	{
		String expectedResult="These credentials do not match our records.";
		WebElement loginField=driver.findElement(By.id("username"));
		loginField.sendKeys("admin");
		WebElement passwordField=driver.findElement(By.id("password"));
		passwordField.sendKeys("123456789");
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		String errorMessage=driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']")).getText();
		Assert.assertEquals(errorMessage, expectedResult);
	}
	
	@Test
	public void verify_LoginPage_with_invalid_username_and_invalid_password()
	{
		String expectedResult="These credentials do not match our records.";
		WebElement loginField=driver.findElement(By.id("username"));
		loginField.sendKeys("admin123");
		WebElement passwordField=driver.findElement(By.id("password"));
		passwordField.sendKeys("123456789");
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		String errorMessage=driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']")).getText();
		Assert.assertEquals(errorMessage, expectedResult);
	}
}