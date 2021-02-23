package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ExcelReader;
import utilities.Logs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Page extends Logs {
	public static WebDriver driver;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
	public static Properties prop;

	public static void initConfiguration() {
		if (Constants.browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver");
			driver = new ChromeDriver();
			LOGGER.debug("Launching Chrome");

		}
		driver.get(Constants.testSiteUrl);
		driver.manage().window().maximize();
//		driver.switchTo().defaultContent();
//		Actions actions = new Actions(driver);
//		actions.click().sendKeys(Keys.ESCAPE).perform();

	}

	public static void clickElement(WebElement element) {
		element.click();
		LOGGER.info("Clicking on an Element: " + element);
	}

	public static void type(WebElement element, String value) {
		element.sendKeys(value);
		LOGGER.info("Entering the value as: " + value + " for the element: " + element);
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static Properties loadProp() {
		File propertyFile = new File("src/test/resources/Config.properties");

		try {
			FileInputStream file = new FileInputStream(propertyFile);
			prop = new Properties();
			try {
				prop.load(file);
				return prop;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	@Test
	public void testLog()
	{
		LOGGER.info("Test");
	}

}
