package pomScripts;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtility.BaseClass;
import genericUtility.webdriverUtility;

public class productListingPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public productListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@FindBy(xpath = "//span[@class='facet-checkbox__text']")
	private List<WebElement> allFilters;

	public List<WebElement> getAllFilters() {
		return allFilters;
	}

	public void setAllFilters(List<WebElement> allFilters) {
		this.allFilters = allFilters;
	}

	@FindBy(xpath = "//b[@id='verticalTitle']")
	private WebElement filterHeading;
	@FindBy(xpath = "//a[@class='active-facets__button active-facets__button--light']")
	private List<WebElement> appliedFilter;
	@FindBy(xpath = "(//span[text()='Clear all'])[1]")
	private WebElement clearAllLink;

	public WebElement getFilterHeading() {
		return filterHeading;
	}

	public void setFilterHeading(WebElement filterHeading) {
		this.filterHeading = filterHeading;
	}

	public List<WebElement> getAppliedFilter() {
		return appliedFilter;
	}

	public void setAppliedFilter(List<WebElement> appliedFilter) {
		this.appliedFilter = appliedFilter;
	}

	public WebElement getClearAllLink() {
		return clearAllLink;
	}

	public void setClearAllLink(WebElement clearAllLink) {
		this.clearAllLink = clearAllLink;
	}

	@FindBy(xpath = "//p[@class='h-pro-card-cnt-description']")
	private List<WebElement> productTitlesPLP;

	public List<WebElement> getProductTitlesPLP() {
		return productTitlesPLP;
	}

	public void setProductTitlesPLP(List<WebElement> productTitlesPLP) {
		this.productTitlesPLP = productTitlesPLP;
	}

	@FindBy(xpath = "//button[@name='add']")
	private List<WebElement> addToCartButtons;

	public List<WebElement> getAddToCartButtons() {
		return addToCartButtons;
	}

	public void setAddToCartButtons(List<WebElement> addToCartButtons) {
		this.addToCartButtons = addToCartButtons;
	}

	@FindBy(xpath = "//div[@class='add-to-cart-pop']")
	private WebElement addToCartPopup;
	@FindBy(xpath = "//button[@id='view-cart-drawer']")
	private WebElement viewCartButton;

	public WebElement getAddToCartPopup() {
		return addToCartPopup;
	}

	public void setAddToCartPopup(WebElement addToCartPopup) {
		this.addToCartPopup = addToCartPopup;
	}

	public WebElement getViewCartButton() {
		return viewCartButton;
	}

	public void setViewCartButton(WebElement viewCartButton) {
		this.viewCartButton = viewCartButton;
	}

	@FindBy(xpath = "//h2[text()='you may also like']")
	private WebElement youMayAlsoLikeSection;
	@FindBy(xpath = "//h2[text()='Beauty Archives']")
	private WebElement beautyArchivesSection;
	@FindBy(xpath = "//a[text()='View all']")
	private WebElement viewAllLink;
	@FindBy(xpath = "//h2[text()='faqs']")
	private WebElement faqsSection;
	@FindBy(xpath = "//a[text()='Write to us']")
	private WebElement writeToUsLink;

	public WebElement getYouMayAlsoLikeSection() {
		return youMayAlsoLikeSection;
	}

	public void setYouMayAlsoLikeSection(WebElement youMayAlsoLikeSection) {
		this.youMayAlsoLikeSection = youMayAlsoLikeSection;
	}

	public WebElement getBeautyArchivesSection() {
		return beautyArchivesSection;
	}

	public void setBeautyArchivesSection(WebElement beautyArchivesSection) {
		this.beautyArchivesSection = beautyArchivesSection;
	}

	public WebElement getViewAllLink() {
		return viewAllLink;
	}

	public void setViewAllLink(WebElement viewAllLink) {
		this.viewAllLink = viewAllLink;
	}

	public WebElement getFaqsSection() {
		return faqsSection;
	}

	public void setFaqsSection(WebElement faqsSection) {
		this.faqsSection = faqsSection;
	}

	public WebElement getWriteToUsLink() {
		return writeToUsLink;
	}

	public void setWriteToUsLink(WebElement writeToUsLink) {
		this.writeToUsLink = writeToUsLink;
	}

	@FindBy(xpath = "//div[@class='result-product-item-info h-pro-card-cnt']//a")
	private List<WebElement> productLinksSearchPLP;

	public List<WebElement> getProductLinksSearchPLP() {
		return productLinksSearchPLP;
	}

	public void setProductLinksSearchPLP(List<WebElement> productLinksSearchPLP) {
		this.productLinksSearchPLP = productLinksSearchPLP;
	}

	public void plpNavigation() {
		lp=new loginPage(driver);
		hp=new homePage(driver);
		lp.goToWebsite();
		hp.getMegamenuOffersLink().click();
		hp.getBuy3At1399Link().click();
	}

	public void applyFilters() {
		plp = new productListingPage(driver);
		List<String> expectedFilters = Arrays.asList("Onion & Rosemary", "Hair Care");

		int selectedCount = 0;

		for (int i = 0; i < plp.getAllFilters().size(); i++) {

			String filterText = plp.getAllFilters().get(i).getText();

			webdriverUtility.toScrollToElement(plp.getAllFilters().get(i), driver);

			if (expectedFilters.contains(filterText)) {

				plp.getAllFilters().get(i).click();
				selectedCount++;

				webdriverUtility.waitForPageToLoad(driver);

				if (selectedCount == expectedFilters.size()) {
					break;
				}
			}
		}

	}

	public String filteredProducts() {
		plp = new productListingPage(driver);
		WebElement firstProduct = plp.getProductTitlesPLP().get(0);
		webdriverUtility.waitUntilElementIsVisible(firstProduct);
		Actions actions = new Actions(driver);
		actions.moveToElement(firstProduct).perform();
		webdriverUtility.waitUntilClickable(firstProduct);
		String productTitle = firstProduct.getText();
		firstProduct.click();

		webdriverUtility.waitForPageToLoad(driver);
		return productTitle;
	}

	public void clearFilters() throws Exception {
		Thread.sleep(2000);
		plp = new productListingPage(driver);
		webdriverUtility.toScrollToElement(plp.getFilterHeading(), driver);
		plp.getClearAllLink().click();
		webdriverUtility.waitForPageToLoad(driver);
	}

	public String addToCart() {
		plp = new productListingPage(driver);
		WebElement firstProduct = plp.getProductTitlesPLP().get(0);
		webdriverUtility.waitUntilElementIsVisible(firstProduct);
		String product = firstProduct.getText();
		webdriverUtility.toScrollToElement(plp.getProductTitlesPLP().get(0), driver);
		webdriverUtility.toScrollToElement(plp.getAddToCartButtons().get(0), driver);
		plp.getAddToCartButtons().get(0).click();
		webdriverUtility.waitUntilElementIsVisible(plp.getViewCartButton());
		plp.getViewCartButton().click();
		return product;
	}

	public void viewAll() {
		webdriverUtility.toScrollToElement(plp.getViewAllLink(), driver);
		plp.getViewAllLink().click();
		webdriverUtility.waitForPageToLoad(driver);
	}

	public void faqsSection() {
		webdriverUtility.toScrollToElement(plp.getFaqsSection(), driver);
		webdriverUtility.waitUntilElementIsVisible(plp.getFaqsSection());
	}

	public void writeToUs() {
		webdriverUtility.toScrollToElement(plp.getWriteToUsLink(), driver);
		plp.getWriteToUsLink().click();
		webdriverUtility.waitForPageToLoad(driver);
	}
	public void refreshPage() {
		driver.navigate().refresh();
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public void scrollToElement(WebElement element) {
		webdriverUtility.toScrollToElement(element, driver);
	}
}
