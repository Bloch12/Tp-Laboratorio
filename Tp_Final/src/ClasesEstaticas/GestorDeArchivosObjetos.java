package ClasesEstaticas;

import java.io.*;
import java.util.ArrayList;

public class GestorDeArchivosObjetos {
    /**
     * Carga un arreglo de un objeto serializable en un archivo de nombre dado
     * @param objetos
     * @param nombreArchivo
     * @param <T>
     */
    public static <T extends Serializable> void  grabar(ArrayList<T> objetos,String nombreArchivo) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream(nombreArchivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (T o : objetos)
            {
                objectOutputStream.writeObject(o);
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();

                if (objectOutputStream != null)
                    objectOutputStream.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Devuelve un arreglo de un objeto serializable extraido de un archivo
     * @param nombreArchvo
     * @return
     * @param <T>
     */

    public static <T extends Serializable> ArrayList<T> leer(String nombreArchvo)
    {
        ArrayList<T> objetos = new ArrayList<>();

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try
        {
            fileInputStream = new FileInputStream(nombreArchvo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            while (true)
            {
                T aux = (T) objectInputStream.readObject();
                objetos.add(aux);
            }
        }
        catch (EOFException ex)
        {
            System.out.println("FIN de ARCHIVO");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (fileInputStream!=null)
                    fileInputStream.close();

                if (objectInputStream!=null)
                    objectInputStream.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }

        }
        return objetos;
    }

}
