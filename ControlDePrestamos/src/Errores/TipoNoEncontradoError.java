package Errores;

public class TipoNoEncontradoError extends Exception {

    public TipoNoEncontradoError(String mensaje) {
        super(mensaje);
    }
}