package ar.edu.unlu.poo.tp2.ej11;

public class Camioneta extends Auto{
    private int Pat;

    public Camioneta(String marca, String patente, int PAT){
        super(marca, patente);
        this.Pat = PAT;
        this.precio = this.precio + (600 * PAT);
    }
}
