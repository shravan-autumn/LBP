package Tests;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import genericUtility.BaseClass;
import genericUtility.StepLogger;
import genericUtility.webdriverUtility;
import pomScripts.cartDrawer;
import pomScripts.homePage;
import pomScripts.loginPage;
import pomScripts.productDetailsPage;

public class HomepageTest extends BaseClass {

	loginPage lp;
	homePage hp;
	productDetailsPage pdp;
	cartDrawer c;

	// Case 1: Verify logo is displayed in home page
	@Test(priority = 1)
	public void logoVerification() {
		StepLogger.given("User is on homepage");
		StepLogger.then("Website logo should be visible");
		lp = new loginPage(driver);
		hp = new homePage(driver);
		lp.goToWebsite();
		Assert.assertTrue(hp.getLogo().isDisplayed());
	}

	// Case 2: Verify user is able to navigate product page by clicking on
	// announcement bar
	@Test(priority = 2)
	public void announcementBarNavigation() {
		StepLogger.given("User is on homepage");
		hp = new homePage(driver);
		StepLogger.when("User clicks on announcement bar");
		hp.clickAnnouncementBar();
		StepLogger.then("User should be redirected to bundle offers page");
		String expectedUrl = "https://lovebeautyandplanet.in/collections/bundle-offers";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		hp.navigateBack();
	}

