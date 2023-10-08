package common;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.core.config.Configurator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class utilities {
	public static Properties OR;
	public static WebDriver driver;

	static {
		Configurator.initialize(null, "./src/test/resources/Config/log4j2.xml");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//src//test//resources//Driver//chromedriver.exe");
		driver = new ChromeDriver();
		// Creating file system object for Object Repository text/property file
		FileInputStream fs;
		try {
			fs = new FileInputStream("./src/test/resources/Config/ObjectRepository.properties");
			// Creating an Object of properties
			OR = new Properties(System.getProperties());
			// Loading all the properties from Object Repository property file in to OR
			// object
			OR.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@After
	public void after(Scenario scenario) {

		Log.endTestCase(scenario.getName(), scenario.getStatus());
	}

	@Before
	public void before(Scenario scenario) {

		Log.startTestCase(scenario.getName());
	}



	public static void Launchurl(String url) {

		driver.get(url);

	}

	public static void clickByLinkText(String linkText) throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement element = driver.findElement(By.linkText(linkText));
		element.click();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public static void clickByButton(String button) throws InterruptedException {
		Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(button));
		element.click();
		Log.info("Clicked on Login Button");
	}

	public static void enterField(String fieldName, String text) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.id(fieldName));
		element.clear();
		element.sendKeys(text);

	}

	public static void validatePageTitle(String expectedTitle) {

		String actualTitle = driver.getTitle();
		Assert.assertEquals("Page title doesnt match", expectedTitle, actualTitle);
		Log.info("The page title has been successfully verified");
	}

	public static String getTextByCss(String text)
	{
		WebElement element=driver.findElement(By.cssSelector(text));
		return element.getText();
	}
	public static void acceptAlert() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
	}
	public void close() {
		driver.quit();
	}
}
