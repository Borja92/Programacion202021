import java.util.Date;
import java.util.Random;

public class Prac1 {
    public static void main(String[] args) {

        Random rdn = new Random();
        Date date = new Date();

        rdn.setSeed(date.getTime());

        float a, b, c;

        a = rdn.nextFloat() * 10;

        System.out.println(a);

        b = rdn.nextFloat() * 10;
        System.out.println(b);

        c = rdn.nextFloat() * 10;
        System.out.println(c);

    }
}
