package Errores;

public class PersonaNoEncontradaError extends Exception {

    public PersonaNoEncontradaError(String mensaje) {
        super(mensaje);
    }
}