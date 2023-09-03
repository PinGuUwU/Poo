package ar.edu.unlu.poo.ej4;

import ar.edu.unlu.poo.ej4.Cola;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        Cola cola = new Cola();
        boolean control = true;
        while(control){
            int pos,op;
            Object dato;
            System.out.println("\tBienvenid@ al menú:");
            System.out.println("1-.Agregar nuevo dato(encolar).");
            System.out.println("2-.Eliminar por posicion ordinal.");
            System.out.println("3-.Recuperar dato (desencolar)");
            System.out.println("4-.Insertar nuevo dato por posicion ordinarl.");
            System.out.println("5-.Mostrar contenido de la cola.");
            System.out.println("6-.Longitud de la pila.");
            System.out.println("7-.¿La pila está vacía?");
            System.out.println("8-.Salir.");
            System.out.printf("ingrese una opción: ");
            op = leer.nextInt();
            System.out.printf("\n");
            switch (op){
                case 1 -> {
                    System.out.print("Ingrese nuevo dato: ");
                    dato = leer.next();
                    cola.encolar(dato);
                }
                case 2 -> {
                    System.out.print("Ingrese posicion ordinal a eliminar: ");
                    pos = leer.nextInt();
                    cola.eliminar(pos);
                }
                case 3 -> System.out.printf("Dato desencolado: "+cola.desencolar()+"\n");
                case 4 -> {
                    System.out.print("Ingrese posicion ordinal a insertar: ");
                    pos = leer.nextInt();
                    System.out.printf("Ingrese nuevo dato: ");
                    dato = leer.next();
                    cola.insertar(pos, dato);
                }
                case 5 -> System.out.println(cola);
                case 6 -> System.out.printf("Longitud de la cola: "+cola.longitud()+"\n");
                case 7 -> System.out.printf("¿La cola está vacía? "+cola.vacia()+"\n");
                case 8 -> control=false;
                default -> System.out.println("Ingrese una opción válida.");
            }
        }
    }
}
