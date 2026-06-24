package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prestamo {

    private int idPrestamo;
    private Date fechaPrestamo;
    private Date fechaRetorno;
    private String estado;

    private Persona persona;
    private Alerta alerta;

    private List<Item> items;

    public Prestamo(int idPrestamo,
                    Date fechaPrestamo,
                    Date fechaRetorno,
                    String estado) {

        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaRetorno = fechaRetorno;
        this.estado = estado;

        this.items = new ArrayList<>();
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public String getEstado() {
        return estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Item> getItems() {
        return items;
    }

    public void agregarItem(Item item) {

        if (!items.contains(item)) {

            items.add(item);

        }
    }

    public void eliminarItem(int idItem) {

        items.removeIf(
                item -> item.getIdItem() == idItem
        );
    }

    public void retornarItem(int idItem) {

        eliminarItem(idItem);
    }

    public void finalizarPrestamo() {

        for (Item item : items) {

            item.setPrestamo(null);
            item.setPrestado(false);

        }

        items.clear();

        estado = "Finalizado";
    }

    public void asignarAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public void agregarAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public Alerta getAlerta() {
        return alerta;
    }
}