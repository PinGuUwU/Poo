package ar.edu.unlu.poo.ej6;

import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Libro> biblioteca = new ArrayList<>();
    public void agregar(String nuevoTitulo, String nuevoAutor, int cant_pag, int cant_dispo, int cant_prest){
        Libro nuevoLibro = new Libro();
        nuevoLibro.setAutor(nuevoAutor);
        nuevoLibro.setPaginas(cant_pag);
        nuevoLibro.setTitulo(nuevoTitulo);
        nuevoLibro.setCant_prestados(cant_prest);
        nuevoLibro.setCant_disponibles(cant_dispo);
        biblioteca.add(nuevoLibro);
    }
    public void buscarTitulo(String titulo){
        Libro libroAux;
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            libroAux = libro;
            if (libroAux.getTitulo().equals(titulo)) {
                libro.descripcion();
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se ha encontrado el libro.");
        }
    }
    public void buscarAutor(String autor){
        Libro libroAux;
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            libroAux = libro;
            if (libroAux.getAutor().equals(autor)) {
                libro.descripcion();
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se ha encontrado el libro.");
        }
    }
    public boolean prestar(int pos, int cant){
        Libro libroPrestar = biblioteca.get(pos-1);
        Libro libroAux;
        boolean resultado=false;
        for (Libro libro : biblioteca) {
            libroAux = libro;
            if (libroAux == libroPrestar) {
                if (libroAux.getCant_disponibles() > cant) {
                    libroAux.setCant_disponibles(libroAux.getCant_disponibles() - cant);
                    libroAux.setCant_prestados(libroAux.getCant_prestados() + cant);
                    resultado = true;
                }
            }
        }
        return resultado;
    }
    public void compararLibros(int pos1, int pos2){
        Libro libro1 = biblioteca.get(pos1), libro2 = biblioteca.get(pos2);
        if(libro1.getPaginas() == libro2.getPaginas()){
            System.out.print("Ambos libros tienen la misma cantidad de páginas.");
        } else if(libro1.getPaginas() > libro2.getPaginas()){
            System.out.printf("El libro: "+libro1.getTitulo()+" tiene más páginas que el libro: "+libro2.getPaginas()+".\n");
        } else {
            System.out.printf("El libro: "+libro2.getPaginas()+" tiene más páginas que el libro: "+libro1.getPaginas()+".\n");
        }
    }
    public int cant_prestamos(){
        Libro libroAux;
        int contador=0;
        for (Libro libro : biblioteca) {
            libroAux = libro;
            contador += libroAux.getCant_prestados();
        }
        return contador;
    }
    public String toString(){
        StringBuilder acumulador = new StringBuilder(); // Usar StringBuilder para construir la cadena
        int i=1;
        for (Libro libroAux : biblioteca) {
            acumulador.append("Libro ").append(i).append(": El libro '")
                    .append(libroAux.getTitulo()).append("' creado por el autor '")
                    .append(libroAux.getAutor()).append("' tiene ")
                    .append(libroAux.getPaginas()).append(" páginas.\n")
                    .append("\tQuedan ").append(libroAux.getCant_disponibles())
                    .append(" disponibles y se prestaron ")
                    .append(libroAux.getCant_prestados()).append(".\n");
            i++;
        }
        return acumulador.toString();
    }

}
