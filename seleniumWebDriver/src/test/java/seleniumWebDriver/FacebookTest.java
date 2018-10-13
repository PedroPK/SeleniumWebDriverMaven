package seleniumWebDriver;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTest {
	
	private static		WebDriver			aDriver;
	private static		FacebookSignUpPage	aFacebookPage;
	
	/**
	 * Driver Configurations
	 */
	private static final String PATH_CHROME_DRIVER = "/Users/pedropk/Downloads/Apps/Development/SeleniumWebDriver/chromedriver";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	
	/**
	 * Values de WebElement Locators
	 */
	private static final String VALUE_OPTION_MES_02_FEVEREIRO_MASCULINO_FACEBOOK	= "2";
	private static final String VALUE_RADIOBUTTON_MASCULINO_FACEBOOK				= "2";
	
	@BeforeClass
	public static void setSystemPropertyChromeWebDriver() {
		System.setProperty(
			WEBDRIVER_CHROME_DRIVER, 
			PATH_CHROME_DRIVER);
		
		aDriver = new ChromeDriver();
		
		aFacebookPage = new FacebookSignUpPage(aDriver);
		aFacebookPage.accessURL();
	}
	
	@Test
	public void testSignUp() {
		aFacebookPage
			.preencherNome("Pedro")
			.preencherSobrenome("Santos")
			.preencherEmail("pedro.santos@@unibratec.edu.br")
			.preencherSenha("asdqwe123df$%fgd$%")
			.selecionarDiaNascimento("1")
			.selecionarMesNascimento("2")
			.selecionarAnoNascimento("1983")
			.selecionarGenero(VALUE_RADIOBUTTON_MASCULINO_FACEBOOK);
		
		aFacebookPage.pressionarBotaoFormularioIncluirUsuario();
	}
	
}