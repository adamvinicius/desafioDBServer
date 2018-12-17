#language: pt

Funcionalidade: compra automationpractice

	Cenário: realizar compra com sucesso
		Dado que estou no site "http://www.automationpractice.com"
		Quando clico no produto "Faded Short Sleeve T-shirts"
		E clico em add cart do produto
		E clico em Proceed to checkout produto
		Entao valido se o produto "Faded Short Sleeve T-shirts" se encontra no carrinho
		Quando clico em Proceed to checkout
		E digito "testeadam@gmail.com" no campo email
		E clico em Create an account
		Dado que estou na pagina Sign in
	
		Quando digito "Adam" no campo first name
		E digito "Luchini" no campo Last Name
		
		E digito "adam123" no campo password
		
		
		E digito "Rua Mauro" no campo address
		E digito "Sao Paulo" no campo City
		E seleciono "Alabama" do campo state
		E digito "01234" no campo zip code
		E digito "1189355210" no campo mobile phone
	
		E clico em Register
		Entao exibe a pagina de Addres
		E valido a rua com o texto "Rua Mauro"
		E valido a cidade com o texto "Sao Paulo, Alabama 01234"
		Quando clico em Proceed to checkout endereco
		
		Dado que estou na pagina shipping
		Quando clico em aceito os termos
		E clico em Proceed to checkout shipping
		Entao valido o valor "$19.25" do total
		Quando clico em pay by bank wire
		E clico em I confirm my order
		Entao valido se a compra foi finalizada
		
		
		
		
		

	

