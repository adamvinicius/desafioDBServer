package steps;

import static com.jayway.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseOptions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;



import com.jayway.restassured.specification.RequestSpecification;



public class TrelloApiSteps {
	private String token = "ec780b1f9c634c5510fa3350a94394006e8c31c555b3663a29dfdf77b03276fa";
	private String key = "4ea30ff69a7fd7c3d53e3b57c75bdf3c";
	private String dashboard = "";
	private String listBacklog = "";
	private String listToDo = "";
	private String listInProgress = "";
	private String listTesting = "";
	private String listDone = "";
	private String card = "";
	private static Response response;
	
	
	JsonPath path;
	
	private Response getResponse(String requisicao) {
		RequestSpecification rs = given()
		        .when()
		        .contentType(ContentType.JSON)
		        .accept(ContentType.JSON);
		
		response = rs.post(requisicao)
                .then()
                .extract().response();
		return response;
	}
	
	private Response getResponsePut(String requisicao) {
		RequestSpecification rs = given()
		        .when()
		        .contentType(ContentType.JSON)
		        .accept(ContentType.JSON);
		
		response = rs.put(requisicao)
                .then()
                .extract().response();
		return response;
	}
	
	private Response getResponseDelete(String requisicao) {
		RequestSpecification rs = given()
		        .when()
		        .contentType(ContentType.JSON)
		        .accept(ContentType.JSON);
		
		response = rs.delete(requisicao)
                .then()
                .extract().response();
		return response;
	}
	
	private String getKey(String url, String campo) {
		
		return this.getResponse(url).getBody().jsonPath().get(campo).toString();
	}
	
	@Dado("^que crio o quadro com \"([^\"]*)\" com nome \"([^\"]*)\"$")
	public void que_crio_o_quadro_com_com_nome(String url, String nome) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String requisicao = url+"?name="+nome+"&defaultLists=false&token="+token+"&key="+key;
		dashboard = this.getKey(requisicao, "id"); 
	}

	@Quando("^crio lista do quadro ja criado com$")
	public void crio_lista_do_quadro_ja_criado_com(DataTable listas) throws Throwable {
		List<Map<String, String>> list = listas.asMaps(String.class, String.class);
		
	    for( Map<String, String> lista : list )
	    {
	       	switch (lista.get("nomeLista")) {
			case "Backlog":
				listBacklog = this.getKey("https://api.trello.com/1/lists/?name=Backlog&idBoard="+dashboard+"&token="+token+"&key="+key, "id");
				break;
			case "To Do":
				listToDo = this.getKey("https://api.trello.com/1/lists/?pos=bottom&name=To Do&idBoard="+dashboard+"&token="+token+"&key="+key, "id");
				break;
			case "In Progress":
				listInProgress = this.getKey("https://api.trello.com/1/lists/?pos=bottom&name=In Progress&idBoard="+dashboard+"&token="+token+"&key="+key, "id");
				break;
			case "Testing":
				listTesting = this.getKey("https://api.trello.com/1/lists/?pos=bottom&name=Testing&idBoard="+dashboard+"&token="+token+"&key="+key, "id");
				break;
			case "Done":
				listDone = this.getKey("https://api.trello.com/1/lists/?pos=bottom&name=Done&idBoard="+dashboard+"&token="+token+"&key="+key, "id");
				break;
			}
	    	
	    }
	    
	}

	@Quando("^crio o card \"([^\"]*)\" na lista backlog$")
	public void crio_o_card_na_lista_backlog(String nomeCard) throws Throwable {
		String url = "https://api.trello.com/1/cards?idList="+listBacklog+"&name="+nomeCard+"&token="+token+"&key="+key;
	    this.card = this.getKey(url, "id");
	}

	@Quando("^atualizo o nome do card criado para \"([^\"]*)\"$")
	public void atualizo_o_nome_do_card_criado_para(String nomeCard) throws Throwable {
	    String url = "https://api.trello.com/1/cards/"+this.card+"/?name="+nomeCard+"&token="+token+"&key="+key;
	    System.out.println("atualiza card: "+url);
	    this.getResponsePut(url);
	    
	}

	@Quando("^movo o card criado para$")
	public void movo_o_card_criado_para(DataTable listas) throws Throwable {
		List<Map<String, String>> list = listas.asMaps(String.class, String.class);
		
	    for( Map<String, String> lista : list )
	    {
	       	switch (lista.get("nomeLista")) {
			case "To Do":
				this.getResponsePut("https://api.trello.com/1/cards/"+this.card+"/?idList="+this.listToDo+"&token="+token+"&key="+key);
				break;
			case "In Progress":
				this.getResponsePut("https://api.trello.com/1/cards/"+this.card+"/?idList="+this.listInProgress+"&token="+token+"&key="+key);
				break;
			case "Testing":
				this.getResponsePut("https://api.trello.com/1/cards/"+this.card+"/?idList="+this.listTesting+"&token="+token+"&key="+key);
				break;
			case "Done":
				this.getResponsePut("https://api.trello.com/1/cards/"+this.card+"/?idList="+this.listDone+"&token="+token+"&key="+key);
				break;
			}
	    	
	    }
	}

	@Entao("^apago o quadro criado$")
	public void apago_o_quadro_criado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String url = "https://api.trello.com/1/boards/"+this.dashboard+"/?token="+token+"&key="+key;
		System.out.println("delete: "+url);
	    this.getResponseDelete(url);
	}
}
