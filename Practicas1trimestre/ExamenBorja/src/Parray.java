public class Parray {

    private int[] array;

    //Constructor inicializa array por parámetro
    public Parray(int size) {

        array = new int[size];
    }

    //Constructor inicializa array con valores de otro array pasado por parámetros
    public Parray(int[] arrayParametro) {

        array = new int[arrayParametro.length];
        for (int i = 0; i < arrayParametro.length; i++) {
            array[i] = arrayParametro[i];
        }
    }

    //Constructor vacío
    /*public Parray() {

    }*/
//Getters&Setters
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    //Método que devuelve el número de elementos de un array
    public int ContadorValoresArray(int[] array) {
        int numElementosEnArray = array.length;
        return numElementosEnArray;

    }

    //Método que devuelve el valor del indice de un array pasado por parámetros
    public int DevuelveValorEnArraySegunIndice(int[] array, int indice) {
        return array[indice];
    }

//Método introduce un valor en una posición determinada en un array

    public int IntroduceValorEnIndice(int[] array, int indice, int valor) {

        return array[indice] = valor;

    }

    //Método que comprueba si un valor existe en el array

    public boolean ValorEnArray(int[] array, int valor) {

        boolean elValorSeEncuentraEnElArray = false;
        for (int i = 0; i < array.length; i++) {

            if (valor == array[i]) {

                return elValorSeEncuentraEnElArray = true;
            }
        }
        return Boolean.parseBoolean("¿El valor se encuentra en el array?" + elValorSeEncuentraEnElArray);
    }

//Llena el array con valores pasados por parámetros indicando el indice en el que se empieza

    public int[] RellenarArrayConValoresApartirDeIndiceIndicado(int[] array, int indice, int valor, int numVeces) {
        do {

            numVeces--;
            array[indice] = valor;
            indice++;
        } while (numVeces > 0);

return array;
    }
//Método que devuelve un array con los elementos en orden inverso

public int[]  DevolverArrayInvertido(int [] array){
int [] arrayAlReves = new int[array.length];
    for (int i = array.length-1, j=0; i >=0 ; i--,j++) {
            arrayAlReves[j]=array[i];
            //System.out.print(arrayAlReves[j]+" ");
    }
    return arrayAlReves;
}

//Método que calcula la diferencia entre arrays y devuelve los valores no repetidos

public int [] ValoresDiferentesEnArrays(int[] array1, int[] array2){
        int[] auxArray=new int[array1.length];
        int aux = 0;
    for (int i = 0, j=0; i <array1.length ;  i++, j++) {

        if (array1[i]!=array2[j]){
            aux=array1[i];
        }
auxArray[i]=aux;
        System.out.println(aux.);
    }

        return auxArray;
}

}

