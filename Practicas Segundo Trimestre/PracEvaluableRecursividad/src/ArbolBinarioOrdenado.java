/**
        *
        *Practica Evaluable sobre recursividad

        ---Árbol de Nodos---

        Autor:                 A. Borja Badía Checa

        *Instrucciones:
        *
        * 1. Escribe el método addValor, para que el nuevo nodo se inserte correctamente en el árbol.
        * 2. Escribe el método inArbol que comprueba si un cierto valor está presente en el árbol.
        * 3. Escribe el método "recorridoEnOrden" que realiza el recorrido en orden de un árbol binario.
        */

public class ArbolBinarioOrdenado {
    private int valor;
    private ArbolBinarioOrdenado hijoIzquierdo, hijoDerecho, arbol;

    /**
     * Declaración constructor
     */
    public ArbolBinarioOrdenado(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
        this.arbol = null;
    }


    /** Fin declaración construtor
     */

    /**
     * Declaración de Getters&Setters
     */
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public ArbolBinarioOrdenado getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(ArbolBinarioOrdenado hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public ArbolBinarioOrdenado getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(ArbolBinarioOrdenado hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public ArbolBinarioOrdenado getArbol() {
        return arbol;
    }

    public void setArbol(ArbolBinarioOrdenado arbol) {
        this.arbol = arbol;
    }

/** Fin declaración Getters&Setters
 */
    /**
     * Inicio declaración de métodos de la Clase Nodo
     */


    public  String pintarValor(){
       /* int casoBase=0;
        int menorCasoBase;
        int mayorCasoBase;

        if(valor>casoBase){
            mayorCasoBase=valor;
            System.out.print(mayorCasoBase + "\\");
        }
        if (valor<casoBase){
            menorCasoBase=valor;
            System.out.print(menorCasoBase + "/");
        } else         System.out.println("/" + valor + "\\");
*/
        //   pintar("", this, false);
        return valor+"";

    }

    public void addValor(int valor) {
        // Método recursivo:
        // Si valor < this.valor
        // añadir en el subárbol izquierdo*
        // En caso contrario
        // añadir en el subárbol derecho
        //
        // * Un subárbol es un nodo que apunta a otros.
        // ** El caso base es un subárbol nulo.

        if (valor<this.valor){
            if (hijoIzquierdo==null) {
                this.setHijoIzquierdo(new ArbolBinarioOrdenado(valor));
            }else
                this.hijoIzquierdo.addValor(valor);
        }
        else if (valor>this.valor){
            if (hijoDerecho==null) {
                this.setHijoDerecho(new ArbolBinarioOrdenado(valor));
            }else
                this.hijoDerecho.addValor(valor);
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

    public String recorridoEnOrden() {
        // La cadena devuelta es la concatenación en orden
        // de las siguientes cadenas:
        //
        // - La cadena correspondiente al hijo izquierdo
        // - El valor del nodo
        // - La cadena correspondiente al hijo derecho.
        //
        // El caso base es:
        // - Un nodo hijo vacío -> ""
        String resultado="";

        if (hijoIzquierdo!=null) {
            resultado+=hijoIzquierdo.recorridoEnOrden() + "";

        }

        resultado+=this.pintarValor();

        if (hijoDerecho!=null) {
            resultado+=hijoDerecho.recorridoEnOrden();
        }
    return resultado;
    }



   /* public void pintar (String prefijo, ArbolBinarioOrdenado nodo, boolean left) {
        if (nodo != null) {
            System.out.println(prefijo + (left ? "└── " : "├──") + nodo.valor);
            recorridoEnOrden();
            pintar(prefijo + (left ? "|   " : "    "), nodo.hijoIzquierdo, true);
            pintar(prefijo + (left ? "|   " : "    "), nodo.hijoDerecho, false);

        }
 }*/
    @Override
    public String toString() {
        return "\nArbolBinarioOrdenado{" +
                "valor=" + valor +
                ", hijoIzquierdo=" + hijoIzquierdo +
                ", hijoDerecho=" + hijoDerecho +
                ", arbol=" + arbol +
                '}';
    }
    public static void main(String[] args) {

        ArbolBinarioOrdenado arbolBinarioOrdenado= new ArbolBinarioOrdenado(0);

        arbolBinarioOrdenado.addValor(0);
        arbolBinarioOrdenado.addValor(1);
        arbolBinarioOrdenado.addValor(-1);
        arbolBinarioOrdenado.addValor(8);
        arbolBinarioOrdenado.addValor(-2);
        arbolBinarioOrdenado.addValor(9);
        arbolBinarioOrdenado.addValor(10);
        arbolBinarioOrdenado.addValor(11);
        arbolBinarioOrdenado.addValor(-88);
        arbolBinarioOrdenado.addValor(15);
        arbolBinarioOrdenado.addValor(16);
        arbolBinarioOrdenado.addValor(10);
        arbolBinarioOrdenado.addValor(12);
        arbolBinarioOrdenado.addValor(5);
        arbolBinarioOrdenado.addValor(27);
        arbolBinarioOrdenado.addValor(26);

        System.out.println(arbolBinarioOrdenado);

        arbolBinarioOrdenado.recorridoEnOrden();
        System.out.println();

     //   arbolBinarioOrdenado.pintarValor();


    }


}
