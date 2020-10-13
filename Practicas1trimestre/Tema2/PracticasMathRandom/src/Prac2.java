import java.util.Date;
import java.util.Random;

public class Prac2 {

    public static void main(String[] args) {


        Random rdn = new Random();

        Date date = new Date();

        rdn.setSeed(date.getTime());
        int a, b, c;

    //    a = (int) (Math.random()*(0-100+1)+100);
      a = rdn.nextInt(101);
      b = rdn.nextInt(101);
      c = rdn.nextInt(101);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
