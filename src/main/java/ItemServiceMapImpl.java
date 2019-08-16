import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class ItemServiceMapImpl {

    public static String loginUser(String urlPost) {
        try {
            URL url = new URL(urlPost);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");
            if (con instanceof HttpURLConnection) {
                HttpURLConnection connection = (HttpURLConnection) con;
                System.out.println("\nSending request to URL : " + url);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuffer response = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
                return response.toString();
            } else {
                System.out.println("URL invalida");
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }



    public static String getSites(String urlGet) throws IOException {
        /*StringBuilder stringBuilder = new StringBuilder(strUrl);
        stringBuilder.append("?username=");
        stringBuilder.append(URLEncoder.encode(username, "UTF-8"));
        stringBuilder.append("&token=");
        stringBuilder.append(URLEncoder.encode(token, "UTF-8"));
        */
        try {
        URL url = new URL(urlGet);
        URLConnection con = url.openConnection();
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        if (con instanceof HttpURLConnection) {
            HttpURLConnection connection = (HttpURLConnection) con;
            System.out.println("\nSending request to URL : " + url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            return response.toString();
        } else {
            System.out.println("URL invalida");
            return null;
        }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getCategories(String urlGet) throws IOException {
        /*StringBuilder stringBuilder = new StringBuilder(strUrl);
        stringBuilder.append("?username=");
        stringBuilder.append(URLEncoder.encode(username, "UTF-8"));
        stringBuilder.append("&token=");
        stringBuilder.append(URLEncoder.encode(token, "UTF-8"));
        */
        try {
            URL url = new URL(urlGet);
            URLConnection con = url.openConnection();
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            if (con instanceof HttpURLConnection) {
                HttpURLConnection connection = (HttpURLConnection) con;
                System.out.println("\nSending request to URL : " + url);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuffer response = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
                return response.toString();
            } else {
                System.out.println("URL invalida");
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }





}
