import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestTiempoOperacionesArrayList {
    private final  int INICIO_LISTA = 0;
    private final  int MITAD_LISTA = 1;

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


}
