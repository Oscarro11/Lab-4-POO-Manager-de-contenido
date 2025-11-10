package models;

import java.util.ArrayList;

public class Video extends Contenido {
    private int duracion;
    public Video(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas, int tipoDeContenido, int duracion){
        super(nombre, descripcion, contenidoPuntual, etiquetas, tipoDeContenido);
        this.duracion = duracion;
    }
    @Override
    public String toString(){
        return String.format("El video %s con descripcion: %s; dura %d minutos y tiene %d visitas", getNombre(), getDescripcion(), duracion, getNumeroDeVisitas());
    }
}
