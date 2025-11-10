import models.*;

import java.util.ArrayList;

public class Controlador {
    private Usuario usuarioActivo;
    private ArrayList<Contenido> listaContenidoNoPublicado = new ArrayList<Contenido>();
    private ArrayList<Contenido> listaContenidoPublicado = new ArrayList<Contenido>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public Controlador() {}

    public boolean crearUsuario(String nombre, String contrasena, int tipoUsuario) {
        boolean nombreUsado = false;

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(contrasena)) {
                nombreUsado = true;
                break;
            }
        }

        if (nombreUsado) {
            return false;
        }
        else {
            Usuario nuevoUsuario;

            switch (tipoUsuario) {
                case 1 -> nuevoUsuario = new Administrador(nombre, contrasena);
                case 2 -> nuevoUsuario = new Editor(nombre, contrasena);
                default -> nuevoUsuario = null;
            }

            listaUsuarios.add(nuevoUsuario);
            usuarioActivo = nuevoUsuario;
            return true;
        }
    }

    public boolean buscarUsuario(String nombre, String contrasena) {
        boolean usuarioEncontrado = false;

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContrasena().equals(contrasena)) {
                usuarioEncontrado = true;
                usuarioActivo = usuario;
                break;
            }
        }

        return usuarioEncontrado;
    }

    public boolean crearContenido(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas, int tipoContenido, int datoAdicional) {
        Contenido contenidoNuevo;
        boolean nombreUsado = false;

        for (Contenido contenido: listaContenidoPublicado) {
            if (contenido.getNombre().equals(nombre)) {
                nombreUsado = true;
                break;
            }
        }

        if (!nombreUsado) {
            for (Contenido contenido: listaContenidoNoPublicado) {
                if (contenido.getNombre().equals(nombre)) {
                    nombreUsado = true;
                    break;
                }
            }
        }
        
        if (nombreUsado) {
            return false;
        }
        else{
            contenidoNuevo = usuarioActivo.crearContenido(nombre, descripcion, contenidoPuntual, etiquetas, tipoContenido, datoAdicional);
            listaContenidoNoPublicado.add(contenidoNuevo);
            return true;
        }
    }

    public void editarContenido(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas) {
        for (Contenido contenido : listaContenidoNoPublicado) {
            if (contenido.getNombre().equals(nombre)) {
                usuarioActivo.editarContenido(contenido, descripcion, contenidoPuntual, etiquetas);
                break;
            }
        }
    }

    public boolean publicarContenido(String nombre) {
        Contenido contenidoAPublicar;
        Contenido contenidoDeReferencia = null;

        for (Contenido contenido : listaContenidoNoPublicado) {
            if (contenido.getNombre().equals(nombre)) {
                contenidoDeReferencia = contenido;
                break;
            }
        }

        if (contenidoDeReferencia == null) {
            return false;
        }
        else{
            contenidoAPublicar = usuarioActivo.publicarContenido(contenidoDeReferencia);
            listaContenidoPublicado.add(contenidoAPublicar);
            return true;
        }
    }

    public boolean eliminarContenido(String nombre) {
        Contenido contenidoAEliminar = null;
        
        for (Contenido contenido : listaContenidoNoPublicado) {
            if (contenido.getNombre().equals(nombre)) {
                contenidoAEliminar = contenido;
                break;
            }
        }

        if (contenidoAEliminar == null) {
            return false;
        }
        else{
            return usuarioActivo.eliminarContenido(listaContenidoNoPublicado, contenidoAEliminar);
        }
    }
}
