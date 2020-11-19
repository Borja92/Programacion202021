/**
 * Vamos a definir ahora una “Cuenta Joven”, para ello vamos a crear una nueva clase
 * CuantaJoven que deriva de la anterior. Cuando se crea esta nueva clase, además del titular
 * y la cantidad se debe guardar una bonificación que estará expresada en tanto por
 * ciento.
 * Construye los siguientes métodos para la clase:
 * Un constructor. Los setters y getters para el nuevo atributo.
 * En esta ocasión los titulares de este tipo de cuenta tienen que ser mayor de edad.,
 * por lo tanto hay que crear un método esTitularValido() que devuelve verdadero si el titular es mayor de edad pero menor de 25
 * años y falso en caso contrario.
 * Además la retirada de dinero sólo se podrá hacer si el titular es válido.
 * El método mostrar() debe devolver el mensaje de “Cuenta Joven” y la bonificación
 * de la cuenta.
 * Piensa los métodos heredados de la clase madre que hay que reescribir.
 * @author  A. Borja Badía
 * @version 1.0
 */

public class CuentaJoven extends Cuenta {
    //Declaración de atributos de clase

    private double bonificacionCuentaJoven;

    /* ************************************ *
     * Area de declaración de Constructores *
     * ************************************ */
public CuentaJoven(Persona p) throws Exception{

    super(p);


}

    /** Fin de la declaración de constructores */
    /* ***************************************************** *
     * Métodos modificadores del estado del objeto (Setters) *
     * ***************************************************** */
     void setBonificacionCuentaJoven(double cantidad) throws Exception {
        try {
            this.bonificacionCuentaJoven = cantidad;
        } catch (Exception e) {
            throw new Exception("No se ha podido asignar esa bonificación");
        }
    }
    /** Fin de la declaración de Setters */

    /* ***************************************************** *
     * Métodos de devolución del estado del objeto (Getters) *
     * ***************************************************** */
    public double getBonificacionCuentaJoven() {
        return this.bonificacionCuentaJoven;
    }

    /** Fin de la declaración de Getters */

    /* ***************************************************** *
     * Métodos propios de la clase Persona *
     * ***************************************************** */
 //Método para saber si el titular es válido o no

     boolean esTitularValido ()
    {
        return this.persona.esMayorDeEdad() && (this.persona.getEdad() < 25);
    }


    //Método toString para formatear la pintada de datos en consola
    @Override
    public String toString() {
        return "Cuenta Joven{ Nombre: "+ this.persona.getNombre()+
                " Bonificacion Cuenta Joven=" +this.getBonificacionCuentaJoven()+"%" +
                '}'+"\n";
    }

    //Método para retirar dinero si el titular es válido
    void retirarDineroSiTitularEsValido(double cantidadAretirar) throws Exception {

        if(this.esTitularValido()){
            this.setCantidad(this.getCantidad()-cantidadAretirar);
            System.out.println("Retirada por un valor de "+cantidadAretirar+" realizada con éxito!!");
        } else {
            throw new Exception("El títular no es válido. No puede realizar la operación");
        }


    }


}
