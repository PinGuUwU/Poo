package ar.edu.unlu.poo.ej6;

import ar.edu.unlu.poo.ej6.Biblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();
        Scanner leer = new Scanner(System.in);
        boolean control = true;
        while(control){
            int op, pos1, pos2, cant_pag, cant_dispo, cant_prest, isbn;
            String titulo, autor;
            System.out.println("\n\tBienvenid@ al menú:");
            System.out.println("1-.Agregar nuevo libro a la biblioteca.");
            System.out.println("2-.Buscar un libro por el título.");
            System.out.println("3-.Buscar un libro por el ISBN.");
            System.out.println("4-.Prestar un libro (por titulo o isbn).");
            System.out.println("5-.Devolver un libro (por titulo o isbn).");
            System.out.println("6-.Comparar la cantidad de páginas de dos libros.");
            System.out.println("7-.Cantidad de prestamos activos.");
            System.out.println("8-.Mostrar todos los libros de la biblioteca.");
            System.out.println("9-.Salir.");
            System.out.print("Ingrese una opción: ");
            op = leer.nextInt();
            switch(op){
                case 1 -> {
                    System.out.print("Ingrese el título del nuevo libro: ");
                    leer.nextLine();
                    titulo = leer.nextLine();
                    System.out.print("Ingrese el autor del nuevo libro: ");
                    autor = leer.nextLine();
                    System.out.print("Ingrese la cantidad de páginas que tiene el nuevo libro: ");
                    cant_pag = leer.nextInt();
                    System.out.print("Ingrese la cantidad de ejemplares disponibles del nuevo libro: ");
                    cant_dispo = leer.nextInt();
                    System.out.print("Ingrese la candidad de ejemplares prestados del nuevo libro: ");
                    cant_prest = leer.nextInt();
                    biblioteca.agregar(titulo, autor, cant_pag, cant_dispo, cant_prest);
                }
                case 2 -> {
                    System.out.print("Ingrese el titulo: ");
                    leer.nextLine();
                    titulo = leer.nextLine();
                    biblioteca.buscar(titulo);
                }
                case 3 -> {
                    System.out.print("Ingrese el ISBN: ");
                    isbn = leer.nextInt();
                    biblioteca.buscar(isbn);
                }
                case 4 -> {
                    System.out.print("Ingrese la posición ordinal del del libro que desea prestar: ");
                    pos1 = leer.nextInt();
                    System.out.print("Ingrese la cantidad de ejemplares que desea prestar: ");
                    cant_prest = leer.nextInt();
                    /*if(biblioteca.prestar(pos1, cant_prest)){
                        System.out.println("Se ha confirmado el prestamo.");
                    } else {
                        System.out.println("La cantidad de ejemplares no alcanza para la cantidad pedida.");
                    }*/
                }
                case 5 -> {

                }
                case 6 -> {
                    System.out.print("Ingrese la posición ordinal del primer libro: ");
                    pos1 = leer.nextInt();
                    System.out.print("Ingrese la posición ordinal del segundo libro: ");
                    pos2 = leer.nextInt();
                    biblioteca.compararLibros(pos1, pos2);
                }
                case 7 -> System.out.printf("La cantidad de prestamos activos actualmente es: "+biblioteca.cant_prestamos()+".\n");
                case 8 -> System.out.println(biblioteca);
                case 9 ->  control = false;
                default -> System.out.print("Ingrese una opción válida.");
            }
        }
    }

}
