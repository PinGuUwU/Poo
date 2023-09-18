package ar.edu.unlu.poo.ej12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner leer = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        boolean control = true;
        AdministradorTarea lista = new AdministradorTarea();
        while(control){
            int op, prioridad, est;
            Date fecha;
            boolean estado;
            String date, nuevaDesc, nuevaTarea, descripcion;
            System.out.println("\tBienvenid@ al menú:");
            System.out.println("1-.Crear nueva tarea.");
            System.out.println("2-.Modificar descripción de una tarea.");
            System.out.println("3-.Comprobar vencimiento de una tarea.");
            System.out.println("4-.Comprobar estado de una tarea.");
            System.out.println("5-.Cambiar prioridad de una tarea.");
            System.out.println("6.-Mostrar la lista de tareas.");
            System.out.println("7-.Salir.");
            System.out.print("Ingrese una opción: ");
            op = leer.nextInt();
            switch(op){
                case 1 -> {
                    System.out.print("Ingrese la nueva tarea:");
                    leer.nextLine();
                    nuevaTarea = leer.nextLine();

                    System.out.print("Ingrese la prioridad de la tarea (1-10): ");
                    prioridad = leer.nextInt();
                    System.out.print("Ingrese la fecha límite de la tarea (formato: dd/MM/yyyy): ");
                    leer.nextLine();
                    date = leer.nextLine();
                    fecha = formato.parse(date);
                    System.out.println("Posibles estados: 1-.Completa. 2-.Incompleta.");
                    System.out.print("Ingrese el estado de la tarea: ");
                    est = leer.nextInt();
                    estado = est == 1;
                    lista.agregar(nuevaTarea, prioridad, estado, fecha);
                }
                case 2 -> {
                    System.out.print("Ingrese la descripción de la tarea a modificar: ");
                    descripcion = leer.nextLine();
                    System.out.print("Ingrese nueva descripción: ");
                    leer.nextLine();
                    nuevaDesc = leer.nextLine();
                    lista.modificar_descripcion(descripcion, nuevaDesc);
                }
                case 3 -> {
                    System.out.print("Ingrese la descripción de la tarea a comprobar: ");
                    descripcion= leer.nextLine();
                    System.out.printf("¿La tarea está vencida? "+lista.vencida(descripcion)+"\n");
                }
                case 4 -> {
                    System.out.print("Ingrese la descripción de la tarea a comprobar: ");
                    descripcion = leer.nextLine();
                    System.out.printf("¿La tarea está completada? " +lista.completada(descripcion)+"\n");
                }
                case 5 -> {
                    System.out.print("Ingrese descripcion de la tarea a cambiar prioridad: ");
                    descripcion = leer.nextLine();
                    System.out.print("Ingrese nueva prioridad: ");
                    prioridad = leer.nextInt();
                    lista.modificar_prioridad(descripcion, prioridad);
                }
                case 6 ->  System.out.println(lista);
                case 7 ->  control = false;
                default -> System.out.print("Por favor, ingrese una opción válida.");
            }
        }
    }
}
