package ar.edu.unlu.poo.tp2.ej1;

public class Socio {
    private final String nombre;
    private final String dni;
    private final String telefono;
    private final String direccion;
    private final String email;
    private final Credencial credencial;

    public Socio(String nombre, String dni, String telefono, String direccion, String email, Credencial credencial){
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.credencial = credencial;
    }
    public String toString(){
        String cadena = "Nombre: "+nombre+"\nDNI: "+dni+"\nTelefono: "+telefono+"\nDireccion: "+direccion+"\nE-mail: "+email+"\nNumero de Credencial: "+credencial.numero()+".\n";
        if(credencial.estado()){
            cadena += "Estado de suscripcion: paga.\n";
        } else {
            cadena += "Estado de suscripción: Inpaga.\n";
        }
        cadena += "Tipo de suscripción: " + credencial.tipo() + ".\n";
        return cadena;
    }
    public boolean esSocioActivo(){
        return credencial.esSocioActivo();
    }
    public boolean suscribioElMes(String mes){
        return credencial.suscribioElMes(mes);
    }
}
