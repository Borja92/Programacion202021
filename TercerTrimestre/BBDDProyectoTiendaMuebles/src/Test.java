import Persistencia.CategoriaDAO;
import Persistencia.SeccionDAO;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();

       /* System.out.println("Pruebas CategoriaDAO: ");
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
        System.out.println("Eliminar una categoria. true si ha sido eliminada si no false (false): "+categoriaDAO.borrar("gama FALSA"));*/
        SeccionDAO seccionDAO= new SeccionDAO();
        System.out.println("Pruebas SeccionDAO");
        System.out.println("Sección por id 76(Cocina): "+seccionDAO.getSeccionById(76));
        System.out.println("Sección por id (no existe debe dar null): "+seccionDAO.getSeccionById(7));
        System.out.println("Crear una nueva seccion true/false: ");
        System.out.println(" (true): "+seccionDAO.crear("Baño"));
        System.out.println(" (true): "+seccionDAO.crear("Salón"));
        System.out.println(" (true): "+seccionDAO.crear("Comedor"));
        System.out.println(" (true): "+seccionDAO.crear("Dormitorio"));
        System.out.println(" (true): "+seccionDAO.crear("Terraza y Jardín"));
        System.out.println(" Baño ya existe (false): "+seccionDAO.crear("Baño"));
        System.out.println("Actualizar nombre de sección (true): "+seccionDAO.actualizar("cocina", "Cocina"));
        System.out.println("Actualizar nombre de categoria (false): "+seccionDAO.actualizar("Garaje", "Sección falsa"));
        System.out.println("Devuelve true/false   dependiendo si la sección existe(true): "+seccionDAO.exists("Baño"));
        System.out.println("Devuelve true/false si la sección existe(false): "+seccionDAO.exists("Sección FALSA"));
        System.out.println("ID de Sección por nombre: "+seccionDAO.getId("Terraza y Jardín"));
        System.out.println("Todos los elementos de la tupla Sección: "+seccionDAO.getAll());
        //System.out.println("Eliminar una Sección, true si ha sido eliminada si no false (true)"+seccionDAO.borrar("Baño"));
        System.out.println("Eliminar una Sección, true si ha sido eliminada si no false (false)"+seccionDAO.borrar("Garaje"));

    }
}
