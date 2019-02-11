package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class BusSelectionPage extends TestBase {

	public BusSelectionPage() {
		PageFactory.initElements(driver, this);
	}

	// Selecting the bus operator.
	@FindBy(xpath = "//div[@id='filtersOnward']//span[text()='Operator ']")
	WebElement operatorOnForward;

	// Selecting the bus Travels 
	@FindBy(xpath = "//div[@id='filtersOnward']//label[contains(text(),'HP')]")
	WebElement selectTravels;

	@FindBy(xpath = "//div[@id='filtersReturn']//label[text()='HP Travels']")
	WebElement selectTravelsOnReturn;
	
	@FindBy(xpath = "//div[@id='filtersReturn']//span[text()='Operator ']")
	WebElement operatorOnReturn;

	public void selectBusOperator() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(operatorOnForward));
		operatorOnForward.click();
		selectTravels.click();
	}

	public void selectBusOperatorOnReturn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(operatorOnReturn));
		operatorOnReturn.click();
		selectTravelsOnReturn.click();
	}

	// Selecting the seat in the bus
	@FindBy(xpath = "(//span[text()='Select Seat'])[1]")
	WebElement selectSeatButton;

	public void clickOnSelectSeatButton() {
		selectSeatButton.click();
	}

	@FindBy(xpath = "(//span[text()='Select Seat'])[3]")
	WebElement selectReturnSeatButton;

	public void clickOnReturnSelectSeatButton() {
		selectReturnSeatButton.click();
	}

	// Available seats
	@FindBy(xpath = "//div[@id='seatSelect1']//ul/li[@class='sleeper available']/a")
	WebElement availableSeats;

	@FindBy(xpath = "(//li[@class='sleeper available']/a)[1]")
	WebElement availableSeat;

	public void selectAvailableSeat() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(availableSeat));
		availableSeat.click();
	}

	@FindBy(xpath = "(//li[@class='sleeper available']/a)[25]")
	WebElement availableSeatOnReturn;

	public void selectAvailableSeatOnReturn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(availableSeatOnReturn));
		availableSeatOnReturn.click();
	}

	// Finding the boarding point
	@FindBy(id = "boardingpoint_id1")
	WebElement boardingPoint;

	@FindBy(id = "boardingpoint_id2")
	WebElement boardingPointOnReturn;

	@FindBy(xpath = "//div[span[select[@id='boardingpoint_id1']]]/../div[@class='red-landmark']")
	WebElement boardingPointaddress;

	@FindBy(xpath = "//div[span[select[@id='boardingpoint_id2']]]/../div[@class='red-landmark']")
	WebElement boardingPointaddressOnReturnJourney;

	public void selectBoardingPoint() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boardingPoint.click();
		Select select = new Select(boardingPoint);
		select.selectByIndex(1);
		// Printing the boarding point address
		System.out.println("Boarding point address is :" + boardingPointaddress.getText());

	}

	public void selectBoardingPointOnReturnJourney() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boardingPointOnReturn.click();
		Select select = new Select(boardingPointOnReturn);
		select.selectByIndex(1);
		// Printing the boarding point address
		System.out.println("Boarding point address on return journey is :" + boardingPointaddressOnReturnJourney.getText());

	}

	// finding the total fare
	@FindBy(xpath = "//span[@id='totalfare']")
	WebElement amount;

	public WebElement amount() {
		System.out.println("Amount is :" + amount.getText());
		return amount;
	}

	@FindBy(xpath = "(//span[@id='totalfare'])[2]")
	WebElement amountOnReturnJourney;

	public void amountOnReturnJourney() {
		System.out.println("Amount is :" + amountOnReturnJourney.getText());
	}

	@FindBy(id = "btnEnable1")
	WebElement bookReturn;

	public void clickOnBookReturn() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		bookReturn.click();
	}

	@FindBy(xpath = "(//input[@id='btnEnable1'])[2]")
	WebElement continueToPayment;

	public void clickOnContinueToPaymentButton() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(continueToPayment));
		continueToPayment.click();
	}
}
