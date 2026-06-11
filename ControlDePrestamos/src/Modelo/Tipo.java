package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Tipo {

    private int idTipo;
    private String nombre;
    private String descripcion;
    private boolean generico;

    private List<Item> items;

    public Tipo(int idTipo, String nombre, String descripcion, boolean generico) {
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.generico = generico;
        this.items = new ArrayList<>();
    }

    public int getIdTipo() {
        return idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isGenerico() {
        return generico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setGenerico(boolean generico) {
        this.generico = generico;
    }

    public List<Item> getItem() {
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