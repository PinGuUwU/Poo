package ar.edu.unlu.poo.ej4;

public class Cola {
    private NodoCola inicio=null;
    private NodoCola ultimo=null;

    /*
        Métodos:
            desencolar (listo)
            recuperar dato (posicion ordinal) (listo)
            Consultar si la pila está vacía. (listo)
            Consultar la longitud de la pila. (listo)
            Agregar elemento al final de la pila. (listo)
            Eliminar elemento de la pila. por posición. (listo)
            Insertar elemento en la pilaen una posición específica. (listo)
            Mostrar.
     */
    public void encolar(Object dato){
        NodoCola nuevoNodo = new NodoCola();
        nuevoNodo.setDato(dato);
        if(inicio==null){
            inicio = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        }
    }
    public Object desencolar(){
        NodoCola nodoAux = inicio.getSiguiente();
        inicio.setAnterior(nodoAux);
        Object dato = inicio.getDato();
        inicio = nodoAux;
        return dato;
    }
    public int longitud(){
        NodoCola nodolong = inicio;
        int contador = 0;
        while(nodolong != null){
            contador++;
            nodolong = nodolong.getSiguiente();
        }
        return contador;
    }
    public boolean vacia(){
        if(inicio != null){ return false; } else { return true;}
    }
    public void eliminar(int pos){
        int contador = 0;
        NodoCola nodoAux = inicio;
        while(nodoAux!=null){
            contador++;
            if(contador == pos){
                NodoCola nodoAux2 = nodoAux.getSiguiente();
                nodoAux = nodoAux.getAnterior();
                nodoAux2.setAnterior(nodoAux);
                nodoAux.setSiguiente(nodoAux2);
            }
        }
    }
    public void insertar(int pos, Object dato){
        int contador = 0;
        NodoCola nodoAux = inicio;
        while(nodoAux!=null){
            contador++;
            if(contador==pos){
                NodoCola nuevoNodo = new NodoCola();
                nuevoNodo.setDato(dato);
                NodoCola nodoAux2 = nodoAux;
                nuevoNodo.setSiguiente(nodoAux2);
                nodoAux = nodoAux.getAnterior();
                nodoAux.setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(nodoAux);
            }
            nodoAux = nodoAux.getSiguiente();
        }
    }
    public String toString(){
        String acumulador = " ";
        NodoCola nodoAux = inicio;
        int i = 1;
        while(nodoAux!=null){
            acumulador += "Nodo "+i+": "+ nodoAux.getDato()+"\n";
            i++;
            nodoAux = nodoAux.getSiguiente();
        }
        return acumulador;
    }
}