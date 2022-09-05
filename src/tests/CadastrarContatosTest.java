package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.ScreenshotHelper;
import helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CadastrarContatosTest {

	WebDriver driver;

	@Given("Acessar a página de autentucação de usuário")
	public void acessar_a_página_de_autentucação_de_usuário() {
		// abrir navegador
		driver = WebDriverHelper.getInstance();

		// acessandoa página de autenticação de usuário
		driver.get("http://sergiocontatos-001-site1.ftempurl.com/");
	}

	@Given("Informar o email de acesso {string}")
	public void informar_o_email_de_acesso(String string) {

		// localizar e capturar o campo email
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
		element.sendKeys(string);

	}

	@Given("informar a senha {string}")
	public void informar_a_senha(String string) {
		// localizar e capturar o campo senha
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		element.clear();
		element.sendKeys(string);
	}

	@When("Solicitar a realizacao do acesso")
	public void solicitar_a_realizacao_do_acesso() {
		// localizar e capturar o botão
		WebElement element = driver.findElement(By.xpath("//*[@id=\"btnAcesso\"]"));

		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		}

		else {
			fail("Botão de acesso não habilitado.");
		}
	}

	@Then("Então sistema autentica o usuario com sucesso")
	public void então_sistema_autentica_o_usuario_com_sucesso() {
		// capturar a url obita apos a autenticação
		String urlObtida = driver.getCurrentUrl();
		String urlEsperada = "http://sergiocontatos-001-site1.ftempurl.com/Contatos/Consulta";

		// comparando o resultado esperado x resultado obtido
		assertEquals(urlEsperada, urlObtida);

		// gerando evidencia
		ScreenshotHelper.print(driver, "Autenticação de usuário com sucesso");

	}

	@Given("Acessar a página de cadastro de contatos")
	public void acessar_a_página_de_cadastro_de_contatos() {
		// acessando o endereço da pagina de cadastro
		driver.get("http://sergiocontatos-001-site1.ftempurl.com/Contatos/Cadastro");

	}

	@Given("Informar o nome do contato {string}")
	public void informar_o_nome_do_contato(String string) {
		// localizar e preencher o campo
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Nome\"]"));
		element.clear();
		element.sendKeys(string);

	}

	@Given("Informar a data de nascimento {string}")
	public void informar_a_data_de_nascimento(String string) {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"DataNascimento\"]"));
		element.clear();
		element.sendKeys(string);
	}

	@Given("Informar o telefone {string}")
	public void informar_o_telefone(String string) {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Telefone\"]"));
		element.clear();
		element.sendKeys(string);
	}

	@Given("Informar o email {string}")
	public void informar_o_email(String string) {

		// localizar e capturar o campo email
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
		element.sendKeys(string);

	}

	@When("Solicitar a realização do cadastro")
	public void solicitar_a_realização_do_cadastro() {
		//localixar e clicar no botão de cadastro 
		WebElement element= driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]"));
		
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		}

		else {
			fail("Botão de cadastro não habilitado.");
		}

	}

	@Then("Sistema realiza o cadastro do contato com sucesso")
	public void sistema_realiza_o_cadastro_do_contato_com_sucesso() {
		
		//localizar e capturar a mensagem 
		WebElement element= driver.findElement(By.xpath("//*[@id=\"msgResultado\"]"));
		
		//comparando se a mensagem contem a frase 
		assertTrue(element.getText().contains("cadastrado com sucesso!"));
		
		//evidencia 
		ScreenshotHelper.print(driver, "Cadastro de contato com sucesso");
		
		driver.close();
		driver.quit();

	}

}
