public class UndoRedoApp {
    public static void main(String[] args) {
Ficha ficha = new Ficha();
//Mover arriba 5 veces
ficha.moverArriba();
ficha.moverArriba();
ficha.moverArriba();
ficha.moverArriba();
ficha.moverArriba();

        System.out.println(ficha.toString());
//Mover a la derecha 6 veces
        ficha.moverDerecha();
        ficha.moverDerecha();
        ficha.moverDerecha();
        ficha.moverDerecha();
        ficha.moverDerecha();
        ficha.moverDerecha();
        //Mover abajo 2 veces
        ficha.moverAbajo();
        ficha.moverAbajo();
        //En este punto ficha debe tener un valor de 6,3
        System.out.println(ficha.toString());
    //Mover a la izquierda 4 veces 2,3
    ficha.moverIzquierda();
    ficha.moverIzquierda();
    ficha.moverIzquierda();
    ficha.moverIzquierda();
        System.out.println(ficha.toString());
        System.out.println();
    //Deshacer los 7 últimos movimientos 5,5
        ficha.undo();
        ficha.undo();
        ficha.undo();
        ficha.undo();
        ficha.undo();
        ficha.undo();
        ficha.undo();
        System.out.println(ficha);
        System.out.println();
        //Rehacer 3 movimientos 6,3
        ficha.redo();
        ficha.redo();
        ficha.redo();
        System.out.println(ficha);
        System.out.println();
        //Mover hacia arriba 1 vez (la lista undone debe quedar vacía) 6,4
        ficha.moverArriba();
        System.out.println(ficha);
        System.out.println();
        //Reacer 1 movimiento (no hace nada, devuelve false) 6,4
        System.out.print("Al haberse quedado la lista undone vacía, esta línea debe devolver false= "+ficha.redo());
        System.out.println("\n"+ficha);

    }
}
