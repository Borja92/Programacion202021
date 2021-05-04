import Persistencia.*;
import modelo.Elemento;
import negocio.*;

import java.sql.Connection;

public class Test {
    public static void main(String[] args)  {
        Connection conn;
        conn= new DBConn().conectar();
        /*Seccion seccion = new Seccion();
        System.out.println("-----Pruebas Seccion-----");
        System.out.println("Crear seccion: "+seccion.crearSeccion("Baño"));
        System.out.println("Crear seccon: "+seccion.crearSeccion("Comedor"));
        System.out.println("Crear seccion: "+seccion.crearSeccion("Terraza y Jardín"));
        System.out.println("Lista de seccion a partir de la clase Seccion"+seccion.getSecciones());
        System.out.println("Existe la seccion?: "+seccion.seccionExists("Fake"));
        System.out.println("Existe la seccion?: "+seccion.seccionExists("Comedor"));
        System.out.println("Crear sección para borrar despues: "+seccion.crearSeccion("Seccion Falsa"));
        System.out.println("Modificar sección antes de borrar: "+seccion.modificarSeccion("Sección Falsa", "Sección a borrar"));
        System.out.println("Borrar sección: "+seccion.deleteSeccion("Sección a borrar"));
        System.out.println("Lista de seccion a partir de la clase Seccion"+seccion.getSecciones());
*/
        Categoria categoria= new Categoria();
        CategoriaDAO categoriaDAO= new CategoriaDAO(conn);
        /*System.out.println("-----Pruebas Categoria-----");
        System.out.println("Crear categoria: "+categoria.crearCategoria("Gama Alta"));
        System.out.println("Crear categoria: "+categoria.crearCategoria("Gama Baja"));
        System.out.println("Crear categoria: "+categoria.crearCategoria("Gama Estándar"));
        System.out.println("Existe la categoria?"+categoria.categoriaExist("Gama Estándar"));
        System.out.println("Existe la categoria? (false)"+categoria.categoriaExist("Gama falsa"));
        System.out.println("Lista de categorias en clase Categoria: "+categoria.getCategorias());
        System.out.println("Modificar categoria: "+categoria.modificarCategoria("Gama Baja","Gama Fake"));
        System.out.println("Lista de categorias en clase Categoria: "+categoria.getCategorias());
        System.out.println("Eliminar categoria: "+categoria.deleteCategoria("Gama Fake"));
        System.out.println("Lista de categorias en clase Categoria: "+categoria.getCategorias());*/
       /* TipoElementos tipoElementos= new TipoElementos();
        System.out.println("-----Pruebas TipoElementos-----");
        System.out.println("Crear tipoelemento"+tipoElementos.crearTipoElemento("Mesa"));
        System.out.println("Crear tipoelemento: "+tipoElementos.crearTipoElemento("Armario"));
        System.out.println("Existe el tipoelemento?"+tipoElementos.tipoElementoExists("silla"));
        System.out.println("Existe el tipoelemento?(false)"+tipoElementos.tipoElementoExists("falso"));
        System.out.println("Modificar un tipoElemento: "+tipoElementos.modificarTipoElemento("Ropero","NuevoTipoElemento"));
        System.out.println("Crear un tipoElemento para borrar: "+tipoElementos.crearTipoElemento("TipoElemento a Borrar"));
        System.out.println("Lista de tipoElementos de la clase TipoElementos"+tipoElementos.getTiposElementos());
        System.out.println("Borrar un tipoElemento: "+tipoElementos.deleteTiposElemento("TipoElemento a Borrar"));
        System.out.println("Lista de tipoElementos de la clase TipoElementos"+tipoElementos.getTiposElementos());*/

        Modelo modelo= new Modelo();
       // modelo.refresh();
        System.out.println(modelo.getCodigosModelos());
      /*  System.out.println("-----Pruebas Modelo-----");

        Elemento elemento= new Elemento("silla","Sc0331");
        Elemento elemento2= new Elemento("silla","Sc02321");
        Elemento elemento3= new Elemento("mesa","Mc0331");
        Elemento elemento4= new Elemento("mesa","Mc02321");

        //elementoList.add(elemento3);
        //elementoList.add(elemento4);
        modelo.Modelo modelo1= new modelo.Modelo("Sc999","Terraza y Jardín","Gama fake");
       System.out.println("Crear modelo: "+modelo.crearModelo(modelo1));

       System.out.println("Crear elemento a partir de la clase negocio.Modelo: "+modelo.crearElemento("Sc9","sillón","C1002"));
        ElementoDAO elementoDao= new ElementoDAO(conn);

        //System.out.println("Crear elemento a partir de la clase negocio.Modelo: "+modelo.crearElemento("Sc0021","silla","C1002"));
        System.out.println("Lista de codigos de modelos de la clase negocio.Modelo: "+modelo.getCodigosModelos());
       //System.out.println("Lista de codigos de modelos de la clase ModeloDAO"+modeloDAO.getCodigosModelos());
        //System.out.println("Crear elemento y retornarlo, usando la clase negocio.Modelo: "+modelo.crearElemento("Sc9021","silla","C1002"));*/
       ElementoModeloDAO elementoModeloDAO = new ElementoModeloDAO(conn);
       /* System.out.println("Insertar elementoModelo: "+elementoModeloDAO.crear("Sc9021","C1002"));
        System.out.println("Insertar elementoModelo: "+elementoModeloDAO.crear("Mc0021","C2900"));
        System.out.println("Elementos de modelo: elementoModelo"+elementoModeloDAO.getElementosByCodigoModelo("C1002"));*/
        System.out.println("-----Pruebas Muebles-----");
        Muebles muebles = new Muebles();
       /* System.out.println("Cargar un modelo: "+muebles.cargarModelo("C1002"));
        System.out.println("Cargar un modelo: "+muebles.cargarModelo("C2001"));
        System.out.println("Cargar un modelo: "+muebles.cargarModelo("Sc666"));
        System.out.println("Listar modelos de Muebles: "+muebles.getModelosDeInteres());
        System.out.println("Cargar modelos de Muebles:"+muebles.cargarModelos());
        System.out.println("Listar modelos de Muebles: "+muebles.getModelosDeInteres());*/
        //System.out.println("Prueba elementos de modelo: "+muebles.getElementosByCodigoModelo("C1002"));
        System.out.println("Cargar modelo por seccion: "+muebles.cargarModelosBySeccion("Terraza y Jardín"));
        System.out.println("Cargar modelos: "+muebles.cargarModelos());
        System.out.println("Lista de modelos de interes: "+muebles.getModelosDeInteres());
        System.out.println("Cargar un modelo: "+muebles.cargarModelo("C1001"));
        System.out.println("Cargar un modelo: "+muebles.cargarModelo("C1002"));
        System.out.println("Lista de modelos de interes: "+muebles.getModelosDeInteres());
        System.out.println("Cargar modelo por el código de un elemento: "+muebles.cargarModelosByElemento("Mc0021"));
muebles.cargarModelos();
        System.out.println("Modificar modelo: "+muebles.modificarModelo("CNew2","C1008"));
        System.out.println("Modificar elemento: "+muebles.modificarElemento("Sc9","Sc3002"));
        System.out.println("Lista modelos de interés: "+muebles.getModelosDeInteres());
        System.out.println("Cargar modelos por Seccion: "+muebles.cargarModelosBySeccion("cocina"));
        System.out.println("Lista modelos de interés: "+muebles.getModelosDeInteres());


    }
}
