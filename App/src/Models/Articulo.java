package models;

import java.util.ArrayList;

public class Articulo extends Contenido {
    private int cantidadDePalabras;

    public Articulo(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas, int cantidadDePalabras){
        super(nombre, descripcion, contenidoPuntual, etiquetas);
        
        this.cantidadDePalabras = cantidadDePalabras;
    }

    @Override
    public void editar(String descripcion, String contenido, ArrayList<String> etiquetas) {
        this.descripcion = descripcion;
        this.contenidoPuntual = contenido;
        this.etiquetas = etiquetas;
    }

    @Override
    public String representacionTexto() {
        return toString();
    }

    @Override
    public String representacionHTML() {
        return String.format("<p>%s</p>", contenidoPuntual);
    }

    @Override
    public Contenido publicar() {
        final Contenido contenidoAPublicar = new Articulo(nombre, descripcion, contenidoPuntual, etiquetas, cantidadDePalabras);
        
        return contenidoAPublicar;
    }

    @Override
    public String toString(){
        return String.format("El articulo %s con descripcion: %s; tiene %d palabras y ha sido visitado %d veces", getNombre(), getDescripcion(), cantidadDePalabras, getNumeroDeVisitas());
    }

    public int getCantidadDePalabras() {
        return cantidadDePalabras;
    }
    public void setCantidadDePalabras(int cantidadDePalabras) {
        this.cantidadDePalabras = cantidadDePalabras;
    }
}
