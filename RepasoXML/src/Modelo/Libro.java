package Modelo;

import java.util.Objects;

public class Libro {
private String fechaPublicacion;
private String titulo;
private String autor;
public Libro(String fechaPublicacion, String titulo, String autor){
    this.fechaPublicacion=fechaPublicacion;
    this.titulo=titulo;
    this.autor=autor;

}

    public Libro() {

    }

    public Libro(String publicado_en) {
    }

    /*public Libro(String publicado_en, String Titulo, String Autor ) {
this.fechaPublicacion=publicado_en;
this.titulo=Titulo;
this.autor=Autor;
}*/



    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return titulo.equals(libro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "fechaPublicacion='" + fechaPublicacion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}