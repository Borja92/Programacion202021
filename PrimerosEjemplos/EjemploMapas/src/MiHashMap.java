import java.util.HashMap;

public class MiHashMap {

HashMap<String,Integer> miMapa= new HashMap<String, Integer>();

    public String getMiMapa() {
        miMapa.put("Lunes", 1800);
        miMapa.put("Marte", 2000);
        miMapa.put("Miércoles", 1900);
        miMapa.put("Jueves", 24000);
        miMapa.put("Viernes", 2100);
        miMapa.put("Sábado", 25000);
        miMapa.put("Domingo", 21000);
        return miMapa.toString();
    }

    public static void main(String[] args) {

    MiHashMap miHashMap=new MiHashMap();

        System.out.println(miHashMap.getMiMapa());

        System.out.println("El miércoles consumí "+miHashMap.miMapa.get("Miércoles")+" calorías.");


        System.out.println("La tabla contiene la clave Viernes: "+miHashMap.miMapa.containsKey("Viernes"));
        System.out.println("La tabla contiene el valor 1800: "+miHashMap.miMapa.containsValue(1800));
        System.out.println("La tabla contiene el valor Corpoles: "+miHashMap.miMapa.containsKey("Corpoles"));
miHashMap.miMapa.remove("Lunes");

        System.out.println("La tabla contiene la clave Viernes: "+miHashMap.miMapa.containsKey("Viernes"));
        System.out.println("La tabla contiene la clave Lunes: "+miHashMap.miMapa.containsKey("Lunes"));




    }
}
