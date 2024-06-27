package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.appconstants.AppConstants;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.errors.AppErrors;
import com.qa.opencart.listeners.AnnotationTransformer;
import com.qa.opencart.listeners.ExtentReportListener;
import com.qa.opencart.listeners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 100: Design Open Cart Application with Shopping workflow" )
//@Listeners({TestAllureListener.class, ExtentReportListener.class})
//@Listeners() - only report will work, retry is not working here


@Story("US 101: Design login page for Open Cart Application")
public class LoginPageTest extends BaseTest {

	
	@Severity(SeverityLevel.MINOR)
	@Description("Checking login page title----")
	
	@Test(priority=1 )
	public void loginPageTitleTest() {
		
		String actTitle = loginPage.getLoginPageTitle();
		
	Assert.assertEquals(actTitle, "Account Login");
	}
	@Description("Checking login page url----")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2 )
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains("route=account/login"), AppErrors.URL_NOT_FOUND);
	}
	@Description("Checking forgot pwd link exist on the loginpage----")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3 )
	
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.checkForgotPwdLinkExist(), AppErrors.ELEMENT_NOT_FOUND);
	}
	
	@Description("checking user is able to login successfully----")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=4 )
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE, AppErrors.TITLE_NOT_FOUND);
	}
	
	
}
