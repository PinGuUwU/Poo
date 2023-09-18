package ar.edu.unlu.poo.ej7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Coeficiente calculadora = new Coeficiente();
        Scanner leer = new Scanner(System.in);
        double a,b,c,x,y;
        System.out.print("Ingrese el numero a: ");
        a = leer.nextByte();
        System.out.print("Ingrese el numero b: ");
        b = leer.nextByte();
        System.out.print("Ingrese el numero c: ");
        c = leer.nextByte();
        calculadora.ingresar(a,b,c);
        System.out.println(calculadora);
        double x1 = calculadora.calcularx1();
        double x2 = calculadora.calcularx2();
        if((x1==0 ^ Double.isNaN(x1))& (x2==0 ^ Double.isNaN(x1))){
            System.out.println("No existen soluciones dentro de los Reales.");
        } else if(x1==0 ^ Double.isNaN(x1)){
            System.out.printf("Tiene una única raíz: "+ x2);
        } else if(x2==0 ^ Double.isNaN(x2)){
            System.out.printf("Tiene una única raíz: "+ x1);
        } else {
            System.out.printf("Las raices son: "+x1+" --- "+x2);
        }
        System.out.println("\n");
        System.out.print("Ingrese el valor de X para hallar el valor de Y: ");
        x = leer.nextByte();
        y = calculadora.calcularX(x);
        System.out.println("El resultado de reemplazar X es: "+y);
    }
}
