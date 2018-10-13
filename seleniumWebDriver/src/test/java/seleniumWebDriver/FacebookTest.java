package seleniumWebDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTest {
	
	private static		WebDriver			aDriver;
	private static		FacebookSignUpPage	aFacebookPage;
	
	/**
	 * Driver Configurations
	 */
	private static final String PATH_CHROME_DRIVER			= "/Users/pedropk/Downloads/Apps/Development/SeleniumWebDriver/chromedriver";
	private static final String WEBDRIVER_CHROME_DRIVER		= "webdriver.chrome.driver";
	
	/**
	 * Values de WebElement Locators
	 */
	private static final String VALUE_OPTION_DIA_1				= "1";
	private static final String VALUE_OPTION_MES_02_FEVEREIRO	= "2";
	private static final String VALUE_RADIOBUTTON_MASCULINO		= "2";
	private static final String VALUE_OPTION_ANO_1983			= "1983";
	
	
	@BeforeClass
	public static void setSystemPropertyChromeWebDriver() {
		System.setProperty(
			WEBDRIVER_CHROME_DRIVER, 
			PATH_CHROME_DRIVER);
		
		aDriver = new ChromeDriver();
		
		aFacebookPage = new FacebookSignUpPage(aDriver);
		aFacebookPage.accessURL();
	}
	
	@Ignore
	@Test
	public void testSignUp() {
		aFacebookPage
			.preencherNome(				"Pedro")
			.preencherSobrenome(		"Santos")
			.preencherEmail(			"pedro.santos@@unibratec.edu.br")
			.preencherSenha(			"asdqwe123df$%fgd$%")
			.selecionarDiaNascimento(	VALUE_OPTION_DIA_1)
			.selecionarMesNascimento(	VALUE_OPTION_MES_02_FEVEREIRO)
			.selecionarAnoNascimento(	VALUE_OPTION_ANO_1983)
			.selecionarGenero(			VALUE_RADIOBUTTON_MASCULINO);
		
		aFacebookPage.pressionarBotaoFormularioIncluirUsuario();
	}
	
	@Test
	public void testLogIn() {
		aFacebookPage
			.preencherEmailLogin(BaseSeleniumTest.EMAIL_FACEBOOK)
			.preencherSenhaLogin(BaseSeleniumTest.SENHA_FACEBOOK);
		;
		
		aFacebookPage.pressionarBotaoEntrar();
	}
	
	@AfterClass
	public static void closeDriver() {
		aDriver.close();
	}
}