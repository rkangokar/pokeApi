package service.testing.pokeApi;

import static org.testng.Assert.assertEquals;
import java.util.Random;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class FetchPokemonByNumber {
	
	PokemonRequest pokeReq;
	Random r;
	int n;

	public FetchPokemonByNumber() {
		pokeReq = new PokemonRequest();
		r = new Random();
		n = r.nextInt(808);
	}
	
	@Test(groups = {"disable"})
	public void fetchPokemonByNumber() {
		Response response = pokeReq.sendRequestByNumber(n);
		assertEquals(response.statusCode(), 200);
		String name = pokeReq.jsonPathofResponse(response).getString("name");
		System.out.println("Number of " + name + " is " + n);
	}
	
	@Test(groups = {"enable"})
	public void validatePokemonViaName() {
		Response response1 = pokeReq.sendRequestByNumber(n);
		String name = pokeReq.jsonPathofResponse(response1).getString("name");
		Response response2 = pokeReq.sendRequestByName(name); 
		String id = pokeReq.jsonPathofResponse(response2).getString("id");
		assertEquals(Integer.parseInt(id), n);
	}
}
