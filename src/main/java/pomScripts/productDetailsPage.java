package pomScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtility.webdriverUtility;

public class productDetailsPage {

	WebDriver driver;
	WebDriverWait wait;
	loginPage lp;
	homePage hp;
	productListingPage plp;

	public productDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@FindBy(xpath = "//div[@class='product__title']")
	private WebElement productTitlePDP;

	public WebElement getProductTitle() {
		return productTitlePDP;
	}

	public void setProductTitle(WebElement productTitle) {
		this.productTitlePDP = productTitle;
	}

	@FindBy(xpath = "//a[text()='View Products']")
	private WebElement viewAllProductsLink;

	@FindBy(xpath = "//span[contains(text(), 'Buy any 3 products at ₹1399 only')]/parent::div[@class='pdp-offer']//a")
	private WebElement viewBundleProductsLink;
	@FindBy(xpath = "//input[@id='pincode']")
	private WebElement pincodeTextField;
	@FindBy(xpath = "//button[@class='submit-pincode-button']")
	private WebElement checkButton;
	@FindBy(xpath = "//div[@class='pincode-response-container']//p")
	private WebElement invalidPincodeErrorMessage;
	@FindBy(xpath = "//p[@id='order-timeline']")
	private WebElement validPincodeErrorMessage;
	@FindBy(xpath = "//product-form[@class='product-form pdp-atc']")
	private WebElement addToCartButton;
	@FindBy(xpath = "//quantity-input[@class='quantity cart-quantity pdp-quantity ']//button[@type='button']")
	private WebElement quantityMinusButton;
	@FindBy(xpath = "//div[@class='pdp-quantity-selector product-form__input product-form__quantity']//button[@name='plus']")
	private WebElement quantityPlusButton;

	public WebElement getProductTitlePDP() {
		return productTitlePDP;
	}

	public void setProductTitlePDP(WebElement productTitlePDP) {
		this.productTitlePDP = productTitlePDP;
	}

	public WebElement getViewAllProductsLink() {
		return viewAllProductsLink;
	}

	public void setViewAllProductsLink(WebElement viewAllProductsLink) {
		this.viewAllProductsLink = viewAllProductsLink;
	}

	public WebElement getViewBundleProductsLink() {
		return viewBundleProductsLink;
	}

	public void setViewBundleProductsLink(WebElement viewBundleProductsLink) {
		this.viewBundleProductsLink = viewBundleProductsLink;
	}

	public WebElement getPincodeTextField() {
		return pincodeTextField;
	}

	public void setPincodeTextField(WebElement pincodeTextField) {
		this.pincodeTextField = pincodeTextField;
	}

	public WebElement getCheckButton() {
		return checkButton;
	}

	public void setCheckButton(WebElement checkButton) {
		this.checkButton = checkButton;
	}

	public WebElement getInvalidPincodeErrorMessage() {
		return invalidPincodeErrorMessage;
	}

	public void setInvalidPincodeErrorMessage(WebElement invalidPincodeErrorMessage) {
		this.invalidPincodeErrorMessage = invalidPincodeErrorMessage;
	}

	public WebElement getValidPincodeErrorMessage() {
		return validPincodeErrorMessage;
	}

