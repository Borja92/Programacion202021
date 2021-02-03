import java.util.*;

public class TestTiempoOperacionesLinkedList{
        private final  int INICIO_LISTA = 0;
        private final  int MITAD_LISTA = 1;

        private LinkedList<Integer> linkedList = new LinkedList<>();

        Random rdn = new Random();
        Date date = new Date();
        long instanteInicio = System.currentTimeMillis();


        public TestTiempoOperacionesLinkedList() {

            this.linkedList= linkedList;

        }



        public long insertarElementosLinkedList(int numElementos, int posicion) {
//Inserción en el principio
            rdn.setSeed(date.getTime());
            if (posicion == INICIO_LISTA) {
                for (int i = 0; i < numElementos; i++) {
                    linkedList.add(posicion, rdn.nextInt(5000));
                }
            }
//Inserción en la mitad
            if (posicion == MITAD_LISTA) {
                posicion = linkedList.size() / 2;

                for (int i = 0; i < numElementos; i++) {
                    linkedList.add(posicion, rdn.nextInt(5000));
                }
            }
            return System.currentTimeMillis() - instanteInicio;
        }

        public long recorrerListaLinkedList() {


            Iterator<Integer> it = linkedList.iterator();
            while (it.hasNext()) {
                System.out.print("[" + it.next() + "]");
            }
            System.out.println();

            return System.currentTimeMillis() - instanteInicio;
        }

        public long ordenarListaLinkedList() {
            Collections.sort(linkedList);
            return System.currentTimeMillis() - instanteInicio;
        }

        public long borrarElementosLinkedList(int numElementos, int posicion) {
            // Donde posicion = INICIO_LISTA | MITAD_LISTA

            //Eliminar desde  el principio

            if (posicion == INICIO_LISTA) {

                Iterator<Integer> it=linkedList.iterator();
                while (it.hasNext()&numElementos>0){
                    linkedList.remove(linkedList.get(posicion));
                    numElementos--;
                }

            }
//Eliminar desde la mitad
            if (posicion == MITAD_LISTA) {
                posicion = linkedList.size() /2;

                if (posicion%2==0){
                    Iterator<Integer> it=linkedList.iterator();

                    while (it.hasNext()&&numElementos>0){

                        linkedList.remove(linkedList.get(posicion));
                        numElementos--;
                    }}
                else {
                    //Si posición es impar le resto uno, para volverlo par y así poder dividir el array en dos y proceder a borrarlo n veces
                    posicion-=1;
                    Iterator<Integer> it=linkedList.iterator();

                    while (it.hasNext()&&numElementos>0){

                        linkedList.remove(linkedList.get(posicion));
                        numElementos--;
                    }
                }}

            return System.currentTimeMillis() - instanteInicio;
        }

    @Override
    public String toString() {
        return "TestTiempoOperacionesLinkedList{" +
                "linkedList=" + linkedList +
                '}';
    }
}


