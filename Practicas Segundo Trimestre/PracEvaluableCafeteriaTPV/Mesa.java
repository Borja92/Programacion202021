import java.util.ArrayList;
import java.util.Objects;

public class Mesa {
    private String codigoMesa;
    private boolean mesaAbierta;
    private Productos listaProductos;



    public Mesa(String codigoMesa, boolean mesaAbierta) {
        this.codigoMesa = codigoMesa;
        this.mesaAbierta = mesaAbierta;
        this.listaProductos=new Productos();
    }

    public Mesa() {
    }

    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public boolean isMesaAbierta() {
        return mesaAbierta;
    }

    public void setMesaAbierta(boolean mesaAbierta) {
        this.mesaAbierta = mesaAbierta;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "Código de Mesa='" + codigoMesa + '\'' +
                ", Mesa abierta=" + mesaAbierta +
                '}';
    }


    public Productos getListaProductos() {
        return listaProductos;
    }

    @Override
    public boolean equals(Object o) {
        Mesa mesa= (Mesa) o;
    return mesa.getCodigoMesa().equalsIgnoreCase(getCodigoMesa());
    }


}
