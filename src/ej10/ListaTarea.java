package ar.edu.unlu.poo.ej10;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListaTarea {
    private Tarea inicio;

    public  void agregar(String nuevaDesc, int priori, Date fecha_lim, boolean estado, Date recordatorio){
        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setDescripcion(nuevaDesc);
        nuevaTarea.setFecha_limite(fecha_lim);
        nuevaTarea.setEstado(estado);
        nuevaTarea.setRecordatorio(recordatorio);
        if((0<=(fecha_lim.compareTo(recordatorio))) ^ (fecha_lim.before(recordatorio))){
            nuevaTarea.setPrioridad(10);
        } else {
            nuevaTarea.setPrioridad(priori);
        }
        if(inicio==null){
            inicio = nuevaTarea;
        } else {
            Tarea tareaAux = inicio;
            while(tareaAux.getSiguiente()!=null){
                tareaAux = tareaAux.getSiguiente();
            }
            tareaAux.setSiguiente(nuevaTarea);
        }
    }
    public void modificar_descripccion(int pos, String nuevaDesc){
        Tarea tareaAux = inicio;
        int contador=0;
        while(tareaAux!=null){
            if(contador==pos){
                tareaAux.setDescripcion(nuevaDesc);
            }
            contador++;
            tareaAux = tareaAux.getSiguiente();
        }
    }
    public void modificar_prioridad(int nuevaPriori, int pos){
        int contador=0;
        Tarea tareaAux = inicio;
        while(tareaAux!=null){
            if(contador==pos){
                tareaAux.setPrioridad(nuevaPriori);
            }
            contador++;
            tareaAux = tareaAux.getSiguiente();
        }
    }
    public boolean vencida(int pos){
        Date fechaAct = new Date();
        int contador=0;
        boolean resultado=true;
        Tarea tareaAux = inicio;
        while(tareaAux!=null){
            if(contador==pos){
                resultado = tareaAux.getFecha_limite().after(fechaAct);
            }
            contador++;
            tareaAux = tareaAux.getSiguiente();
        }
        return resultado;
    }
    public boolean completada(int pos){
        int contador=0;
        boolean resultado=true;
        Tarea tareaAux = inicio;
        while(tareaAux!=null){
            if(contador==pos) {
                resultado = tareaAux.getEstado();
            }
            contador++;
            tareaAux = tareaAux.getSiguiente();
        }
        return resultado;
    }
    public String toString(){
        Date fechaAct = new Date();
        int i=1;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String acumulador = " ";
        Tarea tareaAux = inicio;
        while(tareaAux!=null){
            if(tareaAux.getEstado()){
                acumulador += "Tarea "+i+": (Completa) "+tareaAux.getDescripcion()+"\n";
            } else if(0<=((tareaAux.getFecha_limite()).compareTo(tareaAux.getRecordatorio()))){
                acumulador += "Tarea "+i+": (Por vencer) "+tareaAux.getDescripcion()+"\n";
            } else if(tareaAux.getFecha_limite().after(fechaAct)){
                acumulador += "Tarea "+i+": (Vencida) "+tareaAux.getDescripcion()+"\n";
            } else {
                acumulador += "Tarea "+i+": "+tareaAux.getDescripcion()+"\n";
            }
            acumulador += "\tPrioridad: "+tareaAux.getPrioridad()+"\n";
            if(tareaAux.getEstado()){
                acumulador += "\tEstado: Completa\n";
            } else {
                acumulador += "\tEstado: Incompleta\n";
            }
            acumulador += "\tFecha límite: "+ formato.format(tareaAux.getFecha_limite())+"\n";
            tareaAux = tareaAux.getSiguiente();
            i++;
        }
        return acumulador;
    }
}
