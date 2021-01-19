/*Para probar que cada pila es correcta, hacer las siguientes pruebas:
        Una pila donde no se ha insertado nada, está vacía (pilaVacia == true).
        Al insertar (push) los valores 1, 2 y 3:
        1. La cima (top) devuelve 3
        2. La cima (pop) devuelve 3
        3. La cima (top) devuelve 2
        4. La cima (pop) devuelve 2
        5. La cima (pop) devuelve 1
        6. la pila está vacía (pilaVacia == true)*/

public class PilasApp {

    public static void main(String[] args) {
        //Comprobaciones array estático
        System.out.println("=====Comprobaciones métodos Array estático=====");

        //Llamada a la clase PilaArray
        PilaArray pilaArrayEstatico = new PilaArray();
        //Comprobamos el estado de la pila
        System.out.println("Una pila dónde no se ha insertado nada, está vavía (pilaVacia==true).");
        System.out.println("¿Está vacía la pila? " + pilaArrayEstatico.pilaVacia());
//Insertamos valores en la pila vacía
        System.out.println("Al insertar (push) los valores 1, 2 y 3");
        System.out.println("Insertar valor 1= (push(1))");
        pilaArrayEstatico.push(1);

        System.out.println("Insertar valor 2= (push(2))");
        pilaArrayEstatico.push(2);

        System.out.println("Insertar valor 3= (push(3))");
        pilaArrayEstatico.push(3);
        System.out.println();
        //Mostramos la cima de la pila mediante el método top
        System.out.println("La cima (top) devuelve el elemento 3=" + pilaArrayEstatico.top());
        System.out.println();
        //Removemos el último valor de la pila además mostramos cuál es mediante el método pop
        System.out.println("La cima (pop) devuelve 3");
        System.out.println("Valor de la cima actual que además es sacado de esta: " + pilaArrayEstatico.pop());
        System.out.println();
        System.out.println("La cima (top) devuelve el elemento 2= " + pilaArrayEstatico.top());
        System.out.println("La cima (pop) devuelve 2");
        System.out.println("Valor de la cima actual que además es sacado de esta: " + pilaArrayEstatico.pop());
        System.out.println();
        System.out.println("La cima (top) devuelve el elemento 1=" + pilaArrayEstatico.top());
        System.out.println("La cima (pop) devuelve 1");
        System.out.println("Valor de la cima actual que además es sacado de esta: " + pilaArrayEstatico.pop());
        System.out.println();
        //Volvemos a comprobar si la pila está vacía
        System.out.println("¿Está vacía la pila?" + pilaArrayEstatico.pilaVacia());
        System.out.println();

        //Comprobaciones del Array dinámico
        System.out.println("=====Comprobaciones métodos Array dinámico=====");
        System.out.println();
        //Llamada a la clase PilaCollections
        PilaCollections pilaCollections = new PilaCollections();

        //Comprobamos estado de la pila
        System.out.println("Una pila dónde no se ha insertado nada, está vavía (pilaVacia==true).");
        System.out.println("¿Está vacía la pila? " + pilaCollections.pilaCollectionsVacia());
        System.out.println();
        //Añadimos elementos 1, 2 y 3 a la pila
        System.out.println("Al insertar (push) los valores 1, 2 y 3");

        System.out.println("Insertar valor 1= (push(1))");
        pilaCollections.push(1);
        System.out.println("Insertar valor 2= (push(2))");
        pilaCollections.push(2);
        System.out.println("Insertar valor 3= (push(3))");
        pilaCollections.push(3);
        System.out.println();

        //Mostramos la cima de la pila mediante el método top
        System.out.println("La cima (top) devuelve el elemento 3=" + pilaCollections.top());
        //Removemos el último valor de la pila además mostramos cuál es mediante el método pop
        System.out.println("La cima (pop) devuelve 3");
        System.out.println("Valor de la cima actual que además es sacado de esta: " + pilaCollections.pop());
        System.out.println();
        System.out.println("La cima (top) devuelve el elemento 2=" + pilaCollections.top());
        System.out.println();
        System.out.println("La cima (pop) devuelve 2");
        System.out.println("Valor de la cima actual que además es sacado de esta: " + pilaCollections.pop());
        System.out.println();
        System.out.println("La cima (top) devuelve el elemento 1=" + pilaCollections.top());
        System.out.println("La cima (pop) devuelve 1");
        System.out.println("Valor de la cima actual que además es sacado de esta: " + pilaCollections.pop());
        System.out.println();
//Comprobamos que la pila ha quedado vacía
        System.out.println("¿La pila está vacía?" + pilaCollections.pilaCollectionsVacia());
//        System.out.println(pilaCollections);

    }
}
