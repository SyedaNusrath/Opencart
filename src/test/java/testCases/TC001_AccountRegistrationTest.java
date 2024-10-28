package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest*****");
		try
		{

		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account link....");
		
		hp.clickRegister();
		logger.info("clicked on registration link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumeric());
		
		String pwd=randomAlphaNumeric();
		
		regpage.setPassword(pwd);
		regpage.setConfirmPassword(pwd);
		regpage.setPrivacyPolicy() ;
		regpage.setClickContinue();
		
		logger.info("checking the message");
		String confmsg=regpage.getConfirmationMessage();	
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
	
		logger.info("*****Finished TC001_AccountRegistrationTest*****");
	}
	
}
