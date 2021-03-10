package TurismoCulinario.Modelo.Modelo;

public class CalculadoraDistancia {
    private Coordenadas ubicacionActual;

    public CalculadoraDistancia(Coordenadas ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }

    public double caluclarDisntacia(Establecimiento establecimiento){

        Coordenadas coordenadasEstablecimiento = establecimiento.getUbicacion();

        double theta = ubicacionActual.getLongitud() - coordenadasEstablecimiento.getLongitud();
        double dist = Math.sin(Math.toRadians(ubicacionActual.getLatitud())) *
                Math.sin(Math.toRadians(coordenadasEstablecimiento.getLatitud())) + Math.cos(Math.toRadians(ubicacionActual.getLatitud())) *
                Math.cos(Math.toRadians(coordenadasEstablecimiento.getLatitud())) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.853159616;
        return dist;
    }
}
