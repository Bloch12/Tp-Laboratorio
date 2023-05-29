package ClasesEstaticas;

public class Main {
    public static void main(String[] args) {
        Pokedex.cargarPokemones();
        System.out.printf("AA");
        System.out.println(Pokedex.buscarPokeom("ditto"));
        System.out.printf("AA");
    }
}