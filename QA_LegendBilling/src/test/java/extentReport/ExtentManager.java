package extentReport;

import java.io.File;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.aventstack.extentreports.ExtentReports;
import java.io.File;

public class ExtentManager {

    // Static variable to hold the instance of ExtentReports
    private static ExtentReports extent;
    
    // Variable to store the platform (e.g., WINDOWS, MAC, LINUX)
    private static Platform platform;

    // Constant variables for file names and paths
    private static final String REPORT_FILE_NAME = "Extent.html";
    private static final String MAC_PATH = System.getProperty("user.dir") + "/TestReport";
    private static final String WINDOWS_PATH = System.getProperty("user.dir") + "\\TestReport";
    private static final String MAC_REPORT_FILE_LOC = MAC_PATH + "/" + REPORT_FILE_NAME;
    private static final String WIN_REPORT_FILE_LOC = WINDOWS_PATH + "\\" + REPORT_FILE_NAME;

    /**
     * Returns the instance of ExtentReports, creating it if it doesn't exist.
     * 
     * @return ExtentReports instance
     */
    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    /**
     * Creates a new instance of ExtentReports.
     * This method detects the current platform and sets the correct file path.
     */
    public static ExtentReports createInstance() {
        // Determine the current platform (e.g., Windows, Mac)
        platform = getCurrentPlatform();

        // Get the file location based on the platform
        String fileName = getReportFileLocation(platform);

        // Create an ExtentHtmlReporter and configure it
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        configureReporter(htmlReporter);

        // Create the ExtentReports instance and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    /**
     * Configures the ExtentHtmlReporter with desired settings.
     * This includes setting the report's theme, chart location, and other configurations.
     * 
     * @param htmlReporter the ExtentHtmlReporter instance
     */
    private static void configureReporter(ExtentHtmlReporter htmlReporter) {
        // Set the location of the test view chart to the bottom of the report
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        
        // Make the chart visible when the report is opened
        htmlReporter.config().setChartVisibilityOnOpen(true);

        // Set the theme of the report to dark
        htmlReporter.config().setTheme(Theme.DARK);

        // Set the document title of the report
        htmlReporter.config().setDocumentTitle(REPORT_FILE_NAME);

        // Set the encoding of the report to UTF-8
        htmlReporter.config().setEncoding("utf-8");

        // Set the name of the report
        htmlReporter.config().setReportName(REPORT_FILE_NAME);
    }

    /**
     * Returns the correct file location for the report based on the platform.
     * It also ensures that the necessary directories exist.
     * 
     * @param platform the current platform (e.g., WINDOWS, MAC)
     * @return the file location of the report
     */
    private static String getReportFileLocation(Platform platform) {
        String reportFileLocation = "";
        
        // Switch case to set file location based on the platform
        switch (platform) {
            case MAC:
                reportFileLocation = MAC_REPORT_FILE_LOC;
                createReportPath(MAC_PATH);
                break;
            case WINDOWS:
                reportFileLocation = WIN_REPORT_FILE_LOC;
                createReportPath(WINDOWS_PATH);
                break;
            default:
                throw new RuntimeException("Unknown platform: " + platform);
        }
        
        return reportFileLocation;
    }

    /**
     * Ensures that the directory for storing the report exists. If not, it creates the directory.
     * 
     * @param path the directory path to be created
     */
    private static void createReportPath(String path) {
        // Create a File object for the specified path
        File testDirectory = new File(path);

        // Check if the directory does not exist
        if (!testDirectory.exists()) {
            // Attempt to create the directory
            if (testDirectory.mkdirs()) {
                System.out.println("Directory created: " + path);
            } else {
                System.err.println("Failed to create directory: " + path);
            }
        } else {
            // Directory already exists, no action needed
            System.out.println("Directory already exists: " + path);
        }
    }

    /**
     * Determines the current platform (Windows, Mac, Linux).
     * Uses the OS name from System properties to determine the platform.
     * 
     * @return the platform enum value (WINDOWS, MAC, LINUX)
     */
    private static Platform getCurrentPlatform() {
        // If platform is already set, return it
        if (platform == null) {
            // Get the OS name from system properties
            String osName = System.getProperty("os.name").toLowerCase();

            // Determine the platform based on the OS name
            if (osName.contains("win")) {
                platform = Platform.WINDOWS;
            } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
                platform = Platform.LINUX;
            } else if (osName.contains("mac")) {
                platform = Platform.MAC;
            } else {
                // If the OS is unknown, throw an exception
                throw new RuntimeException("Unknown operating system: " + osName);
            }
        }
        
        return platform;
    }

    // Platform enum used to represent the current platform (e.g., WINDOWS, MAC, LINUX)
    public enum Platform {
        WINDOWS,
        MAC,
        LINUX
    }
}