package ClasesEstaticas;

import Almacenamiento.AlmacenamientoDeDatos;
import Almacenamiento.Equipo;
import Objetos.MaquinasTecnicas;
import Objetos.Objeto;
import Objetos.ObjetoEvolutivo;

import java.util.ArrayList;
import java.util.Iterator;

public class Mochila {
    private static AlmacenamientoDeDatos<Objeto> mochila;
    public static void cargar(){
        ArrayList<ObjetoEvolutivo> aux= GestorDeArchivosObjetos.leer("ObjetosEvolutivos.dat");
        for (ObjetoEvolutivo o: aux) {
            mochila.agregar(o.getNombre(),o);
        }
        ArrayList<MaquinasTecnicas> aux2= GestorDeArchivosObjetos.leer("Mt&Mo.dat");
        for (MaquinasTecnicas o: aux2) {
            mochila.agregar(o.getNombre(),o);
        }
    }

    public static String verObjetos(){
        String rta = "";
        ArrayList<ObjetoEvolutivo> aux= GestorDeArchivosObjetos.leer("ObjetosEvolutivos.dat");
        rta += GestorDeColecciones.CollecionAString(aux);
        ArrayList<MaquinasTecnicas> aux2= GestorDeArchivosObjetos.leer("Mt&Mo.dat");
        rta += GestorDeColecciones.CollecionAString(aux2);
        return rta;
    }

    public static String usarObjeto(String nombre, Equipo equipo, int pokemon){
        return mochila.buscar(nombre).usar(equipo,pokemon);
    }




}
