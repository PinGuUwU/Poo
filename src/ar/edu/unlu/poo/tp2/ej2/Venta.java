package ar.edu.unlu.poo.tp2.ej2;

public class Venta {
    private int nroCliente;
    private int nroPaquete;
    public Venta(int nroCliente, int nroPaquete){
        this.nroCliente = nroCliente;
        this.nroPaquete = nroPaquete;
    }
    public int nroCliente(){ return nroCliente; }
    public int nroPaquete(){ return nroPaquete; }
}
