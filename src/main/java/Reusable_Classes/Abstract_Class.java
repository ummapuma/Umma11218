package Reusable_Classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_Class extends Reusable_Library_Loggers {
    public static WebDriver driver = null;
    public static ExtentReports report = null;
    public static ExtentTest logger = null;

    @BeforeSuite()
        public void openBrowser() throws IOException {
            driver = navigate(driver, "https://www.google.com");
            //path to your report
        report = new ExtentReports( "src\\main\\java\\Report_Folder\\AutomationReport" + getDateTime () + ".html", true);


        }// end of @BeforeSuite

    @Parameters("Browser")
    @BeforeMethod
    public static void captureTestName(String Browser, Method methodName) throws IOException {

       //Define driver parameter
        if(Browser.equalsIgnoreCase( "FireFox")){
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (Browser.equalsIgnoreCase("Chrome")){
            driver = navigate(driver, "http://www.google.com");
        } //end of if else


        //logger below will the actual name of each of your @test methods
        logger = report.startTest(methodName.getName() + "--" + Browser); //captures the test case name
        logger.log(LogStatus.INFO, "Automation Test Scenario Started");

    }//End of @BeforeMethod

    @AfterMethod
    public static void endTest(){
        report.endTest(logger);
        logger.log(LogStatus.INFO, "Automation Test Scenario ended....");
    }


        @AfterSuite
                public void closeBrowser() {
        report.flush();
        report.close();
        //driver.quit();


        }// end of @AfterSuite








}// end of class

