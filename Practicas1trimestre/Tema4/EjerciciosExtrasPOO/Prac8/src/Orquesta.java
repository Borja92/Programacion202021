import java.util.Arrays;

public class Orquesta {

    private String [] nombreMusicos;
    private int [] edadMusicos;

    private int edadDelMayor = 0;
    private int indiceDelMayor = 0;
    private int edadDelMenor = Integer.MAX_VALUE;
    private int indiceDelMenor = 0;

    public Orquesta(String[] nombreMusicos, int[] edadMusicos) {
        this.nombreMusicos = nombreMusicos;
        this.edadMusicos = edadMusicos;
    }

    public Orquesta() {
    }

    public String[] getNombreMusicos() {
        return nombreMusicos;
    }

    public void setNombreMusicos(String[] nombreMusicos) {
        this.nombreMusicos = nombreMusicos;
    }

    public int[] getEdadMusicos() {
        return edadMusicos;
    }

    public void setEdadMusicos(int[] edadMusicos) {
        this.edadMusicos = edadMusicos;
    }



    String musicoMayor(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] > edadDelMayor) {
                edadDelMayor = array[i];
                indiceDelMayor = i;
            }
        }
        return "El músico mayor tiene una edad de: " + edadDelMayor + " y se encuentra en la posición: " + (indiceDelMayor+1);
    }

    String musicoMenor(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < edadDelMenor) {
                edadDelMenor = array[i];
                indiceDelMenor = i;
            }
        }
        return "El músico menor tiene una edad de: " + edadDelMenor + " y se encuentra en la posición: " + (indiceDelMenor+1);
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

    @Override
    public String toString() {
        return "Orquesta{" +
                "nombreMusicos=" + Arrays.toString(nombreMusicos) +
                ", edadMusicos=" + Arrays.toString(edadMusicos) +
                '}';
    }
}
