package ar.edu.unlu.poo.ej13;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdministradorTarea {
    private final ArrayList<Tarea> tareas = new ArrayList<>();
    private final ArrayList<Colaborador> colaboradores = new ArrayList<>();
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
    public void agregar(String descripcion, int prioridad, boolean estado, Date fecha_lim, String nombre, Date fechaFinal){
        Tarea tareaAux = new Tarea();
        tareaAux.cambiarDescripcion(descripcion);
        tareaAux.cambiarEstado(estado);
        tareaAux.cambiarFecha(fecha_lim);
        tareaAux.cambiarPrioridad(prioridad);
        tareaAux.cambiarFechaFinal(fechaFinal);
        Colaborador nuevo = new Colaborador();
        nuevo.cambiarNombre(nombre);
        tareaAux.cambiarColaborador(nuevo);
        nuevo.agregarTarea(tareaAux);
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
    public boolean modificar_descripcion(String descripcion, String nuevaDesc){
        for(Tarea tarea : tareas){
            if(tarea.getDescripcion().equalsIgnoreCase(descripcion)){
                tarea.cambiarDescripcion(nuevaDesc);
                return true;
            }
        }
        return false;
    }
    public boolean modificar_prioridad(String descripcion, int prioridad){
        for(Tarea tarea : tareas){
            if(tarea.getDescripcion().equalsIgnoreCase(descripcion)){
                tarea.cambiarPrioridad(prioridad);
                return true;
            }
        }
        return false;
    }
    public boolean comprobarFecha(String descripcion){
        Date fecha_act = new Date();
        for(Tarea tarea : tareas){
            if(tarea.getDescripcion().equalsIgnoreCase(descripcion)){
                return tarea.getFecha_limite().after(fecha_act);
            }
        }
        return false;
    }
    public boolean comprobarEstado(String descripcion){
        for(Tarea tarea : tareas){
            if(tarea.getDescripcion().equalsIgnoreCase(descripcion)){
                return tarea.getEstado();
            }
        }
        return false;
    }
    public void nuevoColaborador(String nombre){
        Colaborador nuevo = new Colaborador();
        nuevo.cambiarNombre(nombre);
        colaboradores.add(nuevo);
    }
    public void completar(String descripcion, String nombre, Date fecha_final){
        for(Colaborador colaborador : colaboradores){
            if(colaborador.getNombre().equalsIgnoreCase(nombre)){
                for(Tarea tarea : tareas){
                    if(tarea.getDescripcion().equalsIgnoreCase(descripcion)){
                        tarea.cambiarEstado(true);
                        tarea.cambiarColaborador(colaborador);
                        tarea.cambiarFechaFinal(fecha_final);
                        colaborador.agregarTarea(tarea);
                    }
                }
            }
        }
    }
    public boolean existeColaborador(String nombre){
        for(Colaborador colaborador : colaboradores){
            if(colaborador.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }
    public String listaTareas(){
        String acumulador = "";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaAct = new Date();
        int i=0;
        for(Tarea tarea : tareas){
            acumulador += "Tarea "+(i+1);
            if(tarea.getEstado()){
                acumulador += ": (Completa) "+tarea.getDescripcion()+"\nColaborador: "+tarea.getColaborador()+"\nFecha de finalización: "+tarea.getFechaFinal()+".\n";
            } else if(tarea.getFecha_limite().before(fechaAct)){
                acumulador += ": (Vencida) "+tarea.getDescripcion()+"\n";
            } else {
                acumulador += ": "+tarea.getDescripcion()+"\n";
            }
            acumulador += "\tPrioridad: "+tarea.getPrioridad()+"\n\tEstado: ";
            if(tarea.getEstado()){
                acumulador += "Completa\n";
            } else {
                acumulador += "Incompleta\n";
            }
            acumulador += "\tFecha límite: "+ formato.format(tarea.getFecha_limite())+"\n";
            if(tarea.getColaborador()!=null){
                acumulador += "\tColaborador: "+tarea.getColaborador().getNombre()+".\n\tFecha de finalización: "+formato.format(tarea.getFechaFinal())+".\n";
            }
            i++;
        }
        return acumulador;
    }
    public String listaColaboradores() {
        String acumulador = "Colaboradores existentes: \n";
        for(Colaborador colaborador : colaboradores){
            acumulador += "\t-"+colaborador.getNombre()+".\n";
        }
        return acumulador;
    }
}
