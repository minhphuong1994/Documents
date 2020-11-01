package a3.icecream.week6_pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import a3.icecream.week6_pokemon.model.Pokemon;

public class MainActivity extends AppCompatActivity {
    final String TAG="PHUONG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Pokemon> pokemons = PokemonUtils.loadPokemon();

        ArrayList<String> pokemonNames = PokemonUtils.loadPokemonName(pokemons);

        Spinner spPokemon = (Spinner) findViewById(R.id.spPokemon);

        //Adapter for pokemon names
        ArrayAdapter<String> Adapter1 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                pokemonNames);

        //Adapter for pokemon objects
        PokemonAdapter Adapter2 = new PokemonAdapter(
                this,
                R.layout.custom_pokemon_layout,
                pokemons);

        spPokemon.setAdapter(Adapter2);


        //ListView doesn't use the getDropDownView function in PokemonAdapter class
        ListView lvPokemon = (ListView) findViewById(R.id.lvPokemon);
        lvPokemon.setAdapter(Adapter2);

    }
}