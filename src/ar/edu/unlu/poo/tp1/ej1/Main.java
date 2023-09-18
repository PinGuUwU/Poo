package ar.edu.unlu.poo.ej1;

import ar.edu.unlu.poo.ej1.ListaEnlazada;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        ListaEnlazada lista = new ListaEnlazada();
        Scanner leer = new Scanner(System.in);
        boolean control = true;
        while(control){
            int op;
            int pos;
            Object dato;
            System.out.println("\tBienvenid@ al menú:");
            System.out.println("1-.Agregar un valor a la lista.");
            System.out.println("2-.Insertar un valor.");
            System.out.println("3-.Recuperar por posicion ordinal.");
            System.out.println("4-.Eliminar un valor de la lista (por posicion ordinal).");
            System.out.println("5-.Mostrar contenido de la lista.");
            System.out.println("6-.Longitud de la lista.");
            System.out.println("7-.¿La lista está vacía?");
            System.out.println("8.-Salir.");
            System.out.print("Ingrese una opción: ");
            op = leer.nextInt();
            System.out.println("");
            switch (op) {
                case 1 -> {
                    System.out.print("Ingrese el dato a agregar a la lista: ");
                    dato = leer.next();
                    lista.agregar(dato);
                }
                case 2 -> {
                    System.out.println("Ingrese posicion ordinal donde quiere insertar: ");
                    pos = leer.nextInt();
                    System.out.println("Ingrese dato: ");
                    dato = leer.next();
                    lista.insertar(pos, dato);
                }
                case 3 -> {
                    System.out.print("Ingrese posicion ordinal a recuperar: ");
                    pos = leer.nextInt();
                    dato = lista.recuperar(pos);
                    System.out.println("Dato dentro del nodo: " + dato.toString());
                }
                case 4 -> {
                    System.out.print("Ingrese la posicion ordinal a eliminar: ");
                    pos = leer.nextInt();
                    lista.eliminarPos(pos);
                }
                case 5 -> System.out.println(lista);
                case 6 -> {
                    int longi = lista.longitud();
                    System.out.printf("Longitud de la lista: %d", longi);
                }
                case 7 -> System.out.printf("¿Lista vacía? %b ", lista.vacia());
                case 8 -> control = false;
                default -> System.out.println("Ingrese una opcion existente.");
            }
            System.out.println("\n");
        }


    }
}