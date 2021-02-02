import java.util.ArrayList;

public class PilaCollections implements Pila{

    private final static int TAMANNO_PILA = 100;
    private ArrayList<Integer> integerArrayList;

    public PilaCollections() {
        this.integerArrayList = new ArrayList<>(TAMANNO_PILA);
    }



    @Override
    public void push(Integer valor) {
        integerArrayList.add(valor);

    }

    public Integer pop() {
    return integerArrayList.remove(integerArrayList.size()-1);
    }

    public Integer top() {
        return integerArrayList.get(integerArrayList.size() - 1);
    }

    @Override
    public boolean pilaVacia() {
        return integerArrayList.isEmpty();
    }




    @Override
    public String toString() {
        return "PilaCollections{" +
                "integerArrayList=" + this.integerArrayList.toString() +
                '}';
    }
}
