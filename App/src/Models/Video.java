package models;

import java.util.ArrayList;

public class Video extends Contenido {
    private int duracion;

    public Video(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas, int duracion){
        super(nombre, descripcion, contenidoPuntual, etiquetas);
        
        this.duracion = duracion;
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
        return String.format("<video src='%s.mp4' type='video/mp4' controls>", contenidoPuntual);
    }

    @Override
    public Contenido publicar() {
        final Contenido contenidoAPublicar = new Video(nombre, descripcion, contenidoPuntual, etiquetas, duracion);
        
        return contenidoAPublicar;
    }

    @Override
    public String toString(){
        return String.format("El video %s con descripcion: %s; dura %d minutos y tiene %d visitas", getNombre(), getDescripcion(), duracion, getNumeroDeVisitas());
    }

    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
