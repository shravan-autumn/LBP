package pomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import genericUtility.BaseClass;
import genericUtility.webdriverUtility;

public class loginPage  {
	WebDriver driver;

	public loginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "CustomerEmail")
	private WebElement emailTextField;

	@FindBy(id = "CustomerPassword")
	private WebElement passwordTextField;

	@FindBy(id = "customer-login-submit")
	private WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'create account')]")
	private WebElement createAccountLink;

	@FindBy(id = "RegisterForm-FirstName")
	private WebElement firstNameTextField;

	@FindBy(id = "RegisterForm-LastName")
	private WebElement lastNameTextField;

	@FindBy(id = "RegisterForm-email")
	private WebElement registerEmailTextField;

	@FindBy(id = "RegisterForm-Phone")
	private WebElement phoneTextField;

	@FindBy(id = "RegisterForm-password")
	private WebElement registerPasswordTextField;

	@FindBy(id = "confirm_password")
	private WebElement confirmPasswordTextField;

	@FindBy(id = "myCheckbox_reg")
	private WebElement checkbox;

	@FindBy(id = "customer-register-submit")
	private WebElement signupButton;

	@FindBy(xpath = "//h1[@class='customer__title']")
	private WebElement accountTitle;

	@FindBy(xpath = "//a[@href='/account/logout']")
	private WebElement logoutLink;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(WebElement emailTextField) {
		this.emailTextField = emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(WebElement passwordTextField) {
		this.passwordTextField = passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}

	public void setCreateAccountLink(WebElement createAccountLink) {
		this.createAccountLink = createAccountLink;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public void setFirstNameTextField(WebElement firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public void setLastNameTextField(WebElement lastNameTextField) {
		this.lastNameTextField = lastNameTextField;
	}

	public WebElement getRegisterEmailTextField() {
		return registerEmailTextField;
	}

	public void setRegisterEmailTextField(WebElement registerEmailTextField) {
		this.registerEmailTextField = registerEmailTextField;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public void setPhoneTextField(WebElement phoneTextField) {
		this.phoneTextField = phoneTextField;
	}

	public WebElement getRegisterPasswordTextField() {
		return registerPasswordTextField;
	}

	public void setRegisterPasswordTextField(WebElement registerPasswordTextField) {
		this.registerPasswordTextField = registerPasswordTextField;
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	public void setConfirmPasswordTextField(WebElement confirmPasswordTextField) {
		this.confirmPasswordTextField = confirmPasswordTextField;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(WebElement checkbox) {
		this.checkbox = checkbox;
	}

	public WebElement getSignupButton() {
		return signupButton;
	}

	public void setSignupButton(WebElement signupButton) {
		this.signupButton = signupButton;
	}

	public WebElement getAccountTitle() {
		return accountTitle;
	}

	public void setAccountTitle(WebElement accountTitle) {
		this.accountTitle = accountTitle;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void setLogoutLink(WebElement logoutLink) {
		this.logoutLink = logoutLink;
	}

	
	
	public void createAccount(String firstName, String lastName, String email, String phone, String password) {
		createAccountLink.click();
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		registerEmailTextField.sendKeys(email);
		phoneTextField.sendKeys(phone);
		registerPasswordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(password);
		webdriverUtility.toScrollToElement(signupButton, driver);
		webdriverUtility.waitUntilElementIsVisible(signupButton);
		checkbox.click();
		signupButton.click();

	}

	public void login(String email, String password) {
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}

	public void goToWebsite() {
		driver.get("https://lovebeautyandplanet.in/");

	}

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	private WebElement acceptCookiesButton;

	public void acceptCookiesIfPresent() {
		try {
			if (acceptCookiesButton.isDisplayed()) {
				acceptCookiesButton.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
