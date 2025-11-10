package models;

import interfaces.Editar;
import interfaces.Publicar;
import interfaces.Visualizar;
import java.util.ArrayList;

public abstract class Contenido implements Editar, Publicar, Visualizar{
    protected String nombre;
    protected String descripcion;
    protected String contenidoPuntual;
    protected ArrayList<String> etiquetas;
    protected String autor;
    protected String ultimoModificador;
    protected String publicador;
    protected int visitas;
    
    public Contenido(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contenidoPuntual = contenidoPuntual;
        this.etiquetas = etiquetas;
    }

    public void anadirVisitas(int cantidadDeVisitas){
        this.visitas += cantidadDeVisitas;
    }


    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setContenidoPuntual(String contenidoPuntual){
        this.contenidoPuntual = contenidoPuntual;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setUltimoModificador(String ultimoModificador){
        this.ultimoModificador = ultimoModificador;
    }

    public void setPublicador(String publicador){
        this.publicador = publicador;
    }
    
    public void setNumeroDeVisitas(int numeroDeVisitas){
        this.visitas = numeroDeVisitas;
    }


    public String getNombre(){
        return this.nombre;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public String getContenidoPuntual(){
        return this.contenidoPuntual;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getUltimoModificador(){
        return this.ultimoModificador;
    }

    public String getPublicador(){
        return this.publicador;
    }

    public int getNumeroDeVisitas(){
        return this.visitas;
    }

    public void addEtiqueta(String etiqueta){
        this.etiquetas.add(etiqueta);
    }

    public String getEtiqueta(int pos){
        return etiquetas.get(pos);
    }

    public void delEtiqueta(int pos){
        etiquetas.remove(pos);
    }
}

