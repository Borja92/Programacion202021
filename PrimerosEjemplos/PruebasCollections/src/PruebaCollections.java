import java.util.ArrayList;
import java.util.Iterator;

public class PruebaCollections {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(1);
        System.out.println(lista.size());
        lista.add(1, 4);
        System.out.println(lista.size());
        lista.add(3);
        System.out.println(lista);
        System.out.println(lista.get(2));
        System.out.println(lista.get(1));
        System.out.println(lista.remove(1));
        System.out.println(lista);

        lista.add(100);
        lista.add(200);
        lista.add(75);
        lista.add(37);
        lista.add(288);
        lista.add(29);

        Iterator<Integer> iterator = lista.iterator();
while (iterator.hasNext()){

    System.out.print(iterator.next()+" ");
}

lista.removeIf(p -> (p<10)|| (p>100));
        System.out.print("\n"+lista);
    }






}
