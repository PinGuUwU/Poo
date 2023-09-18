package ar.edu.unlu.poo.ej2;

import ar.edu.unlu.poo.ej2.ListaEnlazadaDoble;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        ListaEnlazadaDoble lista = new ListaEnlazadaDoble();
        boolean control = true;
        while(control){
            int op, pos, longitud;
            Object dato;
            boolean vacia;
            System.out.println("\tBienvenid@ al menú:");
            System.out.println("1-.Agregar un valor a la lista.");
            System.out.println("2-.Insertar un valor.");
            System.out.println("3-.Recuperar por posicion ordinal.");
            System.out.println("4-.¿Lista vacia?");
            System.out.println("5-.Longitud de la lista.");
            System.out.println("6-.Eliminar elemento de la lista por posicion ordinal.");
            System.out.println("7-.Mostrar lista.");
            System.out.println("8-.Salir.");
            System.out.print("Ingrese una opcion: ");
            op = leer.nextInt();
            System.out.print("\n");
            switch (op) {
                case 1 -> {
                    System.out.print("Ingrese valor a agregar: ");
                    dato = leer.next();
                    lista.agregar(dato);
                }
                case 2 -> {
                    System.out.print("Ingrese posicion ordinal donde desea insertar: ");
                    pos = leer.nextInt();
                    System.out.print("Ingrese valor a insertar: ");
                    dato = leer.next();
                    lista.insertar(pos - 1, dato);
                }
                case 3 -> {
                    System.out.print("Ingrese posicion ordinal a recuperar: ");
                    pos = leer.nextInt();
                    dato = lista.recuperar(pos - 1);
                    System.out.println("Contenido del dato recuperado: " + dato);
                }
                case 4 -> System.out.println("¿La lista está vacía? " + lista.vacia());
                case 5 -> System.out.println("La longitud de la lista es: " + lista.longitud());
                case 6 -> {
                    System.out.printf("Ingrese posicion ordinal a eliminar: ");
                    pos = leer.nextInt();
                    lista.eliminarPos(pos - 1);
                }
                case 7 -> {
                    System.out.println(lista);
                }
                case 8 -> control = false;
                default -> System.out.println("Ingrese una opción válida.");
            }
        }
    }
}
