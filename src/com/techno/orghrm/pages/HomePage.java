package com.techno.orghrm.pages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

import com.techno.orghrm.base.PredefinedActions;

public class HomePage extends PredefinedActions{
	
	public boolean isBannerDisplayed() {
		
		return isElementDisplayed("className", "oxd-brand-banner", true);
	}
	
	public boolean isdashBoardPreSelected() {
		String attributeValue = getElementAttribute("xPath", "//a[@class='oxd-main-menu-item active']", true, "class");
		return attributeValue.contains("active") ? true:false;
	}
	
	public List<String> getMenulist(){
		List<WebElement> list = getAllElement("xPath", "//li[@class='oxd-main-menu-item-wrapper']", true);
		List<String> menuList = new ArrayList<String>();
		for(WebElement e: list) {
			menuList.add(e.getText());
		}
		return menuList;
	}

}
