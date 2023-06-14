import ClasesEstaticas.Pokedex;
import Poderes.Movimiento;
import Pokemones.PokemonDatos;

public class Main {
    public static void main(String[] args) {
        Pokedex.cargar();
        System.out.println(Pokedex.buscarPokemon("rockruff"));

        /*
        Movimiento mov = new Movimiento("double-slap","https://pokeapi.co/api/v2/move/1/");
        mov.cargar();
        System.out.println(mov.toString());
        */

    }
}