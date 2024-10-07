package p1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestData {
	
	@Test
	void testing() {
		System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/");
		driver.manage().window().maximize();
	}

}
