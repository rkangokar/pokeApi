package service.testing.pokeApi;

import static org.testng.Assert.assertEquals;
import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class FetchPokemonTypeByNumber {
	
	PokemonRequest pokeReq;
	Random r;
	int n;
	
	public FetchPokemonTypeByNumber() {
		pokeReq = new PokemonRequest();
		r = new Random();
		n = r.nextInt(18);
	}
	
	@Test(groups = {"enable"})
	public void validateResponse() {
		Response response = pokeReq.sendRequestForType(9);
		String typeName = pokeReq.jsonPathofResponse(response).getString("name");
		System.out.println("Name of type# " + 9 + " is " + typeName);
		assertEquals(response.getStatusCode(), 200, "StatusCode mismatch");
	}
	
	@Test(groups = {"enable"})
	public void getListOfPokemonbyType() {
		Response response = pokeReq.sendRequestForType(n);
		List<String> list = pokeReq.jsonPathofResponse(response).getList("pokemon.pokemon.name");
		System.out.println(list.size());
	}
}
