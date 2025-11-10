package models;

import java.util.ArrayList;

public class Editor extends Usuario{
    
    public Editor(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public Contenido crearContenido(String nombre, String descripcion, String contenido, ArrayList<String> etiquetas, int tipoContenido, int datoAdicional){
        Contenido contenidoNuevo;

        switch (tipoContenido) {
            case 1 -> contenidoNuevo = new Articulo(nombre, descripcion, contenido, etiquetas, datoAdicional);
            case 2 -> contenidoNuevo = new Video(nombre, descripcion, contenido, etiquetas, datoAdicional);
            case 3 -> contenidoNuevo = new Imagen(nombre, descripcion, contenido, etiquetas, datoAdicional);
            default -> contenidoNuevo = null;
        }

        return contenidoNuevo;
    }

    public void editarContenido(Contenido contenido, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas) {
        contenido.editar(descripcion, contenidoPuntual, etiquetas);
    }

    public Contenido publicarContenido(Contenido contenido) {
        return null;
    }

    public boolean eliminarContenido(ArrayList<Contenido> listaContenido, Contenido contenido) {
        return false;
    }

}
