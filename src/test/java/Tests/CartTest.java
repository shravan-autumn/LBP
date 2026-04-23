package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.webdriverUtility;
import pomScripts.cartDrawer;
import pomScripts.homePage;
import pomScripts.loginPage;
import pomScripts.productDetailsPage;
import pomScripts.productListingPage;

public class CartTest extends BaseClass {

	loginPage lp;
	homePage hp;
	productDetailsPage pdp;
	productListingPage plp;

	// case 1: verify if empty cart is redirected to collections page
	@Test(priority = 1)
	public void emptyCart() {
		lp = new loginPage(driver);
		hp = new homePage(driver);
		lp.goToWebsite();
		hp.clickCartIcon();
		cartDrawer c = new cartDrawer(driver);
		c.clickContinueShopping();
		String expected = "https://lovebeautyandplanet.in/collections/all";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(expected, actual, "user fails to redirect to collections page");

	}

	String product1price;
	String product2price;

	// case 2: Verify if user is able to add multiple product to cart from PDP page
	@Test(priority = 2)
	public void addToCartFromPDP() throws InterruptedException {
		lp = new loginPage(driver);
		hp = new homePage(driver);
		hp.clickSearchIcon();
		webdriverUtility.waitUntilElementIsVisible(hp.getSearchTextField());

		hp.getSearchTextField().sendKeys("hair");
		hp.clickSearchButton();
		plp = new productListingPage(driver);
		String product = "Onion, Black Seed Oil & Patchouli Hair Mask";
		for (WebElement ele : plp.getProductLinksSearchPLP()) {
			if (ele.getText().equalsIgnoreCase(product)) {
				ele.click();
				break;
			}
		}
		pdp = new productDetailsPage(driver);
		product1price = pdp.getProductPrice().getText();
		pdp.scrollToElement(pdp.getAddToCartButton());
		pdp.clickAddtoCart();
		cartDrawer c = new cartDrawer(driver);
		webdriverUtility.waitUntilElementIsVisible(c.getCheckoutButtonCartDrawer());
		String cartPro = c.getProductTitleCartDrawer().getText();
		Assert.assertEquals(cartPro.toLowerCase(), product.toLowerCase(),
				"Product in cart drawer is not same as the one added to cart");
		c.clickcloseCartDrawerButton();
		hp.clickLogo();
		hp.clickSearchIcon();
		webdriverUtility.waitUntilElementIsVisible(hp.getSearchTextField());
		hp.getSearchTextField().sendKeys("body");
		hp.clickSearchButton();
		plp = new productListingPage(driver);
		//String product2 = "Coconut Water & Mimosa Flower Conditioner - 200 ml";
		String product2 = "Argan Oil & Lavender Heat Protect & Conditioning Mist";
		for (WebElement ele1 : plp.getProductLinksSearchPLP()) {
			if (ele1.getText().equalsIgnoreCase(product2)) {
				webdriverUtility.toScrollToElement(ele1, driver);
				ele1.click();
				break;
			}
		}
		pdp = new productDetailsPage(driver);
		product2price = pdp.getProductPrice().getText();
		pdp.waitUntilElementIsVisible(pdp.getProductTitle());
		pdp.scrollToElement(pdp.getAddToCart2());
		pdp.clickAddtoCart2();
		c.waitUntilElementIsVisible(c.getCheckoutButtonCartDrawer());
		String cartPro1 = c.getProductTitleCartDrawer().getText();
		Assert.assertEquals(cartPro1.toLowerCase(), product2.toLowerCase(),
				"Product in cart drawer is not same as the one added to cart");
	}

	// Case3: Verify if cart price updates when user adds multiple quantity to cart
	@Test(priority = 3)
	public void priceUpdateVerification() throws InterruptedException {
		cartDrawer c = new cartDrawer(driver);
		String price = c.getTotalPrice().getText();
		String sumof2products = "₹" + String.valueOf(Integer.parseInt(product1price) + Integer.parseInt(product2price));
		Assert.assertEquals(price, sumof2products,
				"Total price is not updated correctly when user adds multiple product to cart");
		Thread.sleep(2000);

	}

	// case 4: Verify if freebie product is added to cart when user increase the
	// quantity
	@Test(priority = 4)
	public void freeBieProduct() throws InterruptedException {
		cartDrawer c = new cartDrawer(driver);
		boolean freebieProdut = c.getFreeBieproduct().isDisplayed();
		Assert.assertTrue(freebieProdut, "Freebie product is missing");

	}

	// case 5: Verify user is able to click on checkout button
	@Test(priority = 5, dependsOnMethods = "freeBieProduct")
	public void checkout() {
		cartDrawer c = new cartDrawer(driver);
		c.getCheckoutButtonCartDrawer().click();
		c.waitUntilElementIsVisible(c.getGokwikPopup());
		Assert.assertTrue(c.getGokwikPopup().isDisplayed(), "User is unable to navigate to checkout page");
		hp.refreshPage();
		driver.get("https://lovebeautyandplanet.in/cart/clear");
	}

}
