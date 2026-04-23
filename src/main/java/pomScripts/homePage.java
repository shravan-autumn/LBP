package pomScripts;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import genericUtility.BaseClass;
import genericUtility.webdriverUtility;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class homePage extends BaseClass {
	// WebDriver driver;
	WebDriverWait wait;

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@FindBy(xpath = "//a[contains(@class,'header__icon--account link focus-inset')]")
	private WebElement accountLink;

	@FindBy(xpath = "//div[@class='header__heading-logo-wrapper']")
	private WebElement logo;

	@FindBy(xpath = "//a[text()='Shop']")
	private WebElement megamenuShopLink;

	@FindBy(xpath = "//a[text()='Offers']")
	private WebElement megamenuOffersLink;

	@FindBy(xpath = "//div[@class='nav d-none d-lg-block']//a[contains(text(),'About Us')]")
	private WebElement megamenuAboutusLink;

	@FindBy(xpath = "//div[@class='nav d-none d-lg-block']//a[contains(text(),'Know Your Ingredients')]")
	private WebElement megamenuKnowyouringredientsLink;

	@FindBy(xpath = "//div[@class='nav d-none d-lg-block']//a[contains(text(),'Beauty Archives')]")
	private WebElement megamenuBeautyArchivesLink;

	@FindBy(xpath = "//a[text()='Support']")
	private WebElement megamenuSupportLink;

	@FindBy(xpath = "//a[text()='New Launches']")
	private WebElement megamenuNewLaunchesLink;

	@FindBy(xpath = "//a[text()='View All Products']")
	private WebElement megamenuViewAllProductsLink;

	@FindBy(xpath = "//a[text()='Explore By Ingredients']")
	private WebElement exploreByIngredientsLink;

	@FindBy(xpath = "//img[@alt='Curry Leaves, Biotin & Mandarin']")
	private WebElement curryLeavesBiotinMandarinProduct;

	@FindBy(xpath = "//a[text()='BUY3@1399']")
	private WebElement buy3At1399Link;

	@FindBy(xpath = "//a[text()='BUY4@1799']")
	private WebElement buy4At1799Link;

	@FindBy(xpath = "//div[@class='header__icons header__icons--localization header-localization']//input[@type='search']")
	private WebElement searchTextField;

	@FindBy(xpath = "//a[contains(@class,'header__icon--cart')]")
	private WebElement cartLink;

	@FindBy(xpath = "//a[@class='announcement']")
	private WebElement announcementBar;

	
	
	
	public WebElement getLogo() {
		return logo;
	}

	public void setLogo(WebElement logo) {
		this.logo = logo;
	}

	public WebElement getMegamenuShopLink() {
		return megamenuShopLink;
	}

	public void setMegamenuShopLink(WebElement megamenuShopLink) {
		this.megamenuShopLink = megamenuShopLink;
	}

	public WebElement getMegamenuOffersLink() {
		return megamenuOffersLink;
	}

	public void setMegamenuOffersLink(WebElement megamenuOffersLink) {
		this.megamenuOffersLink = megamenuOffersLink;
	}

	public WebElement getMegamenuAboutusLink() {
		return megamenuAboutusLink;
	}

	public void setMegamenuAboutusLink(WebElement megamenuAboutusLink) {
		this.megamenuAboutusLink = megamenuAboutusLink;
	}

	public WebElement getMegamenuKnowyouringredientsLink() {
		return megamenuKnowyouringredientsLink;
	}

	public void setMegamenuKnowyouringredientsLink(WebElement megamenuKnowyouringredientsLink) {
		this.megamenuKnowyouringredientsLink = megamenuKnowyouringredientsLink;
	}

	public WebElement getMegamenuBeautyArchivesLink() {
		return megamenuBeautyArchivesLink;
	}

	public void setMegamenuBeautyArchivesLink(WebElement megamenuBeautyArchivesLink) {
		this.megamenuBeautyArchivesLink = megamenuBeautyArchivesLink;
	}

	public WebElement getMegamenuSupportLink() {
		return megamenuSupportLink;
	}

	public void setMegamenuSupportLink(WebElement megamenuSupportLink) {
		this.megamenuSupportLink = megamenuSupportLink;
	}

	public WebElement getMegamenuNewLaunchesLink() {
		return megamenuNewLaunchesLink;
	}

	public void setMegamenuNewLaunchesLink(WebElement megamenuNewLaunchesLink) {
		this.megamenuNewLaunchesLink = megamenuNewLaunchesLink;
	}

	public WebElement getMegamenuViewAllProductsLink() {
		return megamenuViewAllProductsLink;
	}

	public void setMegamenuViewAllProductsLink(WebElement megamenuViewAllProductsLink) {
		this.megamenuViewAllProductsLink = megamenuViewAllProductsLink;
	}

	public WebElement getExploreByIngredientsLink() {
		return exploreByIngredientsLink;
	}

	public void setExploreByIngredientsLink(WebElement exploreByIngredientsLink) {
		this.exploreByIngredientsLink = exploreByIngredientsLink;
	}

	public WebElement getCurryLeavesBiotinMandarinProduct() {
		return curryLeavesBiotinMandarinProduct;
	}

	public void setCurryLeavesBiotinMandarinProduct(WebElement curryLeavesBiotinMandarinProduct) {
		this.curryLeavesBiotinMandarinProduct = curryLeavesBiotinMandarinProduct;
	}

	public WebElement getBuy3At1399Link() {
		return buy3At1399Link;
	}

	public void setBuy3At1399Link(WebElement buy3At1399Link) {
		this.buy3At1399Link = buy3At1399Link;
	}

	public WebElement getBuy4At1799Link() {
		return buy4At1799Link;
	}

	public void setBuy4At1799Link(WebElement buy4At1799Link) {
		this.buy4At1799Link = buy4At1799Link;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public void setSearchTextField(WebElement searchTextField) {
		this.searchTextField = searchTextField;
	}

	public WebElement getCartLink() {
		return cartLink;
	}

	public void setCartLink(WebElement cartLink) {
		this.cartLink = cartLink;
	}

	public WebElement getAnnouncementBar() {
		return announcementBar;
	}

	public void setAnnouncementBar(WebElement announcementBar) {
		this.announcementBar = announcementBar;
	}

	public WebElement getAccountLink() {
		return accountLink;
	}

	public void setAccountLink(WebElement accountLink) {
		this.accountLink = accountLink;
	}

	// Announcement bar click
	public void clickAnnouncementBar() {
		getAnnouncementBar().click();
	}

	// Megamenu click actions
	public void clickMegamenuLink() {
		getMegamenuShopLink().click();
		getExploreByIngredientsLink().click();
		getCurryLeavesBiotinMandarinProduct().click();
	}

	// megamenu about us link
	public void clickMegamenuAboutUs() {
		getMegamenuAboutusLink().click();
	}

	// megamenu know your ingredients link
	public void clickMegamenuKnowYourIngredients() {
		getMegamenuKnowyouringredientsLink().click();
	}

	// megamenu beauty archives link
	public void clickMegamenuBeautyArchives() {
		getMegamenuBeautyArchivesLink().click();
	}

	// megamenu support link
	public void clickMegamenuSupport() {
		getMegamenuSupportLink().click();
	}

	// Locators
	By nextBtn = By.cssSelector("button.owl-next");
	By prevBtn = By.cssSelector("button.owl-prev");
	By activeSlide = By.cssSelector(".owl-item.active img");

	// Get current banner image
	public String getActiveBannerImage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(activeSlide)).getAttribute("src");
	}

	// Click next n times
	public void clickNext(int times) {
		for (int i = 0; i < times; i++) {

			String before = getActiveBannerImage();

			driver.findElement(nextBtn).click();

			// wait for banner change
			wait.until(ExpectedConditions
					.not(ExpectedConditions.attributeToBe(driver.findElement(activeSlide), "src", before)));
		}
	}

	// Click previous n times
	public void clickPrev(int times) {
		for (int i = 0; i < times; i++) {

			String before = getActiveBannerImage();

			driver.findElement(prevBtn).click();

			wait.until(ExpectedConditions
					.not(ExpectedConditions.attributeToBe(driver.findElement(activeSlide), "src", before)));
		}
	}

	@FindBy(xpath = "//div[contains(@class,'owl-item active center')]")
	private WebElement activeBanner;

	public WebElement getActiveBanner() {
		return activeBanner;
	}

	public void setActiveBanner(WebElement activeBanner) {
		this.activeBanner = activeBanner;
	}

	@FindBy(xpath = "//li[text()='best selling']")
	private WebElement bestSellingTab;
	@FindBy(xpath = "//li[text()='combos']")
	private WebElement combosTab;
	@FindBy(xpath = "//li[text()='new launches']")
	private WebElement newLaunchesTab;
	@FindBy(xpath = "//a[@class='home-common-btn']")
	private List<WebElement> viewAllLink;
	@FindBy(xpath = "//ul[@class='home-pro-tabs']/li")
	private List<WebElement> allCollectionTabs;

	public WebElement getBestSellingTab() {
		return bestSellingTab;
	}

	public void setBestSellingTab(WebElement bestSellingTab) {
		this.bestSellingTab = bestSellingTab;
	}

	public WebElement getCombosTab() {
		return combosTab;
	}

	public void setCombosTab(WebElement combosTab) {
		this.combosTab = combosTab;
	}

	public WebElement getNewLaunchesTab() {
		return newLaunchesTab;
	}

	public void setNewLaunchesTab(WebElement newLaunchesTab) {
		this.newLaunchesTab = newLaunchesTab;
	}

	public List<WebElement> getViewAllLink() {
		return viewAllLink;
	}

	public void setViewAllLink(List<WebElement> viewAllLink) {
		this.viewAllLink = viewAllLink;
	}

	public List<WebElement> getAllCollectionTabs() {
		return allCollectionTabs;
	}

	public void setAllCollectionTabs(List<WebElement> allCollectionTabs) {
		this.allCollectionTabs = allCollectionTabs;
	}

	// heron banner redirection action
	public void clickHeronBannerRedirection() {
		getActiveBanner().click();
	}

	// product card section
	@FindBy(xpath = "//p[@class='h-pro-card-cnt-description']")
	private List<WebElement> productCardDescriptions;

	public List<WebElement> getProductCardDescriptions() {
		return productCardDescriptions;
	}

	public void setProductCardDescriptions(List<WebElement> productCardDescriptions) {
		this.productCardDescriptions = productCardDescriptions;
	}

	// tab section redirection action
	public void clickTabAndRedirect(int a){
		webdriverUtility.toScrollToElement(getCombosTab(), driver);
		getAllCollectionTabs().get(a).click();
		webdriverUtility.toScrollToElement(getViewAllLink().get(a), driver);
		webdriverUtility.elementToBeClickable(driver, getViewAllLink().get(a));
		getViewAllLink().get(a).click();
	}

	// Add a product to cart from tab section
	public String addToCart() throws Exception {
		driver.navigate().refresh();
		// Get first product title
		String pro1 = getProductCardDescriptions().get(0).getText();
		webdriverUtility.toScrollToElement(getProductCardDescriptions().get(0), driver);
		webdriverUtility.toScrollToElement(getAddToCart().get(0), driver);
		// Click first product add to cart
		getAddToCart().get(0).click();
		webdriverUtility.waitUntilElementIsVisible(getViewCartButton());
		getViewCartButton().click();
		Thread.sleep(3000);
		return pro1;
	}

	// shop by concern section

	@FindBy(xpath = "//h2[text()='shop by concern']")
	private WebElement shopByConcernSection;
	@FindBy(xpath = "//p[text()='Frizz']")
	private WebElement frizzConcern;
	@FindBy(xpath = "//p[text()='Hair fall']")
	private WebElement hairFallConcern;
	@FindBy(xpath = "//p[text()='Damage']")
	private WebElement damageConcern;
	@FindBy(xpath = "//p[text()='Split-ends']")
	private WebElement splitEndsConcern;
	@FindBy(xpath = "//p[text()='Curl care']")
	private WebElement curlCareConcern;
	@FindBy(xpath = "//p[text()='Dandruff']")
	private WebElement dandruffConcern;

	public WebElement getShopByConcernSection() {
		return shopByConcernSection;
	}

	public void setShopByConcernSection(WebElement shopByConcernSection) {
		this.shopByConcernSection = shopByConcernSection;
	}

	public WebElement getFrizzConcern() {
		return frizzConcern;
	}

	public void setFrizzConcern(WebElement frizzConcern) {
		this.frizzConcern = frizzConcern;
	}

	public WebElement getHairFallConcern() {
		return hairFallConcern;
	}

	public void setHairFallConcern(WebElement hairFallConcern) {
		this.hairFallConcern = hairFallConcern;
	}

	public WebElement getDamageConcern() {
		return damageConcern;
	}

	public void setDamageConcern(WebElement damageConcern) {
		this.damageConcern = damageConcern;
	}

	public WebElement getSplitEndsConcern() {
		return splitEndsConcern;
	}

	public void setSplitEndsConcern(WebElement splitEndsConcern) {
		this.splitEndsConcern = splitEndsConcern;
	}

	public WebElement getCurlCareConcern() {
		return curlCareConcern;
	}

	public void setCurlCareConcern(WebElement curlCareConcern) {
		this.curlCareConcern = curlCareConcern;
	}

	public WebElement getDandruffConcern() {
		return dandruffConcern;
	}

	public void setDandruffConcern(WebElement dandruffConcern) {
		this.dandruffConcern = dandruffConcern;
	}

	@FindBy(xpath = "//button[@name='add']")
	private List<WebElement> addToCart;
	@FindBy(xpath = "//button[@id='view-cart-drawer']")
	private WebElement viewCartButton;

	public List<WebElement> getAddToCart() {
		return addToCart;
	}

	public void setAddToCart(List<WebElement> addToCart) {
		this.addToCart = addToCart;
	}

	public WebElement getViewCartButton() {
		return viewCartButton;
	}

	public void setViewCartButton(WebElement viewCartButton) {
		this.viewCartButton = viewCartButton;
	}

	// discover beauty bill section

	@FindBy(xpath = "//h3[contains(text(),'Discover Beauty Bill')]//ancestor::section//a[@href='/pages/beauty-bill']")
	private WebElement discoverBeautyBillSection;

	public WebElement getDiscoverBeautyBillSection() {
		return discoverBeautyBillSection;
	}

	public void setDiscoverBeautyBillSection(WebElement discoverBeautyBillSection) {
		this.discoverBeautyBillSection = discoverBeautyBillSection;
	}
 
	// beauty bill section action method
	public void clickDiscoverBeautyBill() {
		webdriverUtility.toScrollToElement(getDiscoverBeautyBillSection(), driver);
		getDiscoverBeautyBillSection().click();
	}

	// in the spotlight section
	@FindBy(xpath = "//h2[text()='what sets us apart']")
	private WebElement whatSetsUsApartSection;

	public WebElement getWhatSetsUsApartSection() {
		return whatSetsUsApartSection;
	}

	public void setWhatSetsUsApartSection(WebElement whatSetsUsApartSection) {
		this.whatSetsUsApartSection = whatSetsUsApartSection;
	}

	// RIGHT navigation arrow
	@FindBy(xpath = "//div[text()='in the spotlight']/parent::div//button[@class='owl-next']")
	private WebElement rightArrow;

	// LEFT navigation arrow
	@FindBy(xpath = "//div[text()='in the spotlight']/parent::div//button[@class='owl-prev']")
	private WebElement leftArrow;

	// ADD TO CART button inside active slide
	@FindBy(xpath = "//div[text()='in the spotlight']//parent::div[@class='container']//descendant::div[@class='owl-item active']//button[@name='add']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[text()='in the spotlight']//parent::div[@class='container']//descendant::div[@class='owl-item active']//div[@class='h-spotlight--name-review']//p")
	private WebElement activeSlideProductName;

	//ACTION METHODS

	public WebElement getActiveSlideProductName() {
		return activeSlideProductName;
	}

	public void setActiveSlideProductName(WebElement activeSlideProductName) {
		this.activeSlideProductName = activeSlideProductName;
	}

	public WebElement getRightArrow() {
		return rightArrow;
	}

	public void setRightArrow(WebElement rightArrow) {
		this.rightArrow = rightArrow;
	}

	public WebElement getLeftArrow() {
		return leftArrow;
	}

	public void setLeftArrow(WebElement leftArrow) {
		this.leftArrow = leftArrow;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public void setAddToCartButton(WebElement addToCartButton) {
		this.addToCartButton = addToCartButton;
	}

	public void clickRightMultipleTimes(int times) {
		for (int i = 0; i < times; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(rightArrow)).click();
		}
	}

	public void clickLeftMultipleTimes(int times) {
		for (int i = 0; i < times; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(leftArrow)).click();
		}
	}

	// click add to cart in spotlight section
	public String clickAddToCartInSpotlight() {
		webdriverUtility.toScrollToElement(getWhatSetsUsApartSection(), driver);
		// Right 3 times
		int n = 3;
		clickRightMultipleTimes(n);

		// Left 2 times

		clickLeftMultipleTimes(n - 1);
		webdriverUtility.waitUntilElementIsVisible(getActiveSlideProductName());
		String activeProduct = getActiveSlideProductName().getText();

		// Click Add to Cart
		getAddToCartButton().click();
		webdriverUtility.waitUntilElementIsVisible(getViewCartButton());
		getViewCartButton().click();
		return activeProduct;
	}

	// what sets us apart section
	@FindBy(xpath = "//h2[text()='what sets us apart']//parent::div")
	private WebElement whatSetsUsApartSectionContainer;
	@FindBy(xpath = "//div[@class='h-apart-card-img']")
	private List<WebElement> whatSetsUsApartCards;

	@FindBy(xpath = "//div[@class='h-apart-card-img']//following-sibling::span")
	private List<WebElement> whatSetsUsApartCardTitles;

	@FindBy(xpath = "//div[contains(@id,'reelUp_playlist')]")
	private WebElement reelsSectionHeading;

	public WebElement getWhatSetsUsApartSectionContainer() {
		return whatSetsUsApartSectionContainer;
	}

	public void setWhatSetsUsApartSectionContainer(WebElement whatSetsUsApartSectionContainer) {
		this.whatSetsUsApartSectionContainer = whatSetsUsApartSectionContainer;
	}

	public List<WebElement> getWhatSetsUsApartCards() {
		return whatSetsUsApartCards;
	}

	public void setWhatSetsUsApartCards(List<WebElement> whatSetsUsApartCards) {
		this.whatSetsUsApartCards = whatSetsUsApartCards;
	}

	public List<WebElement> getWhatSetsUsApartCardTitles() {
		return whatSetsUsApartCardTitles;
	}

	public void setWhatSetsUsApartCardTitles(List<WebElement> whatSetsUsApartCardTitles) {
		this.whatSetsUsApartCardTitles = whatSetsUsApartCardTitles;
	}

	public WebElement getReelsSectionHeading() {
		return reelsSectionHeading;
	}

	public void setReelsSectionHeading(WebElement reelsSectionHeading) {
		this.reelsSectionHeading = reelsSectionHeading;
	}

	//what sets us apart dropdown actions
	public void whatsetsUsapart(int a) {
		webdriverUtility.toScrollToElement(getWhatSetsUsApartCards().get(a), driver);
		getWhatSetsUsApartCards().get(a).click();
	}
	
