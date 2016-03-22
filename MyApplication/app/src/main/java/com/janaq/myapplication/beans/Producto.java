package com.janaq.myapplication.beans;

public class Producto {
    private String nombre;
    private Double precio;
    private String categoria;
    private String image_path;

    public Producto(){

    }

    public Producto (String nombre, Double precio, String cat){
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = cat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
