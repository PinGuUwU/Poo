package ar.edu.unlu.poo.ej3;

import ar.edu.unlu.poo.ej3.Pila;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        boolean control = true;
        Scanner leer = new Scanner(System.in);
        Pila pila = new Pila();
        /*
        Comportamientos:
            apilar(Object) void. (listo)
            desapilar Object. (listo)
            longitud int. (listo)
            vacia Boolean. (listo)
            mostrar void. (listo)
            recuperar Object.
         */
        while(control){
            int op;
            Object dato;
            System.out.println("\tBienvenid@ al menú:");
            System.out.println("1-.Agregar dato.");
            System.out.println("2-.Recuperar por posicion ordinal.");
            System.out.println("3-.Longitud.");
            System.out.println("4-.¿Es vacía?");
            System.out.println("5-.Mostrar contenido de la pila.");
            System.out.println("6-.Recuperar tope.");
            System.out.println("7-.Salir.");
            System.out.printf("Ingrese opcion: ");
            op = leer.nextInt();
            System.out.println("\n");
            switch (op) {
                case 1 -> {
                    System.out.printf("Ingrese dato a ingresar: ");
                    dato = leer.next();
                    pila.apilar(dato);
                }
                case 2 -> {
                }
                case 3 -> System.out.println("La longitud de la pila es: " + pila.longitud());
                case 4 -> System.out.println("¿La pila está vacía? " + pila.vacia());
                case 5 -> System.out.println(pila);
                case 6 -> {
                    dato = pila.recuperar();
                    System.out.println("El tope es: " + dato);
                }
                case 7 -> control = false;
                default -> System.out.println("Ingrese una opcion válida.");
            }
            System.out.println("\n");
        }

    }
}
