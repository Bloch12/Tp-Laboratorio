import ClasesEstaticas.Menu;
import ClasesEstaticas.Pokedex;
import Enums.Naturaleza;

public class Main {
    public static void main(String[] args) {
        Pokedex.cargar();
        Menu.menu();
    }
}