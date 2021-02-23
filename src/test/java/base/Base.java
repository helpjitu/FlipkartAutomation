package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Base {
	protected static WebDriver driver = null;
	protected static Properties prop = null;

	public static WebDriver initiateDriver(String browser) {
		// specify the location of the driver
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/jitendra/eclipse-workspace/chromedriver");
			driver = new ChromeDriver();
			return driver;
		} else if (browser.equalsIgnoreCase("html")) {
			driver = new HtmlUnitDriver();
			return driver;
		} else {
			return driver = null;
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

}
