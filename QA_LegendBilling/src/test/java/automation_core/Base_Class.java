package automation_core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.Constants;

public class Base_Class {
    protected WebDriver driver;
    private Properties prop;

    /**
     * Initializes the browser based on the specified browser name.
     * 
     * @param browser the name of the browser to initialize
     */
    public void initializeBrowser(String browser) {
        loadProperties();
        
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        initializeBrowser("Chrome"); // This can be made dynamic if needed
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result);
        }
        if (driver != null) {
            driver.quit(); // Use quit instead of close for proper cleanup
        }
    }

    /**
     * Loads properties from the configuration file.
     */
    private void loadProperties() {
        prop = new Properties();
        try (FileInputStream file = new FileInputStream(Constants.CONFIG_FILE)) {
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace(); // Log exception (consider using a logger)
        }
    }

    /**
     * Takes a screenshot and saves it to the specified location.
     * 
     * @param result the test result for which the screenshot is taken
     * @throws IOException if an error occurs during file operations
     */
    public void takeScreenshot(ITestResult result) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./Screenshot/" + result.getName() + ".png"));
    }
}
