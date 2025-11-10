import models.*;

import java.util.ArrayList;
import java.util.Collections;

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

    private Contenido buscarContenido(String nombre) {
        Contenido contenidoBuscado = null;

        for (Contenido contenido: listaContenidoPublicado) {
            if (contenido.getNombre().equals(nombre)) {
                contenidoBuscado = contenido;
                break;
            }
        }

        return contenidoBuscado;
    }

    public String buscarDatosContenido(String nombre) {
        return buscarContenido(nombre).toString();
    }

    public boolean crearContenido(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas, int tipoContenido, int datoAdicional) {
        Contenido contenidoNuevo;
        Contenido contenidoExistente = null;
        boolean nombreUsado = false;

        contenidoExistente = buscarContenido(nombre);

        if (contenidoExistente != null) {
            nombreUsado = true;
        }
        else {
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

    public ArrayList<String> filtrarContenido(ArrayList<String> etiquetasFiltro) {
        boolean incluyeEtiquetas;
        ArrayList<String> contenidoFiltrado = new ArrayList<String>();
        
        for (Contenido contenido: listaContenidoPublicado) {
            incluyeEtiquetas = true;

            for (String etiqueta : etiquetasFiltro) {
                if (!contenido.containsEtiqueta(etiqueta)) {
                    incluyeEtiquetas = false;
                    break;
                }
            }

            if (incluyeEtiquetas) {
                contenidoFiltrado.add(contenido.getNombre());
            }
        }

        return contenidoFiltrado;
    }

    public void agregarVisitas(String nombreContenido, int cantidadDeVisitas){
        Contenido contenido = buscarContenido(nombreContenido);

        contenido.anadirVisitas(cantidadDeVisitas);
    }

    public String generarReporte() {
        StringBuilder builder = new StringBuilder();
        StringBuilder auxbuilder = new StringBuilder();
        int cantArticulos = 0;
        int cantVideos = 0;
        int cantImagenes = 0;
        String mediaMasVista;

        ArrayList<Contenido> copiaListaContenidoPublicado = new ArrayList<>(listaContenidoPublicado);
        Collections.sort(copiaListaContenidoPublicado);

        for (Contenido contenido : copiaListaContenidoPublicado) {
            switch (contenido) {
                case Articulo a -> cantArticulos++;
                case Video v -> cantVideos++;
                case Imagen i -> cantImagenes++;

                //Puede ser cualquier valor
                default -> cantArticulos--;
            }
        }

        if (cantArticulos > cantImagenes && cantArticulos > cantVideos) {
            mediaMasVista = "Articulos";
        }
        else if (cantImagenes > cantArticulos && cantImagenes > cantVideos) {
            mediaMasVista = "Imagenes";
        } 
        else {
            mediaMasVista = "Videos";
        }

        builder.append(String.format("El formato de contenido más popular son l@s %s \n", mediaMasVista));
        
        for (int i = 0; i < 3; i++) {
            try {
                Contenido contenido = copiaListaContenidoPublicado.remove(copiaListaContenidoPublicado.size() - 1);
                auxbuilder.append(String.format("- %s", contenido));
                
            } catch (Exception e) {
                break;
            }
        }

        builder.append(String.format("Estos son los tres contenidos más visualizados: \n%s\n", auxbuilder.toString()));

        return builder.toString();
    }
}
