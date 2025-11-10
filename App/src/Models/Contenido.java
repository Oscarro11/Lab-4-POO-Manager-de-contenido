package models;

import interfaces.Editar;
import interfaces.Publicar;
import interfaces.Visualizar;
import java.util.ArrayList;

public class Contenido implements Editar, Publicar, Visualizar{
    private String nombre;
    private String descripcion;
    private String contenidoPuntual;
    private ArrayList<String> etiquetas;
    private int tipoDeContenido;
    private String autor;
    private String ultimoModificador;
    private String publicador;
    private int visitas;
    public Contenido(String nombre, String descripcion, String contenidoPuntual, ArrayList<String> etiquetas, int tipoDeContenido){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contenidoPuntual = contenidoPuntual;
        this.etiquetas = etiquetas;
        this.tipoDeContenido = tipoDeContenido;
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
    public void setTipoDeContenidp(int tipoDeContenido){
        this.tipoDeContenido = tipoDeContenido;
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
    public int getTipoDeContenidp(){
        return this.tipoDeContenido;
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
    @Override
    public String toString(){
        return String.format("El contenido %s con descripcion: %s; tiene %d viditas", nombre, descripcion, visitas);
    }
    @Override
    public void editar(String descripcion, String contenido, ArrayList<String> etiquetas){
        this.descripcion = descripcion;
        this.contenidoPuntual = contenido;
        this.etiquetas = etiquetas;
    }
    @Override
    public Contenido publicar(){
        return this;
    }
    @Override
    public String representacionTexto(){
        return toString();
    }
    @Override
    public String representacionHTML(){
        return toString();
    }
}

