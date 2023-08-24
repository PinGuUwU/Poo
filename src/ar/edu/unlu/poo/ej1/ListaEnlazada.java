package ar.edu.unlu.poo.ej1;

public class ListaEnlazada {

    private static Nodo primero = null;

    /*
    Crear lista. (listo)
    Consultar si la lista está vacía. (listo)
    Consultar la longitud de la lista. (listo)
    Agregar elemento al final de la lista. (listo)
    Eliminar elemento de la lista. posicion ordinal (listo)
    Recuperar elemento de la lista. posicion ordinal
    Insertar elemento en la lista en una posición específica. (listo)
    */


    /***
     * Método para agregar un Object a una lista enlazada simple
     * @param dato
     */
    public void agregar(Object dato){
        //Inicializo una variable Nodo (inicializa vacía)
        Nodo nuevoNodo = new Nodo();
        //Al nuevo nodo le guardo el nodo pasado por parámetro
        nuevoNodo.setDato(dato);
        //Si el primer Nodo de la lista es nulo
        if (primero == null) {
            //Entonces el nuevo nodo será el primero Nodo que contenga la lista
            primero = nuevoNodo;
        } else {//Si la Lista ya tiene otro/s Nodos
            //Inicializo un nodo auxiliar el cual contendrá el primer Nodo de la lista
            Nodo nodoAux = primero;
            //Mientras que el nodo
            while (nodoAux.getProximo() != null) {
                nodoAux = nodoAux.getProximo();
            }
            nodoAux.setProximo(nuevoNodo);
        }
    }
    //Método para mostrar un objeto con un "println"
    //Esto re-configura el cómo interpreta una lista el comando "Println"
    public String toString(){
        String acumulador = "";
        Integer i = 1;
        Nodo nodoAux = primero;
        while(nodoAux != null){
            acumulador += "Nodo " + i + ": " + nodoAux.getDato() + "\n";
            i++;
            nodoAux = nodoAux.getProximo();
        }
        return acumulador;
    }

    /**
     * Método para eliminar un nodo.
     * @param posicion Posición ordinal.
     */
    public void eliminarPos(int posicion){
        //Controlo la posición en la que estoy
        int contador=1;
        //Nodo usado para recorrer
        Nodo nodoAux = primero;
        //Nodo usado para guardar el nodo actual, borrar el nodo ingresado y conectar el siguiente
        Nodo nodoPos = new Nodo();
            //Si la posicion es la primera entonces se reemplaza el primer dato por el que sigue
        if(posicion==1){
            nodoPos = nodoAux.getProximo();
            nodoAux.setProximo(nodoPos.getProximo());
            nodoAux.setDato(nodoPos.getDato());
        } else {
            while(contador<=posicion){
                //Si estoy en la posicion anterior a la buscada
                if(contador==(posicion-1)){
                    //Si el nodo es nulo entonces simplemente seteo el proximo como nulo
                    //Es el caso en que no haya proximo
                    if(nodoAux == null){
                        nodoAux.setProximo(null);
                    } else {
                        //Nodo Aux le pasa el proximo al nodo Pos
                        nodoPos = nodoAux.getProximo();
                        //Noso Pos le pasa el proximo al nodo Aux
                        nodoAux.setProximo(nodoPos.getProximo());
                        //Y así conecta el anterior de la pos al siguiente de la pos
                        //Eliminando así el nodo en la posicion ingresada por parámetro
                    }
                } else {
                    //Sigo avanzando la posicion y aumento el contador
                    nodoAux = nodoAux.getProximo();
                    contador++;
                }
            }

        }
    }

    /***
     * Método para insertar un Objecto en una posición
     * @param posicion
     * @param dato
     */
    public void insertar(int posicion, Object dato){
        int contador=1;
        Nodo nodoAux = primero;
        Nodo nodoPos = new Nodo();
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);
        if(posicion==1){
            nuevoNodo.setProximo(nodoAux);
            nodoAux = nuevoNodo;
        }
        while(contador<=posicion){
            if(contador==(posicion)){
                nodoPos = nodoAux.getProximo();
                nodoAux.setProximo(nuevoNodo);
                nodoAux = nodoAux.getProximo();
                nodoAux.setProximo(nodoPos);
            }
            contador++;
        }
    }

    /**
     * Método que retorna verdadero si la lista está vacía
     * @return
     */
    public boolean vacia(){
        if(primero==null){
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return longitud de la lista
     */
    public int longitud(){
        int longi=0;
        Nodo nodoAux = primero;
        while(nodoAux != null){
            nodoAux = nodoAux.getProximo();
            longi++;
        }
        return longi;
    }

    /**
     * Método para recuperar elemento de la lista. posicion ordinal
     * @param pos Posición ordinal
     * @return dato
     */
    public Object recuperar(int pos){
        int contador=1;
        Nodo nodoAux = primero;
        Object encontrado=null;
        while(nodoAux!=null && encontrado==null){
            if(pos==contador){
                encontrado = nodoAux.getDato();
            }
            nodoAux = nodoAux.getProximo();
        }
        return encontrado;
    }
}
