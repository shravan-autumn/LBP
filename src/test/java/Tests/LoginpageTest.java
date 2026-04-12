package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import genericUtility.BaseClass;
import pomScripts.homePage;
import pomScripts.loginPage;

public class LoginpageTest extends BaseClass {
	loginPage lp;
	homePage hp;

	// Case 1: To verify if user is able to navigate to login page by clicking on
	// account link in home page
	@Test(priority = 1)
	public void loginPageNavigation() {
		lp = new loginPage(driver);
		hp = new homePage(driver);
		lp.goToWebsite();
		hp.getAccountLink().click();
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
		lp.createAccount(firstName, lastName, email, phone, password);
		hp = new homePage(driver);
		hp.getAccountLink().click();
		boolean accountPageHeading = lp.getAccountTitle().isDisplayed();
		Assert.assertTrue(accountPageHeading);
		lp.getLogoutLink().click();
	}
	// case 3: To verify if user is able to login with valid credentials
	@Test(priority = 3, dependsOnMethods = "createAccount")
	public void login() {
		lp.goToWebsite();
		hp.getAccountLink().click();
		lp.login(email, password);
		boolean accountPageHeading = lp.getAccountTitle().isDisplayed();
		Assert.assertTrue(accountPageHeading);
		lp.getLogoutLink().click();
	}
}