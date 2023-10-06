import java.util.ArrayList;

public class Cliente {
    private String nombre;
    String patente;
    private String dni;
    private ArrayList<Venta> compras;

    public Cliente(String nombre, String patente, String dni){
        this.nombre = nombre;
        this.patente = patente;
        this.dni = dni;
        this.compras = new ArrayList<>();
    }

    public void nuevaCompra(Venta compra){
        this.compras.add(compra);
    }

    public double totalHistoricoCompras(){
        double totalHistorico = 0;
        for (Venta compra : compras){
            totalHistorico += compra.getTotal();
        }
        return totalHistorico;
    }

}
