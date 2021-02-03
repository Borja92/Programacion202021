public class TestTiempoOperacionesApp {

    private static final int INICIO_LISTA = 0;
    private static final int MITAD_LISTA = 1;

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
