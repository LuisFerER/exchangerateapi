package principal;

import calculos.ConsultaConversion;
import calculos.RealizarConversion;
import modelos.TipoDeCambio;
import modelos.TipoDeCambioAPI;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        int opcion = 0;
        TipoDeCambioAPI miTipoDeCambioAPI;
        TipoDeCambio miTipoDeCambio;
        double valor;

        ConsultaConversion miConsultaConversion = new ConsultaConversion();
        RealizarConversion conversion;

        while(opcion != 7){
           System.out.println("***Bienvenido/a al Conversor de Moneda***");
            System.out.println("1) Dolar => Peso Argentino");
            System.out.println("2) Peso Argentino => Dolar");
            System.out.println("3) Dolar => Real Brasileño");
            System.out.println("4) Real Brasileño => Dolar");
            System.out.println("5) Dolar => Peso Colombiano");
            System.out.println("6) Peso Colombiano => Peso Dolar");
            System.out.println("7) Salir");
            System.out.print("Elije una opcion valida: ");
            opcion = Integer.valueOf(lectura.next());

            switch (opcion){
                case 1:
                    System.out.println("Ingresa el valor que deseas convertir:");
                    valor = Double.valueOf(lectura.next());
                    miTipoDeCambioAPI = miConsultaConversion.obtenerTasa("USD");
                    miTipoDeCambio = new TipoDeCambio(miTipoDeCambioAPI);
                    miTipoDeCambio.setValorBase(valor);
                    conversion = new RealizarConversion(miTipoDeCambio, "ARS");
                    miTipoDeCambio.setValorConvertido(conversion.resultadoConversion());
                    System.out.println("El valor de "+miTipoDeCambio.getValorBase()+" [USD] corresponde al valor final de => "+miTipoDeCambio.getValorConvertido()+" [ARS]");
                    break;

                case 2:
                    System.out.println("Ingresa el valor que deseas convertir:");
                    valor = Double.valueOf(lectura.next());
                    miTipoDeCambioAPI = miConsultaConversion.obtenerTasa("ARS");
                    miTipoDeCambio = new TipoDeCambio(miTipoDeCambioAPI);
                    miTipoDeCambio.setValorBase(valor);
                    conversion = new RealizarConversion(miTipoDeCambio, "USD");
                    miTipoDeCambio.setValorConvertido(conversion.resultadoConversion());
                    System.out.println("El valor de "+miTipoDeCambio.getValorBase()+" [ARS] corresponde al valor final de => "+miTipoDeCambio.getValorConvertido()+" [USD]");
                    break;

                case 3:
                    System.out.println("Ingresa el valor que deseas convertir:");
                    valor = Double.valueOf(lectura.next());
                    miTipoDeCambioAPI = miConsultaConversion.obtenerTasa("USD");
                    miTipoDeCambio = new TipoDeCambio(miTipoDeCambioAPI);
                    miTipoDeCambio.setValorBase(valor);
                    conversion = new RealizarConversion(miTipoDeCambio, "BRL");
                    miTipoDeCambio.setValorConvertido(conversion.resultadoConversion());
                    System.out.println("El valor de "+miTipoDeCambio.getValorBase()+" [USD] corresponde al valor final de => "+miTipoDeCambio.getValorConvertido()+" [BRL]");
                    break;

                case 4:
                    System.out.println("Ingresa el valor que deseas convertir:");
                    valor = Double.valueOf(lectura.next());
                    miTipoDeCambioAPI = miConsultaConversion.obtenerTasa("BRL");
                    miTipoDeCambio = new TipoDeCambio(miTipoDeCambioAPI);
                    miTipoDeCambio.setValorBase(valor);
                    conversion = new RealizarConversion(miTipoDeCambio, "USD");
                    miTipoDeCambio.setValorConvertido(conversion.resultadoConversion());
                    System.out.println("El valor de "+miTipoDeCambio.getValorBase()+" [BRL] corresponde al valor final de => "+miTipoDeCambio.getValorConvertido()+" [USD]");
                    break;

                case 5:
                    System.out.println("Ingresa el valor que deseas convertir:");
                    valor = Double.valueOf(lectura.next());
                    miTipoDeCambioAPI = miConsultaConversion.obtenerTasa("USD");
                    miTipoDeCambio = new TipoDeCambio(miTipoDeCambioAPI);
                    miTipoDeCambio.setValorBase(valor);
                    conversion = new RealizarConversion(miTipoDeCambio, "COP");
                    miTipoDeCambio.setValorConvertido(conversion.resultadoConversion());
                    System.out.println("El valor de "+miTipoDeCambio.getValorBase()+" [USD] corresponde al valor final de => "+miTipoDeCambio.getValorConvertido()+" [COP]");
                    break;

                case 6:
                    System.out.println("Ingresa el valor que deseas convertir:");
                    valor = Double.valueOf(lectura.next());
                    miTipoDeCambioAPI = miConsultaConversion.obtenerTasa("COP");
                    miTipoDeCambio = new TipoDeCambio(miTipoDeCambioAPI);
                    miTipoDeCambio.setValorBase(valor);
                    conversion = new RealizarConversion(miTipoDeCambio, "USD");
                    miTipoDeCambio.setValorConvertido(conversion.resultadoConversion());
                    System.out.println("El valor de "+miTipoDeCambio.getValorBase()+" [COP] corresponde al valor final de => "+miTipoDeCambio.getValorConvertido()+" [USD]");
                    break;

                case 7:
                    System.out.println("Gracias por usar nuestro sistema Conversor de Moneda. Hasta pronto.");
                    break;

                default:
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
            }
        }

//        String conversion = "USD/MXN";
//
//        ConsultaConversion consulta = new ConsultaConversion();
//        double conversionFinal = consulta.obtenerTasa(conversion);
//        System.out.println(conversionFinal);

    }
}
