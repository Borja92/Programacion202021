public class Prac2 {
    public static void main(String[] args) {

        int X = 1, Y = 2;
        double N = 3.2, M = 4.7;

        System.out.println("El valor de la variable X= " + X);
        System.out.println("El valor de la variable Y= " + Y);
        System.out.println("El valor de la variable N= " + N);
        System.out.println("El valor de la variable M= " + M);

        System.out.println("=====Operaciones=====");

        int sumaXY = X + Y;

        System.out.println(X + " + " + Y + " = " + sumaXY);

        int diferenciaXY = X - Y;
        System.out.println(X + " - " + Y + " = " + diferenciaXY);

        int productoXY = X * Y;

        System.out.println(X + " * " + Y + " = " + productoXY);

        int cocienteXY = X / Y;

        System.out.println(X + " / " + Y + " = " + cocienteXY);
        int restoXY = X % Y;
        System.out.println(X + " % " + Y + " = " + restoXY);
//Variables declaradas como double
        double sumaNM=N+M, diferenciaNM=N-M, productoNM=N*M,
        cocienteNM=N/M, restoNM=N%M, sumaXN=X+N, cocienteYM=Y/M,
        restoYM=Y%M;
        System.out.println(N + " + " + N + " = " +sumaNM);
        System.out.println(N + " - " + N + " = " +diferenciaNM);
        System.out.println(N + " * " + N + " = " +productoNM);
        System.out.println(N + " / " + N + " = " +cocienteNM);
        System.out.println(N + " % " + N + " = " +restoNM);
        System.out.println(X + " + " + N + " = " +sumaXN);
        System.out.println(Y + " / " + M + " = " +cocienteYM);
        System.out.println(Y + " + " + M + " = " +restoYM);
//El doble de cada variable
        System.out.println("El doble del valor de la variable X= "+X*2);
        System.out.println("El doble del valor de la variable Y= "+Y*2);
        System.out.println("El doble del valor de la variable N= "+N*2);
        System.out.println("El doble del valor de la variable M= "+M*2);

//La suma de todas las variables
        double sumaTodasVariables= X+Y+N+M;
        System.out.println("La suma de las variables X+Y+N+M= "+sumaTodasVariables);

//El producto de todas las variables

        double productoTodasVariables= X*Y*N*M;
        System.out.println("El producto de todas las variables es= "+productoTodasVariables);
    }
}
