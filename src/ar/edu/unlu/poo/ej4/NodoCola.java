package ar.edu.unlu.poo.ej4;

public class NodoCola {
    private Object dato;
    private NodoCola siguiente;
    private NodoCola anterior;

    public void setDato(Object dato){
        this.dato = dato;
    }
    public Object getDato(){
        return dato;
    }
    public void setSiguiente(NodoCola nodo){
        siguiente = nodo;
    }
    public NodoCola getSiguiente(){
        return siguiente;
    }
    public void setAnterior(NodoCola nodo){
        anterior = nodo;
    }
    public NodoCola getAnterior(){
        return anterior;
    }
}
