package Errores;

public class PersonaDuplicadaError extends Exception {

    public PersonaDuplicadaError(String mensaje) {
        super(mensaje);
    }
}