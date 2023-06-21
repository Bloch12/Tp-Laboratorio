import ClasesEstaticas.GestorDeEquipo;
import ClasesEstaticas.Menu;
import ClasesEstaticas.Pokedex;
import ControladorVentanas.ControladorVentanaEspeciePokemon;
import ControladorVentanas.ControladorVentanaPrincipal;
import Enums.Naturaleza;

public class Main {
    public static void main(String[] args) {
        Pokedex.cargar();
        GestorDeEquipo.bajar();
        ControladorVentanaPrincipal c = ControladorVentanaPrincipal.getInstance();
        c.setVentana(true);
    }
}