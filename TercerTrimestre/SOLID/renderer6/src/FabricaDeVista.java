import java.util.List;

public class FabricaDeVista {


   public static Vista crear(List<Coche> coches, int tipoRenderer){
       switch (tipoRenderer){
           case Vista.HTML:
                return new VistaConPie(new RendererHtml(coches));
           case Vista.HTML_NAV:
               return new VistaConPie(new RendererHtmlNavegable(coches));
           case Vista.XML:
               return new VistaConPie(new RendererXML(coches));
           default: // Vista.CSV:
               return new VistaSinPie(new RendererCSV(coches));
       }
   }
}
