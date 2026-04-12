package Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.webdriverUtility;
import pomScripts.cartDrawer;
import pomScripts.homePage;
import pomScripts.loginPage;
import pomScripts.productDetailsPage;
import pomScripts.productListingPage;

public class ProductlistingpageTest extends BaseClass {

	loginPage lp;
	homePage hp;
	productDetailsPage pdp;
	productListingPage plp;

	// Case 1: Verify if user is able to navigate to PLP by clicking on mega-menu
	// options
	@Test(priority = 1)
	public void hpToPlpNavigation() {
		plp =new productListingPage(driver);
		plp.plpNavigation();
		String expectedUrl = "https://lovebeautyandplanet.in/collections/buy3-1399";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	// Case 2: Verify applied filters are displayed in PLP page
	@Test(priority = 2)
	public void appliedFilters() {
		plp.applyFilters();

		// Scroll to Applied Filter section
		plp.scrollToElement(plp.getFilterHeading());
		Assert.assertTrue(plp.getClearAllLink().isDisplayed(), "Filters are not applied");
		plp.refreshPage();
	}

	// Case 3: Verify if relevant products are displayed on applying filters in PLP
	// page
	@Test(priority = 3)
	public void filteredproducts() {
		String productTitle = plp.filteredProducts();
		pdp= new productDetailsPage(driver);
		String actualPro = pdp.getProductTitle().getText();
		Assert.assertEquals(actualPro, productTitle, "Product title mismatch after redirection");
		plp.navigateBack();
	}

	// Case 4: Verify if user is able to clear applied filters in PLP page
	@Test(priority = 4)
	public void clearFilters() throws Exception {
		plp.clearFilters();
		Assert.assertTrue(plp.getClearAllLink().isDisplayed(), "Filters are not cleared");
		plp.refreshPage();

	}

	// case 5: Verify Add to Cart functionality from PLP page
	@Test(priority = 5)
	public void addToCartFromPLP() {
		String product = plp.addToCart();
		String cartPro = null;
		cartDrawer c = new cartDrawer(driver);
		for (WebElement pro : c.getAllproductTitleCartDrawer1()) {
			if (pro.getText().toLowerCase().contains(product.toLowerCase())) {
				cartPro = pro.getText();
				break;
			}
		}
		Assert.assertEquals(cartPro.toLowerCase(), product.toLowerCase(),
				"Product in cart drawer is not same as the one added to cart");
		plp.refreshPage();

	}

	// case 6: Verify if You May Also Like section is displayed in PLP page
	@Test(priority = 6)
	public void youMayAlsoLikeSection() {
		plp.scrollToElement(plp.getYouMayAlsoLikeSection());
		Assert.assertTrue(plp.getYouMayAlsoLikeSection().isDisplayed(),
				"You May Also Like section is not displayed in PLP page");
	}

	// case 7: Verify if beauty Archives section is displayed in PLP page
	@Test(priority = 7)
	public void beautyArchivesSection() {
		plp.scrollToElement(plp.getBeautyArchivesSection());
		Assert.assertTrue(plp.getBeautyArchivesSection().isDisplayed(),
				"Beauty Archives section is not displayed in PLP page");
	}

	// case 8: Verify if view all redirects to correct page in PLP page
	@Test(priority = 8)
	public void viewAllRedirection() {
		plp.viewAll();
		String expectedUrl = "https://lovebeautyandplanet.in/blogs/hair";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "View All link is not redirecting to correct page");
		driver.navigate().back();
	}

	// case 9: Verify if FAQs section is displayed in PLP page
	@Test(priority = 9)
	public void faqsSection() {
		plp.faqsSection();
		Assert.assertTrue(plp.getFaqsSection().isDisplayed(), "FAQs section is not displayed in PLP page");
	}

	// case 10: Verify if Write to us link redirects to correct page in PLP page
	@Test(priority = 10)
	public void writeToUsRedirection() {
		plp.writeToUs();
		String expectedUrl = "https://lovebeautyandplanet.in/pages/contact-us";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Write to us link is not redirecting to correct page");
		driver.navigate().back();
	}
}