//customer love section + gif section
	@FindBy(xpath = "//h2[text()='Customer Love']")
	private WebElement customerLoveSectionHeading;
	@FindBy(xpath = "//h2[text()='Customer Love']//parent::div//button[@class='owl-next']")
	private WebElement customerLoveNextBtn;
	@FindBy(xpath = "//h2[text()='Customer Love']//parent::div//button[@class='owl-prev']")
	private WebElement customerLovePrevBtn;
	@FindBy(xpath = "//div[@class='gif-section--main-content']")
	private WebElement gifSection;

	public WebElement getGifSection() {
		return gifSection;
	}

	public void setGifSection(WebElement gifSection) {
		this.gifSection = gifSection;
	}

	public WebElement getCustomerLoveSectionHeading() {
		return customerLoveSectionHeading;
	}

	public void setCustomerLoveSectionHeading(WebElement customerLoveSectionHeading) {
		this.customerLoveSectionHeading = customerLoveSectionHeading;
	}

	public WebElement getCustomerLoveNextBtn() {
		return customerLoveNextBtn;
	}

	public void setCustomerLoveNextBtn(WebElement customerLoveNextBtn) {
		this.customerLoveNextBtn = customerLoveNextBtn;
	}

	public WebElement getCustomerLovePrevBtn() {
		return customerLovePrevBtn;
	}

	public void setCustomerLovePrevBtn(WebElement customerLovePrevBtn) {
		this.customerLovePrevBtn = customerLovePrevBtn;
	}

	public void clickRightMultipleTimesCustomerLove(int times) {
		for (int i = 0; i < times; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(customerLoveNextBtn)).click();
		}
	}

	public void clickLeftMultipleTimesCustomerLove(int times) {
		for (int i = 0; i < times; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(customerLovePrevBtn)).click();
		}
	}

