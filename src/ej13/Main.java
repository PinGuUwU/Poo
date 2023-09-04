package ar.edu.unlu.poo.ej13;

import ar.edu.unlu.poo.ej13.AdministradorTarea;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner leer = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        boolean control=true;
        AdministradorTarea tareas = new AdministradorTarea();
        while(control){
            int prioridad, op,est;
            boolean estado;
            String descripcion, nuevaDesc, nombre, date;
            Date fechaLimite, fechaFinal;
            System.out.println("\tBienvenid@ al menú: ");
            System.out.println("1-.Crear nueva tarea.");
            System.out.println("2-.Crear nuevo colaborador.");
            System.out.println("3-.Marcar una tarea como completada.");
            System.out.println("4-.Modificar descripción de una tarea.");
            System.out.println("5-.Comprobar vencimiento de una tarea.");
            System.out.println("6-.Comprobar estado de una tarea.");
            System.out.println("7-.Cambiar prioridad de una tarea.");
            System.out.println("8-.Mostrar la lista de colaboradores.");
            System.out.println("9.-Mostrar la lista de tareas.");
            System.out.println("10-.Salir.");
            System.out.print("Ingrese una opción: ");
            op = leer.nextInt();
            switch(op){
                case 1 -> {
                    System.out.print("Ingrese la nueva tarea: ");
                    leer.nextLine();
                    descripcion = leer.nextLine();
                    System.out.print("Ingrese la prioridad de la tarea (1-10): ");
                    prioridad = leer.nextInt();
                    System.out.print("Ingrese la fecha límite de la tarea (formato : dd/MM/yyyy): ");
                    leer.nextLine();
                    date = leer.nextLine();
                    fechaLimite = formato.parse(date);
                    System.out.println("Posibles estados: 1-.Completa. 2-.Incompleta.");
                    System.out.print("Ingrese el estado de la tarea: ");
                    est = leer.nextInt();
                    estado = est==1;
                    if(estado){
                        System.out.print("Ingrese el nombre del colaborador que completo la tarea: ");
                        nombre = leer.next();
                        if(tareas.existeColaborador(nombre)){
                            System.out.print("Ingrese fecha de finalización de la tarea:");
                            date = leer.nextLine();
                            fechaFinal = formato.parse(date);
                            tareas.agregar(descripcion, prioridad, true, fechaLimite, nombre, fechaFinal);
                        } else {
                            System.out.println("El nombre de colaborador ingresado no existe.\n Por favor cree un colaborador al que asignarle tareas completadas.");
                        }
                    } else {
                        tareas.agregar(descripcion, prioridad, false, fechaLimite);
                    }
                }
                case 2 -> {
                    System.out.print("Ingrese el nombre del nuevo colaborador: ");
                    leer.nextLine();
                    nombre = leer.nextLine();
                    tareas.nuevoColaborador(nombre);
                }
                case 3 -> {
                    System.out.print("Ingrese la descripción de la tarea a completar: ");
                    leer.nextLine();
                    descripcion = leer.nextLine();
                    System.out.print("Ingrese el nombre del colaborador que completará la tarea: ");
                    nombre = leer.nextLine();
                    if(tareas.existeColaborador(nombre)){
                        System.out.print("Ingrese la fecha de finalizació de la tarea: ");
                        date = leer.nextLine();
                        fechaFinal = formato.parse(date);
                        tareas.completar(descripcion, nombre,fechaFinal);
                    } else {
                        System.out.println("No existe ningún colaborador con el nombre ingresado.");
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese descripción de la tarea a modificar descripción: ");
                    leer.nextLine();
                    descripcion = leer.nextLine();
                    System.out.print("Ingrese la nueva descripción: ");
                    leer.nextLine();
                    nuevaDesc = leer.nextLine();
                    if(tareas.modificar_descripcion(descripcion, nuevaDesc)){
                        System.out.println("La descripción se ha modificado con éxito.");
                    } else {
                        System.out.println("No se ha encontrado una tarea con la descripción ingresada.");
                    }
                }
                case 5 -> {
                    System.out.print("Ingrese descripcion de la tarea a comprobar vencimiento: ");
                    leer.nextLine();
                    descripcion = leer.nextLine();
                    if(tareas.comprobarFecha(descripcion)){
                        System.out.println("La tarea está vencida.");
                    } else {
                        System.out.println("La tarea no está vencida.");
                    }
                }
                case 6 -> {
                    System.out.print("Ingrese descripcion de la tarea a comprobar estado: ");
                    leer.nextLine();
                    descripcion = leer.nextLine();
                    if(tareas.comprobarEstado(descripcion)){
                        System.out.println("La tarea está completada.");
                    } else {
                        System.out.println("La tarea está incompleta.");
                    }
                }
                case 7 -> {
                    System.out.print("Ingrese descripcion de la tarea a cambiar prioridad: ");
                    leer.nextLine();
                    descripcion = leer.nextLine();
                    System.out.print("Ingrese nueva prioridad: ");
                    prioridad = leer.nextInt();
                    if(tareas.modificar_prioridad(descripcion,prioridad)){
                        System.out.println("La prioridad se modificó con éxito.");
                    } else {
                        System.out.println("No se ha encontrado una tarea con esa descripción.");
                    }
                }
                case 8 -> System.out.println(tareas.listaColaboradores());
                case 9 -> System.out.println(tareas.listaTareas());
                case 10 -> control=false;
                default -> System.out.println("Ingrese una opción válida.");
            }
        }
    }
}
