package com.qa.TestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.BusSelectionPage;
import com.qa.pages.HomePage;
import com.qa.pages.PaymentPage;

public class LoginPageTest extends TestBase {

	// Before class Assertion is used to launch the browser once .
	@BeforeClass
	public void launchBrowserTest() {
		TestBase.launchBrowser();
	}

	// Main method starts from here
	@Test
	public void homePagetest() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.verifyAbhiBusLogo();
		homePage.mouseOverAndValidateLogo();
		homePage.selectLeavingFrom(prop.getProperty("leavingFrom"));
		homePage.selectGoingTo(prop.getProperty("goingTo"));
		homePage.clickOnDateOfJourney();
		homePage.clickOnReturnJourney();
		homePage.clickOnSearchButton();

		// Creating an object for bus selection page.
		// Selecting the bus ticket for onward journey.
		BusSelectionPage busSelectionPage = new BusSelectionPage();
		busSelectionPage.selectBusOperator();
		busSelectionPage.clickOnSelectSeatButton();
		busSelectionPage.selectAvailableSeat();
		busSelectionPage.selectBoardingPoint();
		busSelectionPage.amount();

		// Selecting the bus ticket for return journey
		busSelectionPage.clickOnBookReturn();
		busSelectionPage.selectBusOperatorOnReturn();
		busSelectionPage.clickOnReturnSelectSeatButton();
		busSelectionPage.selectAvailableSeatOnReturn();
		busSelectionPage.selectBoardingPointOnReturnJourney();
		busSelectionPage.amountOnReturnJourney();
		busSelectionPage.clickOnContinueToPaymentButton();

		// Payment page details
		PaymentPage paymentPage = new PaymentPage();
		paymentPage.validateBoardingPointOnOnwardJourney();
		paymentPage.validateBoardingPointOnReturnJourney();
		paymentPage.validateOnwardJryDetails(prop.getProperty("leavingFrom"), prop.getProperty("goingTo"));
		paymentPage.validateReturnJryDetails(prop.getProperty("goingTo"), prop.getProperty("leavingFrom"));
		paymentPage.netPayable();
	}

	@AfterClass
	public void closeBrowserTest() {
		driver.quit();
	}
}
