package ClasesEstaticas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class GestorDeColecciones {

    public GestorDeColecciones() {
    }

    public static <T extends Number> double sumarDatosColeccion(ArrayList<T> arr) {
        double rta = 0;
        for (T t : arr) {
            rta += t.doubleValue();
        }
        return rta;
    }

   public static <T extends Number> double sumarDatosColeccion(HashSet<T> set) {
        double rta = 0;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            rta += ((T) it.next()).doubleValue();
        }
        return rta;
    }


    /**
     * se le pasa un arreglo y lo lista
     * @param a el arreglo a listar
     * @return el listado del arreglo
     */
    public static String CollecionAString(ArrayList a) {
        String rta = "";
        for (int i = 0; i < a.size(); i++) {
            rta += a.get(i).toString() + "\n";
        }
        return rta;
    }

    public static String CollecionAString(HashSet set) {
        String rta = "";
        Iterator it = set.iterator();
        while(it.hasNext()){
            rta += it.next().toString() + "\n";
        }
        return rta;
    }


}

