package calculos;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import modelos.TipoDeCambio;
import modelos.TipoDeCambioAPI;

import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaConversion {

    String API_KEY;

    public TipoDeCambioAPI obtenerTasa(String codigoBase){
        //URI direccion = URI.create("https://v6.exchangerate-api.com/v6/42cb8ed89c636c787cc28d80/pair/"+consulta);
        API_KEY = consultaAPI();
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/latest/"+codigoBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
//            //Conversión a JSON
//            JsonElement elemento = JsonParser.parseString(response.body());
//            JsonObject objectRoot = elemento.getAsJsonObject();
//            //Accediendo a JsonObject
//            double tasa = objectRoot.get("conversion_rate").getAsDouble();
//            return tasa;
            return new Gson().fromJson(response.body(), TipoDeCambioAPI.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontre moneda.");
        }
    }

    private String consultaAPI(){
        try{
            Properties properties = new Properties();
            properties.load(new FileInputStream("config.properties"));
            String API_KEY = properties.getProperty("API_KEY");
            return API_KEY;
        } catch (Exception e) {
            throw new RuntimeException("Error cargando config.properties: " + e.getMessage());
        }
    }

}
