package seleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUpPage {
	
	private static final String CSS_SELECTOR_BOTAO_ENTRAR = "#u_0_2";

	private WebDriver aDriver;
	
	/**
	 * URL's
	 */
	private static final String URL_FACEBOOK = "https://pt-br.facebook.com/";
	//private static final String URL_LOCALHOST = "http://localhost:8080/MWA/jsf/named.xhtml";
	
	/**
	 * WebElement Locators for Facebook
	 */
	private static final String NAME_INPUT_NOME					= "firstname";
	private static final String NAME_INPUT_SOBRENOME			= "lastname";
	private static final String NAME_INPUT_EMAIL				= "reg_email__";
	private static final String NAME_INPUT_SENHA				= "reg_passwd__";
	private static final String NAME_INPUT_DIA_ANIVERSARIO		= "birthday_day";
	private static final String NAME_INPUT_MES_ANIVERSARIO		= "birthday_month";
	private static final String NAME_INPUT_ANO_ANIVERSARIO		= "birthday_year";
	private static final String NAME_RADIOBUTTON_GENERO			= "sex";
	private static final String NAME_BOTAO_INSCREVER			= "websubmit";
	private static final String ID_INPUT_EMAIL					= "email";
	private static final String ID_PASSWORD						= "pass";
	public static final String EMAIL							= "INSIRA_AQUI_SEU_EMAIL";
	public static final String SENHA							= "INSIRA_AQUI_SUA_SENHA";
	
	public void accessURL() {
		this.aDriver.get(URL_FACEBOOK);
	}
	
	/**
	 * Valores para preencherWebElements 
	 */
	
	/**
	 * HTML Tags and Attributes
	 */
	private static final String ATTRIBUTE_VALUE = "value";
	
	
	public FacebookSignUpPage(WebDriver pDriver) {
		this.aDriver = pDriver;
	}
	
	public FacebookSignUpPage preencherNome(String pNome) {
		preencherCampoInputPorName(NAME_INPUT_NOME, pNome);
		
		return this;
	}
	
	public FacebookSignUpPage preencherSobrenome(String pSobrenome) {
		preencherCampoInputPorName(NAME_INPUT_SOBRENOME, pSobrenome);
		
		return this;
	}
	
	public FacebookSignUpPage preencherEmail(String pEmail) {
		preencherCampoInputPorName(NAME_INPUT_EMAIL, pEmail);
		
		return this;
	}
	
	public FacebookSignUpPage preencherSenha(String pSenha) {
		preencherCampoInputPorName(NAME_INPUT_SENHA, pSenha);
		
		return this;
	}
	
	public FacebookSignUpPage selecionarDiaNascimento(String pDiaNascimento) {
		selecionarPorNomeValor(NAME_INPUT_DIA_ANIVERSARIO, pDiaNascimento);
		
		return this;
	}
	
	public FacebookSignUpPage selecionarMesNascimento(String pMesNascimento) {
		selecionarPorNomeValor(NAME_INPUT_MES_ANIVERSARIO, pMesNascimento);
		
		return this;
	}
	
	public FacebookSignUpPage selecionarAnoNascimento(String pAnoNascimento) {
		selecionarPorNomeValor(NAME_INPUT_ANO_ANIVERSARIO, pAnoNascimento);
		
		return this;
	}
	
	public FacebookSignUpPage selecionarGenero(String pGenero) {
		selecionarRadiobuttonOuCheckboxPorNomeValor(
				NAME_RADIOBUTTON_GENERO, 
				pGenero);
		
		return this;
	}
	
	public void pressionarBotaoFormularioIncluirUsuario() {
		this.aDriver.findElement(By.name(NAME_BOTAO_INSCREVER)).click();
	}
	
	public void facebookLoginTest() {
		this.aDriver.get(URL_FACEBOOK);
		this.aDriver.manage().window().maximize();
		
		/*WebElement inputEmail		=*/ preencherEmailLogin(EMAIL);
		
		/*WebElement password		=*/ preencherSenhaLogin(SENHA);
		
		//inputEmail.submit();
		pressionarBotaoEntrar();
	}
	
	public void pressionarBotaoEntrar() {
		this.aDriver.findElement(By.cssSelector(CSS_SELECTOR_BOTAO_ENTRAR)).submit();;
	}
	
	public FacebookSignUpPage preencherSenhaLogin(String senha) {
		preencherCampoInputPorID(ID_PASSWORD,	senha);
		
		return this;
	}

	public FacebookSignUpPage preencherEmailLogin(String email) {
		preencherCampoInputPorID(ID_INPUT_EMAIL,	email);
		
		return this;
	}
	
	private WebElement preencherCampoInputPorID(String pId, String pValor) {
		WebElement campo = this.aDriver.findElement(By.id(pId));
		
		// Limpa valores previamente digitados
		campo.clear();
		
		// Preenche o campo
		campo.sendKeys(pValor);
		
		return campo;
	}
	
	private WebElement preencherCampoInputPorName(String pName, String pValor) {
		WebElement campo = aDriver.findElement(By.name(pName));
		
		// Limpa valores previamente digitados
		campo.clear();
		
		// Preenche o campo
		campo.sendKeys(pValor);
		
		return campo;
	}
	
	private Select selecionarPorNomeValor(String pNomeSelect, String pValorSelect) {
		Select selectDiaAniversario = getSelectPorNome(pNomeSelect);
		selectDiaAniversario.selectByValue(pValorSelect);
		return selectDiaAniversario;
	}
	
	private Select getSelectPorNome(String pNomeSelect) {
		WebElement	campoDiaAniversario		= aDriver.findElement(By.name(pNomeSelect));
		Select		selectDiaAniversario	= new Select(campoDiaAniversario);
		return selectDiaAniversario;
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
		List<WebElement> radiosGenero = aDriver.findElements(By.name(pNomeRadioButtons));
		return radiosGenero;
	}
	
}