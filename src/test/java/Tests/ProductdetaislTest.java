package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.StepLogger;
import genericUtility.webdriverUtility;
import pomScripts.cartDrawer;
import pomScripts.homePage;
import pomScripts.loginPage;
import pomScripts.productDetailsPage;
import pomScripts.productListingPage;

public class ProductdetaislTest extends BaseClass {

	loginPage lp;
	homePage hp;
	productDetailsPage pdp;
	productListingPage plp;

	// Case 1: Verify if user is able to navigate to PDP by clicking on product in
	// search PLP page
	@Test(priority = 1)
	public void hpToPdpNavigation() throws Exception {
		StepLogger.given("User is on homepage");
		StepLogger.when("User search for a product");
		StepLogger.and("Select a product from search PLP");
		StepLogger.then("User will be redirected to relevant PDP");
		pdp = new productDetailsPage(driver);
		String product = pdp.pdpNavigation();
		String productActual = pdp.getProductTitle().getText();
		Assert.assertEquals(productActual.toLowerCase(), product.toLowerCase());

	}

	// Case 2: Verify if user is able to navigate to relevant page by clicking on
	// links in PDP page
	@Test(priority = 2)
	public void pdpToPlpNavigation() throws InterruptedException {
		StepLogger.given("User is on PDP");
		StepLogger.when("User clicks on view products links");
		StepLogger.then("User will be redirected to relevant PLP");
		StepLogger.and("User navigates back to PDP");
		pdp = new productDetailsPage(driver);
		pdp.clickViewAllProducts();
		String expectedUrl = "https://lovebeautyandplanet.in/collections/all-products";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		pdp.navigateBack();
		pdp.clickViewBundleProduct();
		String expectedUrl1 = "https://lovebeautyandplanet.in/collections/bundle-offers";
		String actualUrl1 = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl1, expectedUrl1);
		pdp.navigateBack();

	}

	// Case 3: Verify if user is able to check delivery availability by entering
	// invalid pincode in PDP page
	@Test(priority = 3)
	public void invalidPincodeCheck() throws InterruptedException {
		StepLogger.given("User is on PDP");
		StepLogger.when("User scrolls down");
		StepLogger.and("Enter invalid pincode in pincode text field and click Check");
		StepLogger.then("Error message should be displayed " );
		pdp = new productDetailsPage(driver);
		pdp.invalidPincode();
		String expectedErrorMessage = "Destination pincode is not serviceable";
		String actualErrorMessage = pdp.getInvalidPincodeErrorMessage().getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	// Case 4: Verify if user is able to check delivery availability by entering
	// valid pincode in PDP page
	@Test(priority = 4)
	public void validPincodeCheck() throws InterruptedException {
		StepLogger.given("User is on PDP");
		StepLogger.when("User scrolls down");
		StepLogger.and("Enter valid pincode in pincode text field and click Check");
		StepLogger.then("Success message should be displayed");
		pdp = new productDetailsPage(driver);
		pdp.validPincode();
		boolean actualMessage = pdp.getValidPincodeErrorMessage().isDisplayed();
		Assert.assertTrue(actualMessage);
	}

	// Case 5: Verify if user is able to add product to cart from PDP page
	@Test(priority = 5)
	public void addToCartFromPDP() throws InterruptedException {
		StepLogger.given("User is on PDP");
		StepLogger.when("User scrolls down");
		StepLogger.and("Click add to cart");
		StepLogger.then("Relevant product should be added to cart");
		pdp = new productDetailsPage(driver);
		String product = pdp.addToCartFromPDP();
		cartDrawer c = new cartDrawer(driver);
		webdriverUtility.waitUntilElementIsVisible(c.getCheckoutButtonCartDrawer());
		String cartPro = c.getProductTitleCartDrawer().getText();
		Assert.assertEquals(cartPro.toLowerCase(), product.toLowerCase(),
				"Product in cart drawer is not same as the one added to cart");
		c.closeCartDrawer();
	}

	// Case 6: Verify if user is able to increase quantity from PDP page
	@Test(priority = 6)
	public void quantityIncrease() throws Exception {
		StepLogger.given("User is on PDP");
		StepLogger.when("User scroll down");
		StepLogger.and("Increase the quantity from quantity slector");
		StepLogger.then("Product quantity should be updated");
		pdp = new productDetailsPage(driver);
		pdp.increaseQuantityFromPDP();
		cartDrawer c = new cartDrawer(driver);
		c.increaseQuantityFromCartDrawer();
		String cartQuantity = c.getQuantityTextFieldCartDrawer().getAttribute("value");
		c.closeCartDrawer();
		String quantity = pdp.getQuantityTextField().getAttribute("data-cart-quantity");
		Assert.assertEquals(quantity, cartQuantity, "Quantity in cart drawer is not same as the one selected in PDP");
	}

	// Case 7: Verify if user is able to decrease quantity from PDP page
	@Test(priority = 7, dependsOnMethods = { "quantityIncrease" })
	public void quantityDecrease() throws Exception {
		StepLogger.given("User is on PDP");
		StepLogger.when("User scroll down");
		StepLogger.and("Decrease the quantity from quantity slector");
		StepLogger.then("Product quantity should be updated");
		Thread.sleep(2000);
		pdp = new productDetailsPage(driver);
		cartDrawer c = new cartDrawer(driver);
		pdp.decreaseQuantityFromPDP();
		c.decreaseQuantityFromCartDrawer();
		String cartQuantity = c.getQuantityTextFieldCartDrawer().getAttribute("value");
		c.closeCartDrawer();
		String quantity = pdp.getQuantityTextField().getAttribute("data-cart-quantity");
		Assert.assertEquals(quantity, cartQuantity, "Quantity in cart drawer is not same as the one selected in PDP");
	}

	// case 8: Verify if Reviews section is displayed in PDP page
	@Test(priority = 8)
	public void reviewsSection() throws InterruptedException {
		StepLogger.given("User is on PDP");
		StepLogger.when("User scroll down to Reviews section");
		StepLogger.then("User should be able to view Reviews section");
		Thread.sleep(2000);
		pdp = new productDetailsPage(driver);
		webdriverUtility.toScrollToElement(pdp.getReviewSection(), driver);
		boolean actual = pdp.getReviewSection().isDisplayed();
		Assert.assertTrue(actual, "Reviews section is not displayed in PDP page");
	}

	// case 9: Verify if details section is displayed in PDP page
	@Test(priority = 9)
	public void detailsSection() throws InterruptedException {
		StepLogger.given("User is on PDP");
		StepLogger.when("User scroll down to Details section");
		StepLogger.then("User should be able to view Details section and other tabs");
		Thread.sleep(2000);
		pdp = new productDetailsPage(driver);
		pdp.scrollToElement(pdp.getDetailsTab());
		boolean actual = pdp.getDetailsTab().isDisplayed();
		Assert.assertTrue(actual, "Details section is not displayed in PDP page");
	}

	// case 10: Verify if YOU MAY ALSO LIKE section is displayed in PDP page
	@Test(priority = 10)
	public void youMayAlsoLikeSectionPDP() throws InterruptedException {
		StepLogger.given("User is on PDP");
		StepLogger.when("User scroll down to You may also like section");
		StepLogger.then("User should be able to view You may also section");
		Thread.sleep(2000);
		pdp = new productDetailsPage(driver);
		pdp.scrollToElement(pdp.getYouMayAlsoLikeSection());
		boolean actual = pdp.getYouMayAlsoLikeSection().isDisplayed();
		Assert.assertTrue(actual, "YOU MAY ALSO LIKE section is not displayed in PDP page");
	}
}