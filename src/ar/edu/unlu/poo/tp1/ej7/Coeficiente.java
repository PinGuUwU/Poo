package ar.edu.unlu.poo.ej7;

import static java.lang.Math.sqrt;

public class Coeficiente {
    private double a;
    private double b;
    private double c;

    public void setA(double a){this.a = a;}
    public double getA(double a){return a;}
    public void setB(double b){this.b = b;}
    public double getB(double b){return b;}
    public void setC(double c){this.c = c;}
    public double getC(double c){return c;}
    public void ingresar(double a, double b, double c){
        setA(a);
        setB(b);
        setC(c);
    }
    public double calcularx1(){
        if(((Math. pow(b, 2) - 4 * a * c))==0){
            return 0;
        } else {
            return (-b + sqrt((Math.pow(b, 2) - (4 * a * c)))) / (2 * a);
        }
    }
    public double calcularx2(){
        if(((Math. pow(b, 2) - 4 * a * c))==0){
            return 0;
        } else {
            return (-b - sqrt((Math.pow(b, 2) - (4 * a * c)))) / (2 * a);
        }
    }
    public double calcularX(double x){
        return a * Math.pow(x, 2) + b * x + c;
    }
    public String toString(){//y = a * x^2 + b * x + c
        String acumulador = " ";
        acumulador += "y = "+a+" * x^2 + "+b+" * x + "+c;
        return acumulador;
    }

}
