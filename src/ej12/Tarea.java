package ar.edu.unlu.poo.ej12;

import java.util.Date;

public class Tarea {
    private String descripcion;
    private int prioridad;
    private boolean estado;
    private Date fecha_limite;
    private void setDescripcion(String descripcion){ this.descripcion = descripcion; }
    public String getDescripcion(){ return descripcion; }
    private void setEstado(boolean estado){ this.estado = estado; }
    public boolean getEstado(){ return estado; }
    private void setFecha_limite(Date fecha_limite){ this.fecha_limite = fecha_limite; }
    public Date getFecha_limite(){ return fecha_limite; }
    private void setPrioridad(int prioridad){ this.prioridad = prioridad; }
    public int getPrioridad(){ return prioridad; }
    public void cambiarPrioridad(int prioridad){ setPrioridad(prioridad); }
    public void cambiarDescripcion(String descripcion){ setDescripcion(descripcion); }
    public void cambiarEstado(boolean estado){ setEstado(estado); }
    public void cambiarFecha(Date fecha_limite){ setFecha_limite(fecha_limite);}
}
