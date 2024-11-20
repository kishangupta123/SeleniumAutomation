package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Kishan Kumar Gupta
 */

public class WebDriverUtility {

	public WebDriver driver;
	public Actions actions;
	
	/**
	 * This method is used to maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow() {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to get implicit wait
	 */
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method is used to capture size of the window
	 * 
	 * @param driver
	 * @return Dimension
	 */
	public Dimension getSize() {
		return driver.manage().window().getSize();
	}

	/**
	 * This method is used to switch driver control to window based on url
	 * 
	 * @param driver
	 * @param url
	 */
	public void switchToWindow( String url) {
		// Step 1 capture window id
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Step 2 navigate through all the window
		for (String id : allWindowHandles) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(url)) {
				break;
			}
		}
	}

	/**
	 * This method is used to perform right click operation on a webpage
	 * 
	 * @param driver
	 */
	public void rightClick() {
		actions = new Actions(driver);
		actions.contextClick().perform();
	}

	/**
	 * This method is used to perform right click operation on a webpage
	 * 
	 * @param driver
	 */
	public void doubleClick() {
		actions = new Actions(driver);
		actions.doubleClick().perform();
	}

	/**
	 * This method is used to perform click&Hold on a sepecific WebElement
	 * 
	 * @param driver
	 * @param ele
	 */

	public void clickAndHold( WebElement ele) {
		actions = new Actions(driver);
		actions.clickAndHold(ele).perform();
	}

	/**
	 * This method is used to perform mouseHover action on a certain webElement
	 * 
	 * @param driver
	 * @param ele
	 */
	public void mouseHover( WebElement ele) {
		actions = new Actions(driver);
		actions.moveToElement(ele);
	}

	/**
	 * This method is used to perform mouse hover action on a certian position
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void mouseHoverByOffset( int x, int y) {
		actions = new Actions(driver);
		actions.moveByOffset(x, y).perform();
	}

	/**
	 * This method is used to perform drag and drop operation on a webelement
	 * 
	 * @param driver
	 * @param ele
	 */
	public void dragAndDrop( WebElement ele) {
		actions = new Actions(driver);
		actions.dragAndDrop(ele, ele);
	}

	/**
	 * This method is used to perform drag and drop operation on a webelement and
	 * position
	 * 
	 * @param driver
	 * @param ele
	 * @param x
	 * @param y
	 */
	public void dragAndDrop( WebElement ele, int x, int y) {
		actions = new Actions(driver);
		actions.dragAndDropBy(ele, x, y).perform();
	}

	/**
	 * This method is used to perform frame switch action on a certain index
	 * 
	 * @param driver
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to perform switchToFrame based on nameOrID
	 * 
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}

	/**
	 * This method is used to perform switchTOFrame based on a frameElement
	 * 
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame( WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * This method is used to switch back to parent frame
	 * 
	 * @param driver
	 */
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method is used to switch back to main page
	 * 
	 * @param driver
	 */
	public void switchToMainPage() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to handle DropDown based on index
	 * 
	 * @param ele
	 * @param index
	 */
	public void handleDropDown(WebElement ele, int index) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}

	/**
	 * This method is used to handle DropDown based on value
	 * 
	 * @param ele
	 * @param value
	 */
	public void handleDropDownByValue(WebElement ele, String value) {
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}

	/**
	 * This method is used to handle DropDown based on text
	 * 
	 * @param ele
	 * @param text
	 */
	public void handleDropDownByText(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByValue(text);
	}

	/**
	 * This method is used to handle alert popup
	 * 
	 * @param driver
	 * @return
	 */
	public Alert switchTOAlert() {
		return driver.switchTo().alert();
	}

	/**
	 * This method is used to accept alert popup
	 * 
	 * @param driver
	 */
	public void switchToAlertAccept() {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to dismiss alert popup
	 * 
	 * @param driver
	 */
	public void switchToAlertDismiss() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to send data in the alert popup
	 * 
	 * @param driver
	 * @param data
	 */
	public void switchToAlertSendData( String data) {
		driver.switchTo().alert().sendKeys(data);
	}

	/**
	 * This method is used to getText from the alert present
	 * 
	 * @param driver
	 */
	public void switchToAlertGetText() {
		driver.switchTo().alert().getText();
	}

	/**
	 * This method is used to scroll till a certain amount
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void jsScroll( int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	/**
	 * This method is used to perform click operation using javascript
	 * 
	 * @param driver
	 * @param element
	 */
	public void jsClick( WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method is used to scroll till bottom of the webpage
	 * 
	 * @param driver
	 */
	public void jsScrollTillBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	/**
	 * This method is used to take the screenshot
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public void takeScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("");
		org.openqa.selenium.io.FileHandler.copy(temp, dest);
	}
}