	// Case 3: Verify user is able to navigate to product page by clicking on
	// megamenu options
	@Test(priority = 3)
	public void megamenuNavigation() {
		StepLogger.given("User navigates to homepage");
		hp = new homePage(driver);
		StepLogger.when("User Clicks on mega menu option");
		hp.clickMegamenuLink();
		String expectedUrl = "https://lovebeautyandplanet.in/collections/curry-leaves-biotin-mandarin";
		String actualUrl = driver.getCurrentUrl();
		StepLogger.then("User is redireceted to relevant collection page " + expectedUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		hp.navigateBack();
	}

	// Case 4: Verify user is able to navigate to About us page by clicking on about
	// us link in megamenu
	@Test(priority = 4)
	public void aboutUsPageNavigation() {
		hp = new homePage(driver);
		StepLogger.given("User navigates to homepage");
		StepLogger.when("User Clicks on About us link in megamenu");
		hp.clickMegamenuAboutUs();
		StepLogger.then("User is redirected to our-story page");
		String expectedUrl = "https://lovebeautyandplanet.in/pages/our-story";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		hp.navigateBack();
	}

	// Case 5: Verify user is able to navigate to know your ingredients page by
	// clicking on know your ingredients link in megamenu
	@Test(priority = 5)
	public void knowYourIngredientsPageNavigation() {
		StepLogger.given("User navigates to homepage");
		hp = new homePage(driver);
		StepLogger.when("User Clicks on know your ingredients in megamenu");
		hp.clickMegamenuKnowYourIngredients();
		StepLogger.then("User is redirected to ingredients page");
		String expectedUrl = "https://lovebeautyandplanet.in/pages/ingredients";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		hp.navigateBack();
	}

	// Case 6: Verify user is able to navigate to blog listing page by clicking on
	// beauty archives link in megamenu
	@Test(priority = 6)
	public void beautyArchivesPageNavigation() {
		StepLogger.given("User navigates to homepage");
		hp = new homePage(driver);
		StepLogger.when("User clicks on Beauty archives link in mega menu");
		hp.clickMegamenuBeautyArchives();
		StepLogger.then("User is redirected to blogs page");
		String expectedUrl = "https://lovebeautyandplanet.in/pages/blogs";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		hp.navigateBack();
	}

	// Case 7: Verify user is able to navigate to Contact us page by clicking on
	// support link in megamenu
	@Test(priority = 7)
	public void contactUsPageNavigation() {
		StepLogger.given("User navigates to homepage");
		hp = new homePage(driver);
		StepLogger.when("User clicks on support link on mega menu");
		hp.clickMegamenuSupport();
		StepLogger.given("User is redirected to contact us page");
		String expectedUrl = "https://lovebeautyandplanet.in/pages/contact-us";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		hp.navigateBack();
	}

	// Case 8: Verify user is able to navigate to relevant page by clicking on hero
	// banner link
	@Test(priority = 8)
	public void verifyHeroBannerLinkNavigation() {
		StepLogger.given("User navigates to homepage");
		hp = new homePage(driver);
		String homepage = driver.getCurrentUrl();
		StepLogger.when("User clicks on hero banner");
		hp.clickHeronBannerRedirection();
		StepLogger.then("User is redirected to relevant page");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(homepage, currentUrl, "User is not redirected to Relevant Page");
		hp.navigateBack();
	}

	// Case 9: Verify if user is able to switch the tabs and navigate to relevant
	// page by clicking on view all link
	@Test(priority = 9)
	public void verifyCollectionTabsNavigation() {
		StepLogger.given("User navigates to homepage");
		StepLogger.and("User scrolls down to product card section");
		StepLogger.when("User switches the collection tab and select view all");
		StepLogger.then("User is redirected to relevant collection page");
		for (int i = 0; i < hp.getAllCollectionTabs().size(); i++) {
			hp.clickTabAndRedirect(i);
			Assert.assertTrue(driver.getCurrentUrl().contains("collections"), "URL does not contain expected text");
			// hp.navigateBack();
			hp.clickLogo();
		}
	}

	// case 10: Verify user is able to navigate to relevant product page by clicking
	// on product in collection tab
	@Test(priority = 10)
	public void verifyProductNavigationFromCollectionTab() throws InterruptedException {
		hp.refreshPage();
		String product = "Argan Oil & Lavender Hair Mask - 200 ml";
		StepLogger.given("User navigates to homepage");
		StepLogger.and("User scrolls down to product card section");
		StepLogger.when("User clicks on product " + product);
		StepLogger.then("User is redirected to relevant product details page");

		for (WebElement pro : hp.getProductCardDescriptions()) {

			if (pro.getText().equalsIgnoreCase(product)) {
				hp.scrollToElement(pro);
				pro.click();
				pdp = new productDetailsPage(driver);
				hp.waitUnitlelementIsVisible(pdp.getProductTitle());
				String actualProduct = pdp.getProductTitle().getText();
				Assert.assertEquals(actualProduct, product.toLowerCase(),
						"User is not navigated to relevant product page");
				hp.navigateBack();
				break;
			}
		}

	}

	// Case 12: Verify user is able to add a product to cart
	@Test(priority = 12)
	public void verifyAddToCartFunctionality() throws Exception {
		StepLogger.given("User navigates to homepage");
		StepLogger.and("User scrolls down to product card section");
		StepLogger.when("User clicks on Add to cart button");
		StepLogger.then("Relevant product is added to cart");
		// String product = null;
		String a = hp.addToCart();
		String cartPro = null;
		cartDrawer c = new cartDrawer(driver);
		for (WebElement pro : c.getAllproductTitleCartDrawer1()) {
			if (pro.getText().toLowerCase().contains(a.toLowerCase())) {
				cartPro = pro.getText();
				break;
			}
		}
		Assert.assertEquals(cartPro.toLowerCase(), a.toLowerCase(),
				"Product in cart drawer is not same as the one added to cart");
		hp.clearCartAndNaviagteToHomepage();
	}

	// case 13: Verify shop by concern section
	@Test(priority = 13)
	public void verifyShopByConcernSection() {
		StepLogger.given("User navigates to homepage");
		StepLogger.and("User scrolls down to shop by concern section");
		StepLogger.when("User click on Frizz banner");
		StepLogger.then("User is redirected to relevant page");
		StepLogger.and("User navigates back to HP");

		hp.scrollToElement(hp.getFrizzConcern());
		Assert.assertTrue(hp.getShopByConcernSection().isDisplayed(), "Shop by concern section is not displayed");
		hp.clickFizzConcern();
		String expectedUrl = "https://lovebeautyandplanet.in/collections/argan-oil-lavender";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,
				"User is not navigated to relevant page after clicking on frizz concern");
		hp.navigateBack();
		StepLogger.given("User is on homepage");
		StepLogger.when("User click on Hair fall banner");
		StepLogger.then("User is redirected to relevant page");
		StepLogger.and("User navigates back to HP");


		hp.clickHairFallConcern();
		expectedUrl = "https://lovebeautyandplanet.in/collections/onion-blackseed-patchouli";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,
				"User is not navigated to relevant page after clicking on hair fall concern");
		hp.navigateBack();
		StepLogger.given("User is on homepage");
		StepLogger.when("User click on Damage banner");
		StepLogger.then("User is redirected to relevant page");
		StepLogger.and("User navigates back to HP");

