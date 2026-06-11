package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private int idItem;
    private String codigo;
    private String nombre;
    private String descripcion;
    private boolean prestado;
    private Tipo tipo;
    private Prestamo prestamo;
    private List<Categoria> categorias;

    public Item(int idItem, String codigo, String nombre, String descripcion, boolean prestado) {
        this.idItem = idItem;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prestado = prestado;
        this.categorias = new ArrayList<>();
    }

    public int getIdItem() {
        return idItem;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void agregarCategoria(Categoria categoria) {
        if (!categorias.contains(categoria)) {
            categorias.add(categoria);
            categoria.agregarItem(this);
        }
    }

    public void eliminarCategoria(Categoria categoria) {
        categorias.remove(categoria);
        categoria.eliminarItem(this);
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
}