package genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.Logout;
import objectrepository.WelcomePage;

/**
 * @author Kishan Kumar Gupta
 */

public class BaseClass {
	/**
	 * This is used to make global variable so that we can use it anywhere
	 * throughout the project
	 */
	public static ExtentReports extentReports;
	public static ExtentTest test;
	public ExtentTest stest;
	public WebDriver driver;
	public static WebDriver sdriver;

	/**
	 * Creating java object and using the required implementaion
	 */
	public JavaUtility jutils = new JavaUtility();
	public WebDriverUtility webdriver = new WebDriverUtility();
	public FileUtility futil = new FileUtility();
	public ExcelUtility eutil = new ExcelUtility();
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;
	public Logout lo;
	/**
	 * This is used for database connection and report configuration
	 */
	@BeforeSuite
	public void reportCofig() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				"./HTML_reports/ExtentReport_" + jutils.getJavaSystemTime() + ".html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
	}

	/**
	 * This method is used for launching the browser and navigate to the url
	 * 
	 * @param browserName
	 * @throws IOException
	 */
	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			Reporter.log("Wrong browser entered");
		}
		
		sdriver = driver;
		

		driver.get(futil.getDataFromProperty("url"));
	}

	/**
	 * This is used to login to the application
	 * @throws IOException 
	 */
	@BeforeMethod
	public void login() throws IOException {
		wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		lp = new LoginPage(driver);
		lp.getEmailTF().sendKeys(futil.getDataFromProperty("email"));
		lp.getPasswordTF().sendKeys(futil.getDataFromProperty("password"));
		lp.getLoginBTN().click();
	}

	/**
	 * This is used to logout from the application
	 */
	@AfterMethod
	public void logout() {
		lo = new Logout(driver);
		lo.getLogoutLink().click();
	}

	/**
	 * This method is used to close the browser
	 */
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	/**
	 * This method is used to close the database connection and backup for report
	 */
	@AfterSuite
	public void reportBackup() {
		extentReports.flush();
	}
}
