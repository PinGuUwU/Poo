package ar.edu.unlu.poo.ej13;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Colaborador {
    private String nombre;
    private final ArrayList<Tarea> completadas = new ArrayList<>();
    private void setNombre(String nombre){ this.nombre = nombre; }
    public String getNombre(){ return nombre; }
    public void cambiarNombre(String nombre){ setNombre(nombre); }
    public void agregarTarea(Tarea tarea){ completadas.add(tarea); }

    public String toString(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String acumulador = "Tareas completadas por: "+getNombre()+".\n";
        for(Tarea tarea: completadas){
            acumulador += "\t-"+tarea.getDescripcion()+". En la fecha: "+formato.format(tarea.getFecha_limite())+".\n";
        }
        return acumulador;
    }
}
