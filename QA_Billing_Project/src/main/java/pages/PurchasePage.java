package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utility.FileUploadUtility;
import utility.PageUtility;

public class PurchasePage {
PageUtility pageutility=new PageUtility();
	public WebDriver driver;
public PurchasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//to initialize the elements
	}
@FindBy(xpath="//a[@id='tour_step6_menu']") private WebElement pruchaseMenu;
@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/purchases/create']") private WebElement addPurchaseMenu;
@FindBy(xpath="//button[@class='btn btn-default bg-white btn-flat add_new_supplier']") private WebElement addSupplierbutton;
@FindBy(id="name") private WebElement suppliername;
@FindBy(id="supplier_business_name") private WebElement businessName;
@FindBy(id="mobile") private WebElement mobileNumber;
@FindBy(xpath="//button[@class='btn btn-primary']") private WebElement supplierSaveButton;
@FindBy(id="select2-location_id-container") private WebElement location;
@FindBy(xpath="//li[@id='select2-location_id-result-m9jp-1']") private WebElement locationclick;
@FindBy(id="upload_document") private WebElement fileupload;
@FindBy(xpath="//button[@data-href='https://qalegend.com/billing/public/products/quick_add']") 
private WebElement  addproduct;
@FindBy(xpath="//input[@placeholder='Product Name']") private WebElement productName;
@FindBy(id="alert_quantity") private WebElement alertQuantity;
@FindBy(id="single_dpp") private WebElement extax;
@FindBy(id="single_dpp_inc_tax") private WebElement intax;

@FindBy(id="amount_0") private WebElement amount;
@FindBy(id="submit_purchase_form") private WebElement submitButton;

public void clickOnPurchaseMenu()
{
	pageutility.javascriptClick(driver, pruchaseMenu);
}
public void clickOnAddPurchaseMenu()
{
	pageutility.javascriptClick(driver, addPurchaseMenu);
}
public void clickOnAddSupplierButton() {
	pageutility.javascriptClick(driver, addSupplierbutton);
}
public void addSuppliernameOnNameField()
{
	suppliername.sendKeys("Ramesh");
}
public void addSupplierBusinessName()
{
	businessName.sendKeys("R Products");
}
public void addSupplierMobileNumber()
{
	mobileNumber.sendKeys("95422218555");
}
public void clickOnSupplierSaveButton() {
	pageutility.javascriptClick(driver, supplierSaveButton);
}
public void addLocation() {
    pageutility.javascriptClick(driver, location);
	pageutility.javascriptClick(driver, locationclick);
}
public void fileUpload() throws AWTException {
	FileUploadUtility file=new FileUploadUtility();
	file.fileUploadUsingRobotKey(fileupload,Constants.FILEUPLOAD);
}
public void addproduct() {
	pageutility.javascriptClick(driver, addproduct);
}

public void addAmountInAmountField() {
	amount.sendKeys("35000");
}
public void clickOnSubmitButton() {
	pageutility.javascriptClick(driver, submitButton);
}
public void addProductOnProductNameField() {
	productName.sendKeys("ABC Product");
}
public void addquantity()
{
	alertQuantity.sendKeys("25");
}
public void exTax() {
	extax.sendKeys("32000");
}
public void inTax() {
	intax.sendKeys("3750");
}
}