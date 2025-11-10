package models;

import java.util.ArrayList;

public class Administrador extends Usuario{
    
    public Administrador(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    @Override
    public Contenido crearContenido(String nombre, String descripcion, String contenido, ArrayList<String> etiquetas, int tipoContenido, int datoAdicional){
        Contenido contenidoNuevo;

        switch (tipoContenido) {
            case 1 -> contenidoNuevo = new Articulo(nombre, descripcion, contenido, etiquetas, datoAdicional);
            case 2 -> contenidoNuevo = new Video(nombre, descripcion, contenido, etiquetas, datoAdicional);
            case 3 -> contenidoNuevo = new Imagen(nombre, descripcion, contenido, etiquetas, datoAdicional);
            default -> contenidoNuevo = null;
        }

        contenidoNuevo.setAutor(this.nombre);

        return contenidoNuevo;
    }

    @Override
    public void editarContenido(Contenido contenido, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas) {
        contenido.editar(descripcion, contenidoPuntual, etiquetas);
        contenido.setUltimoModificador(this.nombre);
    }

    @Override
    public Contenido publicarContenido(Contenido contenido) {
        Contenido contenidoAPublicar;

        contenidoAPublicar = contenido.publicar();
        contenidoAPublicar.setPublicador(this.nombre);

        return contenidoAPublicar;
    }

    @Override
    public boolean eliminarContenido(ArrayList<Contenido> listaContenido, Contenido contenido) {
        return listaContenido.remove(contenido);
    }
}
