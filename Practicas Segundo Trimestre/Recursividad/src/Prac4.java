/*
Problema4.
Diseñad un método recursivo que escriba al revés la cadena que se le
pasa como parámetro, más un índice que se usará para recorrer la
cadena.
Dicho método será de la#forma:
1 public(void(printReversed(String text, int index) {
2 ¿?
3 }
Haced dos versiones del mismo, una en la que el índice vaya
incrementándose#a#cada#llamada#y#otra#en#la#éste#que#vaya#
decrementándose.#En#los#dos#casos#implementad#la#función#que
#llama#a#
la#función#recursiva#diseñada,#es#decir:
4 public(void(printReversed(String(text)({
5 ((printReversed(text,(¿?);
6 }
Nota:#No#vale#invertir#la#cadena#y#luego#escribirla.*/

public class Prac4 {
    public void printReversed(String text, int index){
if(text.length()-1==index){

    System.out.print(text.charAt(index));
} else {
    printReversed(text,index+1);
    System.out.print(text.charAt(index));
}
    }

void printReverseDescendente(String text, int index){

        if (text.length()==0){
            System.out.print(text.charAt(0));
        } else {
            System.out.print(text.charAt(index));
            printReverseDescendente(text,index-1);

        }

}

    public static void main(String[] args) {

Prac4 prac4 = new Prac4();

String cadena1="esto es una cadena 12345";
String cadena2="esto es una cadena 98765";

        System.out.println(cadena1);
        System.out.println();
        System.out.println(cadena2);

prac4.printReversed(cadena1, 0);
        System.out.println();
prac4.printReversed(cadena2, 0);

prac4.printReverseDescendente(cadena1, cadena1.length()-1);
    }
}
