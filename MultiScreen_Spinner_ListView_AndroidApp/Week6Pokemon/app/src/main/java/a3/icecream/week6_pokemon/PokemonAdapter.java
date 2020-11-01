package a3.icecream.week6_pokemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import a3.icecream.week6_pokemon.model.Pokemon;

public class PokemonAdapter extends ArrayAdapter<Pokemon> { //extend ArrayAdapter of object

    private ArrayList<Pokemon> pokemons;

    //Making constructor with same 3 parameters: context, resource and object as of ArrayAdapter
    public PokemonAdapter(@NonNull Context context, int resource, @NonNull List<Pokemon> objects) {
        super(context, resource, objects);

        //Initialize class variable
        this.pokemons = (ArrayList)objects;
    }

    //set UI view on a dropdown menu
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return this.getView(position,convertView,parent);
    }

    //To set UI view on a single row
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //pick out a pokemon base on its position in the array
        Pokemon pokemon = this.pokemons.get(position);

        //Add template code to check if a view exist, if no, create one using our custom xml file
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_pokemon_layout,
                    parent,
                   false);

        }

        TextView tvname = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvtype = (TextView) convertView.findViewById(R.id.tvType);

        tvname.setText(pokemon.getName());
        tvtype.setText(pokemon.getType());


        return convertView;
    }
}
