package seleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUpPage {
	
	private WebDriver aDriver;
	
	/**
	 * URL's
	 */
	private static final String URL_FACEBOOK = "https://pt-br.facebook.com/";
	
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
	private static final String NAME_BOTAO_INSCREVER_FACEBOOK = "websubmit";
	
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
		preencherCampoInputPorName(NAME_INPUT_NOME_FACEBOOK, pNome);
		
		return this;
	}
	
	public FacebookSignUpPage preencherSobrenome(String pSobrenome) {
		preencherCampoInputPorName(NAME_INPUT_SOBRENOME_FACEBOOK, pSobrenome);
		
		return this;
	}
	
	public FacebookSignUpPage preencherEmail(String pEmail) {
		preencherCampoInputPorName(NAME_INPUT_EMAIL_FACEBOOK, pEmail);
		
		return this;
	}
	
	public FacebookSignUpPage preencherSenha(String pSenha) {
		preencherCampoInputPorName(NAME_INPUT_SENHA_FACEBOOK, pSenha);
		
		return this;
	}
	
	public FacebookSignUpPage selecionarDiaNascimento(String pDiaNascimento) {
		selecionarPorNomeValor(NAME_INPUT_DIA_ANIVERSARIO_FACEBOOK, pDiaNascimento);
		
		return this;
	}
	
	public FacebookSignUpPage selecionarMesNascimento(String pMesNascimento) {
		selecionarPorNomeValor(NAME_INPUT_MES_ANIVERSARIO_FACEBOOK, pMesNascimento);
		
		return this;
	}
	
	public FacebookSignUpPage selecionarAnoNascimento(String pAnoNascimento) {
		selecionarPorNomeValor(NAME_INPUT_ANO_ANIVERSARIO_FACEBOOK, pAnoNascimento);
		
		return this;
	}
	
	public FacebookSignUpPage selecionarGenero(String pGenero) {
		selecionarRadiobuttonOuCheckboxPorNomeValor(
				NAME_RADIOBUTTON_GENERO_FACEBOOK, 
				pGenero);
		
		return this;
	}
	
	public void pressionarBotaoFormularioIncluirUsuario() {
		this.aDriver.findElement(By.name(NAME_BOTAO_INSCREVER_FACEBOOK)).click();
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