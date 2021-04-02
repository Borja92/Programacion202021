/**
 * Clase Parray que complementa el array nativo de java
 *
 * @author A. Borja Badía Checa
 * @version 1.0
 */

public class Parray {

    private int[] array;


    /**
     * Constructor que inicializa el array con un tamaño
     *
     * @param longitudArray Tamaño del array que queremos incializar
     */
    public Parray(int longitudArray) {
        this.array = new int[longitudArray];

    }

    /**
     * Constructor que dado un array copia todos sus datos
     *
     * @param valoresArray Array al que queremos realizar una copia
     */
    public Parray(int[] valoresArray) {

        this.array = valoresArray;
    }

    public int count() {

        return this.array.length;
    }

    private int[] getArray() {

        return this.array;
    }

    /**
     * Metodo que dado un indice devuelve el valor aosciado
     *
     * @param indice Indice del cual queremos obtener el valor del array
     * @return valor del array sobre el indice
     */
    public int getIndice(int indice) {
        if (indice <= getArray().length) {

            return this.array[indice];
        } else return -1;
    }

    /**
     * Metodo donde introducimos en el indice especificado el valor dado por parametros
     *
     * @param indice Indice donde se va a comprobar introducir el valor
     * @param valor  Valor que queremos añadir
     */
    public void setIndex(int indice, int valor) {
        if (indice <= getArray().length) {
            getArray()[indice] = valor;
        }

    }

    /**
     * Metodo que dado un valor busca si existe y devuelve un booleano
     *
     * @param valor Valor del que queremos saber si existe en el array al menos una vez
     * @return true si el valor existe en el array y false si no lo hace
     */
    public boolean in_array(int valor) {

        for (int n : this.array) {
            if (valor == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo donde introducimos a partir de un indice tantos valores como sea indicado
     *
     * @param indice       Indice por donde empezamos a añadir los valores
     * @param repeticiones Cantidad de veces que queremos añadir el valor
     * @param valor        valor que queremos añadir
     */
    public void array_fill(int indice, int repeticiones, int valor) throws Exception {

        if ((indice + repeticiones) > this.count()) {
            throw new Exception("El número de repeticiones excede la longitud del array");
        }
        for (int i = 0; i < repeticiones; i++) {
            this.setIndex(indice + i, valor);
        }
    }

    /**
     * Metodo un array con los valores invertidos respecto a nuestro parray
     *
     * @return Array invertido
     */
    public void array_reverse() {
        int aux;
        for (int i = 0; i < this.count() / 2; i++) {
            aux = this.getIndice(i);
            this.setIndex(i, this.getIndice(this.count() - 1) - i);
            this.setIndex((this.count() - 1) - i, aux);
        }
    }

    /**
     * Metodo que dado un array devuelve otro array con todos los valores que no coincidan con nuestro Parray
     *
     * @param arrayParam Array con el que vamos a comparar nuestro parray
     * @return Array con los valores que no coinciden con nuestro parray
     */
    public Parray array_diff(Parray arrayParam) {

        int count = 0;
        for (int i = 0; i < arrayParam.count(); i++) {
            if (!this.in_array(arrayParam.getIndice(i))) count++;
        }

        Parray parray = new Parray(count);

        count = 0;
        for (int k = 0; k < arrayParam.count(); k++) {
            if (!this.in_array(arrayParam.getIndice(k))) ;
            {
                count++;
            }
        }

        return parray;
    }

    public void mostrar() {


        for (int valor : this.array) {
            System.out.print(valor + ", ");
        }
        System.out.println();
    }

}

