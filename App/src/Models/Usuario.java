package models;

import java.util.ArrayList;

public abstract class Usuario {
    protected String nombre;
    protected String contrasena;


    public Contenido crearContenido(String nombre, String descripcion, String contenido, ArrayList<String> etiquetas, int tipoContenido, int datoAdicional) {
        return null;
    }

    public void editarContenido(Contenido contenido, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas) {
    }

    public Contenido publicarContenido(Contenido contenido) {
        return null;
    }

    public boolean eliminarContenido(ArrayList<Contenido> listaContenido, Contenido contenido) {
        return false;
    }


    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
