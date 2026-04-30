package genericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomScripts.cartDrawer;
import pomScripts.homePage;
import pomScripts.loginPage;
import pomScripts.productDetailsPage;
import pomScripts.productListingPage;

public class BaseClass {
	public WebDriver driver;
	public loginPage lp;
	public homePage hp;
	public productListingPage plp;
	public productDetailsPage pdp;
	public cartDrawer cd;

	public WebDriver initializeDriver() throws IOException {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\genericUtility\\data.properties");
		p.load(fis);
		// 1 browser value form system i.e CMD another from property file
		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: p.getProperty("browser");

		// p.getProperty("browser");
		if (browser.contains("chrome")) { // contains for headless
			ChromeOptions option = new ChromeOptions();
			if (browser.contains("headless")) {
				option.addArguments("--headless=new");
				option.addArguments("--no-sandbox");
				option.addArguments("--disable-dev-shm-usage");
				option.addArguments("--window-size=1920,1080");
				option.addArguments("--disable-gpu");
				option.addArguments("--disable-dev-shm-usage");
				option.addArguments("--force-device-scale-factor=1");
			}
			option.addArguments("--disable-blink-features=AutomationControlled");
			option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			option.setExperimentalOption("useAutomationExtension", false);
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		// driver.manage().window().setSize(new Dimension(1920, 1080));// (1440, 990)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		return driver;
	}

	public String getScreenshot(String name, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir") + "//reports//" + name + ".png");
		FileUtils.copyFile(src, des);
		return System.getProperty("user.dir") + "//reports//" + name + ".png";
	}

	@BeforeClass(alwaysRun = true)
	public loginPage launchApplication() throws Exception {

		driver = initializeDriver();
		lp = new loginPage(driver);
		lp.goToWebsite();
		lp.acceptCookiesIfPresent();
		return lp;
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		driver.quit();
	}
}



