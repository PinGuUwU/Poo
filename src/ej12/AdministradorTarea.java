package ar.edu.unlu.poo.ej12;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdministradorTarea {
    private final ArrayList<Tarea> tareas = new ArrayList<>();
    public void agregar(String descripcion, int prioridad, boolean estado, Date fecha_lim){
        Tarea tareaAux = new Tarea();
        tareaAux.cambiarDescripcion(descripcion);
        tareaAux.cambiarEstado(estado);
        tareaAux.cambiarFecha(fecha_lim);
        tareaAux.cambiarPrioridad(prioridad);
        int i=0;
        boolean control = true;
        if(tareas.isEmpty()){
            tareas.add(tareaAux);
        } else {
            Tarea tarea = tareas.get(i);
            while(control & tareas.get(i)!=null){
                tarea = tareas.get(i);
                if(tarea.getPrioridad()==prioridad){
                    if(tarea.getFecha_limite().after(fecha_lim)){
                        tareas.add(i,tareaAux);
                    } else {
                        tareas.add(i+1,tareaAux);
                    }
                    control = false;
                } else if(tarea.getPrioridad()<prioridad){
                    tareas.add(i+1, tareaAux);
                    control = false;
                }
                i++;
            }
        }
    }
    public void modificar_descripcion(String descripcion, String nuevaDesc){
        for(Tarea tarea : tareas){
            if(tarea.getDescripcion().equalsIgnoreCase(descripcion)){
                tarea.cambiarDescripcion(nuevaDesc);
            }
        }
    }
    public void modificar_prioridad(String descripcion, int prioridad){
        for(Tarea tarea : tareas){
            if(tarea.getDescripcion().equalsIgnoreCase(descripcion)){
                tarea.cambiarPrioridad(prioridad);
            }
        }
    }
    public boolean vencida(String descripcion){
        Date fecha_act = new Date();
        for(Tarea tarea : tareas){
            if(tarea.getDescripcion().equalsIgnoreCase(descripcion)){
                return tarea.getFecha_limite().after(fecha_act);
            }
        }
        return false;
    }
    public boolean completada(String descripcion){
        for(Tarea tarea : tareas){
            if(tarea.getDescripcion().equalsIgnoreCase(descripcion)){
                return tarea.getEstado();
            }
        }
        return false;
    }
    public String toString(){
        String acumulador = "";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaAct = new Date();
        int i=0;
        for(Tarea tarea : tareas){
            acumulador += "Tarea "+(i+1);
            if(tarea.getEstado()){
                acumulador += ": (Completa) "+tarea.getDescripcion()+"\n";
            } else if(tarea.getFecha_limite().before(fechaAct)){
                acumulador += ": (Vencida) "+tarea.getDescripcion()+"\n";
            } else {
                acumulador += ": "+tarea.getDescripcion()+"\n";
            }
            acumulador += "\tPrioridad: "+tarea.getPrioridad()+"\nEstado: ";
            if(tarea.getEstado()){
                acumulador += "Completa\n";
            } else {
                acumulador += "Incompleta\n";
            }
            acumulador += "\tFecha límite: "+ formato.format(tarea.getFecha_limite())+"\n";
            i++;
        }
        return acumulador;
    }
}
