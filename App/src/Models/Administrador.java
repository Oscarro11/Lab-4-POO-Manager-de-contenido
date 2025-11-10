package models;

import java.util.ArrayList;

public class Administrador extends Usuario{
    
    public Administrador(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public Contenido crearContenido(String nombre, String descripcion, String contenido, ArrayList<String> etiquetas, int tipoContenido){

        switch (tipoContenido) {
            case 1:

            case 2:

            case 3:
        
            default:
                return null;
        }
    }

    public void editarContenido(Contenido contenido, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas) {
        
    }

    public Contenido publicarContenido(Contenido contenido) {
        return contenido.publicar();
    }

    public boolean eliminarContenido(ArrayList<Contenido> listaContenido, Contenido contenido) {
        if (true){
            return true;
        }
        else {
            return false;
        }
    }
}
