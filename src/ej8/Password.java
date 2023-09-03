package ar.edu.unlu.poo.ej8;

import java.util.ArrayList;

public class Password {
    private int id_general = 1;
    private int id;
    private ArrayList<String> password;
    private int longitud;
    private PosiblesEstados EstadoPassword;
    private enum PosiblesEstados {Fuerte, Debil}
    public void setId_general(int id){ id_general = id; }
    public int getId_general(){ return id_general; }
    public void setId(int id){ this.id = id;}
    public int getId(){ return id; }
    public void setLongitud(int longitud) { this.longitud = longitud; }
    public int getLongitud() { return longitud; }
    public String recuperar(){ return password.toString(); }
    public void setPassword(ArrayList<String> password){ this.password = password; }
    public void generar(int longitud){
        setLongitud(longitud);
        setId(id_general);
        setId_general(id_general+1);
        ArrayList<String> aux = new ArrayList<>();
        for (int i = 0; i < longitud; i++) {
            String caracter = Character.toString((char) (Math.random() * 95+32));
            aux.add(caracter);
        }
        setPassword(aux);
        if(fuerte()){
            EstadoPassword = PosiblesEstados.Fuerte;
        } else {
            EstadoPassword = PosiblesEstados.Debil;
        }
    }
    public void reGenerar(int longitud){
        setLongitud(longitud);
        ArrayList<String> aux = new ArrayList<>();
        for (int i = 0; i < longitud; i++) {
            String caracter = Character.toString((char) (Math.random() * 95+32));
            aux.add(caracter);
        }
        setPassword(aux);
        if(fuerte()){
            EstadoPassword = PosiblesEstados.Fuerte;
        } else {
            EstadoPassword = PosiblesEstados.Debil;
        }
    }
    public boolean fuerte(){
        int mayus=0, minus=0, num=0;
        for(int i=0; i<getLongitud();i++){
            String aux= password.get(i);
            char c = aux.charAt(0);
            if(Character.isAlphabetic(c) & aux.equals(aux.toUpperCase())){//Caso mayúscula
                mayus++;
            } else if(Character.isAlphabetic(c) & aux.equals(aux.toLowerCase())){//caso minúscula
                minus++;
            } else if(Character.isDigit(c)){
                num++;
            }
        }
        return mayus > 2 & minus > 1 & num >= 2;
    }
    public String toString(){
        String pass = "";
        for(int i=0;i<password.size();i++){
            pass += password.get(i);
        }
        return "<"+pass+"> - "+ EstadoPassword+"\n";
    }
}
