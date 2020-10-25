/*import java.util.Scanner;

public class Practica13 {
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.println("Introduce una fecha dd/mm/aaaa");
        String fecha = lectorTeclado.nextLine();

        String dia = fecha.substring(0,2);

        String mes = fecha.substring(3,5);

        int year = Integer.valueOf(fecha.substring(6,10));
        if(year % 4 == 0 && year % 100 !=0){
            System.out.println("Es bisiesto");
        }
        else {
            if (year % 100 == 0 && year % 400 == 0) {
                System.out.println("Se encuentra dentro de un año bisiesto");
            }
            else
                System.out.println( "No se encuentra dentro de un año bisiesto");
        }

        if (mes.equals("01") ){
            mes = "enero";
        }
        if (mes.equals("02")){
            mes = "febrero";
        }
        if (mes.equals("03")){
            mes = "marzo";
        }
        if (mes.equals("04")){
            mes = "abril";
        }
        if (mes.equals("05")){
            mes = "mayo";
        }
        if (mes.equals("06")){
            mes = "junio";
        }
        if (mes.equals("07")){
            mes = "julio";
        }
        if (mes.equals("08")){
            mes = "agosto";
        }
        if (mes.equals("09")){
            mes = "septiembre";
        }
        if (mes.equals("10")){
            mes = "octubre";
        }
        if (mes.equals("11")){
            mes = "noviembre";
        }
        if (mes.equals("12")){
            mes = "diciembre";
        }
        System.out.println(dia + " de " +  mes + " de " +  year);
    }
}

 */