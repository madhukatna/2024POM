package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.AccountsPage;
import com.qa.opencart.LoginPage;
import com.qa.opencart.ProductInfoPage;
import com.qa.opencart.RegisterPage;
import com.qa.opencart.SearchResultsPage;
import com.qa.opencart.factory.DriverFactory;

public class BaseTest {

	DriverFactory df;

	WebDriver driver;

	protected LoginPage loginPage;
	protected AccountsPage accPage;

	protected Properties prop;
	protected SearchResultsPage searchResultsPage;

	protected ProductInfoPage productInfoPage;

	protected SoftAssert softAssert;
	protected RegisterPage regPage;

	@Parameters({ "browser" })
	@BeforeTest

	public void setup(@Optional String browserName) {

		df = new DriverFactory();

		prop = df.initProp();
		if (browserName != null) {

			prop.setProperty("browser", browserName);

		}

		driver = df.initDriver(prop);

		loginPage = new LoginPage(driver);

		softAssert = new SoftAssert();

	}

	@AfterTest
	public void teardown() {

		driver.quit();

	}
}
