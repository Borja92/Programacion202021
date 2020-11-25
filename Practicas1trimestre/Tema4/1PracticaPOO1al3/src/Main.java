import java.text.DecimalFormat;

public class Main {


    public static void main(String[] args) throws Exception {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona();
        Persona persona3 = new Persona();


        //Con decimalformat controlo el número de décimales
        DecimalFormat formateador = new DecimalFormat("#######.##");


        //Bloque código referente al ejercicio1
        persona1.setNombre("Borja");
        persona1.setDni("12345678A");
        persona1.setEdad(28);

        System.out.println("¿"+persona1.getNombre()+" es mayor de edad? " + persona1.esMayorDeEdad() + "\n");

        persona1.mostrar();

        persona2.setNombre("Persona2");
        persona2.setDni("12345678S");
        persona2.setEdad(23);

        persona2.mostrar();
        System.out.println("¿"+persona2.getNombre()+" es mayor de edad? " + persona2.esMayorDeEdad() + "\n");

        persona3.setNombre("Persona3");
        persona3.setEdad(17);
        persona3.setDni("26842211O");

        persona3.mostrar();
        System.out.println("¿"+persona3.getNombre()+" es mayor de edad? " + persona3.esMayorDeEdad() + "\n");

//No continua el programa si el DNI no está en el formato adecuado ?¿
        /*persona3.setDni("268422O");

        persona3.mostrar();*/


        //Bloque código referente al ejercicio 2
        Cuenta cuentaA = new Cuenta(persona1);
        Cuenta cuentaB = new Cuenta(persona2);
        Cuenta cuentaC = new Cuenta(persona3);

        cuentaA.setCantidad(527.8500);

        cuentaA.mostrar();

        //Bloque operaciones ingresar y retirar dinero de cuenta
        cuentaA.ingresarEnCuenta(23.15);

        cuentaA.mostrar();

        cuentaA.retirarCantidadEnCuenta(250);
        cuentaA.mostrar();

        cuentaB.ingresarEnCuenta(1500);
        cuentaB.mostrar();

        cuentaB.retirarCantidadEnCuenta(2000);
        cuentaB.mostrar();


        //Bloque código referente al ejericio 3
        CuentaJoven cuentaJovenA = new CuentaJoven(persona1);

        System.out.println("¿Es válido el títular " + cuentaJovenA.persona.getNombre() + " de la cuenta joven? " + cuentaJovenA.esTitularValido() + "\n");
       // cuentaJovenA.retirarDineroSiTitularEsValido(250); no continua programa si el titular no es válido
        CuentaJoven cuentaJovenB = new CuentaJoven(persona2);
        System.out.println("¿Es válido el títular " + cuentaJovenB.persona.getNombre() + " de la cuenta joven? " + cuentaJovenB.esTitularValido() + "\n");

        cuentaJovenB.retirarDineroSiTitularEsValido(250);

        cuentaJovenB.setBonificacionCuentaJoven(1.5);
        cuentaJovenB.mostrar();

    }
}
