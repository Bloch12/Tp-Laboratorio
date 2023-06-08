package ClasesEstaticas;

import Pokemones.PokemonDatos;

public class Main {
    public static void main(String[] args) {
        Pokedex.cargarPokemones();
        System.out.println(Pokedex.buscarPokemon("pikachu"));


    }
}