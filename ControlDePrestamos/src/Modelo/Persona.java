package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private String identificacion;
    private String telefono;
    private String correo;

    private List<Prestamo> prestamos;

    public Persona(String nombre, String identificacion, String telefono, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correo = correo;
        this.prestamos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void eliminarPrestamo(int idPrestamo) {
        prestamos.removeIf(prestamo -> prestamo.getIdPrestamo() == idPrestamo);
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}