import java.text.Normalizer;
import java.util.*;


public class ContadorPalabrasDistintas {

private HashSet<String> formaFinal = new HashSet<>();
    private String texto="Escribir un programa en Java que extraiga de un texto todas las palabras (Utilizando expresiones regulares) .\n" +
            "Se desea conocer cuántas palabras distintas existen en el texto dado, para ello, se deberán almacenar  y mostrar las palabras distintas (no repetidas) extraídas del texto en una estructura collection. \n" +
            "También se desea conocer el número de palabras distintas. Pingüino, Año";
    private int  numPalabrasDistintas=0;
    private StringTokenizer st1, st2;

    String normalizarTexto(){
        String textoFiltrado = texto;//Normalizer.normalize(texto, Normalizer.Form.NFD);
  textoFiltrado=   textoFiltrado.toLowerCase().replaceAll("[^\\dA-Za-z0-9Á-Úá-úüñ]"," ");
        st1= new StringTokenizer(textoFiltrado);

        String[] textoEnArray = textoFiltrado.split("[ ]+");


        for (String s:textoEnArray ) {
            formaFinal.add(s);
        }
        st2= new StringTokenizer(formaFinal.toString());
        return "Número de palabras totales: "+st1.countTokens()+". Número de palabras quitando las repetidas: "+st2.countTokens()+ " en el texto normalizado: \n"+formaFinal;
    }



    public static void main(String[] args) {

        ContadorPalabrasDistintas  contadorPalabrasDistintas= new ContadorPalabrasDistintas();
        System.out.println(contadorPalabrasDistintas.normalizarTexto());


    }
}
