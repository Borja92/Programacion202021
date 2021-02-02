import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestTiempoOperacionesArrayList {
    public final static int INICIO_LISTA = 0;
    public final static int MITAD_LISTA = 1;

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();

    Random rdn = new Random();
    Date date = new Date();
    long instanteInicio = System.currentTimeMillis();


    public TestTiempoOperacionesArrayList() {

        this.arrayList = arrayList;
        this.linkedList= linkedList;

    }



    public long insertarElementos(int numElementos, int posicion) {
//Inserción en el principio
        rdn.setSeed(date.getTime());
        if (posicion == INICIO_LISTA) {
            for (int i = 0; i < numElementos; i++) {
                arrayList.add(posicion, rdn.nextInt(5000));
            }
        }
//Inserción en la mitad
        if (posicion == MITAD_LISTA) {
            posicion = arrayList.size() / 2;

            for (int i = 0; i < numElementos; i++) {
                arrayList.add(posicion, rdn.nextInt(5000));
            }
        }
        return System.currentTimeMillis() - instanteInicio;
    }

    public long recorrerLista() {

      /*  for (int i = 0; i <arrayList.size() ; i++) {
            //arrayList.get(i);
        }*/
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            System.out.print("[" + it.next() + "]");
        }
        System.out.println();

        return System.currentTimeMillis() - instanteInicio;
    }

    public long ordenarLista() {
        Collections.sort(arrayList);
        return System.currentTimeMillis() - instanteInicio;
    }

    public long borrarElementos(int numElementos, int posicion) {
        // Donde posicion = INICIO_LISTA | MITAD_LISTA

        //Eliminar desde  el principio

        if (posicion == INICIO_LISTA) {
            /*for (int i = posicion; i < numElementos; i++) {
                arrayList.remove(i);
            }*/
            Iterator<Integer> it=arrayList.iterator();
            while (it.hasNext()&numElementos>0){
                arrayList.remove(arrayList.get(posicion));
            numElementos--;
            }

        }
//Eliminar desde la mitad
        if (posicion == MITAD_LISTA) {
           posicion = arrayList.size() /2;
            /*for (int i =posicion; i < numElementos; i++) {
//this.arrayList.removeAll(Collections.singleton(i));
   arrayList.remove(arrayList.size()-1);
            }*/
if (posicion%2==0){
            Iterator<Integer> it=arrayList.iterator();

            while (it.hasNext()&&numElementos>0){

                arrayList.remove(arrayList.get(posicion));
numElementos--;
            }}
else {
    //Si posición es impar le resto uno, para volverlo par y así poder dividir el array en dos y proceder a borrarlo n veces
   posicion-=1;
    Iterator<Integer> it=arrayList.iterator();

    while (it.hasNext()&&numElementos>0){

        arrayList.remove(arrayList.get(posicion));
numElementos--;
    }
        }}

        return System.currentTimeMillis() - instanteInicio;
    }

    @Override
    public String toString() {
        return "TestTiempoOperacionesLinkedList{" +
                "arrayList=" + arrayList +
                '}';
    }

    public static void main(String[] args) {

        TestTiempoOperacionesArrayList testTiempoOperacionesArrayList = new TestTiempoOperacionesArrayList();
        TestTiempoOperacionesLinkedList testTiempoOperacionesLinkedList = new TestTiempoOperacionesLinkedList();
        System.out.println("Tiempo en milisegundos inserción al principio del Array List: " + testTiempoOperacionesArrayList.insertarElementos(15, INICIO_LISTA));
        System.out.println();
        System.out.println("Tiempo en milisegundos inserción al principio del LinkedList: " + testTiempoOperacionesLinkedList.insertarElementosLinkedList(15, INICIO_LISTA));
        System.out.println();

        System.out.println(testTiempoOperacionesArrayList.toString());
        System.out.println(testTiempoOperacionesLinkedList);
        System.out.println();
        System.out.println("Tiempo en milisegundos inserción en mitad del Array List: " + testTiempoOperacionesArrayList.insertarElementos(5, MITAD_LISTA));
        System.out.println("Tiempo en milisegundos inserción en mitad del Linked List: " + testTiempoOperacionesLinkedList.insertarElementosLinkedList(5, MITAD_LISTA));
        System.out.println();
        System.out.println(testTiempoOperacionesArrayList.toString());
        System.out.println(testTiempoOperacionesLinkedList);
        System.out.println();
        System.out.println("Tiempo en milisegundos recorrer arrayList: " + testTiempoOperacionesArrayList.recorrerLista());
        System.out.println("Tiempo en milisegundos recorrer Linked List: " + testTiempoOperacionesLinkedList.recorrerListaLinkedList());
        System.out.println();
        System.out.println("Tiempo de ArrayList de ordenador de menor a mayor: " + testTiempoOperacionesArrayList.ordenarLista());
        System.out.println("Tiempo de LinkedList de ordenador de menor a mayor: " + testTiempoOperacionesLinkedList.ordenarListaLinkedList());
        System.out.println();
        System.out.println("Array List Ordenado de mayor a menor: " + testTiempoOperacionesArrayList.toString());
        System.out.println("Linked List Ordenado de mayor a menor: " + testTiempoOperacionesLinkedList);
        System.out.println();
        System.out.println("Tiempo en milisegundos que tarda en borrar N elementos en un ArrayList desde el inicio: "+testTiempoOperacionesArrayList.borrarElementos(10,INICIO_LISTA));
        System.out.println("Tiempo en milisegundos que tarda en borrar N elementos en un LinkedList desde el inicio: "+testTiempoOperacionesLinkedList.borrarElementosLinkedList(10,INICIO_LISTA));
        System.out.println();
        System.out.println(testTiempoOperacionesArrayList.toString());
        System.out.println(testTiempoOperacionesLinkedList);
        System.out.println();
        System.out.println("Tiempo en milisegundos que tarda en borrar N elementos en un ArrayList desde la mitad: "+testTiempoOperacionesArrayList.borrarElementos(6,MITAD_LISTA));
        System.out.println("Tiempo en milisegundos que tarda en borrar N elementos en un Linked List desde la mitad: "+testTiempoOperacionesLinkedList.borrarElementosLinkedList(6,MITAD_LISTA));
        System.out.println();
        System.out.println(testTiempoOperacionesArrayList.toString());
        System.out.println(testTiempoOperacionesLinkedList);
        System.out.println("Tiempo en milisegundos que tarda en borrar N elementos en un ArrayList desde el inicio: "+testTiempoOperacionesArrayList.borrarElementos(2,MITAD_LISTA));
        System.out.println("Tiempo en milisegundos que tarda en borrar N elementos en un Linked List desde el inicio: "+testTiempoOperacionesLinkedList.borrarElementosLinkedList(2,MITAD_LISTA));
        System.out.println();
        System.out.println(testTiempoOperacionesArrayList.toString());
        System.out.println(testTiempoOperacionesLinkedList);

    }
}
