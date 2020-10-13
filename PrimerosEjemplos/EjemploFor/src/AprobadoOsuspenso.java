import java.util.Scanner;

public class AprobadoOsuspenso {

    public static void main(String[] args) {

        Scanner src= new Scanner(System.in);
        int aprobados=0;
        int reprobados=0;

        for (int f=0;f<10;f++){

            System.out.println("Introduce la nota de un alumno: ");

            int notaAlumno=src.nextInt();

        if(notaAlumno<7){
            reprobados++;

        } else {
            aprobados++;

        }


        }

        System.out.println("Alumnos aprobados: "+aprobados);
        System.out.println("Alumnos suspensos: "+reprobados);
    }
}
