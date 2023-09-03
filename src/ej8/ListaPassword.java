package ar.edu.unlu.poo.ej8;

import java.util.ArrayList;

public class ListaPassword {
    private final ArrayList<Password> lista = new ArrayList<>();
    public Password generar(int longitud){
        Password password = new Password();
        password.generar(longitud);
        lista.add(password);
        if(!password.fuerte()){
            System.out.printf("La contraseña es debil, si quiere volver a generarla hagalo desde el menú (id de contraseña:"+password.getId()+").\n");
        }
        return password;
    }
    public Password regenerarFuerte(int longitud, int id){
        Password aux = lista.get(id-1);
        while(!aux.fuerte()){
            aux.reGenerar(longitud);
        }
        return aux;
    }
    public String toString(){
        String acumulador = "";
        for(int i=0; i<lista.size();i++){
            acumulador+= "Pass "+(i+1)+": "+lista.get(i);
        }
        return acumulador;
    }
}
