package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.reactivex.rxjava3.functions.Action;

public class webdriverUtility extends javaUtility {
	public static WebDriver driver;

	/**
	 * This method will maximize the browser
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will maximize the browser
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait until the webelements loads
	 * 
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * this method will wait until element is clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public static void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		// we can use locator or webelement
	}

	/**
	 * this method will wait until element is clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void visibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		// we can use locator or webelement
	}

	/**
	 * This method will select based on index
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method will select based on value
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method will select based on visibleText
	 * 
	 * @param element
	 * @param index
	 */
	// change arguments
	public void handleDropdown(String visibleText, WebElement element) {
		Select s = new Select(element);
		s.selectByValue(visibleText);
	}

	/**
	 * This method will double click anywhere on the webpage
	 * 
	 * @param driver
	 */
	public void toDoubleClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method will double click on particular webelement
	 * 
	 * @param driver
	 */
	public void toDoubleClickOnWebelement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}

	/**
	 * This method will right click anywhere on the webpage
	 * 
	 * @param driver
	 */
	public void toRightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method will right click on particular webelement
	 * 
	 * @param driver
	 */
	public void toRightClickOnWebelement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}

	/**
	 * This method will move the cursor to particular webelement
	 * 
	 * @param driver
	 * @param ele
	 */
	public void toMouseHover(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	/**
	 * This method will perform drag and drop operation
	 * 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void toDragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	// to handle frames
	/**
	 * This method will switch to frame based on index value
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch to frame based on id & name attribute value
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);
	}

	/**
	 * This method will switch to frame based on webelement
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	/**
	 * This method will switch back to immediate parent frame
	 * 
	 * @param driver
	 * @param index
	 */
	public void toSwitchBackFromFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method will switch back to main page
	 * 
	 * @param driver
	 * @param index
	 */
	public void toSwitchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This is method will switch the driver control to the alert popup
	 * 
	 * @param driver
	 */
	public void toSwitchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}

	/**
	 * This method will switch the driver control to the alert and click on accept
	 * 
	 * @param driver
	 */
	public void toSwitchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will switch the driver control to alert and click on dismiss
	 * 
	 * @param driver
	 */
	public void toSwitchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will switch the driver control to the alert and capture the text
	 * 
	 * @param driver
	 * @return
	 */
	public String toSwitchToAlertAndGetText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	/**
	 * This method will switch the driver control to the alert and it will the the
	 * text> sendkeys
	 * 
	 * @param driver
	 * @param data
	 */
	public void toSwitchToAlertAndSendKeys(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys("data");
	}

	/**
	 * This method will switch the driver control to child window
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void toSwitchWindowTOChild(WebDriver driver, String partialTitle) {
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			String windowTitle = driver.switchTo().window(id).getTitle();
			// driver will switch to the title
			if (windowTitle.contains(partialTitle)) {
				// partailTitle is the title of child window (wherewe want to switch)
				break;
			}
		}
	}

	/**
	 * This method will capture the screenshot
	 * 
	 * @param driver
	 * @param fileName
	 * @throws Exception
	 */
	public String toTakescreenShot(WebDriver driver, String fileName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//screenshots//" + fileName + ".png");
		Files.copy(source, dest);
		// for extent report we need absolute path
		return dest.getAbsolutePath();
	}

	String subfolder;

	public void takeScreenShot(String filename) {
		if (subfolder == null) {
			LocalDateTime ld = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy-hh-mm-ss");
			subfolder = ld.format(dtf);
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File s = ts.getScreenshotAs(OutputType.FILE);
		File d = new File(".//screenshot//" + subfolder + filename);
		try {
			FileUtils.copyFile(s, d);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// similarly we have to write for java script executor
	/**
	 * This method is used to access the application using java-script
	 * 
	 * @param driver
	 * @param url
	 */
	public void toAccessTheApplication(WebDriver driver, String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location=arguments[0]", url);
	}

	/**
	 * This method will backward the webpage using java-script
	 * 
	 * @param driver
	 */
	public void toBackwordTheWebpage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("histort.back(0)");
	}

	/**
	 * This method will forward the webpage using java-script
	 * 
	 * @param driver
	 */
	public void toForwordTheWebpage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("histort.forward(0)");
	}

	/**
	 * This method will refresh the webpage using java-script
	 * 
	 * @param driver
	 */
	public void toRefreshTheWebpage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("histort.go(0)");
	}

	/**
	 * This method will flash (highlight) the webelement using java-script
	 * 
	 * @param driver
	 */
	public void toFlashTheWebelement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border= '3px solid red'", ele);
	}

	// scroll
	public static void toScrollToElement(WebElement ele, WebDriver driver) {
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
	}

	public void toScrollByAmount(int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}

	// to get current url
	public String toGetCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	// to handel windows
	public Set<String> tohandleMultipleWindows(WebDriver driver) {
		return driver.getWindowHandles();
	}

	public String tohandleWindows(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public webdriverUtility(WebDriver driver) {
		this.driver = driver;
	}

	public static void waitUntilElementIsVisible(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitUntilClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilInvisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void scrollToElement(WebElement ele) {
		Actions act = new Actions(driver);

		act.scrollToElement(ele).build().perform();
	}

	public void randomClick() {
		Actions act = new Actions(driver);

		act.click().build().perform();
	}
	public static void waitForNumberOfWindowsToBe(int number) {
	    new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.numberOfWindowsToBe(number));
	}

	public static void waitForPageToLoad(WebDriver driver2) {
	    new WebDriverWait(driver2, Duration.ofSeconds(10))
	            .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));		
	}

}
