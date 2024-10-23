package com.techno.orghrm.testscript;


import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.techno.orghrm.base.PredefinedActions;
import com.techno.orghrm.pages.HomePage;
import com.techno.orghrm.pages.LoginPage;

public class LoginTest {
	
	@Test
	public void loginTest() {
		PredefinedActions.start();
		LoginPage loginPage = new LoginPage();
		
		
		Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo No Displayed");
		HomePage homePage = loginPage.doLogin("admin", "admin123");		
		
		Assert.assertTrue(homePage.isBannerDisplayed(), "Banner Not Displayed");
		
		boolean isDashboardpreselected = homePage.isdashBoardPreSelected();
		Assert.assertTrue(isDashboardpreselected,"Dashboard was not pre-selected");
		
		List<String>menuList = homePage.getMenulist();
		Assert.assertEquals(12, menuList.size(),"some menu are missing");
	}

}
