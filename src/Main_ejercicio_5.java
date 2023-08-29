import ar.edu.unlu.poo.ej5.ListaTarea;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main_ejercicio_5 {
    public static void main(String[] args) throws ParseException {
        Scanner leer = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //String aux = leer.next();
        //Date fecha = formato.parse(aux);
        //System.out.println(formato.format(fecha));
        Boolean control = true;
        ListaTarea lista = new ListaTarea();
        while(control){
            int op, prioridad, pos, est;
            Date fecha;
            Boolean estado;
            String date, nuevaDesc, nuevaTarea;
            System.out.println("\tBienvenid@ al menú:");
            System.out.println("1-.Crear nueva tarea.");
            System.out.println("2-.Modificar descripción de una tarea. (Por posición ordinal)");
            System.out.println("3-.Comprobar vencimiento de una tarea. (Por posición ordinal)");
            System.out.println("4-.Comprobar estado de una tarea. (Por posición ordinal)");
            System.out.println("5-.Cambiar prioridad de una tarea. (Por posición ordinal)");
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
                    if(est==1){ estado = true; } else { estado = false; }
                    lista.agregar(nuevaTarea, prioridad, fecha, estado);
                }
                case 2 -> {
                    System.out.print("Ingrese posición ordinal para modificar su descripción: ");
                    pos = leer.nextInt();
                    System.out.print("Ingrese nueva descripción: ");
                    leer.nextLine();
                    nuevaDesc = leer.nextLine();
                    lista.modificar_descripccion(pos-1, nuevaDesc);
                }
                case 3 -> {
                    System.out.print("Ingrese posición ordinal de la tarea a comprobar: ");
                    pos = leer.nextInt();
                    System.out.printf("¿La tarea está vencida? "+lista.vencida(pos-1)+"\n");
                }
                case 4 -> {
                    System.out.print("Ingrese posición ordinal de la tarea a comprobar: ");
                    pos = leer.nextInt();
                    System.out.printf("¿La tarea está completada? " +lista.completada(pos-1)+"\n");
                }
                case 5 -> {
                    System.out.print("Ingrese posición ordinal a modificar: ");
                    pos = leer.nextInt();
                    System.out.print("Ingrese nueva prioridad: ");
                    prioridad = leer.nextInt();
                    lista.modificar_prioridad(prioridad, pos-1);
                }
                case 6 -> { System.out.println(lista); }
                case 7 -> { control = false; }
                default -> System.out.print("Por favor, ingrese una opción válida.");
            }
        }
        System.out.printf("Que tengas un buen dia <3");
        leer.close();
    }
}
