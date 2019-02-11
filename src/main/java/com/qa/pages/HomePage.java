package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	boolean flag;

	// Creating the webelements in the home page by using locators.

	@FindBy(xpath = "//div[@class='mainheader']/div/a/img")
	WebElement abhiBusLogo;

	@FindBy(id = "source")
	WebElement leavingFrom;

	@FindBy(xpath = "//ul[@id='ui-id-1']/li[1]")
	WebElement leavingFromDropDown;

	@FindBy(id = "destination")
	WebElement goingTo;

	@FindBy(xpath = "//ul[@id='ui-id-2']/li[1]")
	WebElement goingToDropDown;

	@FindBy(id = "datepicker1")
	WebElement dateOfJourney;

	@FindBy(id = "todaydiv")
	WebElement selectTodaysDate;

	@FindBy(id = "datepicker2")
	WebElement dateOfReturnJourney;

	@FindBy(id = "tomorrowdiv")
	WebElement selectTomorrowsDate;

	public boolean verifyAbhiBusLogo() {
		flag = abhiBusLogo.isDisplayed();
		if (flag) {
			System.out.println("Abhi bus logo is displayed");
		} else {
			System.out.println("Abhi bus logo is not displayed");
			Assert.assertTrue(false);
		}
		return flag;
	}

	public void mouseOverAndValidateLogo() {
		Actions actions = new Actions(driver);
		actions.moveToElement(abhiBusLogo).build().perform();
		String actualMsg = abhiBusLogo.getAttribute("alt");
		String expectedMsg = "abhibus.com - India's Fastest Online bus ticket booking site";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	public void selectLeavingFrom(String leavingFrom) {
		this.leavingFrom.sendKeys(leavingFrom);
		Actions action = new Actions(driver);
		action.moveToElement(leavingFromDropDown).click().build().perform();
	}

	public void selectGoingTo(String goingTo) {
		this.goingTo.sendKeys(goingTo);
		Actions action = new Actions(driver);
		action.moveToElement(goingToDropDown).click().build().perform();
		// this.goingTo.sendKeys(Keys.ENTER);
	}

	public void clickOnDateOfJourney() {
		dateOfJourney.click();
		selectTodaysDate.click();
	}

	public void clickOnReturnJourney() {
		dateOfReturnJourney.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		selectTomorrowsDate.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//div[@id='roundTrip']/a")
	WebElement searchButton;

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public boolean isAbhiBusLogoVisible() throws InterruptedException {
		flag = false;
		flag = abhiBusLogo.isDisplayed();
		if (flag) {
			System.out.println("Abhi bus logo is displayed successfully");
		} else {
			System.out.println("Abhi bus logo is not displayed");
			Assert.assertTrue(false);
		}
		return flag;
	}
}
