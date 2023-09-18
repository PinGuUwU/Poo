package ar.edu.unlu.poo.ej3;

public class Pila {
    private NodoPila tope;

    /*
    Comportamientos:
        apilar(Object) void. (listo)
        desapilar Object. (listo)
        longitud int. (listo)
        vacia Boolean. (listo)
        mostrar void. (listo)
        recuperar Object.
     */

    public void apilar(Object dato){
        NodoPila nuevoNodo = new NodoPila();
        nuevoNodo.setDato(dato);
        if(tope==null) {
            tope = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(tope);
            tope = nuevoNodo;
        }
    }
    public Object desapilar(){
        NodoPila nodoAux = new NodoPila();
        nodoAux = tope.getSiguiente();
        Object dato = tope.getDato();
        tope = nodoAux;

        return dato;
    }
    public int longitud(){
        int contador=0;
        NodoPila nodoAux = tope;
        while(tope!=null){
            contador++;
            nodoAux = nodoAux.getSiguiente();
        }
        return contador;
    }
    public boolean vacia(){
        if(tope==null){
            return true;
        } else {
            return false;
        }
    }
    public String toString(){
        String acumulador = " ";
        int i = 1;
        NodoPila nodoAux = tope;
        while(nodoAux != null){
            acumulador += "Nodo "+i+" "+nodoAux.getDato()+"\n";
            i++;
            nodoAux = nodoAux.getSiguiente();
        }
        return acumulador;
    }
    public Object recuperar(){
        return tope.getDato();
    }
}
