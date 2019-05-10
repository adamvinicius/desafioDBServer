package pages;

import support.DriverQA;

public class Compra {
	String link_produto = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a";
	String btn_cart = "//p[@id=\"add_to_cart\"]/button";
	String link_title = "//a[@title = 'Proceed to checkout']";
	String link_text_produto = "#product_1_1_0_0 > td.cart_description > p > a";
	String h3_cabecalho = "//h3[@class='page-subheading']";
	String li_rua = "//*[@id=\"address_delivery\"]/li[3]";
	String li_endereco_entrega = "//*[@id=\"address_delivery\"]/li[4]";
	String h1_head = "//h1[@class='page-heading']";
	String link_pagamento = "//a[@title = 'Pay by bank wire']";
	String btn_cart_pagamento = "//*[@id=\"cart_navigation\"]/button";
	String p_confirmacao = "//*[@id=\"center_column\"]/div/p/strong";
	String link_checkout = "//*[@id=\"center_column\"]/p[2]/a[1]";
	String btn_endereco = "//button[@name = 'processAddress']";
	String btn_checkout = "//button[@name = 'processCarrier']";
	
	
	
	public Compra(String endereco) {
		DriverQA.start(endereco);
	}
	public void clickProduto(String produto) {
		DriverQA.click(link_produto, "xpath");
		
	}
	public void clickAddCart() {
		//*[@id="add_to_cart"]/button/span
		DriverQA.waitElement(btn_cart, "xpath");
		DriverQA.click(btn_cart, "xpath");
		
	}
	public void clickCheckout() {
		DriverQA.waitElement(link_title, "xpath");
		DriverQA.click(link_title, "xpath");
		
	}
	public String getProduto() {
		DriverQA.waitElement(link_text_produto,"css");
		return DriverQA.getText(link_text_produto,"css");
	}
	public void setEmailCreate(String email) {
		DriverQA.waitElement("email_create", "id");
		DriverQA.sendKeys(email, "email_create", "id");
		
	}
	public void clickCreateAccount() {
		DriverQA.click("SubmitCreate", "id");
	}
	public String getTitulo() {
		DriverQA.waitElement(h3_cabecalho, "xpath");
		return DriverQA.getText(h3_cabecalho, "xpath");
	}
	public void setFirstName(String nome) {
		DriverQA.waitElement("customer_firstname", "id");
		DriverQA.sendKeys(nome, "customer_firstname", "id");
		
	}
	public void setLastName(String sobrenome) {
		DriverQA.sendKeys(sobrenome, "customer_lastname", "id");
		
	}
	public void setSenha(String senha) {
		DriverQA.sendKeys(senha, "passwd", "id");
		
	}
	public void setRua(String rua) {
		DriverQA.sendKeys(rua, "address1", "id");
		
	}
	public void setCidade(String cidade) {
		DriverQA.sendKeys(cidade, "city", "id");
		
	}
	public void selecionaEstado(String estado) {
		DriverQA.selectText(estado, "id_state", "id");
		
	}
	public void setZipoCode(String cep) {
		DriverQA.sendKeys(cep, "postcode", "id");
		
	}
	public void setTelefone(String telefone) {
		DriverQA.sendKeys(telefone, "phone_mobile", "id");
		
	}
	public void clickRegister() {
		DriverQA.click("submitAccount", "id");
		
	}
	public String getRua() {
		DriverQA.waitElement(li_rua, "xpath");
		return DriverQA.getText(li_rua, "xpath");
	}
	public Object getCidade() {
		return DriverQA.getText(li_endereco_entrega, "xpath");
	}
	public String getTituloShipping() {
		DriverQA.waitElement(h1_head, "xpath");
		return DriverQA.getText(h1_head, "xpath");
	}
	public void clickAceitoTermos() {
		DriverQA.click("cgv", "id");
		
	}
	public String getTotal() {
		DriverQA.waitElement("total_price", "id");
		return DriverQA.getText("total_price", "id");
	}
	public void clickPayByBank() {
		DriverQA.click(link_pagamento, "xpath");
	}
	public void clickConfirmo() {
		DriverQA.waitElement(btn_cart_pagamento, "xpath");
		DriverQA.click(btn_cart_pagamento, "xpath");
	}
	public String getConfirmation() {
		return DriverQA.getText(p_confirmacao, "xpath");
	}
	public void clickProcedCheckout() {
		DriverQA.click(link_checkout, "xpath");
		
	}
	public void clickCheckoutEndereco() {
		DriverQA.click(btn_endereco, "xpath");
	}
	public void clickCheckoutShipping() {
		DriverQA.click(btn_checkout, "xpath");
	}
	
	
	
	
	 
	
	
	
}
