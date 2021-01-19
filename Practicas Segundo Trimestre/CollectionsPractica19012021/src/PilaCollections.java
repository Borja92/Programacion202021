import java.util.ArrayList;

public class PilaCollections {

    private final static int TAMANNO_PILA = 100;
    private ArrayList<Integer> integerArrayList;

    public PilaCollections() {
        this.integerArrayList = new ArrayList<>(TAMANNO_PILA);
    }

    public void push(int valor) {
        integerArrayList.add(valor);

    }

    public Integer pop() {
        Integer valor = this.integerArrayList.get(integerArrayList.size() - 1);
        integerArrayList.remove(integerArrayList.size() - 1);
        return valor;
    }

    public Integer top() {
        return integerArrayList.get(integerArrayList.size() - 1);
    }


    public boolean pilaCollectionsVacia() {

        return integerArrayList.isEmpty();

    }

    @Override
    public String toString() {
        return "PilaCollections{" +
                "integerArrayList=" + this.integerArrayList.toString() +
                '}';
    }
}
