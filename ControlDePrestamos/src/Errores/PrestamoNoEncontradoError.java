package Errores;

public class PrestamoNoEncontradoError extends Exception {

    public PrestamoNoEncontradoError(String mensaje) {
        super(mensaje);
    }
}