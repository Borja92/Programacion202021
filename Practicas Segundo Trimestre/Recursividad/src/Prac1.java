/*Problema)1.
        El  factorial de un número entero! ≥ 0, denotado como!!, se define
        como ! !
        !!! = 1 ∗ 2 ∗ ... ∗ ! cuando! > 0,y 0! = 1.
        Por ejemplo 6 = 1 ∗ 2 ∗ 3 ∗ 4 ∗ 5 ∗ 6 = 720
        Diseñad#una#método recursiva que lo calcule e implementadlo en Java
        (junto con un programa que lo utilice)*/

public class Prac1 {

    public int factorial (int i){

        if (i==0) return 1;
        else  return i*factorial(i-1);

    }

    public static void main(String[] args) {

        Prac1 prac1 = new Prac1();

        System.out.println(prac1.factorial(6));

    }

}
