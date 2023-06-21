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

    /**
     * Carga todos los objetos de un archivo binario
     */
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

    /**
     * Devuelve el objeto guardado con la clave key, lanza una exeption si este no existe
     * @param key
     * @return el objeto
     * @throws ValorNoValidoExeption
     */

    public static Objeto getObjeto(String key) throws ValorNoValidoExeption{
        if(tieneObjeto(key)){
            return mochila.buscar(key);
        }
        throw new ValorNoValidoExeption("Objeto No Encontrado");
    }

    /**
     * Consulta si existe el objeto
     * @param key
     * @return true/false dependiendo si existe o no
     */

    public static boolean tieneObjeto(String key){
        return mochila.contienteClave(key);
    }




}
