package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private int idCategoria;
    private String nombre;
    private String descripcion;

    private List<Item> items;

    public Categoria(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.items = new ArrayList<>();
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Item> getItems() {
        return items;
    }

    public void agregarItem(Item item) {
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    public void eliminarItem(Item item) {
        items.remove(item);
    }
}