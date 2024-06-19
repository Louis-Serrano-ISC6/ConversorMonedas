import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultarApi {

    public Divisa consultarDivisa(String divisa) {

        URI direccionApi = URI.create("https://v6.exchangerate-api.com/v6/6abf9744304e2d8782895fb5/latest/" + divisa);

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(direccionApi)
                .build();

        try {

            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            ApiResponse apiResponse = new Gson().fromJson(respuesta.body(), ApiResponse.class);
            Map<String, Double> conversionRates = apiResponse.getConversionRates();

            // Ahora puedes obtener los valores de las divisas deseadas
            double mxn = conversionRates.getOrDefault("MXN", 0.0);
            double eur = conversionRates.getOrDefault("EUR", 0.0);
            double usd = conversionRates.getOrDefault("USD", 0.0);

            return new Divisa(mxn, eur, usd);

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la divisa", e);
        }
    }
}