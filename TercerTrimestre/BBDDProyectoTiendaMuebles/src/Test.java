import Persistencia.CategoriaDAO;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        System.out.println("Pruebas CategoriaDAO: ");
        System.out.println("Categoria por id 75(Gama Económica): "+categoriaDAO.getCategoriaById(75));
        System.out.println("Categoria por id (no existe debe dar null): "+categoriaDAO.getCategoriaById(7));
        System.out.println("Crear una nueva cateogoria true/false: ");
      System.out.println("Debe dar false puesto que ya existe: "+categoriaDAO.crear("Gama Económica"));
        System.out.println("Actualizar nombre de categoria (true): "+categoriaDAO.actualizar("gama económica", "Gama Económica"));
        System.out.println("Actualizar nombre de categoria (false): "+categoriaDAO.actualizar("gama atómica", "Gama electrónica"));
        System.out.println("Id de categoría por nombre (Gama Alta): "+categoriaDAO.getId("gama alta"));
        System.out.println("Devuelve la lista de los elementos de Categoría: "+categoriaDAO.getAll());
        System.out.println("Devuelve true/false si la dependiendo si la categoria existe(true): "+categoriaDAO.exists("gama alta"));
        System.out.println("Devuelve true/false si la dependiendo si la categoria existe(false): "+categoriaDAO.exists("gama FALSA"));
       // System.out.println("Eliminar una categoria. true si ha sido eliminada si no false (true): "+categoriaDAO.borrar("gama alta"));
        System.out.println("Eliminar una categoria. true si ha sido eliminada si no false (false): "+categoriaDAO.borrar("gama FALSA"));
    }
}
