import ClasesEstaticas.*;
import ControladorVentanas.ControladorVentanaEspeciePokemon;
import ControladorVentanas.ControladorVentanaPrincipal;
import Enums.Naturaleza;
import Objetos.MaquinasTecnicas;
import Objetos.ObjetoEvolutivo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pokedex.cargar();
        Mochila.cargar();
        GestorDeEquipo.bajar();
        ControladorVentanaPrincipal c = ControladorVentanaPrincipal.getInstance();
        c.setVentana(true);
    }
}