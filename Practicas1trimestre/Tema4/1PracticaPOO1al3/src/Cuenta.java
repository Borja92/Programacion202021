
/**
 * Crea una clase llamada Cuenta que tendrá los siguientes atributos:
 * titular (que es una persona) y cantidad (puede tener decimales).
 * El titular será obligatorio y la cantidad es opcional.
 * Construye los siguientes métodos para la clase
 * Un constructor, donde los datos pueden estar vacíos.
 * Los setters y getters para cada uno de los atributos.
 * El atributo no se puede modificar directamente, sólo ingresando o retirando dinero.
 * mostrar(): Muestra los datos de la cuenta.
 * ingresar(cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
 * retirar(cantidad): se retira una cantidad a la cuenta. La cuenta puede estar en números rojos.
 * @author  A. Borja Badía
 * @version 1.0
 **/
public class Cuenta {

    //Declaración de atributos de clase

    protected Persona persona;
    private double cantidad;

    /* ************************************ *
     * Area de declaración de Constructores *
     * ************************************ */
    public Cuenta(Persona p) throws Exception {

        this.persona = new Persona(p.getNombre(), p.getDni(), p.getEdad());
        this.setCantidad(0);
    }

    public Cuenta(Persona p, double cantidad) throws Exception {
        this.persona = new Persona(p.getNombre(), p.getDni(), p.getEdad());
        this.setCantidad(cantidad);
    }

    /** Fin de la declaración de constructores */

    /* ***************************************************** *
     * Métodos modificadores del estado del objeto (Setters) *
     * ***************************************************** */

    protected void setCantidad(double cantidad) throws Exception {

        try {
            this.cantidad = cantidad;

        } catch (Exception e) {

            throw new Exception("Esa cantidad no se ha podido asignar");
        }
    }

    /**
     * Fin de la declaración de Setters
     */

    /* ***************************************************** *
     * Métodos de devolución del estado del objeto (Getters) *
     * ***************************************************** */
    public double getCantidad() {
        return this.cantidad;
    }
    /** Fin de la declaración de Getters */

    //Método mostrar, haremos uso de él para mostrar contenido de objetos tipo Cuenta
    void mostrar() {
        System.out.println(this);
    }


    //Método toString para formatear la pintada de datos en consola

    @Override
    public String toString() {
        return "Cuenta{" +
                "Titular=" + this.persona.getNombre() +
                ", Cantidad=" + this.getCantidad() + "€" +
                '}'+"\n";
    }

    /**
     * Fin de la declaración de Getters
     */


    /* ***************************************************** *
     * Métodos propios de la clase Cuenta *
     * ***************************************************** */

    void ingresarEnCuenta(double cantidadAingresar) throws Exception {
        if (cantidadAingresar > 0) {

            this.setCantidad(this.getCantidad() + cantidadAingresar);
        } else throw new Exception("No se permiten los ingresos con catidad negativa");
    }


    void retirarCantidadEnCuenta(double cantidadAretirar) throws Exception {

        this.setCantidad(this.getCantidad() - cantidadAretirar);
if (getCantidad()<0){

    System.out.println("La cuenta del títular "+persona.getNombre() +" está en números rojos.");
}

    }

}