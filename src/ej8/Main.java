package ar.edu.unlu.poo.ej8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        boolean control=true;
        ListaPassword lista = new ListaPassword();
        Scanner leer = new Scanner(System.in);
        while(control){
            int op, longitud, id;
            Password password;
            System.out.println("\tBienvenid@ al menú.");
            System.out.println("1-.Generar nueva password.");//Luego de generarla
            //Mostrarla y preguntar si se quiere volver a generar
            System.out.println("2-.Mostrar todas las contraseñas (Muestra posición ordinal).");
            System.out.println("3-.Cambiar longitud de una contraseña (Por posición ordinal).");
            System.out.println("4-.Salir.");
            System.out.print("Ingrese una opción: ");
            op = leer.nextInt();
            switch  (op){
                case 1 -> {
                    System.out.print("Ingrese la longitud deseada: ");
                    longitud = leer.nextInt();
                    password = lista.generar(longitud);
                    System.out.println(password);
                }
                case 2 -> {
                    System.out.println(lista);
                }
                case 3 -> {
                    System.out.print("Ingrese el id de la contraseña: ");
                    id = leer.nextInt();
                    System.out.print("Ingrese la nueva longitud: ");
                    longitud = leer.nextInt();
                    password = lista.regenerarFuerte(longitud, id);
                    System.out.println(password);
                }
                case 4 -> { control = false; }
                default -> System.out.println("Ingrese una opción válida.");
            }

        }
    }
}
