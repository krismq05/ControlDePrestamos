package Modelo;

import java.util.Date;

public class Alerta {

    private int idAlerta;
    private String mensaje;
    private Date fechaInicio;
    private FrecuenciaAlerta frecuencia;
    private boolean activa;

    private Prestamo prestamo;

    public Alerta(int idAlerta,
                  String mensaje,
                  Date fechaInicio,
                  FrecuenciaAlerta frecuencia,
                  boolean activa,
                  Prestamo prestamo) {

        this.idAlerta = idAlerta;
        this.mensaje = mensaje;
        this.fechaInicio = fechaInicio;
        this.frecuencia = frecuencia;
        this.activa = activa;
        this.prestamo = prestamo;
    }

    public int getIdAlerta() {
        return idAlerta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public FrecuenciaAlerta getFrecuencia() {
        return frecuencia;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFrecuencia(FrecuenciaAlerta frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void activar() {
        this.activa = true;
    }

    public void desactivar() {
        this.activa = false;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }
}