public class Fecha {

    private String dia, mes, anno;

    /* ************************************ *
     * Area de declaración de Constructores *
     * ************************************ */
    public Fecha(String dia, String mes, String anno) throws Exception {
        this.setDia(dia);
        this.setMes(mes);
        this.setAnno(anno);
    }

    /* ***************************************************** *
     * Métodos modificadores del estado del objeto (Setters) *
     * ***************************************************** */
  public void setDia(String dia) throws Exception{
        this.dia=dia;

  }

  public void setMes(String mes) throws Exception{
        this.mes=mes;
  }

  public void setAnno(String anno) throws  Exception{
        this.anno=anno;
  }
    /** Fin de la declaración de Setters */

    /* ***************************************************** *
     * Métodos de devolución del estado del objeto (Getters) *
     * ***************************************************** */

public String getDia(){
    return this.dia;
}

    public String getMes() {
        return this.mes;
    }

    public String getAnno() {
        return this.anno;
    }
    /** Fin de la declaración de Getters */

    /* ***************************************************** *
     * Métodos propios de la clase Fecha *
     * ***************************************************** */









}
