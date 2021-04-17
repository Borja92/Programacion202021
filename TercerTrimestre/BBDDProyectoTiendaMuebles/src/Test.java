import Persistencia.*;

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
        /*System.out.println("Pruebas SeccionDAO");
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
        System.out.println("Eliminar una Sección, true si ha sido eliminada si no false (false)"+seccionDAO.borrar("Garaje"));*/

        TipoElementoDAO tipoElementoDAO= new TipoElementoDAO();
        /*System.out.println("Pruebas TipoElementoDAO");
        System.out.println("Crear un nuevo tipo de elemento: (true)"+tipoElementoDAO.crear("Mesa"));
        System.out.println("Crear un nuevo tipo de elemento: (true)"+tipoElementoDAO.crear("Comoda"));
        System.out.println("Crear un nuevo tipo de elemento: (true)"+tipoElementoDAO.crear("Banco de madera y hierro forjado"));*/
       /* System.out.println("Crear un nuevo tipo de elemento: (false)"+tipoElementoDAO.crear("silla"));
        System.out.println("Crear un nuevo tipo de elemento: (true)"+tipoElementoDAO.crear("Armario"));
        System.out.println("Tipo Elemento por ID: "+tipoElementoDAO.getTipoElementoById(71));
        System.out.println("Tipo Elemento por ID: (no existe debe dar null): "+tipoElementoDAO.getTipoElementoById(7));
        System.out.println("ID de Tipo de elemento por nombre: "+tipoElementoDAO.getId("Mesa"));
        System.out.println("Actualizar nombre de tipo elemento (true): "+tipoElementoDAO.actualizar("silla", "Silla"));
        System.out.println("Actualizar nombre de tipo elemento (false): "+tipoElementoDAO.actualizar("elemento falso", "falso elemento"));
        System.out.println("Devuelve true/false si tipo elemento existe(true): "+tipoElementoDAO.exists("Mesa"));
        System.out.println("Devuelve true/false si tipo elemento existe(falso): "+tipoElementoDAO.exists("elemento falso"));
        System.out.println("Eliminar una tipo elemento, true si ha sido eliminada si no false (true)"+tipoElementoDAO.borrar("Armario"));
        System.out.println("Eliminar una tipo elemento, true si ha sido eliminada si no false (false)"+tipoElementoDAO.borrar("elemento falso"));*/

        ElementoDAO elementoDAO= new ElementoDAO();
        /*System.out.println("Pruebas de ElementoDAO: ");
        System.out.println("Crear un elemento en la tabla elemento: "+elementoDAO.crear(new Elemento("ComDa0","Comoda")));
        System.out.println("Devuelve un elemento por el id: "+elementoDAO.getElementoById(45));
        System.out.println("Devuelve el elemento por el código, con su tipo "+elementoDAO.leer("ComDa0"));
        System.out.println("Devuelve el elemento por el código, con su tipo (null)"+elementoDAO.leer("ZTA77"));
        System.out.println("Crea un nuevo elemento tipo Mesa: "+elementoDAO.crear(new Elemento("Mc0331", "Mesa")));
        System.out.println("Crea un nuevo elemento tipo Mesa: "+elementoDAO.crear(new Elemento("Mc02321", "Mesa")));
        System.out.println("Modifca el código de un elemento: (true)"+elementoDAO.actualizar("sc0331", "Sc0331"));
        System.out.println("Elimina un elemento: (true)"+elementoDAO.borrar("Mc02321"));
        System.out.println("Elimina un elemento: (false)"+elementoDAO.borrar("Mc02321"));
        System.out.println("Devuelve la id de un elemento a partir del código: "+elementoDAO.getId("ComDa0"));
        System.out.println("Devuelve la id de un elemento a partir del código: -1 "+elementoDAO.getId("Mc02321"));*/
        ModeloDAO modeloDAO = new ModeloDAO();
        //System.out.println("Crea un nuevo elemento: (true)"+modeloDAO.crear(new Modelo("TJ004","Terraza y Jardín","Gama Estándar")));
        /*System.out.println("Crea un nuevo elemento: (true)"+modeloDAO.crear(new Modelo("TJ004","Terraza y Jardín","Gama Estándar")));
        System.out.println("Crea un nuevo elemento: (true)"+modeloDAO.crear(new Modelo("DR067","Dormitorio","Gama Alta")));
        System.out.println("Crea un nuevo elemento: (true)"+modeloDAO.crear(new Modelo("BÑ894","Baño","Gama Económica")));
        System.out.println("Crea un nuevo elemento: (true)"+modeloDAO.crear(new Modelo("SL008","Salón","Gama Estándar")));*/
       /* System.out.println("Actualiza codigo de modelo: (true)"+modeloDAO.actualizar("DR067", "DR007"));
        System.out.println("Obtener modelos por categoria: (Estándar)"+modeloDAO.getCodigosModelosByCategoria("Gama Estándar"));
        System.out.println("Obtener modelos por categoria: (lista vacía)"+modeloDAO.getCodigosModelosByCategoria("Gama Falsa"));
        System.out.println("Obtener modelos por sección (Baño):"+modeloDAO.getCodigosModelosBySeccion("baño"));
        System.out.println("Obtener todos los códigos de modelo: "+modeloDAO.getCodigosModelos());
        System.out.println("Leer un modelo por código: "+modeloDAO.leer("DR007"));
        System.out.println("Eliminar un modelo: (true)"+modeloDAO.borrar("TJ004"));
        System.out.println("Eliminar un modelo: (false)"+modeloDAO.borrar("TJ004"));
        System.out.println("Obtener un id de elemento por el código: "+modeloDAO.getId("DR007"));
        System.out.println("Obtener un id de elemento por el código: (-1) "+modeloDAO.getId("TJ004"));*/
ElementoModeloDAO elementoModeloDAO= new ElementoModeloDAO();
        System.out.println("Pruebas de ElementoModelo");
      //  System.out.println("Insertamos un nuevo objeto elementoModelo: (true)"+elementoModeloDAO.crear("Mc0331","C1001"));
     ///Preguntar por valores repetidos en esta tabla
    //    System.out.println("Insertamos un nuevo objeto elementoModelo: (true)"+elementoModeloDAO.crear("Mc0331","C1001"));
      System.out.println("Insertamos un nuevo objeto elementoModelo: (false)"+elementoModeloDAO.crear("VFals","fake"));
      //System.out.println("Insertamos un nuevo objeto elementoModelo: (true)"+elementoModeloDAO.crear("Sc0331","SL008"));
       System.out.println("Obtenemos id de un objeto elementoModelo a partir de  CodElemento y CodModelo: (50)"+elementoModeloDAO.getId("Sc0331","SL008"));
       System.out.println("Obtenemos el id de un elementoModelo: (20)"+elementoModeloDAO.getId("Mc0331","C1001"));
        System.out.println("Obtener lista de elementos por codigo modelo: "+elementoModeloDAO.getElementosByCodigoModelo("C1001"));

    }
}
