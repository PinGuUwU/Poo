package ar.edu.unlu.poo.ej2;

public class Nodo {

    private Object dato;
    private Nodo siguiente = null;
    private Nodo anterior = null;

    public void setDato(Object dato){
        this.dato = dato;
    }

    public Object getDato(){
        return dato;
    }

    public void setSiguiente(Nodo nodo){
        siguiente = nodo;
    }

    public Nodo getSiguiente(){
        return siguiente;
    }

    public void setAnterior(Nodo nodo){
        anterior = nodo;
    }

    public Nodo getAnterior(){
        return anterior;
    }
}
