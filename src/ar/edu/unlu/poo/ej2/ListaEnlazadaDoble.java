package ar.edu.unlu.poo.ej2;

public class ListaEnlazadaDoble {

    private Nodo primero;

    /*
    Comportamientos:
        Crear lista. (listo)
        Consultar si la lista está vacía. (listo)
        Consultar la longitud de la lista.(listo)
        Agregar elemento al final de la lista. (listo)
        Eliminar elemento de la lista. por posición. (listo)
        Recuperar elemento de la lista. (listo)
        Insertar elemento en la lista en una posición específica. (listo)
        Mostrar una lista enlazada doble. (listo)
     */

    public Boolean vacia(){
        if(primero==null){
            return true;
        } else {
            return false;
        }
    }

    public int longitud(){
        int contador =0;
        Nodo nodoAux = primero;
        while(nodoAux!=null){
            nodoAux = nodoAux.getSiguiente();
            contador++;
        }
        return contador;
    }

    public void agregar(Object dato){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);
        if(primero==null){
            primero = nuevoNodo;
        } else {
            Nodo nodoAux = primero;
            while(nodoAux.getSiguiente()!=null){
                Nodo nodoaux2 = nodoAux;
                nodoAux = nodoAux.getSiguiente();
                nodoAux.setAnterior(nodoaux2);
            }
            nuevoNodo.setAnterior(nodoAux);
            nodoAux.setSiguiente(nuevoNodo);
        }
    }

    public String toString(){
        String acumulador = " ";
        int i = 1;
        Nodo nodoAux = primero;
        while(nodoAux != null){
            acumulador += "Nodo " + i + ": " + nodoAux.getDato() + "\n";
            i++;
            nodoAux = nodoAux.getSiguiente();
        }
        return acumulador;
    }

    public void eliminarPos(int pos){
        int acumulador =0;
        Nodo nodoAux = primero;
        while(nodoAux != null){
            if(acumulador == pos){
                Nodo nodoaux2 = nodoAux.getSiguiente();
                nodoAux = nodoAux.getAnterior();
                nodoaux2.setAnterior(nodoAux);
                nodoAux.setSiguiente(nodoaux2);
            }
            nodoAux = nodoAux.getSiguiente();
            acumulador++;
        }
    }

    public Object recuperar(int pos){
        int acumulador = 0;
        Nodo nodoAux = primero;
        Object encontrado = null;
        while(nodoAux!=null){
            if(acumulador == pos){
                encontrado = nodoAux.getDato();
            }
            nodoAux = nodoAux.getSiguiente();
            acumulador++;
        }
        return encontrado;
    }

    public void insertar(int pos, Object dato){
        int acumulador = 0;
        Nodo nodoAux = primero;
        Nodo nodoPos = new Nodo();
        Nodo nodoAux2 = new Nodo();
        nodoPos.setDato(dato);
        while(nodoAux != null){
            if(acumulador==pos){
                nodoAux2 = nodoAux;
                nodoPos.setSiguiente(nodoAux2);
                nodoAux = nodoAux.getAnterior();
                nodoAux.setSiguiente(nodoPos);
            }
            nodoAux = nodoAux.getSiguiente();
            acumulador++;
        }
    }

}
