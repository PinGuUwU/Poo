package ar.edu.unlu.poo.ej6;

public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private int cant_disponibles;
    private int cant_prestados;

    public void setTitulo(String nuevoTitulo){ titulo = nuevoTitulo; }
    public String getTitulo(){ return titulo; }
    public void setAutor(String nuevoAutor){ autor = nuevoAutor; }
    public String getAutor(){ return autor; }
    public void setPaginas(int cant_pag){ paginas = cant_pag; }
    public int getPaginas(){ return paginas; }
    public void setCant_disponibles(int nueva_cant_dispo){ cant_disponibles = nueva_cant_dispo; }
    public int getCant_disponibles(){ return cant_disponibles; }
    public void setCant_prestados(int nueva_cant_prest){ cant_prestados = nueva_cant_prest; }
    public int getCant_prestados(){ return cant_prestados; }
    public void descripcion(){
        System.out.print("El libro '"+titulo+"' creado por el autor '"+autor+"' tiene "+paginas+" páginas.\n\tQuedan "+cant_disponibles+" disponibles y se prestaron "+cant_prestados+".\n");
    }
}
