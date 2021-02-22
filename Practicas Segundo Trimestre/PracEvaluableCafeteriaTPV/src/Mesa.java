import java.util.LinkedList;

public class Mesa {
    private int codigoMesa;
    private boolean mesaAbierta = true;
    LinkedList<Producto> comandaProductos = new LinkedList<>();

    /**
     * Declaración constructor
     */
    public Mesa(int codigoMesa) {
        this.codigoMesa = codigoMesa;
        this.mesaAbierta = mesaAbierta;
    }

    public Mesa() {
    }
/** Fin declaración construtor
 */

    /**
     * Declaración de Getters&Setters
     */
    public int getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(int codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public boolean isMesaAbierta() {
        return mesaAbierta;
    }

    public void setMesaAbierta(boolean mesaAbierta) {
        this.mesaAbierta = mesaAbierta;
    }

    /**
     * Fin declaración Getters&Setters
     */
    @Override
    public String toString() {
        return "Mesa{" +
                "Código de Mesa='" + codigoMesa + '\'' +
                "Comanda= " + comandaProductos +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        Mesa mesa = (Mesa) o;
        return mesa.getCodigoMesa() == (getCodigoMesa());
    }


}
