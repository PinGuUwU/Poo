package ar.edu.unlu.poo.ej11;

public class Juego {
    private final Jugador player1 = new Jugador();
    private final Jugador player2 = new Jugador();
    private final Diccionario palabras = new Diccionario();
    /*
    Responsabilidades:
        -Tener acceso a los dos jugadores (listo)
        -crear a los jugadores con sus "username" (listo)
        -Permitir agregar palabras a los jugadores (listo)
        -Actualizar los puntos de los jugadores (listo)
        -Ingresar a los jugadores las palabras que ingresaron cada uno y validarlas (listo)
        -validar las palabras ingresadas por los jugadores (listo)
        -Ingresar nuevas palabras al diccionario (listo)
        -determinar cuándo finaliza el juego, retornando el jugador ganador
     */
    private int puntuacion(String palabra){
        int suma=0;
        char c;
        for(int i=0; i<palabra.length();i++){
            c = palabra.charAt(i);
            if((c=='k') ^ (c=='z') ^ (c=='x') ^ (c=='y') ^ (c=='w') ^ (c=='q')){
                suma +=2;
            } else suma++;
        }
        return suma;
    }
    public void crearJugadores(String nombre1, String nombre2){
        player1.cambiarNombre(nombre1);
        player2.cambiarNombre(nombre2);
    }
    public boolean agregarPalabraPlayer1(String palabra){
        if(palabras.esValida(palabra)){
            player1.cambiarPuntuacion(player1.getPuntuacion()+puntuacion(palabra));
            player1.agregarPalabra(palabra);
            return true;
        } else return false;//Mostrar en main que no es valida
    }
    public boolean agregarPalabraPlayer2(String palabra) {
        if (palabras.esValida(palabra)) {
            player2.cambiarPuntuacion(player2.getPuntuacion()+puntuacion(palabra));
            player2.agregarPalabra(palabra);
            return true;
        } else return false;
    }
    public int puntosPlayer1(){
        return player1.getPuntuacion();
    }
    public int puntosPlayer2(){
        return player2.getPuntuacion();
    }
    public void palabrasValidas(){
        System.out.println(palabras);
    }
    public void eliminarPalabra(String palabra){
        palabras.eliminasPalabra(palabra);
    }
    public void agregarPalabra(String palabra){
        palabras.agregarPalabra(palabra);
    }
}
