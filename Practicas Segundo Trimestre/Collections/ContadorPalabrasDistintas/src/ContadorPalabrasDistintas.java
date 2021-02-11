import java.text.Normalizer;
import java.util.*;


public class ContadorPalabrasDistintas {

private TreeSet<String> formaFinal = new TreeSet<>();
    private String texto="Escribir un programa en Java que extraiga de un texto todas las palabras (Utilizando expresiones regulares) .\n" +
            "Se desea conocer cuántas palabras distintas existen en el texto dado, para ello, se deberán almacenar  y mostrar las palabras distintas (no repetidas) extraídas del texto en una estructura collection. \n" +
            "También se desea conocer el número de palabras distintas. Pingüino, Año";
    private int  numPalabrasDistintas=0;
    private StringTokenizer st;

    String normalizarTexto(){
        String textoFiltrado = texto;//Normalizer.normalize(texto, Normalizer.Form.NFD);
  textoFiltrado=   textoFiltrado.toLowerCase().replaceAll("[^\\dA-Za-z0-9Á-Úá-úüñ]"," ");
        st= new StringTokenizer(textoFiltrado);

        String[] textoEnArray = new String[textoFiltrado.length()];

        for (int i = 0; i <textoFiltrado.length(); i++) {

            formaFinal.add(textoFiltrado);
        }
      //  textoEnArray.(textoFiltrado.split("[ ]+"));

       // Iterator <String> it=textoEnArray.iterator();

  /*      while (it.hasNext()){

            formaFinal.add(it.next());
        }
*/
        return "Número de palabras: "+st.countTokens()+" en el texto normalizado: "+formaFinal;
    }



    public static void main(String[] args) {

        ContadorPalabrasDistintas  contadorPalabrasDistintas= new ContadorPalabrasDistintas();
        System.out.println(contadorPalabrasDistintas.normalizarTexto());


    }
}
