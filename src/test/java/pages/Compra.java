package pages;

import support.DriverQA;

public class Compra {
	DriverQA driver = new DriverQA();
	public Compra(String endereco) {
		driver.start(endereco);
	}
	public void clickProduto(String produto) {
		driver.click("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a", "xpath");
		
	}
	public void clickAddCart() {
		//*[@id="add_to_cart"]/button/span
		driver.waitElement("//p[@id=\"add_to_cart\"]/button", "xpath");
		driver.click("//p[@id=\"add_to_cart\"]/button", "xpath");
		
	}
	public void clickCheckout() {
		driver.waitElement("//a[@title = 'Proceed to checkout']", "xpath");
		driver.click("//a[@title = 'Proceed to checkout']", "xpath");
		
	}
	public String getProduto() {
		driver.waitElement("#product_1_1_0_0 > td.cart_description > p > a","css");
		return driver.getText("#product_1_1_0_0 > td.cart_description > p > a","css");
	}
	public void setEmailCreate(String email) {
		driver.waitElement("email_create", "id");
		driver.sendKeys(email, "email_create", "id");
		
	}
	public void clickCreateAccount() {
		driver.click("SubmitCreate", "id");
	}
	public String getTitulo() {
		driver.waitElement("//h3[@class='page-subheading']", "xpath");
		return driver.getText("//h3[@class='page-subheading']", "xpath");
	}
	public void setFirstName(String nome) {
		driver.waitElement("customer_firstname", "id");
		driver.sendKeys(nome, "customer_firstname", "id");
		
	}
	public void setLastName(String sobrenome) {
		driver.sendKeys(sobrenome, "customer_lastname", "id");
		
	}
	public void setSenha(String senha) {
		driver.sendKeys(senha, "passwd", "id");
		
	}
	public void setRua(String rua) {
		driver.sendKeys(rua, "address1", "id");
		
	}
	public void setCidade(String cidade) {
		driver.sendKeys(cidade, "city", "id");
		
	}
	public void selecionaEstado(String estado) {
		driver.selectText(estado, "id_state", "id");
		
	}
	public void setZipoCode(String cep) {
		driver.sendKeys(cep, "postcode", "id");
		
	}
	public void setTelefone(String telefone) {
		driver.sendKeys(telefone, "phone_mobile", "id");
		
	}
	public void clickRegister() {
		driver.click("submitAccount", "id");
		
	}
	public String getRua() {
		driver.waitElement("//*[@id=\"address_delivery\"]/li[3]", "xpath");
		return driver.getText("//*[@id=\"address_delivery\"]/li[3]", "xpath");
	}
	public Object getCidade() {
		return driver.getText("//*[@id=\"address_delivery\"]/li[4]", "xpath");
	}
	public String getTituloShipping() {
		driver.waitElement("//h1[@class='page-heading']", "xpath");
		return driver.getText("//h1[@class='page-heading']", "xpath");
	}
	public void clickAceitoTermos() {
		driver.click("cgv", "id");
		
	}
	public String getTotal() {
		driver.waitElement("total_price", "id");
		return driver.getText("total_price", "id");
	}
	public void clickPayByBank() {
		driver.click("//a[@title = 'Pay by bank wire']", "xpath");
	}
	public void clickConfirmo() {
		driver.waitElement("//*[@id=\"cart_navigation\"]/button", "xpath");
		driver.click("//*[@id=\"cart_navigation\"]/button", "xpath");
	}
	public String getConfirmation() {
		return driver.getText("//*[@id=\"center_column\"]/div/p/strong", "xpath");
	}
	public void clickProcedCheckout() {
		driver.click("//*[@id=\"center_column\"]/p[2]/a[1]", "xpath");
		
	}
	public void clickCheckoutEndereco() {
		driver.click("//button[@name = 'processAddress']", "xpath");
	}
	public void clickCheckoutShipping() {
		driver.click("//button[@name = 'processCarrier']", "xpath");
	}
	
	
	
	
	 
	
	
	
}
