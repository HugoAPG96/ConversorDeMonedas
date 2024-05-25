import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        var opcion=0;
        var codigoMoneda1 = "";
        var codigoMoneda2="";

        while (opcion!=9){
            try {
                System.out.println("\nSea bienvenido/a al Conversor de Moneda\n\n"+
                                    "1) Dolar => Peso argentino\n"+
                                    "2) Peso argentino => Dólar\n"+
                                    "3) Dolar => Real Brazileño\n"+
                                    "4) Real brazileño => Dólar\n"+
                                    "5) Dolar => Peso colombiano\n"+
                                    "6) Peso colombiano => Dólar\n"+
                                    "7) Dólar => Sol peruano\n"+
                                    "8) Sol peruano => Dólar\n"+
                                    "9) Salir\n"+
                        "Elija una opcion valida"+
                        "*********************************************");
                opcion = Integer.valueOf(lectura.nextLine());

                switch (opcion){
                    case 1:
                        codigoMoneda1="USD";codigoMoneda2="ARS";
                        break;
                    case 2:
                        codigoMoneda1="ARS";codigoMoneda2="USD";
                        break;
                    case 3:
                        codigoMoneda1="USD";codigoMoneda2="BRL";
                        break;
                    case 4:
                        codigoMoneda1="BRL";codigoMoneda2="USD";
                        break;
                    case 5:
                        codigoMoneda1="USD";codigoMoneda2="COP";
                        break;
                    case 6:
                        codigoMoneda1="COP";codigoMoneda2="USD";
                        break;
                    case 7:
                        codigoMoneda1="USD";codigoMoneda2="PEN";
                        break;
                    case 8:
                        codigoMoneda1="PEN";codigoMoneda2="USD";
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Opción no valida");
                }
                if (opcion==9){
                    System.out.println("Cerrando aplicación");
                    break;
                }
                System.out.println("Ingrese el monto a convertir");
                var cantidad = Double.valueOf(lectura.nextLine());
                Moneda moneda = consulta.buscaMoneda(codigoMoneda1, codigoMoneda2,cantidad);
                System.out.println("El valor "+codigoMoneda1+" corresponde al valor "+codigoMoneda2+" "+moneda.conversion_rate());
                System.out.println("La conversion del monto es "+codigoMoneda2+" "+moneda.conversion_result());
            }catch (NumberFormatException e){
                System.out.println("Codigo de moneda no encontrada");
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
            }
        }
    }
}