		hp.clickDamageConcern();
		expectedUrl = "https://lovebeautyandplanet.in/collections/bond-repair";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,
				"User is not navigated to relevant page after clicking on damage concern");
		hp.navigateBack();
		StepLogger.given("User is on homepage");
		StepLogger.when("User click on Split-ends banner");
		StepLogger.then("User is redirected to relevant page");
		StepLogger.and("User navigates back to HP");


		hp.clickSplitEndsConcern();
		expectedUrl = "https://lovebeautyandplanet.in/collections/curry-leaves-biotin-mandarin";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,
				"User is not navigated to relevant page after clicking on split ends concern");
		hp.navigateBack();
		StepLogger.given("User is on homepage");
		StepLogger.when("User click on Curl care banner");
		StepLogger.then("User is redirected to relevant page");
		StepLogger.and("User navigates back to HP");

		hp.clickCurlCareConcern();
		expectedUrl = "https://lovebeautyandplanet.in/collections/rice-water-angelica";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,
				"User is not navigated to relevant page after clicking on curl care concern");
		hp.navigateBack();
		StepLogger.given("User is on homepage");
		StepLogger.when("User click on Dandruff banner");
		StepLogger.then("User is redirected to relevant page");
		StepLogger.and("User navigates back to HP");

		hp.clickDandruffConcern();
		expectedUrl = "https://lovebeautyandplanet.in/collections/tea-tree-and-vetiver";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,
				"User is not navigated to relevant page after clicking on dandruff concern");
		hp.navigateBack();

	}

	// Case 14: Verify discover beauty bill section
	@Test(priority = 14)
	public void verifyDiscoverBeautyBillSection() {
		StepLogger.given("User is on homepage");
		StepLogger.and("User scroll down to Beauty bill section");
		StepLogger.when("User click on Beauty bill banner");
		hp.clickDiscoverBeautyBill();
		StepLogger.then("User is redirected to relevant page");
		String expectedUrl = "https://lovebeautyandplanet.in/pages/beauty-bill";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,
				"User is not navigated to beauty bill page after clicking on discover beauty bill section");
		StepLogger.and("User navigates back to HP");
		hp.navigateBack();
	}

	// Case 15: Verify in the spot light section and add a product to cart
	@Test(priority = 15)
	public void verifyInTheSpotlightSection() {
		StepLogger.given("User is on homepage - In the spotlight section");
		StepLogger.when("User click on Add to cart button");
		StepLogger.then("Relevant product is added to cart");
		String activeProduct = hp.clickAddToCartInSpotlight();
		String cartPro = null;
		cartDrawer c = new cartDrawer(driver);
		for (WebElement pro : c.getAllproductTitleCartDrawer1()) {
			if (pro.getText().toLowerCase().contains(activeProduct.toLowerCase())) {
				cartPro = pro.getText();
				break;
			}
		}
		Assert.assertTrue(cartPro.toLowerCase().contains(activeProduct.toLowerCase()),
				"Product in cart drawer is not same as the one added to cart");
		StepLogger.and("User navigates back to HP");
		hp.clearCartAndNaviagteToHomepage();

	}

	// Case 16: Verify what sets us apart section
	@Test(priority = 16)
	public void verifyWhatSetsUsApartSection() {
		StepLogger.given("User is on homepage");
		StepLogger.and("User scrolls to what sets us apart section");
		StepLogger.then("User is able to view the section");

		hp.scrollToElement(hp.getWhatSetsUsApartSection());
		Assert.assertTrue(hp.getWhatSetsUsApartSection().isDisplayed(), "What sets us apart section is not displayed");

		for (int i = 0; i < hp.getWhatSetsUsApartCards().size(); i++) {
			hp.whatsetsUsapart(i);
			Assert.assertTrue(hp.getWhatSetsUsApartCardTitles().get(i).isDisplayed(),
					"Content is not displayed after clicking on tab");
		}
	}

	// case 17: Verify reels section
	@Test(priority = 17)
	public void verifyReelsSection() {
		StepLogger.given("User is on homepage");
		StepLogger.and("User scrolls down to reels section");
		StepLogger.then("User is able to view reels section");
		

		hp.scrollToElement(hp.getReelsSectionHeading());
		Assert.assertTrue(hp.getReelsSectionHeading().isDisplayed(), "Reels section is not displayed");
	}

	// case 18: Verify customer love section
	@Test(priority = 18)
	public void verifyCustomerLoveSection() {
		StepLogger.given("User is on homepage");
		StepLogger.and("User nscrolls down to customer love section");
		StepLogger.then("User is able to view customer love section");
		hp.scrollToElement(hp.getCustomerLoveSectionHeading());
		Assert.assertTrue(hp.getCustomerLoveSectionHeading().isDisplayed(), "Customer love section is not displayed");

	}

	// case 19: Verify discover our story section
	@Test(priority = 19)
	public void verifyDiscoverOurStorySection() {
		StepLogger.given("User is on homepage");
		StepLogger.and("User scroll down to discover our story section");
		StepLogger.then("User is able to view discover our story section");

		hp.clickDiscoverOurStory();
		String expectedUrl = "https://lovebeautyandplanet.in/pages/our-story";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,
				"User is not navigated to our story page after clicking on discover our story section");
		hp.navigateBack();

	}

	// Case 20: Verify beauty archives section
	@Test(priority = 20)
	public void verifyBeautyArchivesSection() {
		hp.clickBeautyArchivesViewAll();
		StepLogger.given("User is on homepage");
		StepLogger.and("User scrolls to beauty archives section");
		StepLogger.when("User clicks on blogs");
		StepLogger.then("User is redirected to relevant page");
		StepLogger.and("User navigates back to HP");

		String expectedUrl = "https://lovebeautyandplanet.in/pages/blogs";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,
				"User is not navigated to blogs page after clicking on beauty archives view all link");
		hp.navigateBack();
		String blog = "6 Post-Festive Hair Hacks That Will Make Your Hair Healthier Than Ever";
		for (int i = 0; i < hp.getBeautyArchivesArticleLinks().size(); i++) {
			if (hp.getBeautyArchivesArticleLinks().get(i).getText().equalsIgnoreCase(blog)) {
				hp.getBeautyArchivesArticleLinks().get(i).click();
				String actualBlogTitle = hp.getBlogHeading().getText();
				Assert.assertEquals(actualBlogTitle, blog,
						"User is not navigated to relevant blog page after clicking on blog");
				hp.navigateBack();
				break;
			}
		}
	}

	// Case 21: Verify the newsletter subscription functionality
	@Test(priority = 21)
	public void verifyNewsletterSubscription() {
		StepLogger.given("User is on homepage - newsletter section");
		StepLogger.when("User enters valid email and click submit");
		StepLogger.then("Newsletter success message is displayed");
		hp.subscribeToNewsletter();
		Assert.assertTrue(hp.getNewsletterSuccessMessage().isDisplayed(),
				"Success message is not displayed after subscribing to newsletter");

	}

	// Case 22: Verify the footer product links
	@Test(priority = 22)
	public void verifyFooterProductLinks() {
		StepLogger.given("User is on homepage - footer");
		StepLogger.when("User clicks on footer product links");
		StepLogger.then("User is redirected to relevant products");
		StepLogger.and("User navigates back to HP");
		hp = new homePage(driver);
		// webdriverUtility.scrollToElement(hp.getBeBeautifulSection());
		for (int i = 0; i < hp.getProductLinksFooter().size(); i++) {
			webdriverUtility.toScrollToElement(hp.getProductLinksFooter().get(i), driver);
			String linkName = hp.getProductLinksFooter().get(i).getText();
			hp.getProductLinksFooter().get(i).click();
			String currentUrl = driver.getCurrentUrl();
			String url = currentUrl.toLowerCase();
			String[] words = linkName.toLowerCase().split(" ");

			boolean matchFound = false;

			for (String word : words) {
				String root = word.replaceAll("(es|s)$", ""); // remove plural

				if (url.contains(root)) {
					matchFound = true;
					break;
				}
			}

			Assert.assertTrue(matchFound,
					"User is not navigated to relevant page after clicking on footer link: " + linkName);
			hp.navigateBack();
		}
	}

	// case 23: Verify the concern links in footer
	@Test(priority = 23)
	public void verifyFooterConcernLinks() {
		StepLogger.given("User is on homepage - footer");
		StepLogger.when("User clicks on footer concern links");
		StepLogger.then("User is redirected to relevant page");
		StepLogger.and("User navigates back to HP");

		hp = new homePage(driver);
		for (int i = 0; i < hp.getConcernsFooter().size(); i++) {
			hp.scrollToElement(hp.getConcernsFooter().get(i));
			String linkName = hp.getConcernsFooter().get(i).getText();
			hp.getConcernsFooter().get(i).click();
			String currentUrl = driver.getCurrentUrl();
			String url = currentUrl.toLowerCase();
			String[] words = linkName.toLowerCase().split(" ");

			boolean matchFound = false;

			for (String word : words) {
				String root = word.replaceAll("(es|s)$", ""); // remove plural

				if (url.contains(root)) {
					matchFound = true;
					break;
				}
			}

			Assert.assertTrue(matchFound,
					"User is not navigated to relevant page after clicking on footer link: " + linkName);
			hp.navigateBack();
		}
	}

	// case 24: Verify the about us and quick links in footer
	@Test(priority = 24)
	public void verifyFooterQuickLinks() {
		StepLogger.given("User is on homepage - footer");
		StepLogger.when("User clicks on footer quick links");
		StepLogger.then("User is redirected to relevant page");
		StepLogger.and("User navigates back to HP");
		hp = new homePage(driver);
		for (int i = 0; i < hp.getQuickLinksFooter().size(); i++) {
			hp.scrollToElement(hp.getQuickLinksFooter().get(i));
			String linkName = hp.getQuickLinksFooter().get(i).getText();
			hp.getQuickLinksFooter().get(i).click();
			String currentUrl = driver.getCurrentUrl();
			String url = currentUrl.toLowerCase();
			String[] words = linkName.toLowerCase().split(" ");

			boolean matchFound = false;

			for (String word : words) {
				String root = word.replaceAll("(es|s)$", ""); // remove plural

				if (url.contains(root)) {
					matchFound = true;
					break;
				}
			}

			Assert.assertTrue(matchFound,
					"User is not navigated to relevant page after clicking on footer link: " + linkName);
			hp.navigateBack();
		}

	}

	// Case 25: Verify the legal links in footer
	@Test(priority = 25)
	public void verifyFooterLegalLinks() {
		StepLogger.given("User is on homepage - footer");
		StepLogger.when("User clicks on footer legal links");
		StepLogger.then("User is redirected to relevant page");
		StepLogger.and("User navigates back to HP");
		for (int i = 0; i < hp.getLegalFooter().size(); i++) {

			hp.scrollToElement(hp.getLegalFooter().get(i));

			String linkName = hp.getLegalFooter().get(i).getText();

			String parentWindow = driver.getWindowHandle();
			int windowsBefore = driver.getWindowHandles().size();

			hp.getLegalFooter().get(i).click();

			// Wait a moment for navigation/tab opening
			new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(d -> driver.getWindowHandles().size() >= windowsBefore);

			int windowsAfter = driver.getWindowHandles().size();

			// NEW TAB OPENED
			if (windowsAfter > windowsBefore) {

				for (String window : driver.getWindowHandles()) {
					if (!window.equals(parentWindow)) {
						driver.switchTo().window(window);
						break;
					}
				}

			}
			// SAME TAB NAVIGATION
			else {
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/"));
			}

			// FIRST 4 LETTER MATCH

			String currentUrl = driver.getCurrentUrl().toLowerCase();

			// Normalize URL → remove symbols, hyphens, spaces
			String normalizedUrl = currentUrl.replaceAll("[^a-z]", "");

			// Normalize link text
			String normalizedLink = linkName.toLowerCase().replaceAll("[^a-z]", "");

			// Take first 4 letters (or less if word small)
			int compareLength = Math.min(4, normalizedLink.length());
			String prefix = normalizedLink.substring(0, compareLength);

			boolean matchFound = normalizedUrl.contains(prefix);

			Assert.assertTrue(matchFound, "User is not navigated correctly after clicking footer link");

			// CLOSE CHILD TAB OR GO BACK
			if (!driver.getWindowHandle().equals(parentWindow)) {
				driver.close(); // close new tab
				driver.switchTo().window(parentWindow);
			} else {
				driver.navigate().back(); // same tab
			}
		}

	}

	// case 26: Verify the social media links in footer
	@Test(priority = 26)
	public void verifyFooterSocialMediaLinks() {
		StepLogger.given("User is on homepage - footer");
		StepLogger.when("User clicks on footer socail links");
		StepLogger.then("User is redirected to relevant social page");
		StepLogger.and("User navigates back to HP");
		String parent = hp.clickfacebook();
		String expectedUrl = "https://www.facebook.com/lovebeautyandplanetin";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,
				"User is not navigated to Facebook page after clicking on Facebook link");
		driver.close();
		driver.switchTo().window(parent);

		hp.clickinstagram();
		String expectedUrlinsta = "https://www.instagram.com/lovebeautyandplanet_in/";
		String actualUrlinsta = driver.getCurrentUrl();
		Assert.assertEquals(actualUrlinsta, expectedUrlinsta,
				"User is not navigated to Instagram page after clicking on Facebook link");
		driver.close();
		driver.switchTo().window(parent);

		hp.clickyoutube();
		String expectedUrlYT = "https://www.youtube.com/channel/UCUFcrEf1Wb1164G6O2_LoyA";
		String actualUrlYT = driver.getCurrentUrl();
		Assert.assertEquals(actualUrlYT, expectedUrlYT,
				"User is not navigated to Youtube page after clicking on Facebook link");
		driver.close();
		driver.switchTo().window(parent);
	}

	// Case 27: Verify the Caution notice
	@Test(priority = 27)
	public void verifyCautionNotice() {
		StepLogger.given("User is on homepage - footer");
		StepLogger.and("User scrolls down till end");
		StepLogger.then("User is able to view Cation notice");
		hp.scrollToElement(hp.getCautionNotice());
		Assert.assertTrue(hp.getCautionNotice().isDisplayed(), "Caution notice is not displayed in the footer");
	}

}