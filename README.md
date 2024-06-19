# Conversor de Monedas

## Descripción del Proyecto

El proyecto "Conversor de Monedas" es una aplicación de consola que permite a los usuarios convertir entre varias divisas predefinidas utilizando una API de tipo `ExchangeRate`. Además, el programa puede guardar un historial de conversiones en un archivo JSON y mostrar dicho historial en la consola.

## Estructura del Proyecto

El proyecto consta de las siguientes clases:

### Divisa

La clase `Divisa` es un `record` que representa las tasas de cambio de distintas divisas. Esta clase se utiliza para almacenar las tasas de cambio obtenidas de la API.

### ConsultarApi

La clase `ConsultarApi` se encarga de consultar la API de tipo `ExchangeRate` para obtener las tasas de cambio. Utiliza la biblioteca `HttpClient` para realizar peticiones HTTP y `Gson` para deserializar la respuesta JSON en una instancia de `Divisa`.

### Archivo

La clase `Archivo` maneja la persistencia de datos, guardando y cargando el historial de conversiones en un archivo JSON. Los métodos principales son:

- `guardarDatos`: Guarda una nueva conversión en el historial, incluyendo la fecha y hora de la conversión.
- `cargarHistorial`: Carga el historial de conversiones desde el archivo JSON.
- `mostrarHistorial`: Muestra el historial de conversiones en la consola.

### Menu

La clase `Menu` proporciona una interfaz de usuario en la consola. Muestra un menú con opciones para realizar conversiones entre diferentes divisas, guardar las conversiones y mostrar el historial. Las opciones del menú son:

1. Dólar a Euro
2. Euro a Dólar
3. Dólar a Pesos Mexicanos
4. Pesos Mexicanos a Dólar
5. Euro a Pesos Mexicanos
6. Pesos Mexicanos a Euro
7. Mostrar historial
8. Salir

## Funcionamiento

1. **Inicio**: Al iniciar la aplicación, se muestra un menú con las opciones de conversión disponibles.
2. **Conversión**: El usuario selecciona una opción de conversión, ingresa la cantidad a convertir y puede optar por guardar la conversión en el historial.
3. **Guardar Historial**: Si el usuario decide guardar la conversión, los datos se guardan en un archivo JSON junto con la fecha y hora de la conversión.
4. **Mostrar Historial**: El usuario puede ver el historial de conversiones guardadas, que se muestra en la consola en formato JSON.
5. **Salir**: El usuario puede salir de la aplicación seleccionando la opción correspondiente.

## Requisitos

- Java 11 o superior
- Biblioteca `Gson` para manejo de JSON

## Ejecución

Para ejecutar el proyecto, compila las clases y ejecuta la clase `Main`.

