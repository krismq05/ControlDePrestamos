package Errores;

public class ItemNoEncontradoError extends Exception {

    public ItemNoEncontradoError(String mensaje) {
        super(mensaje);
    }
}