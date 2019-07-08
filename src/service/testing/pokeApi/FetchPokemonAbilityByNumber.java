package service.testing.pokeApi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;
import java.util.Random;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class FetchPokemonAbilityByNumber {
	
	PokemonRequest pokeReq;
	Random r; 
	int n; 
	String abilityName;
	
	public FetchPokemonAbilityByNumber() {
		pokeReq = new PokemonRequest();
		r = new Random();
		n = r.nextInt(233);
		
	}
	
	public List<String> getListOfPokemonWithAbilityN(int n) {
		Response response = pokeReq.sendRequestForAbility(n);
		List<String> list = pokeReq.jsonPathofResponse(response).getList("pokemon.pokemon.name");
		System.out.println("List of Pokemons : ");
		for(String name : list) {
			System.out.println(name);
		}
		return list;
	}

	@BeforeTest
	public void validateResponse() {
		Response response = pokeReq.sendRequestForAbility(n);
		abilityName = pokeReq.jsonPathofResponse(response).getString("name");
		System.out.println("Ability : " + abilityName);
		assertEquals(response.getStatusCode(), 200);	
	}
		
	@Test(groups = {"enable"})
	public void validatePokemonHasAbility() {
		List<String> list = getListOfPokemonWithAbilityN(n);
		Response response = pokeReq.sendRequestByName(list.get(list.size()-1));
		List<String> abilities = pokeReq.jsonPathofResponse(response).getList("abilities.ability.name");
		for(String ability : abilities) {
			if(ability.equalsIgnoreCase(abilityName)) {
				assertTrue(true);
				break;
			}
		}	
	}
}