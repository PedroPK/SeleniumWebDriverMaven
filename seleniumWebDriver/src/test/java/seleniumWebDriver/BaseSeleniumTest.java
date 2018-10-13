package seleniumWebDriver;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseSeleniumTest {
	
	private static final String NAME_BOTAO_INSCREVER_FACEBOOK = "websubmit";
	
	/**
	 * HTML Tags and Attributes
	 */
	private static final String ATTRIBUTE_VALUE = "value";
	
	private static final String EMAIL_FACEBOOK = "pedropk@gmail.com";
	private static final String SENHA_FACEBOOK = "ubE7bUN#&$Z5";
	
	/**
	 * URL's
	 */
	private static final String URL_FACEBOOK = "https://pt-br.facebook.com/";
	private static final String URL_G1 = "https://g1.globo.com/";
	
	/**
	 * WebElement Locators
	 */
	private static final String NAME_INPUT_QUERY									= "q";
	
	/**
	 * WebElement Locators for Facebook
	 */
	
	private static final String NAME_INPUT_NOME_FACEBOOK							= "firstname";
	private static final String NAME_INPUT_SOBRENOME_FACEBOOK						= "lastname";
	private static final String NAME_INPUT_EMAIL_FACEBOOK							= "reg_email__";
	private static final String NAME_INPUT_SENHA_FACEBOOK							= "reg_passwd__";
	private static final String NAME_INPUT_DIA_ANIVERSARIO_FACEBOOK					= "birthday_day";
	private static final String NAME_INPUT_MES_ANIVERSARIO_FACEBOOK					= "birthday_month";
	private static final String NAME_INPUT_ANO_ANIVERSARIO_FACEBOOK					= "birthday_year";
	private static final String NAME_RADIOBUTTON_GENERO_FACEBOOK					= "sex";
	private static final String ID_INPUT_EMAIL										= "email";
	private static final String ID_PASSWORD											= "pass";
	
	/**
	 * Values de WebElement Locators
	 */
	private static final String VALUE_OPTION_MES_02_FEVEREIRO_MASCULINO_FACEBOOK	= "2";
	private static final String VALUE_RADIOBUTTON_MASCULINO_FACEBOOK				= "2";
	
	
	/**
	 * Driver Configurations
	 */
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
	
	@Ignore
	@Test
	public void g1SearchTest() {
		driver.get(URL_G1);
		driver.manage().window().maximize();
		
		WebElement inputBusca = preencherCampoInputPorName(NAME_INPUT_QUERY, "Recife");
			
		inputBusca.submit();
	}
	
	@Ignore
	@Test
	public void facebookLoginTest() {
		driver.get(URL_FACEBOOK);
		driver.manage().window().maximize();
		
		WebElement inputEmail		= preencherCampoInputPorID(ID_INPUT_EMAIL,		EMAIL_FACEBOOK);
		
		/*WebElement password		=*/ preencherCampoInputPorID(ID_PASSWORD,			SENHA_FACEBOOK);
		
		inputEmail.submit();
	}
	
	@Test
	public void facebookCadastroTest() {
		driver.get(URL_FACEBOOK);
		driver.manage().window().maximize();
		
		/*WebElement inputNome				=*/ 	preencherCampoInputPorName(	NAME_INPUT_NOME_FACEBOOK,				"Pedro");
		/*WebElement inputSobrenome			=*/ 	preencherCampoInputPorName(	NAME_INPUT_SOBRENOME_FACEBOOK,			"Santos");
		/*WebElement inputEmail				=*/ 	preencherCampoInputPorName(	NAME_INPUT_EMAIL_FACEBOOK,				"pedro.santos@@unibratec.edu.br");
		/*WebElement inputSenha				=*/ 	preencherCampoInputPorName(	NAME_INPUT_SENHA_FACEBOOK,				"12sad435g76gh!@#ˆ&%");
		
		/*Select selectDiaAniversario			=*/ selecionarPorNomeValor(		NAME_INPUT_DIA_ANIVERSARIO_FACEBOOK, 	"1");
		/*Select selectMesAniversario			=*/ selecionarPorNomeValor(		NAME_INPUT_MES_ANIVERSARIO_FACEBOOK, 	VALUE_OPTION_MES_02_FEVEREIRO_MASCULINO_FACEBOOK);
		/*Select selectAnoAniversario			=*/ selecionarPorNomeValor(		NAME_INPUT_ANO_ANIVERSARIO_FACEBOOK, 	"1983");
		
		selecionarRadiobuttonOuCheckboxPorNomeValor(
			NAME_RADIOBUTTON_GENERO_FACEBOOK, 
			VALUE_RADIOBUTTON_MASCULINO_FACEBOOK);
		
		//submeterBotaoFormularioIncluirUsuario(NAME_BOTAO_INSCREVER_FACEBOOK);
		pressionarBotaoFormularioIncluirUsuario(NAME_BOTAO_INSCREVER_FACEBOOK);
	}
	
	/*private void submeterBotaoFormularioIncluirUsuario(String pNomeBotaoSubmit) {
		driver.findElement(By.name(pNomeBotaoSubmit)).submit();
	}*/
	
	private void pressionarBotaoFormularioIncluirUsuario(String pNomeBotaoSubmit) {
		driver.findElement(By.name(pNomeBotaoSubmit)).click();
	}
	
	private void selecionarRadiobuttonOuCheckboxPorNomeValor(String pNomeRadiobuttons, String pValorDesejadoRadiobutton) {
		List<WebElement> radiosGenero = getRadiobuttonsPorNome(pNomeRadiobuttons);
		
		for (WebElement radioButton : radiosGenero) {
			if ( radioButton.getAttribute(ATTRIBUTE_VALUE).equals(pValorDesejadoRadiobutton)		&&
				 !radioButton.isSelected()
			) {
				radioButton.click();
			}
		}
	}

	private List<WebElement> getRadiobuttonsPorNome(String pNomeRadioButtons) {
		List<WebElement> radiosGenero = driver.findElements(By.name(pNomeRadioButtons));
		return radiosGenero;
	}

	private Select selecionarPorNomeValor(String pNomeSelect, String pValorSelect) {
		Select selectDiaAniversario = getSelectPorNome(pNomeSelect);
		selectDiaAniversario.selectByValue(pValorSelect);
		return selectDiaAniversario;
	}
	
	private Select getSelectPorNome(String pNomeSelect) {
		WebElement	campoDiaAniversario		= driver.findElement(By.name(pNomeSelect));
		Select		selectDiaAniversario	= new Select(campoDiaAniversario);
		return selectDiaAniversario;
	}
	
	private WebElement preencherCampoInputPorID(String pId, String pValor) {
		WebElement campo = driver.findElement(By.id(pId));
		
		// Limpa valores previamente digitados
		campo.clear();
		
		// Preenche o campo
		campo.sendKeys(pValor);
		
		return campo;
	}
	
	private WebElement preencherCampoInputPorName(String pName, String pValor) {
		WebElement campo = driver.findElement(By.name(pName));
		
		// Limpa valores previamente digitados
		campo.clear();
		
		// Preenche o campo
		campo.sendKeys(pValor);
		
		return campo;
	}
	
	@AfterClass
	public static void finalizeChrome() {
		driver.close();
	}
	
}