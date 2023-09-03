package ar.edu.unlu.poo.ej6;

public class Libro {
    private String titulo;
    private String autor;
    private int isbn;
    private int paginas;
    private int cant_disponibles;
    private int cant_prestados;

    public void setTitulo(String nuevoTitulo){ titulo = nuevoTitulo; }
    public String getTitulo(){ return titulo; }
    public void setAutor(String nuevoAutor){ autor = nuevoAutor; }
    public String getAutor(){ return autor; }
    public void setIsbn(int isbn){ this.isbn = isbn; }
    public int getIsbn(){ return isbn; }
    public void setPaginas(int cant_pag){ paginas = cant_pag; }
    public int getPaginas(){ return paginas; }
    public void setCant_disponibles(int nueva_cant_dispo){ cant_disponibles = nueva_cant_dispo; }
    public int getCant_disponibles(){ return cant_disponibles; }
    public void setCant_prestados(int nueva_cant_prest){ cant_prestados = nueva_cant_prest; }
    public int getCant_prestados(){ return cant_prestados; }
    public boolean prestar(){
        if(getCant_disponibles()<1){
            return false;
        } else {
            setCant_disponibles(getCant_disponibles() - 1);
            setCant_prestados(getCant_prestados() + 1);
            return true;
        }
    }
    public boolean devolver(){
        if(getCant_prestados()<1){
            return false;
        } else {
            setCant_disponibles(getCant_disponibles() + 1);
            setCant_prestados(getCant_prestados() - 1);
            return true;
        }
    }
    public String toString(){
        return "El libro '"+titulo+"' creado por el autor '"+autor+"' tiene "+paginas+" páginas.\n\tQuedan "+cant_disponibles+" disponibles y se prestaron "+cant_prestados+".\n";
    }
}
