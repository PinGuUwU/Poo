package ar.edu.unlu.poo.ej3;

public class NodoPila {
    private Object dato;
    private NodoPila siguiente=null;

    public void setDato(Object dato){
        this.dato = dato;
    }

    public Object getDato(){
        return dato;
    }

    public void setSiguiente(NodoPila nuevoNodo){
        siguiente = nuevoNodo;
    }

    public NodoPila getSiguiente(){
        return siguiente;
    }
}
