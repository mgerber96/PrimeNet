package PrimeNet;

//import com.google.gson.Gson;

import com.google.gson.Gson;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by behrends on 11/04/16.
 */

public class MovieDatabase {
    private static String apiKey;

    private static final String HOST = "api.themoviedb.org";
    private static final String PATH_PREFIX = "3/search/";

    // read API key from file (happens only once after JVM start)
    static {
        try {
            Properties properties = new Properties();
            BufferedInputStream stream = new BufferedInputStream(new FileInputStream("config.properties"));
            properties.load(stream);
            stream.close();
            apiKey = properties.getProperty("api.key");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MovieData getCurrentWeatherDataForCity(String city) {
        String path = PATH_PREFIX + "movie?";
        String queryString = "api_key=" + apiKey + "&query=" + "Filmname durch Suchfeld" + "&page=" + "1" + "&include_adult=" + "false";

        try {
            URL url = new URI("http", HOST, path, queryString, null).toURL();
            Reader reader = new InputStreamReader(url.openStream());
            return new Gson().fromJson(reader, MovieData.class);
        } catch (URISyntaxException | IOException e) {
            System.err.println("An error occurred while requesting data from weather API.");
        }

        return null;
    }
}
