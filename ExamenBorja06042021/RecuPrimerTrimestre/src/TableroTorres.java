import com.sun.source.tree.NewArrayTree;

import java.util.Scanner;

public class TableroTorres {

Torre[][] tablero;


public TableroTorres(){
    this.tablero= new Torre[8][8];
}

private void setCoordenadas(String nombre){

    Scanner src = new Scanner(System.in);
    int f,c;
        System.out.println("Introduce coordenadas para torre1");
        System.out.println("Torre1 fila: ");
        f=src.nextInt();
        System.out.println("Torre1 columna: ");
        c=src.nextInt();
tablero[f-1][c-1]= new Torre(nombre);

//return new Torre(f,c);

}
public  boolean seEliminan(){

    for (int i = 0; i <8 ; i++) {
        for (int j = 0; j <8 ; j++) {

           if (tablero[i][j]!=null){

               System.out.println(i+" "+j+"Torre:  "+tablero[i+1][j+1].getNombre());
                return ((torreEnMismaFila(i,j))||(torreEnMismaColumna(i,j)));
           }
        }
    }

   // return (torre1.getCol()==torre2.getCol()||torre1.getFila()==torre2.getFila());
return false;
}
private boolean torreEnMismaFila(int fila, int columna){
boolean rdo=false;
    for (int i = columna; i < 8; i++) {
        if (tablero[fila][i]!=null){
            rdo=true;

        }
    }
    return rdo;
}

private boolean torreEnMismaColumna( int fila, int columna){

    boolean rdo=false;
    for (int i =fila ; i <8 ; i++) {
        if (tablero[i][columna]!=null){
            rdo=true;

        }
    }

    return rdo;

}

    public static void main(String[] args) {

    TableroTorres juego = new TableroTorres();


    do {

juego.setCoordenadas("torre1");
juego.setCoordenadas("torre2");
juego.seEliminan();


    }while (true);


    }



}
