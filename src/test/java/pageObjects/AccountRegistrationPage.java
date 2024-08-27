package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(id = "input-confirm")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setConfirmPassword(String confirmpwd) {
		txtConfirmPassword.sendKeys(confirmpwd);
	}

	public void checkPolicy() {
		checkPolicy.click();
	}

	public void clickContinue() {

		// sol1
		btnContinue.click();

		// sol2
		/*
		 * btnContinue.submit();
		 * 
		 * // sol3 Actions act = new Actions(driver);
		 * act.moveToElement(btnContinue).click().perform();
		 * 
		 * // sol4 JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", btnContinue);
		 * 
		 * // sol5 btnContinue.sendKeys(Keys.RETURN);
		 * 
		 * // sol6 WebDriverWait mywait = new WebDriverWait(driver,
		 * Duration.ofSeconds(10));
		 * mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		 */
	}

	public String messageConfirmation() {

		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			// TODO: handle exception
			return (e.getMessage());
		}

	}

}
