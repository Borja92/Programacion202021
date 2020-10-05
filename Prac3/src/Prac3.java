public class Prac3 {
    public static void main(String[] args) {

        int N= 1;
        System.out.println("Valor inicial de variable N = "+N);
        //Incrementar N en 77
        int incrementar= N += 77;  /*En esta operación, al añadir un
         segundo = tras el simbolo +, N conservará el valor de la ultima operación
         de lo contrario la variable N seguiría conservando su valor incial*/

        System.out.println("N + 77= "+incrementar);
        System.out.println("Valor de N= "+N);
    //Decrementar N en 3
        int decrementar= N-=3;
        System.out.println("N - 3 = "+decrementar);
        System.out.println("Valor de N= "+N);

    //Duplicar valor de N
        int duplicar=N*=2;
        System.out.println("N * 2 = "+duplicar);
        System.out.println("Valor de N= "+N);

    }
}
