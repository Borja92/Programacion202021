import javax.swing.*;
import java.text.Normalizer;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AppPalindroma extends JOptionPane {

    private LinkedList<Character> cola = new LinkedList<>();
    private LinkedList<Character> pila = new LinkedList<>();
    private int espaciosBlancos=0;
    private StringTokenizer st;
    private String cadena="";

    String normalizarCadena(){

        Scanner src = new Scanner(System.in);
        System.out.println("Introduce una frase para comprobar si es palíndroma o no: ");
         cadena= src.nextLine();
        String cadenaFiltrada = Normalizer.normalize(cadena, Normalizer.Form.NFD); // Normaliza una secuencia de valores de caracteres. La secuencia se normalizará de acuerdo con la normalización especificada (Canonical Descomposition)
        cadenaFiltrada = cadenaFiltrada.toLowerCase().replaceAll("[\\s+\\p{InCombiningDiacriticalMarks},]", ""); // Sin espacios ni comas y en minusculas

        // Contador de  Espacios en Blanco
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                espaciosBlancos++;
            }}
        //conteo de palábras en la frase
         st= new StringTokenizer(cadena); //Gracias a esta clase contaremos las palabras separadas por espacio fácilmente
return cadenaFiltrada;
    }

    void esPalindroma() {
        boolean esPalindroma = true;
        String cadenaNormalizada=normalizarCadena();
        int longitud = cadenaNormalizada.length();

        //Llenamos la pila y la cola con los valores de la frase
        for (int i = 0; i < longitud; i++) {
            cola.add(cadenaNormalizada.charAt(i));
            pila.add(cadenaNormalizada.charAt(i));
        }
        //ahora comparamos la pila y la cola para comprobar si hay palíndromo o no
//Método pop se utiliza para extraer el primer elemento de la pila, además lo devuelve
//Método pollLast se utilizar para extraer el último elemento de la cola, además también lo devuelve
        while (!cola.isEmpty()) {
            if (pila.pop() != cola.pollLast()) {
                esPalindroma = false;
            }
        }
        if (esPalindroma) {
            JOptionPane.showMessageDialog(this, "La cadena: "+cadena+" es palíndroma. \nTiene " + (st.countTokens()) + " palábras y un total de  "+espaciosBlancos+" espacios en blanco.");
        } else {
            JOptionPane.showMessageDialog(this, "La cadena: " +cadena+"  NO es palíndroma. \nTiene " + (st.countTokens()) + " palábras y un total de " +espaciosBlancos+ " espacios en blanco.");
        }
    }


    public static void main(String[] args) {
        AppPalindroma appPalindroma = new AppPalindroma();
      /* appPalindroma.esPalindroma("Dábale arroz a la zorra el Abad");
        appPalindroma.esPalindroma("Dábale lentejas a la zorra el Abad");*/
appPalindroma.esPalindroma();
    }
}
