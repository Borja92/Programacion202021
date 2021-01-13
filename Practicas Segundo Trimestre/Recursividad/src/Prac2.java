/*Problema2

Para#calcular#el#máximo#común#divisor#de#dos#números#enteros#puedo#
        aplicar#el#algoritmo)de)Euclides,#que#consiste#en#ir#restando#el#más#
        pequeño#del#más#grande#hasta#que#queden#dos#números#iguales,#que#
        serán#el#máximo#común#divisor de#los#dos#números.
        Por#ejemplo,#si#comenzamos#con#el#par#de#números#412#y#184,#
        tendríamos:
        412 228 44 44 44 44 44 36 28 20 12 8 4
        184 184 184 140 96 52 8 8 8 8 8 4 4
        Es decir, m.c.d.(412,184)=4  */


public class Prac2 {



    public int euclides (int a, int b){

        if (a==b) return a;

        if (a>b) return euclides( (a-b), b);
        else return euclides(a, b-a);
    }
    public static void main(String[] args) {


        Prac2 prac2 = new Prac2();

        System.out.println(prac2.euclides(36, 15));

    }
}
