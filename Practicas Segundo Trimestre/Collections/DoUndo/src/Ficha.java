/*Los métodos públicos de la clase Ficha tienen la siguiente signatura:

     boolean undo()   : deshace el último movimiento realizado y devuelve true, salvo que no hayan

        movimientos realizados.

       boolean redo() : rehace el último movimiento deshecho y devuelve true, salvo que no hayan

        movimientos que deshacer, en cuyo caso devuelve false.
        Escribe el código necesario para hacer los siguientes movimientos:
        void moverArriba()
        void moverAbajo()
        void moverIzquierda()
        void moverDerecha()
        boolean undo()
        boolean redo()

        Mover arriba 5 veces -> (0,5)
        Mover a la derecha 6 veces -> (6,5)
        Mover abajo 2 veces -> (6,3)
        Mover a la izquierda 4 veces -> (2,3)
        Deshacer los últimos 7 movimientos -> (5,5)
        Rehacer 3 movimientos -> (6,3)
        Mover hacia arriba 1 vez (la lista undone debería vaciarse) -> (6,4)
        Rehacer 1 movimiento (no hace nada y devuelve false) -> (6,4)*/

import java.util.LinkedList;

public class Ficha {

private int x;
private int y;
LinkedList<String> done;
LinkedList<String> undone;
    public Ficha() {
        this.x = 0;
        this.y = 0;
        this.done = new LinkedList<String>();
        this.undone = new LinkedList<String>();
    }

    public int getX() {  return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    private void move(String movement) {
        switch (movement) {
            case "up" :         setY(getY()+1); break;
            case "down" :       setY(getY()-1); break;
            case "right" :      setX(getX()+1); break;
            case "left" :       setX(getX()-1); break;
        }
    }

    private void saveInverseMove(LinkedList<String> list,String movement) {
        switch (movement) {
            case "up" :         list.addFirst("down"); break;
            case "down" :       list.addFirst("up"); break;
            case "right" :      list.addFirst("left"); break;
            case "left" :       list.addFirst("right"); break;
        }
    }

    public void moverArriba()
    {
        move("up");
        saveInverseMove(done,"up");
        undone.clear();
    }

    public void moverAbajo()
    {
        move("down");
        saveInverseMove(done,"down");
        undone.clear();
    }

    public void moverIzquierda()
    {
        move("left");
        saveInverseMove(done,"left");
        undone.clear();
    }

    public void moverDerecha()
    {
        move("right");
        saveInverseMove(done,"right");
        undone.clear();
    }

    public boolean undo(){
        if (!done.isEmpty())
        {
            String movimiento = done.pop();
            move(movimiento);
            saveInverseMove(undone,movimiento);
            return true;
        }
        else
            return false;
    }

    public boolean redo(){
        if (!undone.isEmpty()) {
            String movimiento = undone.pop();
            done.addFirst(movimiento);
            move (movimiento);
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "Ficha{ x=" + x +", y=" + y +
                ", done=" + done +
                ", undone=" + undone + "}";
    }

}
