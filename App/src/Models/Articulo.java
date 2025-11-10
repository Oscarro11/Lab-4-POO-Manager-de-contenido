package models;

import java.util.ArrayList;

public class Articulo extends Contenido {
    private int cantidadDePalabras;
    public Articulo(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas, int tipoDeContenido, int cantidadDePalabras){
        super(nombre, descripcion, contenidoPuntual, etiquetas, tipoDeContenido);
        this.cantidadDePalabras = cantidadDePalabras;
    }
    @Override
    public String toString(){
        return String.format("El articulo %s con descripcion: %s; tiene %d palabras y ha sido visitado %d veces", getNombre(), getDescripcion(), cantidadDePalabras, getNumeroDeVisitas());
    }
}
