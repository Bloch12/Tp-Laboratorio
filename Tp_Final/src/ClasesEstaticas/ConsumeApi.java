package ClasesEstaticas;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConsumeApi {

    /**
     * Se le pasa el url de una API y devuelve los datos en formato json
     * @param link el link donde se encuentra el json
     * @return un String con todos los datos del json
     * @throws RuntimeException
     */
    public static String getInfo(String link)
    {
        try
        {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != 200)
            {
                throw new RuntimeException("Codigo de error: "+responseCode);
            }
            else
            {
                StringBuilder stringBuilder = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext())
                {
                    stringBuilder.append(scanner.nextLine());
                }
                scanner.close();
                return stringBuilder.toString();
            }
        }
        catch (IOException exception)
        {
            System.out.println(exception.getMessage());
        }
        return "";
    }

}
