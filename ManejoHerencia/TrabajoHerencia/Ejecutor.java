package Poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class PrestamoEducativo extends Prestamo{
    public String nivelEstudio;
    public InstitucionEducativa centroEducativo;
    public double valorCarrera;
    public double valorMensualPagoCarrera;

    public PrestamoEducativo() {}
    public PrestamoEducativo(String nivelEstudio, InstitucionEducativa centroEducativo, double valorCarrera, Persona beneficiario, double tiempoMeses, String ciudadPrestamo) {
        super(beneficiario, tiempoMeses, ciudadPrestamo);
        this.nivelEstudio = nivelEstudio;
        this.centroEducativo = centroEducativo;
        this.valorCarrera = valorCarrera;
    }



    public void calcularValorMensualPago(){
        this.valorMensualPagoCarrera = (this.valorCarrera/ tiempoMeses) - ( (this.valorCarrera/ tiempoMeses) * 0.10 );
    }

    @Override
    public String toString() {
        return super.toString()+
                "-- PrestamoEducativo: --\n" +
                "Nivel de Estudio = " + nivelEstudio + "\n"+
                "Centro Educativo: " +
                centroEducativo.toString() + "\n"+
                "Valor de la Carrera = " + valorCarrera + "\n"+
                "Valor Mensual del Pago del prestamo del valor de la carrera = " + valorMensualPagoCarrera + "\n";
    }
}
class InstitucionEducativa{
    public String nombre;
    public String siglas;

    public InstitucionEducativa() {}
    public InstitucionEducativa(String nombre, String siglas) {
        this.nombre = nombre;
        this.siglas = siglas;
    }

    @Override
    public String toString() {
        return "\nNombre = " + nombre +
                "\nSiglas = " + siglas ;
    }
}
    class PrestamoAutomovil extends Prestamo {
    public String tipoAutomovil;
    public String marcaAutomovil;
    public Persona garante1;
    public double valorAutomovil;
    public double valorMensualPagoAutomovil;

    public PrestamoAutomovil() {}

    public PrestamoAutomovil(String tipoAutomovil, String marcaAutomovil, Persona garante1, double valorAutomovil, Persona beneficiario, double tiempoMeses, String ciudadPrestamo) {
        super(beneficiario, tiempoMeses, ciudadPrestamo);
        this.tipoAutomovil = tipoAutomovil;
        this.marcaAutomovil = marcaAutomovil;
        this.garante1 = garante1;
        this.valorAutomovil = valorAutomovil;
    }

    public void calcularValorMensualPagoAutomovil() {
        this.valorMensualPagoAutomovil = (this.valorAutomovil / tiempoMeses) ;
    }

    @Override
    public String toString() {
        return super.toString() +
                "--- Prestamo Automovil: ---\n"+
                "Tipo de automovil = " + tipoAutomovil + "\n" +
                "Marca de automovil = " + marcaAutomovil + "\n" +
                "Garante 1:\n" +
                garante1.toString() +
                "Valor de automovil: " + valorAutomovil + "\n" +
                "Valor mensual de pago del prestamo del automovil: " + valorMensualPagoAutomovil+ "\n";
    }

}
class Persona{
    public String nombre;
    public String apellido;
    public String userName;

    public Persona() {}
    public Persona(String nombre, String apellido, String userName) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Nombre = " + nombre + "\n" +
                "Apellido = " + apellido + "\n" +
                "Username = " + userName + "\n";
    }

}

class Prestamo {
    public Persona beneficiario;
    public double tiempoMeses;
    public String ciudadPrestamo;

    public Prestamo() {}

    public Prestamo(Persona beneficiario, double tiempoMeses, String ciudadPrestamo) {
        this.beneficiario = beneficiario;
        this.tiempoMeses = tiempoMeses;
        this.ciudadPrestamo = ciudadPrestamo;
    }

    public void setCiudadPrestamo() {
        this.ciudadPrestamo = ciudadPrestamo.toLowerCase();
    }

