package objects;

import java.awt.*;

public class Pokemon {
    String pokename;
    Image pokemon_img;

    public Pokemon(String pokename) {
        this.pokename = pokename;
    }

    public Pokemon(String pokename, Image pokemon_img) {
        this.pokename = pokename;
        this.pokemon_img = pokemon_img;
    }

    public String getPokename() {
        return pokename;
    }

    public void setPokename(String pokename) {
        this.pokename = pokename;
    }

    public Image getPokemon_img() {
        return pokemon_img;
    }

    public void setPokemon_img(Image pokemon_img) {
        this.pokemon_img = pokemon_img;
    }
}
