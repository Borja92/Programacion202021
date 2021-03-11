package TurismoCulinario.Modelo;

public class Coordenadas {

    private  double latitud;//43.060017;
    private  double longitud;//-2.493796;

    public Coordenadas(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    // DEPURACIÓN
    @Override
    public String toString() {
        return "Coordenadas{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
