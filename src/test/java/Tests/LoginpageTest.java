package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import genericUtility.BaseClass;
import genericUtility.StepLogger;
import pomScripts.homePage;
import pomScripts.loginPage;

public class LoginpageTest extends BaseClass {
	loginPage lp;
	homePage hp;

	// Case 1: To verify if user is able to navigate to login page by clicking on
	// account link in home page
	@Test(priority = 1)
	public void loginPageNavigation() {

		StepLogger.given("User is on homepage");
		lp = new loginPage(driver);
		hp = new homePage(driver);
		lp.goToWebsite();
		StepLogger.when("User clicks on account link");
		hp.getAccountLink().click();
		StepLogger.then("User should be navigated to login page");
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("login"));

	}

	Faker f = new Faker();
	String firstName = f.name().firstName();
	String lastName = f.name().lastName();
	String email = f.internet().emailAddress();
	String phone = f.number().numberBetween(6000000000L, 9999999999L) + "";
	String password = f.internet().password(8, 16);

	// case 2: To verify if user is able to create account by providing valid
	// credentials
	@Test(priority = 2)
	public void createAccount() throws InterruptedException {

		StepLogger.given("User is on login page");
		StepLogger.when("User clicks on account page link");
		StepLogger.then("Account page should be displayed");
		StepLogger.when("User enters the valid credentials and click on signup button");
		StepLogger.then("Account is created and user is redirected to home page");
		lp.createAccount(firstName, lastName, email, phone, password);
		hp = new homePage(driver);
		StepLogger.when("User clicks on account icon in header");
		hp.getAccountLink().click();
		StepLogger.then("User is redirected to account page");
		boolean accountPageHeading = lp.getAccountTitle().isDisplayed();
		Assert.assertTrue(accountPageHeading);
		
		
		
	}

	// case 3: To verify if user is able to login with valid credentials
	@Test(priority = 3, dependsOnMethods = "createAccount")
	public void login() {
		StepLogger.when("User logout from account page");
		lp.getLogoutLink().click();
		StepLogger.then("User is on homepage");
		lp.goToWebsite();
		StepLogger.when("User clicks on account icon in header");
		hp.getAccountLink().click();
		StepLogger.then("User is redirected to login page");
		StepLogger.when("User logs in with valid credentials");
		lp.login(email, password);
		StepLogger.then("User should be redirected to account page");
		boolean accountPageHeading = lp.getAccountTitle().isDisplayed();
		Assert.assertTrue(accountPageHeading);
		StepLogger.and("User logs out");
		lp.getLogoutLink().click();
	}
}