package ar.edu.unlu.poo.ej10;

import java.util.Date;

public class Tarea {
    private Tarea siguiente;
    private String descripcion;
    private int prioridad;
    private boolean estado;
    private Date fecha_limite;
    private Date recordatorio;

    public void setSiguiente(Tarea tarea){ siguiente = tarea; }
    public Tarea getSiguiente(){ return siguiente; }
    public void setDescripcion(String nuevaDesc){ descripcion = nuevaDesc; }
    public String getDescripcion(){ return descripcion; }
    public void setPrioridad(int nuevaPrioridad){ prioridad = nuevaPrioridad; }
    public int getPrioridad(){ return prioridad;}
    public void setEstado(boolean nuevoEstado){ estado = nuevoEstado; }
    public boolean getEstado(){ return estado; }
    public void setFecha_limite(Date nuevaFecha){ fecha_limite = nuevaFecha; }
    public Date getFecha_limite(){ return fecha_limite; }
    public void setRecordatorio(Date recordatorio){ this.recordatorio = recordatorio; }
    public Date getRecordatorio(){ return recordatorio; }
}
