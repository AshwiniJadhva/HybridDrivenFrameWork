package com.techno.orghrm.testscript;




import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.techno.orghrm.base.PredefinedActions;
import com.techno.orghrm.constant.ConstantPath;
import com.techno.orghrm.pages.HomePage;
import com.techno.orghrm.pages.LoginPage;
import com.techno.orghrm.utility.ExcelOperation;

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
		Assert.assertEquals(11, menuList.size(),"some menu are missing");
		PredefinedActions.tearDown();
	}
	
	@Test(dataProvider="orghrnLoginDataProvider")
	public void loginTestwithMultipledata(String username, String password, String expectedResult) {
		PredefinedActions.start(username, password,ConstantPath.URL);
		
		if(expectedResult.equals("pass")) {
			
			LoginPage loginPage = new LoginPage();
			
			
			Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo No Displayed");
			HomePage homePage = loginPage.doLogin("admin", "admin123");		
			
			Assert.assertTrue(homePage.isBannerDisplayed(), "Banner Not Displayed");
			
			boolean isDashboardpreselected = homePage.isdashBoardPreSelected();
			Assert.assertTrue(isDashboardpreselected,"Dashboard was not pre-selected");
			
		}
		else if(expectedResult.equals("Requried")) {
			if(!ConstantPath.URL.contains("dashboard")) {
				Assert.assertTrue(true);
			}
			else Assert.assertTrue(false);
		}
		else if(expectedResult.equals("Requried")) {
			if(!ConstantPath.URL.contains("dashboard")) {
				Assert.assertTrue(true);
			}
			else Assert.assertTrue(false);
		}
		else if(expectedResult.equals("Requried")) {
			if(!ConstantPath.URL.contains("dashboard")) {
				Assert.assertTrue(true);
			}
			else Assert.assertTrue(false);
		}
		else if(expectedResult.equals("Invalid credentials")) {
			if(!ConstantPath.URL.contains("dashboard")) {
				Assert.assertTrue(true);
			}
			else Assert.assertTrue(false);
		}
		
		
	}
	@DataProvider(name = "orghrnLoginDataProvider")
	Object[][] logindata() throws IOException{
		return ExcelOperation.getSheetData("LoginData.xlsx","Data",true);
	}

}