	public void setValidPincodeErrorMessage(WebElement validPincodeErrorMessage) {
		this.validPincodeErrorMessage = validPincodeErrorMessage;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public void setAddToCartButton(WebElement addToCartButton) {
		this.addToCartButton = addToCartButton;
	}

	public WebElement getQuantityMinusButton() {
		return quantityMinusButton;
	}

	public void setQuantityMinusButton(WebElement quantityMinusButton) {
		this.quantityMinusButton = quantityMinusButton;
	}

	public WebElement getQuantityPlusButton() {
		return quantityPlusButton;
	}

	public void setQuantityPlusButton(WebElement quantityPlusButton) {
		this.quantityPlusButton = quantityPlusButton;
	}

	@FindBy(xpath = "//button[@id='view-cart-drawer']")
	private WebElement viewCartDrawerButton;

	public WebElement getViewCartDrawerButton() {
		return viewCartDrawerButton;
	}

	public void setViewCartDrawerButton(WebElement viewCartDrawerButton) {
		this.viewCartDrawerButton = viewCartDrawerButton;
	}

	@FindBy(xpath = "//product-info//quantity-input[@class='quantity cart-quantity pdp-quantity ']//input[@type='number']")
	private WebElement quantityTextField;

	public WebElement getQuantityTextField() {
		return quantityTextField;
	}

	public void setQuantityTextField(WebElement quantityTextField) {
		this.quantityTextField = quantityTextField;
	}

	@FindBy(xpath = "//div[@class='yotpo-main-layout yotpo-main-reviews-widget yotpo-main-widget-layout-reviews']")
	private WebElement reviewSection;
	@FindBy(xpath = "//section[@class='pdp-details-sec']")
	private WebElement detailsTab;
	@FindBy(xpath = "//div[@class='shopify-block shopify-app-block']")
	private WebElement reelSection;
	@FindBy(xpath = "//section[@class='pdp-collection rekated_product ymal']")
	private WebElement youMayAlsoLikeSection;

	public WebElement getReviewSection() {
		return reviewSection;
	}

	public void setReviewSection(WebElement reviewSection) {
		this.reviewSection = reviewSection;
	}

	public WebElement getDetailsTab() {
		return detailsTab;
	}

	public void setDetailsTab(WebElement detailsTab) {
		this.detailsTab = detailsTab;
	}

	public WebElement getReelSection() {
		return reelSection;
	}

	public void setReelSection(WebElement reelSection) {
		this.reelSection = reelSection;
	}

	public WebElement getYouMayAlsoLikeSection() {
		return youMayAlsoLikeSection;
	}

	public void setYouMayAlsoLikeSection(WebElement youMayAlsoLikeSection) {
		this.youMayAlsoLikeSection = youMayAlsoLikeSection;
	}

	@FindBy(xpath = "//product-form[@class='product-form pdp-atc']")//"(//div[@class='product-form__buttons'])[5]"
	private WebElement addToCart2;

	public WebElement getAddToCart2() {
		return addToCart2;
	}

	public void setAddToCart2(WebElement addToCart2) {
		this.addToCart2 = addToCart2;
	}

	@FindBy(xpath = "//div[@class='sing-product-variant']//span[@class='pro-variant-price']")
	private WebElement productPrice;

	public WebElement getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(WebElement productPrice) {
		this.productPrice = productPrice;
	}

	public String pdpNavigation() throws Exception {
		lp = new loginPage(driver);
		hp = new homePage(driver);
		lp.goToWebsite();
		hp.getSearchTextField().click();
		Thread.sleep(2000);
		hp.getSearchTextField().sendKeys("hair");
		hp.getSearchButton().click();
		plp = new productListingPage(driver);
		String product = "Onion, Black Seed Oil & Patchouli Hair Mask";
		for (WebElement ele : plp.getProductLinksSearchPLP()) {
			if (ele.getText().equalsIgnoreCase(product)) {
				ele.click();
				break;
			}
		}
		return product;
	}

	public void invalidPincode() {
		webdriverUtility.toScrollToElement(getPincodeTextField(), driver);
		getPincodeTextField().sendKeys("123456");
		getCheckButton().click();
		webdriverUtility.toScrollToElement(getAddToCartButton(), driver);
		webdriverUtility.waitUntilElementIsVisible(invalidPincodeErrorMessage);
	}

	public void validPincode() {
		webdriverUtility.toScrollToElement(getPincodeTextField(), driver);
		getPincodeTextField().clear();
		getPincodeTextField().sendKeys("560037");
		getCheckButton().click();
		webdriverUtility.toScrollToElement(getAddToCartButton(), driver);
	}

	public String addToCartFromPDP() {
		String product = getProductTitle().getText();
		webdriverUtility.toScrollToElement(getAddToCartButton(), driver);
		getAddToCartButton().click();
		return product;
	}

	public void increaseQuantityFromPDP() throws InterruptedException {
		webdriverUtility.toScrollToElement(getQuantityPlusButton(), driver);
		getQuantityPlusButton().click();
	}

	public void decreaseQuantityFromPDP() throws InterruptedException {
		webdriverUtility.toScrollToElement(getQuantityMinusButton(), driver);
		getQuantityMinusButton().click();
	}

	public void clickViewAllProducts() {
		getViewAllProductsLink().click();
	}

	public void clickViewBundleProduct() {
		getViewBundleProductsLink().click();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void scrollToElement(WebElement element) {
		webdriverUtility.toScrollToElement(element, driver);
	}

	public void clickAddtoCart2() {
		getAddToCart2().click();
	}

	public void clickAddtoCart() {
		getAddToCartButton().click();
	}

	public void waitUntilElementIsVisible(WebElement element) {
		webdriverUtility.waitUntilElementIsVisible(element);
	}

}
