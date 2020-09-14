package com.koch.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.koch.automation.basePage.BasePage;
import com.koch.automation.utils.ActionUtils;

public class HomePage extends BasePage {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Round Trip']")
	private WebElement roundTrip;

	public WebElement getRoundTrip() {
		return this.roundTrip;
	}
	public void clickRoundTrip() {
		getRoundTrip().click();
	}


	@FindBy(xpath="//div[text()='From']/following-sibling::input")
	private WebElement from;

	public WebElement getFrom() {
		return this.from;
	}
	public void setFrom(String fromAddress) {
		getFrom().sendKeys(fromAddress);
	}


	@FindBy(xpath="(//div[contains(text(),'PNQ - Pune, India')])[1]")
	private WebElement fromSel;

	public WebElement getFromSel() {
		return this.fromSel;
	}
	public void clickFromSel() {
		getFromSel().click();
	}


	@FindBy(xpath="//div[text()='To']/following-sibling::input")
	private WebElement to;

	public WebElement getTo() {
		return this.to;
	}
	public void setTo(String toAddress) {
		getTo().sendKeys(toAddress);
	}

	@FindBy(xpath="(//div[contains(text(),'Rajiv Gandhi International Airport')])[1]")
	private WebElement toSel;

	public WebElement getToSel() {
		return this.toSel;
	}
	public void clickToSel() {
		getToSel().click();
	}

	@FindBy(xpath="//div[text()='Departure']/following-sibling::input")
	private WebElement departureDateInputField;

	public WebElement getDepartureDateInputField() {
		return this.departureDateInputField;
	}
	public void clickDepartureDateInputField() {
		getDepartureDateInputField().click();
	}

	@FindBy(xpath="//td[@data-date='17092020']")
	private WebElement departureDate;

	public WebElement getDepartureDate() {
		return this.departureDate;
	}
	public void setDepartureDate() {
		getDepartureDate().click();
	}


	@FindBy(xpath="//div[@class='rd-container flight-ret-cal extra-bottom rd-container-attachment arrow-animation']//td[@data-date='24102020']")
	private WebElement returnDate;

	public WebElement getReturnDate() {
		return this.returnDate;
	}
	public void setReturnDate() {
		returnDate.click();
	}

	@FindBy(xpath="(//span[@data-val='2'])[1]")
	private WebElement travellers;

	public WebElement getTravellers() {
		return this.travellers;
	}
	public void setTravellers() {
		getTravellers().click();
	}

	@FindBy(xpath="//div[@class='close-btn u-pos-abs ixi-icon-cross']")
	private WebElement travellersCloseButton;

	public WebElement getTravellersCloseButton() {
		return this.travellersCloseButton;
	}
	public void clickTravellersCloseButton() {
		getTravellersCloseButton().click();
	}

	@FindBy(xpath="//div[@class='search u-ib u-v-align-bottom']//span[@class='u-ripple-circle']")
	private WebElement searchButton;

	public WebElement getSearchButton() {
		return this.searchButton;
	}
	public void clickSearchButton() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.querySelector(\"div[class='search u-ib u-v-align-bottom'] span[class='u-ripple-circle']\").click();");
	}


	@FindBy(xpath="//div[contains(text(),'Stops')]")
	private WebElement stopFilterOption;

	public WebElement getStopFilterOption() {
		return this.stopFilterOption;
	}
	public Boolean isStopFilterOptionDisplayed() {
		return getStopFilterOption().isDisplayed();
	}

	@FindBy(xpath="//div[contains(text(),'Departure from PNQ')]")
	private WebElement departureFilterOption;

	public WebElement getDepartureFilterOption() {
		return this.departureFilterOption;
	}
	public Boolean isDepartureFilterOptionDisplayed() {
		return getDepartureFilterOption().isDisplayed();
	}

	@FindBy(xpath="//div[contains(text(),'Airlines')]")
	private WebElement airlinesFilterOption;

	public WebElement getAirlinesFilterOption() {
		return this.airlinesFilterOption;
	}
	public Boolean isAirlinesFilterOptionDisplayed() {
		return getAirlinesFilterOption().isDisplayed();
	}
	@FindBy(xpath="(//span[@class='ixi-icon-tick check-icon'])[1]")
	private WebElement nonStopOption;

	public WebElement getNonStopOption() {
		return this.nonStopOption;
	}
	public void clickNonStopOption() {
		getNonStopOption().click();
	}


}
