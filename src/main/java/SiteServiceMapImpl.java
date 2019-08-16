import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class SiteServiceMapImpl implements ISiteService {


    private final String meliSite = "https://api.mercadolibre.com/sites";
    private final String meliCategories = "categories";

    @Override
    public String getSites() throws IOException{

        Gson gson = new Gson();

        try{

            // Llamo al metodo setURL para pedir el json
            BufferedReader in = setURL(meliSite);

            // Pido el body (json) de lo que tuve en esta URL
            Site[] sites = gson.fromJson(in,Site[].class);

            // Lo ordeno y lo retorno ordenado
            Operador<Site> operator = new Operador<Site>();
            Site.criteria = Site.Criteria.NAME;
            Operador.ordenar(sites);

            return gson.toJson( sites );

        } catch (SocketException e){

            System.out.println(e.toString());
            throw e;

        } catch (IOException e){

            System.out.println(e.toString());
            throw e;
        }


    }


    @Override
    public String getCategories( String id ) throws IOException{
        Gson gson = new Gson();

        try{

            BufferedReader in = setURL(meliSite + "/"+id+"/"+meliCategories);

            Categories[] categories = gson.fromJson(in,Categories[].class);

            Operador<Categories> operator = new Operador<Categories>();
            Site.criteria = Site.Criteria.NAME;
            Operador.ordenar(categories);

            return gson.toJson( categories );

        } catch (SocketException e) {

            System.out.println(e.toString());
            throw e;

        } catch (IOException e){

            System.out.println(e.toString());
            throw e;
        }
    }

    private static BufferedReader setURL(String Url) throws IOException {

        // Almaceno en un buffer el response del site que llame
        URL url = new URL(Url);

        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("Accept", "application/json");

        if (urlConnection instanceof HttpURLConnection) {

            try {
                HttpURLConnection connection = (HttpURLConnection) urlConnection;
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                return in;

            } catch (SocketException e){
                System.out.println(e.toString());
                throw e;

            }

        } else {
            return null;
        }

    }

}
