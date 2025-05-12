package calculos;

import com.google.gson.Gson;
import modelos.TipoDeCambioAPI;

import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaConversion {

    public TipoDeCambioAPI obtenerTasa(String codigoBase){
        String apiKey = consultaAPI();
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+codigoBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), TipoDeCambioAPI.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontre moneda.");
        }
    }

    private String consultaAPI(){
        try (FileInputStream fis = new FileInputStream("config.properties")) {  // Aquí se usa try-with-resources
            Properties properties = new Properties();
            properties.load(fis);
            String API_KEY = properties.getProperty("API_KEY");
            return API_KEY;
        } catch (Exception e) {
            throw new RuntimeException("Error cargando 'API_KEY' desde config.properties: " + e.getMessage(), e);
        }
    }
}
