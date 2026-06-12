package Errores;

public class CategoriaNoEncontradaError extends Exception {

    public CategoriaNoEncontradaError(String mensaje) {
        super(mensaje);
    }
}