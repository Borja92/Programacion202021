/**
*
*Practica Evaluable sobre recursividad

                            ---Árbol de Nodos---

 Autor:                 A. Borja Badía Checa

 *Instrucciones:
 *
 * 1. Escribe el método addValor, para que el nuevo nodo se inserte correctamente en el árbol.
 * 2. Escribe el método inArbol que comprueba si un cierto valor está presente en el árbol.
 * 3. Escribe el método "recorridoEnOrdenIzqDerech" que realiza el recorrido en orden de un árbol binario.
 */

public class Nodo {

    private int valor;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

/**
     * Declaración constructor
   */


    public Nodo(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

/** Fin declaración construcor



/**
     * Declaración de Getters&Setters
   */


    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

/** Fin declaración Getters&Setters
*/

/**
     * Inicio declaración de métodos de la Clase Nodo
   */


    public void addValor(int valor) {
        // Método recursivo:
        // Si valor < this.valor
        // añadir en el subárbol izquierdo*
        // En caso contrario
        // añadir en el subárbol derecho
        //
        // * Un subárbol es un nodo que apunta a otros.
        // ** El caso base es un subárbol nulo.
        if(valor<this.valor){
            if (hijoIzquierdo!=null){
                hijoIzquierdo.addValor(valor);
            } else {
                hijoIzquierdo= new Nodo(valor);
        }
        } else {
            if (hijoDerecho!=null){
                hijoDerecho.addValor(valor);
            } else {
                hijoDerecho=new Nodo(valor);
            }
            }
}

    public boolean inArbol(int valor){
        // Método recursivo:
        //
        // Un valor está en el árbol si está
        // en el nodo actual o bien en alguno de sus hijos.
        // El caso base es:
        // - Valor encontrado -> true
        // - Nodo nulo -> false
    boolean valorEnArbol=false;
if (valor == this.valor) valorEnArbol=true;
        else if (valor < this.valor) {
            if (hijoIzquierdo == null) valorEnArbol= false;
            else return hijoIzquierdo.inArbol(valor);
        } else if (valor > this.valor) {
            if (hijoDerecho == null) valorEnArbol=false;
            else return hijoDerecho.inArbol(valor);
        }
        return valorEnArbol;

    }

//Nodo Izq -> Nodo Contenedor -> Nodo Der

    public void recorridoEnOrdenIzqDerech() {
        // La cadena devuelta es la concatenación en orden
        // de las siguientes cadenas:
        //
        // - La cadena correspondiente al hijo izquierdo
        // - El valor del nodo
        // - La cadena correspondiente al hijo derecho.
        //
        // El caso base es:
        // - Un nodo hijo vacío -> ""
        if (hijoIzquierdo != null) {
            hijoIzquierdo.recorridoEnOrdenIzqDerech();
        }
        if (hijoIzquierdo != null) {
            hijoIzquierdo.recorridoEnOrdenIzqDerech();
        }
        System.out.print(pintarValor());
    }

    //Nodo Árbol -> Nodo Izq -> Nodo Derecho

    public  void recorridoEnOrdenArbolIzqDerech(){
        System.out.print(pintarValor());
        if (hijoIzquierdo!=null){
            hijoIzquierdo.recorridoEnOrdenArbolIzqDerech();
        }
        if (hijoDerecho!=null){
            hijoDerecho.recorridoEnOrdenArbolIzqDerech();
        }
    }

    public  String pintarValor(){
        return valor+" ";
    }
    @Override
    public String toString() {
        return "Nodo{" +
                "valor=" + valor +
                ", hijoIzquierdo=" + hijoIzquierdo +
                ", hijoDerecho=" + hijoDerecho +
                '}';
    }

/** Fin declaración de métodos de la clase Nodo
*/

public static void main(String[] args) {

    Nodo arbol = new Nodo(0);

    //Añadir elementos al árbol
    arbol.addValor(1);
    arbol.addValor(2);
    arbol.addValor(3);
    arbol.addValor(4);
    arbol.addValor(5);
    arbol.addValor(6);
    arbol.addValor(7);
    arbol.addValor(8);
    arbol.addValor(9);
    arbol.addValor(10);
    arbol.addValor(-5);
    arbol.addValor(-17);
    arbol.addValor(-50);
    arbol.addValor(-88);
//Imprimir el árbol
    System.out.println(arbol);
    System.out.println();
    //Comprobar el método que inArbol
    System.out.println("El valor 7 se encuentra en el árbol: "+arbol.inArbol(7));
    System.out.println("El valor 3 se encuentra en el árbol: "+arbol.inArbol(3));
    System.out.println("El valor 99 se encuentra en el árbol: "+arbol.inArbol(99));

    //Recorrer arbol y mostrar valores menores que el caso base
    System.out.println("Nodos menores que el caso base: ");
    arbol.recorridoEnOrdenIzqDerech();
    System.out.println();
    //Recorrer arbol y mostrar valores mayores que el caso base
    System.out.println("Nodos mayores que el caso base: ");
    arbol.recorridoEnOrdenArbolIzqDerech();

}
}
