package ar.edu.unlu.poo.ej11;

import java.util.ArrayList;

public class Diccionario {
    private final ArrayList<String> palabras = new ArrayList<>();
    /*
    Responsabilidades:
        buscar las palabras que le pasan para ver si estan en su lista
     */
    public void agregarPalabra(String palabra){
        String cadena = palabra.toLowerCase();
        palabras.add(cadena);
    }
    public boolean esValida(String palabra){
        String cadena = palabra.toLowerCase();
        return palabras.contains(cadena);
    }
    public void eliminasPalabra(String palabra){
        String cadena = palabra.toLowerCase();
        palabras.remove(cadena);
    }
    public String toString(){
        String acumulador ="Palabras válidas: ";
        for(int i=0; i<palabras.size();i++){
            acumulador+= palabras.get(i)+", ";
        }
        return acumulador;
    }
}
