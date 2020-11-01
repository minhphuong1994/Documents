package a3.icecream.week6_pokemon;

import java.util.ArrayList;

import a3.icecream.week6_pokemon.model.Pokemon;

public final class PokemonUtils {

    private PokemonUtils(){}

    public static ArrayList<Pokemon> loadPokemon(){
        ArrayList<Pokemon> list = new ArrayList<>();

        list.add(new Pokemon("Eevee", "Normal", "eevee", 75));
        list.add(new Pokemon("Pikachu", "Electric", "pikachu", 75));
        list.add(new Pokemon("Psyduck", "Psychique", "psyduck", 75));
        list.add(new Pokemon("Rattata", "Normal/Grass", "rattata", 75));
        list.add(new Pokemon("Snorlax", "Normal/Ground", "snorlax", 75));
        return list;
    }

    public static ArrayList<String> loadPokemonName(ArrayList<Pokemon> pokemons){
        ArrayList<String> list = new ArrayList<>();
        for (Pokemon p:pokemons){
            list.add(p.getName());
        }
        return list;
    }

}
