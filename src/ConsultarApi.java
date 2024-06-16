import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarApi {

    public Divisa consultarDivisa(String divisa) {

        URI direccionAPi = URI.create("https://api.exchangerate-api.com/v4/latest/" + divisa);

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(direccionAPi)
                .build();

        try {

            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(respuesta.body(), Divisa.class);

        }catch (Exception e) {
            throw new RuntimeException("Error al consultar la divisa");
        }
    }

}
