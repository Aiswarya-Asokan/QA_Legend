package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;



import org.openqa.selenium.WebElement;


public class FileUploadUtility {
	public void fileUploadUsingSendkeys(WebElement element,String filepath)
	{
		
		element.sendKeys(filepath);
	}
	public void fileUploadUsingRobotKey(WebElement element,String filepath) throws AWTException
	{
		
		element.click();
		StringSelection s = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null); 
		Robot robot = new Robot();
		robot.delay(2500);
		 robot.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      robot.keyRelease(KeyEvent.VK_ENTER);
	      robot.keyPress(KeyEvent.VK_CONTROL);
	      robot.keyPress(KeyEvent.VK_V);//two
	      
	      robot.keyRelease(KeyEvent.VK_V);
	      robot.keyRelease(KeyEvent.VK_CONTROL);//release command
	     
	      robot.keyPress(KeyEvent.VK_ENTER);
	      
	      robot.delay(90);
	      robot.keyRelease(KeyEvent.VK_ENTER);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
