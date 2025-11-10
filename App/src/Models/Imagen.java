package models;

import java.util.ArrayList;

public class Imagen extends Contenido {
    private int formato;
    private String formatoTexto = "";
    public Imagen(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas, int tipoDeContenido, int formato){
        super(nombre, descripcion, contenidoPuntual, etiquetas, tipoDeContenido);
        this.formato = formato;
        if (this.formato == 1){
            this.formatoTexto = ".JPG"; 
        }
        if (this.formato == 2){
            this.formatoTexto = ".PNG"; 
        }
        if (this.formato == 3){
            this.formatoTexto = ".GIF"; 
        }
    }
    @Override
    public String toString(){
        return String.format("La imagen %s%s con descripcion: %s; tiene %d visitas", getNombre(), this.formatoTexto, getDescripcion(), getNumeroDeVisitas());
    }
}
