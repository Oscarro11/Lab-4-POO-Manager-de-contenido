package models;

import java.util.ArrayList;

public class Imagen extends Contenido {
    private int formato;
    private String formatoTexto = "";

    public Imagen(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas, int formato){
        super(nombre, descripcion, contenidoPuntual, etiquetas);

        this.formato = formato;
        switch (formato){
            case 1 -> this.formatoTexto = ".JPG";
            case 2 -> this.formatoTexto = ".PNG";
            case 3 -> this.formatoTexto = ".GIF";
            default -> this.formatoTexto = null;
        }
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
        return String.format("<img src=%s%s>", contenidoPuntual, formatoTexto);
    }

    @Override
    public Contenido publicar() {
        Contenido contenidoAPublicar = new Imagen(nombre, descripcion, contenidoPuntual, etiquetas, formato);
        
        return contenidoAPublicar;
    }

    @Override
    public String toString(){
        return String.format("La imagen %s%s con descripcion: %s; tiene %d visitas", getNombre(), this.formatoTexto, getDescripcion(), getNumeroDeVisitas());
    }

    public int getFormato() {
        return formato;
    }
    public void setFormato(int formato) {
        this.formato = formato;
    }

    public String getFormatoTexto() {
        return formatoTexto;
    }
    public void setFormatoTexto(String formatoTexto) {
        this.formatoTexto = formatoTexto;
    }
}
