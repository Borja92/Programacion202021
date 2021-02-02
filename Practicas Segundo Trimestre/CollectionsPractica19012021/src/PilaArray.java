import java.util.Arrays;

public class PilaArray implements Pila{

    private final static int TAMANNO_PILA = 100;
    private Integer[] array;
    private int cima;

    public PilaArray() {

        this.array = new Integer[TAMANNO_PILA];
        this.cima = -1;
    }

    public void push(Integer valor) {

        cima++;
        array[cima] = valor;
    }

    public Integer pop() {

        Integer valor = array[cima];
        cima--;
        return valor;
    }

    public Integer top() {
        return array[cima];
    }

    public boolean pilaVacia() {
        return (cima == -1);
    }

    @Override
    public String toString() {
        return "PilaArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
