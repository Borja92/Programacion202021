public class Rectangulo extends Figura{


    public Rectangulo(double[] dimensiones) {
        super(dimensiones);
    }



    @Override
    public double area() {
        return dimensiones[0]*dimensiones[1];
    }
}
