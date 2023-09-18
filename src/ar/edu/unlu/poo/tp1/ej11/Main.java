package ar.edu.unlu.poo.ej11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        Juego juego = new Juego();
        boolean control = true;
        String username1, username2;
        System.out.println("\tBienveni@ al juego de palabras:");
        System.out.print("Ingrese el nombre del jugador 1: ");
        username1 = leer.nextLine();
        System.out.print("Ingrese el nombre del jugador 2: ");
        username2 = leer.nextLine();
        juego.crearJugadores(username1,username2);
        while(control){
            String palabra;
            boolean agregar;
            int op;
            System.out.println("\n\tBienvenid@ al menú.");
            System.out.printf("1-.Agregar nueva palabra para el jugador "+username1+"\n");
            System.out.printf("2-.Agregar nueva palabra para el jugador "+username2+"\n");
            System.out.println("3-.Agregar nueva palabra al diccionario.");
            System.out.println("4-.Eliminar palabra del diccionario.");
            System.out.println("5-.Mostrar todas las palabras del diccionario.");
            System.out.println("6-.Finalizar partida.");
            System.out.print("Ingrese la opcion a ejercutar: ");
            op = leer.nextInt();
            switch(op){
                case 1 ->{
                    System.out.print("Ingrese nueva palabra: ");
                    leer.nextLine();
                    palabra = leer.nextLine();
                    agregar = juego.agregarPalabraPlayer1(palabra);
                    if(agregar){
                        System.out.println("Se agregó una palabra válida.");
                    } else {
                        System.out.println("Se agregó una palabra inválida.");
                    }
                }
                case 2 -> {
                    System.out.print("Ingrese nueva palabra: ");
                    leer.nextLine();
                    palabra = leer.nextLine();
                    agregar = juego.agregarPalabraPlayer2(palabra);
                    if(agregar){
                        System.out.println("Se agregó una palabra válida.");
                    } else {
                        System.out.println("Se agregó una palabra inválida.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese la palabra a agregar al diccionario: ");
                    leer.nextLine();
                    palabra = leer.nextLine();
                    juego.agregarPalabra(palabra);
                }
                case 4 -> {
                    System.out.print("Ingrese la palabra a eliminar del diccionaro: ");
                    leer.nextLine();
                    palabra = leer.nextLine();
                    juego.eliminarPalabra(palabra);
                }
                case 5 -> {
                    juego.palabrasValidas();
                }
                case 6 -> {
                    if(juego.puntosPlayer1()==juego.puntosPlayer2()){
                        System.out.println("Los jugadores están empatados.");
                        System.out.printf("Puntos: "+juego.puntosPlayer1());
                    } else if(juego.puntosPlayer1()>juego.puntosPlayer2()){
                        System.out.println("Ganó el jugador: "+username1);
                        System.out.printf("Puntos: "+juego.puntosPlayer1());
                    } else {
                        System.out.println("Ganó el jugador: "+username2);
                        System.out.printf("Puntos: "+juego.puntosPlayer2());
                    }
                    control = false;
                }
                default -> System.out.println("ingrese una opción válida.");
            }
        }
    }
}
