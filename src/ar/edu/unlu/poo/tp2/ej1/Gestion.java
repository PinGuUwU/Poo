package ar.edu.unlu.poo.tp2.ej1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Gestion {
    private final ArrayList<Socio> socios = new ArrayList<>();
    private final ArrayList<Credencial> credenciales = new ArrayList<>();
    public void registrarSocio(String nombre, String dni, String telefono, String direccion, String email, String tipoSuscripcion, String primeraFecha){
        LocalDate primeraVez = LocalDate.parse(primeraFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate vencimiento = primeraVez.withDayOfMonth(primeraVez.lengthOfMonth());
        Credencial c = new Credencial(primeraVez, vencimiento, tipoSuscripcion);
        Socio s = new Socio(nombre, dni, telefono, direccion, email, c);
        socios.add(s);
        credenciales.add(c);
    }
    public void suscripciones(){ //Muestra las suscripciones con sus actividades
        Suscripcion suscripcion = new Suscripcion();
        System.out.println(suscripcion);
    }
    public void reInscripcion(String nuevaFechaVenci, int nroCredencial){
        LocalDate fechaVencimiento = LocalDate.parse(nuevaFechaVenci, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        fechaVencimiento = fechaVencimiento.withDayOfMonth(fechaVencimiento.lengthOfMonth());
        for(Credencial credencial : credenciales){
            if(credencial.numero() == nroCredencial){
                credencial.reInscripcion(fechaVencimiento);
            }
        }
    }
    public void sociosActivos(){
        System.out.println("Listado de socios inscriptos: ");
        for(Socio socio : socios){
            if(socio.esSocioActivo()){
                System.out.println(socio);
            }
        }
    }
    public void sociosMes(String mes){
        boolean aux = false;
        System.out.println("Listado de socios inscriptos el mes "+mes+": \n");
        for(Socio socio: socios){
            if(socio.suscribioElMes(mes)){
                System.out.println(socio);
                aux=true;
            }
        }
        if(!aux){
            System.out.println("No existen personas inscriptas en ese mes\n");
        }
    }
}
