package com.koch.automation.Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.koch.automation.basePage.BasePage;
import com.koch.automation.pageObjects.IxigoPage;
import com.koch.automation.utils.ActionUtils;

public class IxigoTest {
	@Test
	public void bookATicketFromIxigoTest() throws InterruptedException {
		SoftAssert sa=new SoftAssert();
		WebDriver driver=BasePage.getDriver();
		driver.get("https://www.ixigo.com/");
		String expectedTitle="ixigo - Flights, Train Reservation, Hotels, Air Tickets, Bus Booking";
		String actualTitle=driver.getTitle();
		sa.assertEquals(actualTitle, expectedTitle, "Title does not matches");
		IxigoPage.getHomePage().clickRoundTrip();
		ActionUtils.waitForVisibiltyOfWebElement(driver, IxigoPage.getHomePage().getFrom(), 20);
		IxigoPage.getHomePage().setFrom("PNQ - Pune");
		ActionUtils.waitForVisibiltyOfWebElement(driver, IxigoPage.getHomePage().getFromSel(), 20);
		IxigoPage.getHomePage().clickFromSel();
		ActionUtils.waitForVisibiltyOfWebElement(driver, IxigoPage.getHomePage().getTo(), 20);
		IxigoPage.getHomePage().setTo("HYD - Hyderabad");
		ActionUtils.waitForVisibiltyOfWebElement(driver, IxigoPage.getHomePage().getToSel(), 20);
		IxigoPage.getHomePage().clickToSel();
		IxigoPage.getHomePage().clickDepartureDateInputField();
		ActionUtils.waitForVisibiltyOfWebElement(driver, IxigoPage.getHomePage().getDepartureDate(), 20);
		IxigoPage.getHomePage().setDepartureDate();
		ActionUtils.waitForVisibiltyOfWebElement(driver, IxigoPage.getHomePage().getReturnDate(), 20);
		IxigoPage.getHomePage().setReturnDate();
		ActionUtils.waitForVisibiltyOfWebElement(driver, IxigoPage.getHomePage().getTravellers(), 20);
		IxigoPage.getHomePage().setTravellers();
		IxigoPage.getHomePage().clickTravellersCloseButton();
		IxigoPage.getHomePage().clickSearchButton();
		ActionUtils.waitForVisibiltyOfWebElement(driver, IxigoPage.getHomePage().getStopFilterOption(), 60);
		String expResPageTitle="Pune - Hyderabad, Economy Flights, roundtrip, 17 Sep - 24 Oct";
		String actResPageTitle=driver.getTitle();
		sa.assertEquals(actResPageTitle, expResPageTitle, "Result page Title does not matches");
		ActionUtils.waitForVisibiltyOfWebElement(driver, IxigoPage.getHomePage().getStopFilterOption(), 40);
		sa.assertTrue(IxigoPage.getHomePage().isStopFilterOptionDisplayed(), "Stop filter opion did not display");
		sa.assertTrue(IxigoPage.getHomePage().isDepartureFilterOptionDisplayed(), "Departure filter opion did not display");
		sa.assertTrue(IxigoPage.getHomePage().isAirlinesFilterOptionDisplayed(), "Airline filter opion did not display");
		IxigoPage.getHomePage().clickNonStopOption();
		List<WebElement>  flights=driver.findElements(By.className("summary-section"));
		for(int i=1;i<flights.size();i++) {
			String priceValue=flights.get(i).findElement(By.className("price")).getText();
			int fair=Integer.parseInt(priceValue);
			if(fair<5000) {
				System.out.println("Fare is :"+fair);
				String departureTime=flights.get(i).findElement(By.className("time-group")).findElement(By.className("time")).getText();
				System.out.println("Departure Time is : "+departureTime);
				String airlineNumberWithName=flights.get(i).findElement(By.className("time-group")).findElement(By.xpath("//div[@class='u-text-ellipsis']")).getText();
				String airlineNumber=ActionUtils.getIntegerValueFromString(airlineNumberWithName);
				System.out.println("AirlineNumber is : "+airlineNumber);
			}
		}
		sa.assertAll();
		driver.close();
	}
}
