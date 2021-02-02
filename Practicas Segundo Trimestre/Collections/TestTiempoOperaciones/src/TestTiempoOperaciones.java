import java.util.*;

public class TestTiempoOperaciones {

    public final static int INICIO_LISTA = 0;
    public final static int MITAD_LISTA = 1;
    private List<Integer> lista;

    Random rdn = new Random();
    Date date = new Date();


    public TestTiempoOperaciones(List<Integer> lista) {
        this.lista = lista;
    }

    public TestTiempoOperaciones() {
    }

    public long insertarElementos(int numElementos, int posicion) {
long tiempoTotal=System.currentTimeMillis();
//int valor=rdn.nextInt(100);
int valor=numElementos;
/*

   if (posicion==INICIO_LISTA){
       posicion=lista.get(INICIO_LISTA);
   }

   if (posicion==MITAD_LISTA){
       posicion=lista.get(lista.size()/2);
   }
*/


    for (int i = 0; i <numElementos ; i++) {
        lista.add(posicion,valor);
valor++;
    }


return tiempoTotal;
    }

  //  public long recorrerLista(){}

  /*  public long insertarElementos(int numElementos, int posicion)
    // Donde posicion = INICIO_LISTA | MITAD_LISTA
    public long borrarElementos(int numElementos, int posicion)
    // Donde posicion = INICIO_LISTA | MITAD_LISTA
    public long recorrerLista()
    public long ordenarLista() */

    @Override
    public String toString() {
        return "TestTiempoOperaciones{" +
                "lista=" + lista.toString() +
                '}';
    }

    public static void main(String[] args) {

        TestTiempoOperaciones testTiempoOperaciones = new TestTiempoOperaciones();
     System.out.println(testTiempoOperaciones.insertarElementos(1, INICIO_LISTA));

        System.out.println(testTiempoOperaciones.lista.toString());
    }

}
