public class Circulo extends Figura{

    public Circulo(double[]dimensiones){
        super(dimensiones);
    }



    @Override
    public double area() {
        return Math.pow(dimensiones[0],2+Math.PI);
    }
}
