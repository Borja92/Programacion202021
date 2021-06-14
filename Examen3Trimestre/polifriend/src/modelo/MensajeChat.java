package modelo;

import java.sql.Timestamp;

public class MensajeChat {

    Integer remitente;
    String mensaje;
    Timestamp timestamp;
    Integer estado;


    public MensajeChat(Integer remitente, String mensaje, Timestamp timestamp,Integer estado) {
        this.remitente = remitente;
        this.mensaje = mensaje;
        this.timestamp = timestamp;
        this.estado = estado;
    }

    public Integer getRemitente() {
        return remitente;
    }

    public void setRemitente(Integer remitente) {
        this.remitente = remitente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getEstado() {
        return estado;
    }
}
