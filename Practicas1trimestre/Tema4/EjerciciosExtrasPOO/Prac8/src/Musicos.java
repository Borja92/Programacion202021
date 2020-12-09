public class Musicos {

    //Declaración de atributos de clase

    private int edad;
    private String nombre;
    private int edadDelMayor = 0;
    private int indiceDelMayor = 0;
    private int edadDelMenor = Integer.MAX_VALUE;
    private int indiceDelMenor = 0;

    /* ************************************ *
     * Area de declaración de Constructores *
     * ************************************ */
    public Musicos(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public Musicos() {
    }

    /**
     * Fin de la declaración de constructores
     */

    /* ***************************************************** *
     * Métodos modificadores del estado del objeto (Setters) *
     * ***************************************************** */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Fin de la declaración de Setters
     */

    /* ***************************************************** *
     * Métodos de devolución del estado del objeto (Getters) *
     * ***************************************************** */
    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Fin de la declaración de Getters
     */


    @Override
    public String toString() {
        return "Musicos{" +
                "Edad=" + edad +
                ", Nombre='" + nombre + '\'' +
                '}';
    }

    String musicoMayor(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] > edadDelMayor) {
                edadDelMayor = array[i];
                indiceDelMayor = i;
            }
        }
        return "El músico mayor tiene una edad de: " + edadDelMayor + " y se encuentra en la posición: " + indiceDelMayor;
    }

    String musicoMenor(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < edadDelMenor) {
                edadDelMenor = array[i];
                indiceDelMenor = i;
            }
        }
        return "El músico menor tiene una edad de: " + edadDelMenor + " y se encuentra en la posición: " + indiceDelMenor;
    }

    String elMusicoMayorYelMenor(String[] arrayNombres, int[] arrayEdad) {
        String elMenorNombre = "";
        String elMayorNombre = "";

musicoMenor(arrayEdad);
musicoMayor(arrayEdad);

        for (int i = 0; i < arrayNombres.length; i++) {
            if (indiceDelMayor == i) {
                elMayorNombre = arrayNombres[i];
            }
            if (indiceDelMenor == i) {
                elMenorNombre = arrayNombres[i];
            }
        }

        return "El musico mayor se llama: " + elMayorNombre + " con una edad de: " + edadDelMayor + " años.\n" +
                "El músico menor se llama: " + elMenorNombre + " con una edad de: " + edadDelMenor + " años.";
    }


}
