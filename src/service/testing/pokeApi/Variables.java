package service.testing.pokeApi;

public enum Variables {
	
	Domain("https://pokeapi.co/api/v2/"),
	FetchPokemon("pokemon/"),
	FetchType("type/"),
	FetchAbility("ability/"),
	Pokemon_name("raichu");
	
	private String field;
	
	Variables(String val) {
		this.field = val;
	}
	
	public String field() {
		return field;
	}
	
}
