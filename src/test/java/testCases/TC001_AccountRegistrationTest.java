package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException {
		logger.info("********* Starting TC001_AccountRegistrationTest *********");
		try {
			HomePage hp = new HomePage(driver);
			
			hp.clickMyAccount();
			logger.info("------Clicked on My Account Link------");
			
			hp.clickRegister();
			logger.info("------Clicked on My Register Link------");
			
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("------Providing customer details------");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com");
			regpage.setTelephone(randomNumber());

			String password = randomAlphaNumeric();

			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.checkPolicy();
			regpage.clickContinue();
			
			logger.info("------Validating expected message------");
			String confmsg = regpage.messageConfirmation();
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else {
				logger.error("TEST FAILED!........");
				logger.debug("Debug logs........ ");
				Assert.assertTrue(false);
			}
			
			//Assert.assertEquals(confmsg, "Your Account Hasgdg Been Created!");
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}
		
		logger.info("********* Finished TC001_AccountRegistrationTest *********");

		
	}

}
