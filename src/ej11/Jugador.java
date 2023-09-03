package ar.edu.unlu.poo.ej11;

import java.util.ArrayList;

public class Jugador {
    private String username;
    private final ArrayList<String> palabras = new ArrayList<>();
    private int puntuacion=0;

    private void setUsername(String username) { this.username += username; }
    public void cambiarNombre(String username){ setUsername(username); }
    public String getUsername(){ return username; }
    private void setPuntuacion(int puntuacion){ this.puntuacion = puntuacion; }
    public void cambiarPuntuacion(int puntuacion){ setPuntuacion(puntuacion); }
    public int getPuntuacion(){ return puntuacion; }
    public void agregarPalabra(String palabra){ palabras.add(palabra); }
}
