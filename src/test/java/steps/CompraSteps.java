package steps;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

import pages.Compra;

public class CompraSteps {
	Compra compra;
	
	@Dado("^que estou no site \"([^\"]*)\"$")
	public void que_estou_no_site(String endereco) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra = new Compra(endereco);
	}

	@Quando("^clico no produto \"([^\"]*)\"$")
	public void clicoNoProduto(String produto) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickProduto(produto);
	}
	
	@Quando("^clico em add cart do produto$")
	public void clicoEmAddCartDoProduto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickAddCart();
	}

	@Quando("^clico em Proceed to checkout$")
	public void clicoEmProceedToCheckout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickProcedCheckout();
	}
	
	@Quando("^clico em Proceed to checkout produto$")
	public void clicoEmProceedToCheckoutProduto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickCheckout();
	}
	
	@Quando("^clico em Proceed to checkout endereco$")
	public void clicoEmProceedToCheckoutEndereco() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickCheckoutEndereco();
	}
	
	@Quando("^clico em Proceed to checkout shipping$")
	public void clicoEmProceedToCheckoutShipping() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickCheckoutShipping();
	}

	@Entao("^valido se o produto \"([^\"]*)\" se encontra no carrinho$")
	public void validoSeOProdutoSeEncontraNoCarrinho(String produto) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(produto, compra.getProduto());
	}

	@Quando("^digito \"([^\"]*)\" no campo email$")
	public void digitoNoCampoEmail(String email) throws Throwable {
	    compra.setEmailCreate(email);
	}

	@Quando("^clico em Create an account$")
	public void clicoEmCreateAnAccount() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickCreateAccount();
	}

	@Dado("^que estou na pagina Sign in$")
	public void queEstouNaPaginaSignIn() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals("CREATE AN ACCOUNT", compra.getTitulo());
	}

	@Quando("^digito \"([^\"]*)\" no campo first name$")
	public void digitoNoCampoFirstName(String nome) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.setFirstName(nome);
	}

	@Quando("^digito \"([^\"]*)\" no campo Last Name$")
	public void digitoNoCampoLastName(String sobrenome) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.setLastName(sobrenome);
	}

	@Quando("^digito \"([^\"]*)\" no campo password$")
	public void digitoNoCampoPassword(String senha) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.setSenha(senha);
	}

	

	@Quando("^digito \"([^\"]*)\" no campo address$")
	public void digitoNoCampoAddress(String rua) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.setRua(rua);
	}

	@Quando("^digito \"([^\"]*)\" no campo City$")
	public void digitoNoCampoCity(String cidade) throws Throwable {
	    compra.setCidade(cidade);
	}

	@Quando("^seleciono \"([^\"]*)\" do campo state$")
	public void selecionoDoCampoState(String estado) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.selecionaEstado(estado);
	}

	@Quando("^digito \"([^\"]*)\" no campo zip code$")
	public void digitoNoCampoZipCode(String cep) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.setZipoCode(cep);
	}

	@Quando("^digito \"([^\"]*)\" no campo mobile phone$")
	public void digitoNoCampoMobilePhone(String telefone) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.setTelefone(telefone);
	}

	@Quando("^digito \"([^\"]*)\" no campo addres allias$")
	public void digitoNoCampoAddresAllias(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^clico em Register$")
	public void clicoEmRegister() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickRegister();
	}

	@Entao("^exibe a pagina de Addres$")
	public void exibeAPaginaDeAddres() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("YOUR DELIVERY ADDRESS", compra.getTitulo());
	}

	@Entao("^valido a rua com o texto \"([^\"]*)\"$")
	public void validoARuaComOTexto(String rua) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(rua, compra.getRua());
	}

	@Entao("^valido a cidade com o texto \"([^\"]*)\"$")
	public void validoACidadeComOTexto(String cidade) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(cidade, compra.getCidade());
	}

	@Dado("^que estou na pagina shipping$")
	public void queEstouNaPaginaShipping() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals("SHIPPING", compra.getTituloShipping());
	}

	@Quando("^clico em aceito os termos$")
	public void clicoEmAceitoOsTermos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickAceitoTermos();
	} 

	@Entao("^valido o valor \"([^\"]*)\" do total$")
	public void validoOValorDoTotal(String total) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(total, compra.getTotal());
	}

	@Quando("^clico em pay by bank wire$")
	public void clicoEmPayByBankWire() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickPayByBank();
	}

	@Quando("^clico em I confirm my order$")
	public void clicoEmIConfirmMyOrder() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    compra.clickConfirmo();
	}

	@Entao("^valido se a compra foi finalizada$")
	public void validoSeACompraFoiFinalizada() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals("Your order on My Store is complete.", compra.getConfirmation());
	}

}
