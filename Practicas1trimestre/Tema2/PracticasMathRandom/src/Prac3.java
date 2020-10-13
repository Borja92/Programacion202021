import java.util.Date;
import java.util.Random;

public class Prac3 {
    public static void main(String[] args) {

        Random rdn = new Random();

        Date date = new Date();

        rdn.setSeed(date.getTime());

        int a, b, c;

        a= (rdn.nextInt(26)+65);
        System.out.println(a);

        b= (rdn.nextInt(26)+65);
        System.out.println(b);

        c= (rdn.nextInt(26)+65);
        System.out.println(c);


    }
}
