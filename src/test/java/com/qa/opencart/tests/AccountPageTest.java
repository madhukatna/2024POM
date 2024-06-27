package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.appconstants.AppConstants;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.errors.AppErrors;

public class AccountPageTest extends BaseTest {
	@BeforeClass
	public void accSetUp() {
	accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
}

@Test
public void accPageTitleTest() {
	Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE, AppErrors.TITLE_NOT_FOUND);
}

@Test
public void accPageURLTest() {
	Assert.assertTrue(accPage.getAccPageURL().contains(AppConstants.ACC_PAGE_FRACTION_URL), AppErrors.URL_NOT_FOUND);
}


@Test
public void accPageHeadersTest() {
	List<String> accPageHeadersList = accPage.getAccPageHeaders();
	Assert.assertEquals(accPageHeadersList, AppConstants.ACC_PAGE_HEADERS_LIST, AppErrors.LIST_IS_NOT_MATCHED);
}

@DataProvider
public Object[][] getSearchData() {
	
	
	return new Object[][] {
		
		{"macbook", 3},{"imac",1},{"samsung",2},{"Airtel",0}
		
	};
	
	
	
}
@Test(dataProvider = "getSearchData")

public void searchTest(String searchkey, int resultsCount) {
	
	searchResultsPage = accPage.doSearch(searchkey);
	
	Assert.assertEquals(searchResultsPage.getsearchResultsCount(), resultsCount, AppErrors.RESULTS_COUNT_MISMATCHED);
}

}
