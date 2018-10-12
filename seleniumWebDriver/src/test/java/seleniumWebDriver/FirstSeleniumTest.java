package seleniumWebDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
	
	private static final String URL_G1 = "https://g1.globo.com/";
	private static final String NAME_INPUT_QUERY = "q";
	private static final String URL_OANTAGONISTA = "https://www.oantagonista.com";
	private static final String PATH_CHROME_DRIVER = "/Users/pedropk/Downloads/Apps/Development/SeleniumWebDriver/chromedriver";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setSystemPropertyChromeWebDriver() {
		System.setProperty(
			WEBDRIVER_CHROME_DRIVER, 
			PATH_CHROME_DRIVER);
		
		driver = new ChromeDriver();
	}
	
	@Test
	public void firstSeleniumTest() {
		driver.get(URL_G1);
		driver.manage().window().maximize();
		
		WebElement inputBusca = driver.findElement(By.name(NAME_INPUT_QUERY));
		inputBusca.clear();
		inputBusca.sendKeys("Marcos Lisboa");
		inputBusca.submit();
	}
	
	@AfterClass
	public static void finalizeChrome() {
		driver.close();
	}
	
}