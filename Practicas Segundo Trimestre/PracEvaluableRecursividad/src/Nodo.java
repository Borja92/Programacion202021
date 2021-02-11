/**
 * Practica Evaluable sobre recursividad
 *
 *                             ---Árbol de Nodos Binario---
 *
 * Autor:                 A. Borja Badía Checa
 *
 * Instrucciones:
 *
 * 1. Escribe el método addValor, para que el nuevo nodo se inserte correctamente en el árbol.
 * 2. Escribe el método inArbol que comprueba si un cierto valor está presente en el árbol.
 * 3. Escribe el método "recorridoEnOrden" que realiza el recorrido en orden de un árbol binario.
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

    /**
     * Fin declaración construtor
     * <p>
     * <p>
     * <p>
     * /**
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
        if (valor < this.valor) {
            if (hijoIzquierdo != null) { //Insertar en el subárbol izquierdo

                hijoIzquierdo.addValor(valor);
            } else {
                hijoIzquierdo = new Nodo(valor);
            }
        } else {
            if (hijoDerecho != null) { //Insertar en el subárbol derecho
                hijoDerecho.addValor(valor);
            } else {
                hijoDerecho = new Nodo(valor);
            }
        }
    }

    public boolean inArbol(int valor) {
        // Método recursivo:
        //
        // Un valor está en el árbol si está
        // en el nodo actual o bien en alguno de sus hijos.
        // El caso base es:
        // - Valor encontrado -> true
        // - Nodo nulo -> false
        boolean valorEnArbol = false;
        if (valor == this.valor) valorEnArbol = true;
        else if (valor < this.valor) {
            if (hijoIzquierdo == null) valorEnArbol = false;
            else return hijoIzquierdo.inArbol(valor);
        } else if (valor > this.valor) {
            if (hijoDerecho == null) valorEnArbol = false;
            else return hijoDerecho.inArbol(valor);
        }
        return valorEnArbol;

    }

//Nodo Izq -> Nodo Contenedor -> Nodo Der

    public void recorridoEnOrden() {
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
            if (hijoIzquierdo.valor < this.valor) {
                hijoIzquierdo.recorridoEnOrden();
            }
        }
        pintarValor();

        if (hijoDerecho != null) {
            if (hijoDerecho.valor > this.valor) {
                hijoDerecho.recorridoEnOrden();
            }
        }
    }


    public void pintarValor() {
        int casoBase =this.valor;
        int menorCasoBase;
        int mayorCasoBase;

        if (valor > casoBase) {
            mayorCasoBase = valor;
            System.out.println(mayorCasoBase + "\\");
        }
        if (valor < casoBase) {
            menorCasoBase = valor;
            System.out.println(menorCasoBase + "/");
        }

    }

    @Override
    public String toString() {
        return "\nNodo{" +
                "Valor=" + valor +
                ", HijoIzquierdo=" + hijoIzquierdo +
                ", HijoDerecho=" + hijoDerecho +
                '}';
    }

    /**
     * Fin declaración de métodos de la clase Nodo
     */

    public static void main(String[] args) {

        Nodo arbol = new Nodo(0);

        //Añadir elementos al árbol
        arbol.addValor(1);
        arbol.addValor(2);
        arbol.addValor(-4);
        arbol.addValor(4);
        arbol.addValor(5);
        arbol.addValor(18);
        arbol.addValor(7);
        arbol.addValor(8);
        arbol.addValor(9);
        arbol.addValor(10);
        arbol.addValor(-5);
        arbol.addValor(-17);
        arbol.addValor(-50);
        arbol.addValor(-4);
        arbol.addValor(3);
        arbol.addValor(-2);
        arbol.addValor(-1);
        arbol.addValor(5);
//Imprimir el árbol
        System.out.println();
        System.out.println(arbol); //Al imprimir el árbol tal cual se aprecia cómo desde la semilla, se reproducen los nodos, los cuales a su vez tienen hojas con otros valores o están vacíos(null)
        System.out.println();
        //Comprobar el método  inArbol
        System.out.println("El valor 7 se encuentra en el árbol: " + arbol.inArbol(7));
        System.out.println("El valor 3 se encuentra en el árbol: " + arbol.inArbol(3));
        System.out.println("El valor 99 se encuentra en el árbol: " + arbol.inArbol(99));
        System.out.println();
        //Recorrer arbol y mostrar nodos en orden <=0=>. Izquierda /(<) para valores menores,  drecha\(>) para valores mayores
        System.out.println("=====Imprimir árbol ordenado=====");
        arbol.recorridoEnOrden();
    }
}
