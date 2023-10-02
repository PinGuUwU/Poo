package ar.edu.unlu.poo.tp2.ej1;

import java.time.LocalDate;
import java.time.Month;

public class Credencial {
    private static int numerosCredencial = 1050;
    private final int numeroCredencial;
    private boolean estadoPago;
    private LocalDate fechaVencimiento;
    private final LocalDate primeraInscripcion; //Dato usado para saber si es nuevo
    private final String tipoSuscripcion;
    public Credencial(LocalDate primeraInscripcion, LocalDate fechaVencimiento, String tipoSuscripcion){
        numeroCredencial = numerosCredencial;
        numerosCredencial++;
        LocalDate date = LocalDate.now();
        estadoPago= fechaVencimiento.isAfter(date);

        this.tipoSuscripcion = tipoSuscripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.primeraInscripcion = primeraInscripcion;
    }
    public void reInscripcion(LocalDate nuevaFechaVenci){
        estadoPago = true;
        fechaVencimiento = nuevaFechaVenci;
    }
    private int getNumeroCredencial(){
        return numeroCredencial;
    }
    public int numero(){
        return getNumeroCredencial();
}
    public boolean esSocioActivo(){
        LocalDate date = LocalDate.now();
        return (fechaVencimiento.isAfter(date));
    }
    public String tipo(){
        return tipoSuscripcion;
    }
    public boolean estado(){
        return estadoPago;
    }
    public boolean suscribioElMes(String mes){
        Month numMes;
        try{
            numMes = Month.valueOf(mes.toLowerCase());
        } catch (IllegalArgumentException e){
            System.out.println("Se ingreso un mes inválido.");
            return false;
        }
        return (primeraInscripcion.getMonth()).equals(numMes);
    }
}
