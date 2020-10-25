/*14- Haz un programa que presente en pantalla una palabra,
de modo que aparezca en la primera línea una letra en la
siguiente dos y así sucesivamente hasta completar la palabra.*/

import java.util.Scanner;

public class Prac14 {
    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        System.out.println("Introduce una palabra: ");
        String palabra=src.nextLine();

int contador= palabra.length();

        for (int i = 1; i <contador ; i++) {

            System.out.println(palabra.substring(0,i+1));
        }

    }

}