//discover our story section
	@FindBy(xpath = "//h3[contains(text(),'Discover our story')]/ancestor::section//div[@class='hos-cont']")
	private WebElement discoverOurStorySection;
	@FindBy(xpath = "//section[@class='home-ingredients']/child::div[@class='container']//div")
	private WebElement discoverOurStorySection2;

	public WebElement getDiscoverOurStorySection() {
		return discoverOurStorySection;
	}

	public void setDiscoverOurStorySection(WebElement discoverOurStorySection) {
		this.discoverOurStorySection = discoverOurStorySection;
	}

	public WebElement getDiscoverOurStorySection2() {
		return discoverOurStorySection2;
	}

	public void setDiscoverOurStorySection2(WebElement discoverOurStorySection2) {
		this.discoverOurStorySection2 = discoverOurStorySection2;
	}

//discover our story section action method
	public void clickDiscoverOurStory() {
		webdriverUtility.toScrollToElement(getDiscoverOurStorySection(), driver);
		webdriverUtility.waitUntilElementIsVisible(getDiscoverOurStorySection());
		getDiscoverOurStorySection().click();
	}

	// beauty archives section
	@FindBy(xpath = "//a[@class='home-page--blogs-button home-common-btn']")
	private WebElement beautyArchivesViewAllLink;
	@FindBy(xpath = "//div[@class='h-beauty-card-cnt']//a")
	private List<WebElement> beautyArchivesArticleLinks;
	@FindBy(xpath = "//h1[@class='line-1 h1']")
	private WebElement blogHeading;

	public WebElement getBeautyArchivesViewAllLink() {
		return beautyArchivesViewAllLink;
	}

	public void setBeautyArchivesViewAllLink(WebElement beautyArchivesViewAllLink) {
		this.beautyArchivesViewAllLink = beautyArchivesViewAllLink;
	}

	public List<WebElement> getBeautyArchivesArticleLinks() {
		return beautyArchivesArticleLinks;
	}

	public void setBeautyArchivesArticleLinks(List<WebElement> beautyArchivesArticleLinks) {
		this.beautyArchivesArticleLinks = beautyArchivesArticleLinks;
	}

	public WebElement getBlogHeading() {
		return blogHeading;
	}

	public void setBlogHeading(WebElement blogHeading) {
		this.blogHeading = blogHeading;
	}

	// beauty archives section action method
	public void clickBeautyArchivesViewAll() {
		webdriverUtility.toScrollToElement(getBeautyArchiveNextBtn(), driver);
		getBeautyArchivesViewAllLink().click();
	}

	@FindBy(xpath = "//section[@class='home-page--custom-blogs home-beautyedits']//button[@class='owl-next']")
	private WebElement beautyArchiveNextBtn;
	@FindBy(xpath = "//section[@class='home-page--custom-blogs home-beautyedits']//button[@class='owl-prev']")
	private WebElement beautyArchivePrevBtn;

	public WebElement getBeautyArchiveNextBtn() {
		return beautyArchiveNextBtn;
	}

	public void setBeautyArchiveNextBtn(WebElement beautyArchiveNextBtn) {
		this.beautyArchiveNextBtn = beautyArchiveNextBtn;
	}

	public WebElement getBeautyArchivePrevBtn() {
		return beautyArchivePrevBtn;
	}

	public void setBeautyArchivePrevBtn(WebElement beautyArchivePrevBtn) {
		this.beautyArchivePrevBtn = beautyArchivePrevBtn;
	}

	public void clickRightArrow(int times) {
		for (int i = 0; i < times; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(beautyArchiveNextBtn)).click();
		}
	}

	public void clickLeftArrow(int times) {
		for (int i = 0; i < times; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(beautyArchivePrevBtn)).click();
		}
	}

	public void clickFirstBlog() {
		wait.until(ExpectedConditions.elementToBeClickable(beautyArchivesArticleLinks.get(0))).click();

	}

	// newsletter subscription
	@FindBy(xpath = "//div[@class='field']//input")
	private WebElement newsletterEmailTextField;
	@FindBy(xpath = "//label[@class='newsletter-consent consent-statement']//input")
	private WebElement newsletterCheckbox;
	@FindBy(xpath = "//button[@id='Subscribe']")
	private WebElement newsletterSubscribeButton;
	@FindBy(xpath = "//h3[@class='test newsletter-form__message newsletter-form__message--success form__message']")
	private WebElement newsletterSuccessMessage;

	public WebElement getNewsletterCheckbox() {
		return newsletterCheckbox;
	}

	public void setNewsletterCheckbox(WebElement newsletterCheckbox) {
		this.newsletterCheckbox = newsletterCheckbox;
	}

	public WebElement getNewsletterSubscribeButton() {
		return newsletterSubscribeButton;
	}

	public void setNewsletterSubscribeButton(WebElement newsletterSubscribeButton) {
		this.newsletterSubscribeButton = newsletterSubscribeButton;
	}

	public WebElement getNewsletterSuccessMessage() {
		return newsletterSuccessMessage;
	}

	public void setNewsletterSuccessMessage(WebElement newsletterSuccessMessage) {
		this.newsletterSuccessMessage = newsletterSuccessMessage;
	}

	public WebElement getNewsletterEmailTextField() {
		return newsletterEmailTextField;
	}

	public void setNewsletterEmailTextField(WebElement newsletterEmailTextField) {
		this.newsletterEmailTextField = newsletterEmailTextField;
	}

	// newsletter subscription action method
	public void subscribeToNewsletter() {
		webdriverUtility.toScrollToElement(getProductLinksFooterHeading(), driver);
		Faker faker = new Faker();
		getNewsletterEmailTextField().sendKeys(faker.internet().emailAddress());
		getNewsletterCheckbox().click();
		getNewsletterSubscribeButton().click();
		webdriverUtility.waitUntilElementIsVisible(getNewsletterSuccessMessage());
	}

	// footer links
	@FindBy(xpath = "//p[text()='Product Links']")
	private WebElement productLinksFooterHeading;

	public WebElement getProductLinksFooterHeading() {
		return productLinksFooterHeading;
	}

	public void setProductLinksFooterHeading(WebElement productLinksFooterHeading) {
		this.productLinksFooterHeading = productLinksFooterHeading;
	}

	// footer links
	@FindBy(xpath = "//p[text()='Product Links']/parent::div//a")
	private List<WebElement> productLinksFooter;
	@FindBy(xpath = "//p[text()='Concerns']/parent::div//a")
	private List<WebElement> concernsFooter;
	@FindBy(xpath = "//p[text()='Quick links']/parent::div//a")
	private List<WebElement> quickLinksFooter;
	@FindBy(xpath = "//p[text()='legal']/parent::div//a")
	private List<WebElement> legalFooter;
	@FindBy(xpath = "//strong[text()='Caution Notice']")
	private WebElement cautionNotice;

	public List<WebElement> getProductLinksFooter() {
		return productLinksFooter;
	}

	public void setProductLinksFooter(List<WebElement> productLinksFooter) {
		this.productLinksFooter = productLinksFooter;
	}

	public List<WebElement> getConcernsFooter() {
		return concernsFooter;
	}

	public void setConcernsFooter(List<WebElement> concernsFooter) {
		this.concernsFooter = concernsFooter;
	}

	public List<WebElement> getQuickLinksFooter() {
		return quickLinksFooter;
	}

	public void setQuickLinksFooter(List<WebElement> quickLinksFooter) {
		this.quickLinksFooter = quickLinksFooter;
	}

	public List<WebElement> getLegalFooter() {
		return legalFooter;
	}

	public void setLegalFooter(List<WebElement> legalFooter) {
		this.legalFooter = legalFooter;
	}

	public WebElement getCautionNotice() {
		return cautionNotice;
	}

	public void setCautionNotice(WebElement cautionNotice) {
		this.cautionNotice = cautionNotice;
	}

	@FindBy(xpath = "copyright__content")
	private WebElement copyrightNotice;

	public WebElement getCopyrightNotice() {
		return copyrightNotice;
	}

	public void setCopyrightNotice(WebElement copyrightNotice) {
		this.copyrightNotice = copyrightNotice;
	}

	@FindBy(xpath = "//div[@class='footer-block col-md-2']//div[@class='be_beautiful__container']")
	private WebElement beBeautifulSection;

	public WebElement getBeBeautifulSection() {
		return beBeautifulSection;
	}

	public void setBeBeautifulSection(WebElement beBeautifulSection) {
		this.beBeautifulSection = beBeautifulSection;
	}


	// social media links
	@FindBy(xpath = "//div[@class='footer__blocks-wrapper desktop_only ft-blwr-desk row']//a[@href='https://www.facebook.com/lovebeautyandplanetin']")
	private WebElement facebookLink;
	@FindBy(xpath = "//div[@class='footer__blocks-wrapper desktop_only ft-blwr-desk row']//a[@href='https://www.instagram.com/lovebeautyandplanet_in/']")
	private WebElement instagramLink;
	@FindBy(xpath = "//div[@class='footer__blocks-wrapper desktop_only ft-blwr-desk row']//a[@href='https://www.youtube.com/channel/UCUFcrEf1Wb1164G6O2_LoyA']")
	private WebElement youtubeLink;

	public WebElement getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(WebElement facebookLink) {
		this.facebookLink = facebookLink;
	}

	public WebElement getInstagramLink() {
		return instagramLink;
	}

	public void setInstagramLink(WebElement instagramLink) {
		this.instagramLink = instagramLink;
	}

	public WebElement getYoutubeLink() {
		return youtubeLink;
	}

	public void setYoutubeLink(WebElement youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	@FindBy(xpath = "//li[@class='list-social__item']")
	private List<WebElement> socialMediaLinks;

	public List<WebElement> getSocialMediaLinks() {
		return socialMediaLinks;
	}

	public void setSocialMediaLinks(List<WebElement> socialMediaLinks) {
		this.socialMediaLinks = socialMediaLinks;
	}

	@FindBy(xpath = "(//input[@type='search']/following-sibling::button[@type='submit'])[2]")
	private WebElement searchButton;

	public WebElement getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(WebElement searchButton) {
		this.searchButton = searchButton;
	}
	
	public String clickfacebook() {
		webdriverUtility.toScrollToElement(getFacebookLink(), driver);
		getFacebookLink().click();
		Set<String> windows = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equals(parent)) {
				driver.switchTo().window(window);
				break;
			}
		}
		return parent;
	}
	public String clickinstagram() {
		webdriverUtility.toScrollToElement(getInstagramLink(), driver);
		getInstagramLink().click();
		Set<String> windows1 = driver.getWindowHandles();
		String parent1 = driver.getWindowHandle();
		for (String window : windows1) {
			if (!window.equals(parent1)) {
				driver.switchTo().window(window);
				break;
			}
		}
		return parent1;
		
	}
	public String clickyoutube() {
		webdriverUtility.toScrollToElement(getYoutubeLink(), driver);
		getYoutubeLink().click();
		Set<String> windows2 = driver.getWindowHandles();
		String parent2 = driver.getWindowHandle();
		for (String window : windows2) {
			if (!window.equals(parent2)) {
				driver.switchTo().window(window);
				break;
			}
		}
		return parent2;
	}

	public void navigateBack() {
		driver.navigate().back();

	}
	public void refreshPage() {
		driver.navigate().refresh();
	}
	public void scrollToElement(WebElement element) {
		webdriverUtility.toScrollToElement(element, driver);
	}
	public void waitUnitlelementIsVisible(WebElement element) {
		webdriverUtility.waitUntilElementIsVisible(element);
	}
	public void clearCartAndNaviagteToHomepage() {
		driver.get("https://lovebeautyandplanet.in/cart/clear");
		getLogo().click();
	}
	public void clickFizzConcern() {
		getFrizzConcern().click();

	}
	public void clickHairFallConcern() {
		getHairFallConcern().click();

	}
	public void clickDamageConcern() {
		getDamageConcern().click();

	}
	public void clickSplitEndsConcern() {
		getSplitEndsConcern().click();

	}
	public void clickCurlCareConcern() {
		getCurlCareConcern().click();

	}
	public void clickDandruffConcern() {
		getDandruffConcern().click();

	}
	public void clickCartIcon() {
		
		getCartLink().click();
	}
	public void clickSearchIcon() {
		getSearchTextField().click();	
		}
	public void clickSearchButton() {
		getSearchButton().click();	}
	public void clickLogo() {
		getLogo().click();
	}

}