    @Override
    public String toString() {
        return "-- Beneficiario: --\n" +
                beneficiario.toString() +
                "Tiempo de prestamo en meses = " + tiempoMeses + "\n" +
                "Ciudad del prestamo = " + ciudadPrestamo + "\n";
    }

}
public class Ejecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Prestamo> lista_prestamos = new ArrayList<>();

        boolean repeat  = false;
        while(!repeat){
            System.out.println("|             SISTEMA DE PRESTAMO            |");
            System.out.println("|   1   |  Prestamo Automovil                |");
            System.out.println("|   2   |  Prestamo Educativo                |");
            System.out.println("|   3   |  Salir y Mostar                    |");
            System.out.print("- Ingrese el numero de prestamo deseado: ");
            byte op = sc.nextByte();

            switch (op){
                case 1:
                    System.out.println("| Postulacion para Prestamo Automovil |");
                    PrestamoAutomovil prestamoTipo1 = crearObjeto_PrestamoAutomovil(sc);
                    prestamoTipo1.setCiudadPrestamo();
                    prestamoTipo1.calcularValorMensualPagoAutomovil();
                    lista_prestamos.add(prestamoTipo1);
                    break;
                case 2:
                    System.out.println("| Postulacion para Prestamo Educativo |");
                    PrestamoEducativo prestamoTipo2 = crearObjeto_PrestamoEducativo(sc);
                    prestamoTipo2.setCiudadPrestamo();
                    prestamoTipo2.calcularValorMensualPago();
                    lista_prestamos.add(prestamoTipo2);
                    break;
                case 3:
                    System.out.println("Programa terminado...");
                    //recorro la lista
                    int n=1;
                    for(Prestamo p : lista_prestamos) {
                        System.out.println("|           PRESTAMO "+n+":             |");
                        System.out.println(p.toString() );
                        n++;
                    }
                    repeat = true;
                    break;

                default:
                    System.err.println("ERROR!");
                    System.out.println("Opcion No Valida");
                    break;
            }
        }
    }

    public static PrestamoAutomovil crearObjeto_PrestamoAutomovil (Scanner teclado){
        //Persona y Prestamo
        System.out.println("INGRESE DATOS DEL BENEFICIARIO");
        teclado.nextLine();
        System.out.print("Nombre: ");
        String nombreB = teclado.nextLine();
        System.out.print("Apellido: ");
        String apellidoB = teclado.nextLine();
        System.out.print("Username: ");
        String userNameB = teclado.nextLine();
        Persona beneficiario = new Persona(nombreB, apellidoB, userNameB);
        System.out.print("Ingrese el Tiempo de prestamo en meses: ");
        double meses = teclado.nextDouble();
        teclado.nextLine();
        System.out.print("Ingrese la Ciudad del prestamo: ");
        String ciudad = teclado.nextLine();
        //Prestamo new = Prestamo(beneficiario, meses, ciudad);
        //PERSONA
        System.out.println("INGRESE DATOS DEL GARANTE 1");
        System.out.print("Nombre: ");
        String nombreG = teclado.nextLine();
        System.out.print("Apellido: ");
        String apellidoG = teclado.nextLine();
        System.out.print("Username: ");
        String userNameG = teclado.nextLine();
        Persona garante1 = new Persona(nombreG, apellidoG, userNameG);

        //PrestamoAutomovil
        System.out.println("INGRESE DATOS DEL AUTOMOVIL");
        System.out.print("Tipo: ");
        String tipoAutomovil = teclado.nextLine();
        System.out.print("Marca :");
        String marcaAutomovil = teclado.nextLine();
        System.out.print("Valor del Automovil: "); double valorAutomovil = teclado.nextDouble();
        return new PrestamoAutomovil (tipoAutomovil, marcaAutomovil, garante1, valorAutomovil,beneficiario, meses, ciudad);
    }

    public static PrestamoEducativo crearObjeto_PrestamoEducativo(Scanner teclado){
        //PersonaBeneficiaria y Prestamo
        System.out.println("INGRESE DATOS DEL BENEFICIARIO");
        teclado.nextLine();
        System.out.print("Nombre: ");
        String nombreB = teclado.nextLine();
        System.out.print("Apellido: ");
        String apellidoB = teclado.nextLine();
        System.out.print("Username: ");
        String userNameB = teclado.nextLine();
        Persona beneficiario = new Persona(nombreB, apellidoB, userNameB);

        System.out.print("Ingrese el Tiempo de prestamo en meses: ");
        double meses = teclado.nextDouble();
        teclado.nextLine();
        System.out.print("Ingrese la Ciudad del prestamo: ");
        String ciudad = teclado.nextLine();
        //PrestamoEducativo
        System.out.print("Nivel de Estudio: ");
        String nivelEstudio = teclado.nextLine();
        System.out.print("Valor de la carrera: ");
        double valorCarrera = teclado.nextDouble();
        teclado.nextLine();
        System.out.println("INGRESE DATOS DEL CENTRO EDUCATIVO");
        System.out.print("Nombre:");
        String nombreC = teclado.nextLine();
        System.out.print("Siglas:");
        String siglasC = teclado.nextLine();
        InstitucionEducativa centroEducativo = new  InstitucionEducativa (nombreC,siglasC);
        return new PrestamoEducativo(nivelEstudio, centroEducativo, valorCarrera, beneficiario, meses, ciudad);
    }
}
