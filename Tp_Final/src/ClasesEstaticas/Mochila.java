package ClasesEstaticas;

import Almacenamiento.AlmacenamientoDeDatos;
import Almacenamiento.Equipo;
import Exepciones.ValorNoValidoExeption;
import Objetos.MaquinasTecnicas;
import Objetos.Objeto;
import Objetos.ObjetoEvolutivo;

import java.util.ArrayList;
import java.util.Iterator;

public class Mochila {
    private static AlmacenamientoDeDatos<Objeto> mochila = new AlmacenamientoDeDatos<>();
    public static void cargar(){
        ArrayList<ObjetoEvolutivo> aux = GestorDeArchivosObjetos.leer("ObjetosEvolutivos.dat");
        for (ObjetoEvolutivo o: aux) {
            mochila.agregar(o.getNombre(),o);
        }
        ArrayList<MaquinasTecnicas> aux2 = GestorDeArchivosObjetos.leer("Mt&Mo.dat");
        for (MaquinasTecnicas o: aux2) {
            mochila.agregar(o.getNombre(),o);
        }
    }


    public static Objeto getObjeto(String key) throws ValorNoValidoExeption{
        if(tieneObjeto(key)){
            return mochila.buscar(key);
        }
        throw new ValorNoValidoExeption("Objeto No Encontrado");
    }

    public static boolean tieneObjeto(String key){
        return mochila.contienteClave(key);
    }




}
