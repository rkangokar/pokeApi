package service.testing.pokeApi;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class FetchPokemonByName {
	
	PokemonRequest pokeReq;

	public FetchPokemonByName() {
		pokeReq = new PokemonRequest();
	}
	
	@Test(groups = {"enable"})
	public void fetchPokemonByName() {
		Response response = pokeReq.sendRequestByName(Variables.Pokemon_name.field());
		assertEquals(response.statusCode(), 200);
	}
	
	@Test(groups = {"enable"})
	public void validatePokemonViaNumber() {
		Response response1 = pokeReq.sendRequestByName(Variables.Pokemon_name.field()); 
		String id = pokeReq.jsonPathofResponse(response1).getString("id");
		Response response2 = pokeReq.sendRequestByNumber(Integer.parseInt(id)); 
		String name = pokeReq.jsonPathofResponse(response2).getString("name");
		assertEquals(name, Variables.Pokemon_name.field());
	}
}
