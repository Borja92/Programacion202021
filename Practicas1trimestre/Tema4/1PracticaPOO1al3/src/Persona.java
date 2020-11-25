/**
 * Vamos a crear una clase llamada Persona. Sus atributos son: nombre, edad y DNI.
 * Construye los siguientes métodos para la clase:
 * Un constructor, donde los datos pueden estar vacíos.
 * Los setters y getters para cada uno de los atributos.
 * Hay que validar las entradas de datos.
 * mostrar(): Muestra los datos de la persona.
 * esMayorDeEdad(): Devuelve un valor lógico indicando si es mayor de edad.
 * @author  A. Borja Badía
 * @version 1.0
 */



public class Persona {

//Declaración de atributos de clase
    private String nombre, dni;
    private int edad;

    /* ************************************ *
     * Area de declaración de Constructores *
     * ************************************ */

    public Persona(String nombre, String dni, int edad) throws Exception {

        this.setNombre(nombre);
        this.setDni(dni);
        this.setEdad(edad);
    }





//Constructor vacío
    public Persona() {
    }

    /** Fin de la declaración de constructores */


    /* ***************************************************** *
     * Métodos modificadores del estado del objeto (Setters) *
     * ***************************************************** */


    public void setNombre(String nombre) throws  Exception{

        if(nombre.length()!=0 ) this.nombre=nombre;
        else throw  new Exception("El nombre no puede estar vacío");
    }

    public void setDni (String dni) throws Exception {

if(this.dniValido(dni)) this.dni=dni;
else throw new Exception("El formato del DNI no es válido");

    }
    public void setEdad(int edad) throws Exception{
        if (edad>0) this.edad=edad;
        else throw new Exception("La edad debe ser mayor de cero");
    }
    /** Fin de la declaración de Setters */




    /* ***************************************************** *
     * Métodos de devolución del estado del objeto (Getters) *
     * ***************************************************** */


    public String getNombre(){ return this.nombre;  }
    public String getDni() { return this.dni; }
    public int getEdad()  { return this.edad;  }


    /** Fin de la declaración de Getters */


    /* ***************************************************** *
     * Métodos propios de la clase Persona *
     * ***************************************************** */



    //El método toString nos ayuda a dar formato a la salida por teclado de los valores a convenir
    @Override
    public String toString() {
        return "\n{ Nombre: " + this.getNombre()+
                ", DNI:'" +this.getDni() + '\'' +
                ", Edad:" +this.getEdad() +
                '}' + "\n";
    }

    //Método mostrar, haremos uso de él para mostrar contenido de objetos tipo persona
    void mostrar() {
        System.out.println(this);
    }

    //Método para comprobar si la persona es mayor de edad
    boolean esMayorDeEdad() {
       // System.out.println("¿La persona "+getNombre()+ " es mayor de edad?");
        boolean mayorDeEdad=true;

        if (this.getEdad() < 18) {
            mayorDeEdad = false;
        return mayorDeEdad;  //Boolean.parseBoolean(((mayorDeEdad) + "\nLa persona "+this.getNombre()+" es menor de edad."));
        } else {
           return mayorDeEdad;//Boolean.parseBoolean(((mayorDeEdad) + "\nLa persona "+this.getNombre() +" es mayor de edad."));
        }

    }

//Método para validar DNI
    private boolean dniValido(String dni){

      String formatoValidoDNI =  "[0-9]{8}[A-Z]";

      return dni.matches(formatoValidoDNI);
    }




}
