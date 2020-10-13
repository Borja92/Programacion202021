import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Aleatorios {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        double temperatura;
        System.out.println(Math.random()*150+50);//

        Random rnd = new Random();
        System.out.println(rnd.nextInt(20));//obtenemos un número aletario entre 0 y 19

        rnd.setSeed(1234);
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println("================================");
        Date date= new Date();
        rnd.setSeed(date.getTime());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());

    }
}
