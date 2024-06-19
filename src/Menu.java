
import java.util.Scanner;

public class Menu {

    private Scanner entrada;
    private ConsultarApi consultarApi;
    private Archivo archivo;


    public Menu() {
        System.out.println("Bienvenido al conversor de monedas");
        System.out.println();

        this.entrada = new Scanner(System.in);
        this.consultarApi = new ConsultarApi();
        this.archivo = new Archivo();
    }


    void menu(){
        while (true){
            System.out.println("Menu de divisas predefinidas");
            System.out.println("1. Dolar a Euro");
            System.out.println("2. Euro a Dolar");
            System.out.println("3. Dolar a Pesos Mexicanos");
            System.out.println("4. Pesos Mexicanos a Dolar");
            System.out.println("5. Euro a Pesos Mexicanos");
            System.out.println("6. Pesos Mexicanos a Euro");
            System.out.println("7. Salir");
            System.out.println();
            System.out.print("Opcion > ");
            int opcion = entrada.nextInt();

            if (opcion == 1){
                System.out.println("--------------------");
                System.out.println("Dolar a Euro");
                Divisa datos = consultarApi.consultarDivisa("USD");
                System.out.println("1 Dolar equivale a " + datos.EUR() + " Euros");
                System.out.println("Ingresa la cantidad de dolares a convertir a Euros");
                double cantidad = entrada.nextDouble();
                System.out.println(cantidad + " Dolares equivalen a " + (cantidad * datos.EUR()) + " Euros");
                System.out.println("--------------------");

                System.out.println("Deseas guardar la conversion? (s/n)");
                String guardar = entrada.next();
                if (guardar.equals("s")) {
                    System.out.println("Conversion guardada");
                    archivo.guardarDatos(cantidad, cantidad * datos.EUR(), "USD", "EUR");
                }
                System.out.println("--------------------");

            } else if (opcion == 2){
                System.out.println("--------------------");
                System.out.println("Euro a Dolar");
                Divisa datos = consultarApi.consultarDivisa("EUR");
                System.out.println("1 Euro equivale a " + datos.USD() + " Dolares");
                System.out.println("Ingresa la cantidad de Euros a convertir a Dolares");
                double cantidad = entrada.nextDouble();
                System.out.println(cantidad + " Euros equivalen a " + (cantidad * datos.USD()) + " Dolares");
                System.out.println("--------------------");

                System.out.println("Deseas guardar la conversion? (s/n)");
                String guardar = entrada.next();
                if (guardar.equals("s")) {
                    System.out.println("Conversion guardada");
                    archivo.guardarDatos(cantidad, cantidad * datos.USD(), "EUR", "USD");
                }
                System.out.println("--------------------");

            } else if (opcion == 3){
                System.out.println("--------------------");
                System.out.println("Dolar a Pesos Mexicanos");
                Divisa datos = consultarApi.consultarDivisa("USD");
                System.out.println("1 Dolar equivale a " + datos.MXN() + " Pesos Mexicanos");
                System.out.println("Ingresa la cantidad de dolares a convertir a Pesos Mexicanos");
                double cantidad = entrada.nextDouble();
                System.out.println(cantidad + " Dolares equivalen a " + (cantidad * datos.MXN()) + " Pesos Mexicanos");
                System.out.println("--------------------");

                System.out.println("Deseas guardar la conversion? (s/n)");
                String guardar = entrada.next();

                if (guardar.equals("s")) {
                    System.out.println("Conversion guardada");
                    archivo.guardarDatos(cantidad, cantidad * datos.MXN(), "USD", "MXN");
                }
                System.out.println("--------------------");

            } else if (opcion == 4){
                System.out.println("--------------------");
                System.out.println("Pesos Mexicanos a Dolar");
                Divisa datos = consultarApi.consultarDivisa("MXN");
                System.out.println("1 Peso Mexicano equivale a " + datos.USD() + " Dolares");
                System.out.println("Ingresa la cantidad de Pesos Mexicanos a convertir a Dolares");
                double cantidad = entrada.nextDouble();

                System.out.println(cantidad + " Pesos Mexicanos equivalen a " + (cantidad / datos.USD()) + " Dolares");
                System.out.println("--------------------");

                System.out.println("Deseas guardar la conversion? (s/n)");
                String guardar = entrada.next();
                if (guardar.equals("s")) {
                    System.out.println("Conversion guardada");
                    archivo.guardarDatos(cantidad, cantidad / datos.USD(), "MXN", "USD");
                }

            } else if (opcion == 5) {
                System.out.println("--------------------");
                System.out.println("Euro a Pesos Mexicanos");
                Divisa datos = consultarApi.consultarDivisa("EUR");
                System.out.println("1 Euro equivale a " + datos.MXN() + " Pesos Mexicanos");
                System.out.println("Ingresa la cantidad de Euros a convertir a Pesos Mexicanos");
                double cantidad = entrada.nextDouble();
                System.out.println(cantidad + " Euros equivalen a " + (cantidad * datos.MXN()) + " Pesos Mexicanos");
                System.out.println("--------------------");

                System.out.println("Deseas guardar la conversion? (s/n)");
                String guardar = entrada.next();
                if (guardar.equals("s")) {
                    System.out.println("Conversion guardada");
                    archivo.guardarDatos(cantidad, cantidad * datos.MXN(), "EUR", "MXN");
                }
                System.out.println("--------------------");

            } else if (opcion == 6) {
                System.out.println("--------------------");
                System.out.println("Pesos Mexicanos a Euro");
                Divisa datos = consultarApi.consultarDivisa("MXN");
                System.out.println("1 Peso Mexicano equivale a " + datos.EUR() + " Euros");
                System.out.println("Ingresa la cantidad de Pesos Mexicanos a convertir a Euros");
                double cantidad = entrada.nextDouble();
                System.out.println(cantidad + " Pesos Mexicanos equivalen a " + (cantidad / datos.EUR()) + " Euros");
                System.out.println("--------------------");

                System.out.println("Deseas guardar la conversion? (s/n)");
                String guardar = entrada.next();
                if (guardar.equals("s")) {
                    System.out.println("Conversion guardada");
                    archivo.guardarDatos(cantidad, cantidad / datos.EUR(), "MXN", "EUR");
                }
                System.out.println("--------------------");

            }  else if (opcion == 7) {
                System.exit(0);
            }

        }


    }




}
