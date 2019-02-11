package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

public class PaymentPage extends TestBase{

	String actualMsg;
	String expectedMsg;
	WebDriverWait wait;

	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	// finding the webelements for boarding points and jorney details
	
	@FindBy(xpath = "//h3[text()='Onward Journey Details']/../following-sibling::div/div/p[contains(text(),'Boarding')]/strong")
	WebElement boardingPointOnOnwardJourney;

	@FindBy(xpath = "//h3[text()='Return Journey Details']/../following-sibling::div/div/p[contains(text(),'boarding')]/strong")
	WebElement boardingPointOnReturnJourney;

	@FindBy(xpath = "//div[h3[text()='Onward Journey Details']]/following-sibling::div[1]/div[1]/h3/strong")
	WebElement onwardJryDetails;

	@FindBy(xpath = "//div[h3[text()='Return Journey Details']]/following-sibling::div[1]/div[1]/h3/strong")
	WebElement returnJryDetails;


	public void validateOnwardJryDetails(String leavingFrom, String goingTo) {
		actualMsg = onwardJryDetails.getText();
		System.out.println(actualMsg);
		expectedMsg = leavingFrom +" To "+ goingTo;
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	public void validateReturnJryDetails(String goingTo, String leavingFrom ) {
		actualMsg = returnJryDetails.getText();
		System.out.println(actualMsg);
		expectedMsg = goingTo +" To "+ leavingFrom;
		Assert.assertEquals(actualMsg, expectedMsg);
	}



	public void validateBoardingPointOnOnwardJourney() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(boardingPointOnOnwardJourney));
		actualMsg = boardingPointOnOnwardJourney.getText();
		expectedMsg = "Mini ByePass Road";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	public void validateBoardingPointOnReturnJourney() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(boardingPointOnReturnJourney));
		actualMsg = boardingPointOnReturnJourney.getText();
		expectedMsg = "Anand Rao Circle";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@FindBy(id = "NetAmountmsg")
	WebElement netPayable;

	public void netPayable() {
		System.out.println("Net payable amount is : " +netPayable.getText());		
	}
}
