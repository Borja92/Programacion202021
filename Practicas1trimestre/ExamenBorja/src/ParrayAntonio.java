public class ParrayAntonio {

    private int [] array;

    public ParrayAntonio(int size)
    {
        array = new int[size];
    }

    public ParrayAntonio(int[] parametro)
    {
        array = new int[parametro.length];
        for (int i=0;i<parametro.length;i++)
            setIndex(i,parametro[i]);
    }

    public int count()
    {
        return this.array.length;
    }

    public int getIndex( int indice )
    {
        return this.array[indice];
    }

    public int setIndex( int indice, int valor )
    {
        return this.array[indice]=valor;
    }


    public boolean in_array( int needle )
    {
        for (int valor : this.array) if (needle==valor) return true;
        return false;
    }


    public void array_fill ( int start_index , int num , int value ) throws Exception {
        if ((start_index+num)>this.count())
            throw new Exception("El número de repeticiones excede la longitud del array");

        for (int i=0;i<num;i++)
            this.setIndex(start_index+i,value);
    }


    public void array_reverse ()
    {
        int aux;
        for (int i=0;i<this.count()/2;i++)
        {
            aux=this.getIndex(i);
            this.setIndex(i,this.getIndex((this.count()-1)-i));
            this.setIndex((this.count()-1)-i,aux);
        }
    }


    public ParrayAntonio array_diff(ParrayAntonio arrayParam )
    {
        int cont=0;

        for (int i=0;i<arrayParam.count();i++)
            if (!this.in_array(arrayParam.getIndex(i))) cont++;

        ParrayAntonio obj = new ParrayAntonio(cont);

        cont=0;
        for (int i=0;i<arrayParam.count();i++)
            if (!this.in_array(arrayParam.getIndex(i)))
                { obj.setIndex(cont,arrayParam.getIndex(i));
                    cont++;
                }

        return obj;

    }

    public void mostrar()
    {
        for (int valor : this.array) System.out.print(valor+", ");
        System.out.println();
    }


    public static void main(String[] args) throws Exception {

        int [] a = {10,2,0,6,9,3,8,5,6};
        ParrayAntonio p = new ParrayAntonio(a);
        System.out.println("Setea un valor dado a un índice dado: ");
        p.setIndex(0,11);
        System.out.println("Rellena un array apartir de un índice dado, con el valor dado, el número de veces dado: ");
        p.array_fill(4,3,-7);
        System.out.println("Muestra el primer parray");
        p.mostrar();

        System.out.println("Invierte los valores de un array");
        p.array_reverse();
        System.out.println("Muestra el array a");
        p.mostrar();

        int [] b = {3,2,4,6,2,3,78,35,8,6};
        ParrayAntonio otro = new ParrayAntonio(b);
        System.out.println("Muestra array b");
        otro.mostrar();
        System.out.println("Compara el array a con el b");
        ParrayAntonio resultado=p.array_diff(otro);
        System.out.println("Muestra los valores resultantes de los valores diferentes: ");
        resultado.mostrar();

    }



}