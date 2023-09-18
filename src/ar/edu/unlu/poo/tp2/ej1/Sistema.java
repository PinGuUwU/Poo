package ar.edu.unlu.poo.tp2.ej1;

import java.text.ParseException;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) throws ParseException {
        Scanner leer = new Scanner(System.in);
        Gestion gestionar = new Gestion();
        boolean control=true;
        while(control){
            int op;
            String nombre, dni, telefono, email, direccion, suscripcion;
            System.out.println("\tBienvenido al sistema del Gymnasio.");
            System.out.println("1-.Registrar nuevo socio.");
            System.out.println("2-.Listado de socios inscriptos.");
            System.out.println("3-.Reporte mensual de socios inscriptos.");
            System.out.println("4-.Listado de tipos de suscripciones con sus actividades.");
            System.out.println("5-.Actualizar la suscripcion de alguien (nro credencial).");
            System.out.println("6-.Salir.");
            System.out.print("Ingrese una opción: ");
            op = leer.nextInt();
            switch(op){
                case 1 -> {
                    System.out.print("Ingrese el nombre del nuevo socio: ");
                    leer.nextLine();
                    nombre = leer.nextLine();
                    System.out.print("Ingrese el DNI: ");
                    dni = leer.nextLine();
                    System.out.print("Ingrese el teléfono: ");
                    telefono = leer.nextLine();
                    System.out.print("Ingrese la dirección: ");
                    direccion = leer.nextLine();
                    System.out.print("Ingrese el E-mail: ");
                    email = leer.nextLine();
                    System.out.println("Tipos de suscripciones existentes:\n\t-Basico.\n\t-Intermedio\n\t-Destacado.\n");
                    System.out.print("Ingrese el tipo de suscripción a adquirir: ");
                    suscripcion = leer.nextLine();
                    System.out.print("Ingrese la fecha de la primera suscripción(formato: dd/MM/yyyy): ");
                    String primeraFecha;
                    primeraFecha = leer.nextLine();
                    gestionar.registrarSocio(nombre, dni, telefono, direccion, email, suscripcion, primeraFecha);
                }
                case 2 -> gestionar.sociosActivos();
                case 3 -> {
                    System.out.print("Ingrese el mes del cual quiere un reporte: ");
                    String mes = leer.nextLine();
                    gestionar.sociosMes(mes);
                }
                case 4 -> gestionar.suscripciones();
                case 5 -> {
                    System.out.print("Ingrese la fecha de su reinscripcion: ");
                    leer.nextLine();
                    suscripcion = leer.nextLine();
                    System.out.print("Ingrese el numero de la credencial: ");
                    int numero = leer.nextInt();
                    gestionar.reInscripcion(suscripcion, numero);
                }
                case 6 -> control=false;
                default -> System.out.println("Ingrese una opcion válida.");
            }
        }
    }
}
