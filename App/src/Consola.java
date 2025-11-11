import java.io.PrintStream;
import java.util.Scanner;
public class Consola {
    private final Scanner escaner;
    private final PrintStream imprimir;
    public Consola(){
        escaner = new Scanner(System.in);
        imprimir = new PrintStream(System.out);
    }
    public String pedirNombreDeUsuario(){
        String res = "";
        while (res.trim().isEmpty()){
            imprimir.println("Ingrese el nombre de usuario: ");
            res = escaner.nextLine();
        }
        return res;
    }
    public String pedirContrasena(String usuario){
        String res = "";
        while (res.trim().isEmpty()){
            imprimir.println("Ingrese la contrasena del usuario: " + usuario);
            res = escaner.nextLine();
        }
        return res;
    }
    public int pedirTipoDeUsuario(String usuario){
        int res = 0;
        while (!(res == 1 || res == 2)){
            imprimir.println("Ingrese el tipo de usuario para: " + usuario + "(Escribir el numero)\n\t1) Administrador\n\t2) Editor");
            res = escaner.nextInt();
        }
        return res;
    }
    public String pedirNombreDelContenido(){
        String res = "";
        while (res.trim().isEmpty()){
            imprimir.println("Ingrese el nombre del contenido: ");
            res = escaner.nextLine();
        }
        return res;
    }
    public String pedirDescripcionDelContenido(String nombre){
        String res = "";
        while (res.trim().isEmpty()){
            imprimir.println("Ingrese la descripcion del contenido: " + nombre);
            res = escaner.nextLine();
        }
        return res;
    }
    public String pedirContenidoPuntualDelContenido(String nombre){
        String res = "";
        while (res.trim().isEmpty()){
            imprimir.println("Ingrese el contenido puntual del contenido: " + nombre);
            res = escaner.nextLine();
        }
        return res;
    }
    public String pedirEtiquetaDelContenido(String nombre) {
        String res = "";
        while (res.trim().isEmpty()){
            imprimir.println("Ingrese la etiqueta del contenido: " + nombre);
            res = escaner.nextLine();
        }
        return res;
    }
    //int datoAdicional (Duracion, formato, cantpal)
    public int pedirTipoDeContenido(String nombre){
        int res = 0;
        while (!(res == 1 || res == 2 || res == 3)){
            imprimir.println("Ingrese el tipo de contenido para: " + nombre + " (Escribir el numero).\n\t1) Imagen\n\t2) Video\n\t3) Articulo");
            res = escaner.nextInt();
        }
        return res;
    }
    public int pedirFormatoDeImagen(String nombre){
        int res = 0;
        while (!(res == 1 || res == 2 || res == 3)){
            imprimir.println("Ingrese el formato de la imagen: " + nombre + " (Escribir el numero).\n\t1) .jpg\n\t2) .png\n\t3) .gif");
            res = escaner.nextInt();
        }
        return res;
    }
    public int pedirDuracionDeVideo(String nombre){
        imprimir.println("Ingrese la duracion del video: " + nombre + " (En minutos. Solo enteros).");
        int res = escaner.nextInt();
        return res;
    }
    public int pedirCantidadDePalabrasDeArticulo(String nombre){
        imprimir.println("Ingrese la cantidad de palabras que tiene el articulo: " + nombre + ".");
        int res = escaner.nextInt();
        return res;
    }
    public int obtenerCantidadDeNuevasVisitas(String nombre){
        imprimir.println("Ingrese la cantidad de visitas nuevas que tiene el contenido: " + nombre + ".");
        int res = escaner.nextInt();
        return res;
    }
}
