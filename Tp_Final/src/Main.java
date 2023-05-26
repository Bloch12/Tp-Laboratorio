public class Main {
    public static void main(String[] args) {
        Pokedex.cargarPokemones();
        Integer num = 156;
        System.out.println(Pokedex.buscarPokeom(num.toString()));
    }
}