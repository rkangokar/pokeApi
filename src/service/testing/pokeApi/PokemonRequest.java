package service.testing.pokeApi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PokemonRequest {
	
	public Response sendRequestByNumber(int n) {
		RestAssured.baseURI = Variables.Domain.field() + Variables.FetchPokemon.field() ;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, n + "/");
		return response;
	}
	
	public Response sendRequestByName(String name) {
		RestAssured.baseURI = Variables.Domain.field() + Variables.FetchPokemon.field() ;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, name+"/");
		return response;
	}
	
	public Response sendRequestForAbility(int n) {
		RestAssured.baseURI = Variables.Domain.field()+ Variables.FetchAbility.field();
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, n+"/");
		return response;
	}
	
	public Response sendRequestForType(int n) {
		RestAssured.baseURI = Variables.Domain.field()+ Variables.FetchType.field();
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, n+"/");
		return response;
	}

	public JsonPath jsonPathofResponse(Response response) {
		JsonPath jp = response.jsonPath(); 
		return jp;
	}
	
}
