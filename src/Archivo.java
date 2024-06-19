import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Archivo {

    private static final String FILE_NAME = "src/historial.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void guardarDatos(double cantidadConversion, double totalConversion, String divisaOrigen, String divisaDestino) {
        List<Map<String, Object>> historial = cargarHistorial();

        // Crear un nuevo registro con la información y la fecha/hora actual
        Map<String, Object> nuevoRegistro = Map.of(
                "cantidadConversion", cantidadConversion,
                "totalConversion", totalConversion,
                "divisaOrigen", divisaOrigen,
                "divisaDestino", divisaDestino,
                "fechaHora", LocalDateTime.now().toString()
        );

        historial.add(nuevoRegistro);

        // Escribir el historial actualizado de vuelta al archivo
        guardarHistorial(historial);
    }

    private List<Map<String, Object>> cargarHistorial() {
        Path path = Paths.get(FILE_NAME);
        if (Files.exists(path)) {
            try {
                String contenido = Files.readString(path);
                Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
                return gson.fromJson(contenido, listType);
            } catch (IOException e) {
                throw new RuntimeException("Error al leer el archivo de historial", e);
            }
        } else {
            return new ArrayList<>();
        }
    }

    private void guardarHistorial(List<Map<String, Object>> historial) {
        Path path = Paths.get(FILE_NAME);
        try {
            String json = gson.toJson(historial);
            Files.writeString(path, json);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo de historial", e);
        }
    }

}
