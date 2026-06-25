package Control;

import Modelo.Alerta;
import Modelo.Categoria;
import Modelo.FrecuenciaAlerta;
import Modelo.Item;
import Modelo.Persona;
import Modelo.Prestamo;
import Modelo.Tipo;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import Errores.ItemYaPrestadaError;
import Errores.PersonaDuplicadaError;
import Errores.PersonaNoEncontradaError;
import Errores.ItemNoEncontradoError;
import Errores.PrestamoNoEncontradoError;
import Errores.PrestamoFinalizadoError;
import Errores.CategoriaNoEncontradaError;
import Errores.TipoNoEncontradoError;
import Errores.AlertaNoEncontradaError;

public class ControlPrestamos {

    private static ControlPrestamos instancia;

    private Map<String, Persona> personas;
    private Map<Integer, Item> items;
    private Map<Integer, Categoria> categorias;
    private Map<Integer, Tipo> tipos;
    private Map<Integer, Prestamo> prestamos;
    private Map<Integer, Alerta> alertas;

    private int nextIdItem;
    private int nextIdCategoria;
    private int nextIdTipo;
    private int nextIdPrestamo;
    private int nextIdAlerta;

    private ControlPrestamos() {
        personas = new LinkedHashMap<>();
        items = new LinkedHashMap<>();
        categorias = new LinkedHashMap<>();
        tipos = new LinkedHashMap<>();
        prestamos = new LinkedHashMap<>();
        alertas = new LinkedHashMap<>();

        nextIdItem = 1;
        nextIdCategoria = 1;
        nextIdTipo = 1;
        nextIdPrestamo = 1;
        nextIdAlerta = 1;

        crearTipo("Generico", "Tipo por defecto del sistema", true);
    }

    public static ControlPrestamos getInstancia() {
        if (instancia == null) {
            instancia = new ControlPrestamos();
        }

        return instancia;
    }

    public Collection<Persona> listarPersonas() {
        return personas.values();
    }

    public Persona obtenerPersona(String identificacion)
            throws PersonaNoEncontradaError {

        Persona persona = personas.get(identificacion);

        if (persona == null) {

            throw new PersonaNoEncontradaError(
                    "No existe una persona con la identificación "
                            + identificacion);

        }

        return persona;

    }

    public Persona crearPersona(String nombre,
            String identificacion,
            String telefono,
            String correo)
            throws PersonaDuplicadaError {
        if (estaVacio(nombre) || estaVacio(identificacion)) {
            return null;
        }

        if (personas.containsKey(identificacion)) {

            throw new PersonaDuplicadaError(
                    "Ya existe una persona registrada con la identificacion "
                            + identificacion
            );
        }

        Persona persona = new Persona(nombre, identificacion, telefono, correo);
        personas.put(identificacion, persona);

        return persona;
    }

    public boolean modificarPersona(String identificacion, String nombre, String telefono, String correo)
            throws PersonaNoEncontradaError {

        Persona persona = personas.get(identificacion);

        if (persona == null) {

            throw new PersonaNoEncontradaError(
                    "No existe una persona con la identificacion "
                            + identificacion
            );
        }

        if (estaVacio(nombre)) {
            return false;
        }

        persona.setNombre(nombre);
        persona.setTelefono(telefono);
        persona.setCorreo(correo);

        return true;
    }

    public boolean eliminarPersona(String identificacion)
            throws PersonaNoEncontradaError {

        Persona persona = personas.get(identificacion);

        if (persona == null) {

            throw new PersonaNoEncontradaError(
                    "No existe una persona con la identificacion "
                            + identificacion
            );
        }

        for (Prestamo prestamo : prestamos.values()) {

            if (prestamo.getPersona() == persona && !"Finalizado".equalsIgnoreCase(prestamo.getEstado())) {
                return false;
            }
        }

        personas.remove(identificacion);
        return true;
    }
    
    public Categoria obtenerCategoria(int idCategoria)
            throws CategoriaNoEncontradaError {

        Categoria categoria = categorias.get(idCategoria);

        if (categoria == null) {

            throw new CategoriaNoEncontradaError(
                    "No existe una categoria con el id "
                            + idCategoria
            );
        }

        return categoria;
    }

    public Categoria crearCategoria(String nombre, String descripcion) {
        if (estaVacio(nombre)) {
            return null;
        }

        Categoria categoria = new Categoria(nextIdCategoria, nombre, descripcion);
        categorias.put(nextIdCategoria, categoria);
        nextIdCategoria++;

        return categoria;
    }

    public boolean modificarCategoria(int idCategoria,
            String nombre,
            String descripcion)
    throws CategoriaNoEncontradaError {

Categoria categoria = categorias.get(idCategoria);

if (categoria == null) {

throw new CategoriaNoEncontradaError(
"No existe una categoria con el id "
  + idCategoria
);

}

if (estaVacio(nombre)) {
return false;
}

categoria.setNombre(nombre);
categoria.setDescripcion(descripcion);

return true;
}

    public boolean eliminarCategoria(int idCategoria)
            throws CategoriaNoEncontradaError {

        Categoria categoria = categorias.get(idCategoria);

        if (categoria == null) {

            throw new CategoriaNoEncontradaError(
                    "No existe una categoria con el id "
                            + idCategoria
            );

        }

        for (Item item : categoria.getItems()) {

            item.eliminarCategoria(categoria);

        }

        categorias.remove(idCategoria);

        return true;
    }
    public Collection<Categoria> listarCategorias() {

        return categorias.values();

    }

    public Collection<Tipo> listarTipos() {
        return tipos.values();
    }

    public Tipo obtenerTipo(int idTipo)
            throws TipoNoEncontradoError {

        Tipo tipo = tipos.get(idTipo);

        if (tipo == null) {

            throw new TipoNoEncontradoError(
                    "No existe un tipo con el id "
                            + idTipo
            );
        }

        return tipo;
    }

    public Tipo crearTipo(String nombre, String descripcion, boolean generico) {
        if (estaVacio(nombre)) {
            return null;
        }

        Tipo tipo = new Tipo(nextIdTipo, nombre, descripcion, generico);
        tipos.put(nextIdTipo, tipo);
        nextIdTipo++;

        return tipo;
    }

    public boolean modificarTipo(int idTipo,
            String nombre,
            String descripcion,
            boolean generico)
            throws TipoNoEncontradoError {

        Tipo tipo = tipos.get(idTipo);

        if (tipo == null) {

            throw new TipoNoEncontradoError(
                    "No existe un tipo con el id "
                            + idTipo
            );

        }

        if (estaVacio(nombre)) {
            return false;
        }

        tipo.setNombre(nombre);
        tipo.setDescripcion(descripcion);
        tipo.setGenerico(generico);

        return true;
    }

    public boolean eliminarTipo(int idTipo)
            throws TipoNoEncontradoError {

        Tipo tipo = tipos.get(idTipo);

        if (tipo == null) {

            throw new TipoNoEncontradoError(
                    "No existe un tipo con el id "
                            + idTipo
            );

        }

        for (Item item : tipo.getItem()) {

            item.setTipo(null);

        }

        tipos.remove(idTipo);

        return true;
    }

    public Collection<Item> listarItems() {
        return items.values();
    }

    public Item obtenerItem(int idItem) {
        return items.get(idItem);
    }

    public Item crearItem(String codigo, String nombre, String descripcion, int idTipo) {
        Tipo tipo = tipos.get(idTipo);

        if (tipo == null || estaVacio(codigo) || estaVacio(nombre)) {
            return null;
        }

        Item item = new Item(nextIdItem, codigo, nombre, descripcion, false);

        item.setTipo(tipo);
        tipo.agregarItem(item);

        items.put(nextIdItem, item);
        nextIdItem++;

        return item;
    }

    public boolean modificarItem(int idItem,
            String codigo,
            String nombre,
            String descripcion,
            int idTipo)
throws ItemNoEncontradoError {
    	Item item = items.get(idItem);
    	Tipo nuevoTipo = tipos.get(idTipo);

    	if (item == null) {

    	    throw new ItemNoEncontradoError(
    	            "No existe un item con el id "
    	                    + idItem
    	    );

    	}

    	if (nuevoTipo == null || estaVacio(codigo) || estaVacio(nombre)) {
    	    return false;
    	}

        Tipo tipoActual = item.getTipo();

        if (tipoActual != null && tipoActual != nuevoTipo) {
            tipoActual.eliminarItem(item);
        }

        item.setCodigo(codigo);
        item.setNombre(nombre);
        item.setDescripcion(descripcion);
        item.setTipo(nuevoTipo);

        nuevoTipo.agregarItem(item);

        return true;
    }

    public boolean eliminarItem(int idItem)
            throws ItemNoEncontradoError {
    	Item item = items.get(idItem);

    	if (item == null) {

    	    throw new ItemNoEncontradoError(
    	            "No existe un item con el id "
    	                    + idItem
    	    );

    	}

    	if (item.isPrestado()) {
    	    return false;
    	}

        if (item.getTipo() != null) {
            item.getTipo().eliminarItem(item);
        }

        for (Categoria categoria : item.getCategorias()) {
            categoria.eliminarItem(item);
        }

        items.remove(idItem);
        return true;
    }

    public boolean agregarCategoriaItem(int idItem, int idCategoria) {
        Item item = items.get(idItem);
        Categoria categoria = categorias.get(idCategoria);

        if (item == null || categoria == null) {
            return false;
        }

        item.agregarCategoria(categoria);
        return true;
    }

    public boolean eliminarCategoriaItem(int idItem, int idCategoria) {
        Item item = items.get(idItem);
        Categoria categoria = categorias.get(idCategoria);

        if (item == null || categoria == null) {
            return false;
        }

        item.eliminarCategoria(categoria);
        return true;
    }

    public Collection<Prestamo> listarPrestamos() {
        return prestamos.values();
    }

    public Prestamo obtenerPrestamo(int idPrestamo) {
        return prestamos.get(idPrestamo);
    }

    public Prestamo crearPrestamo(String identificacionPersona)
            throws PersonaNoEncontradaError {
        Persona persona = personas.get(identificacionPersona);

        if (persona == null) {

            throw new PersonaNoEncontradaError(
                    "No existe una persona con la identificacion "
                            + identificacionPersona
            );
        }

        Calendar calendario = Calendar.getInstance();
        calendario.add(Calendar.DAY_OF_MONTH, 7);

        Date fechaRetorno = calendario.getTime();

        Prestamo prestamo = new Prestamo(
                nextIdPrestamo,
                new Date(),
                fechaRetorno,
                "Activo"
        );

        prestamo.setPersona(persona);
        persona.agregarPrestamo(prestamo);

        prestamos.put(nextIdPrestamo, prestamo);
        nextIdPrestamo++;

        return prestamo;
    }

    public boolean agregarItemPrestamo(int idPrestamo, int idItem)
            throws ItemYaPrestadaError,
                   ItemNoEncontradoError,
                   PrestamoNoEncontradoError,
                   PrestamoFinalizadoError {
        Prestamo prestamo = prestamos.get(idPrestamo);
        Item item = items.get(idItem);
        if (prestamo == null) {

            throw new PrestamoNoEncontradoError(
                    "No existe un prestamo con el id "
                            + idPrestamo
            );
        }

        if (item == null) {

            throw new ItemNoEncontradoError(
                    "No existe un item con el id "
                            + idItem
            );
        }

        if (!"Activo".equalsIgnoreCase(prestamo.getEstado())) {

            throw new PrestamoFinalizadoError(
                    "El prestamo ya se encuentra finalizado"
            );
        }

        if (item.isPrestado()) {

            String fechaDisponible = "sin fecha registrada";

            if (item.getPrestamo() != null && item.getPrestamo().getFechaRetorno() != null) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                fechaDisponible = formato.format(item.getPrestamo().getFechaRetorno());
            }

            throw new ItemYaPrestadaError(
                    "El item "
                            + item.getNombre()
                            + " ya se encuentra prestado. Estara disponible nuevamente el "
                            + fechaDisponible
            );
        }

        prestamo.agregarItem(item);
        item.setPrestamo(prestamo);
        item.setPrestado(true);

        return true;
    }

    public boolean eliminarItemPrestamo(int idPrestamo, int idItem) {
        Prestamo prestamo = prestamos.get(idPrestamo);
        Item item = items.get(idItem);

        if (prestamo == null || item == null) {
            return false;
        }

        if (item.getPrestamo() != prestamo) {
            return false;
        }

        prestamo.eliminarItem(idItem);
        item.setPrestamo(null);
        item.setPrestado(false);

        return true;
    }

    public boolean retornarItemPrestamo(int idPrestamo, int idItem) {
        Prestamo prestamo = prestamos.get(idPrestamo);
        Item item = items.get(idItem);

        if (prestamo == null || item == null) {
            return false;
        }

        if (item.getPrestamo() != prestamo) {
            return false;
        }

        prestamo.retornarItem(idItem);
        item.setPrestamo(null);
        item.setPrestado(false);

        return true;
    }

    public boolean finalizarPrestamo(int idPrestamo)
            throws PrestamoNoEncontradoError {
        Prestamo prestamo = prestamos.get(idPrestamo);

        if (prestamo == null) {

            throw new PrestamoNoEncontradoError(
                    "No existe un prestamo con el id "
                    + idPrestamo
            );

        }

        prestamo.setFechaRetorno(new Date());
        prestamo.finalizarPrestamo();

        return true;
    }

    public Alerta obtenerAlerta(int idAlerta)
            throws AlertaNoEncontradaError {

        Alerta alerta = alertas.get(idAlerta);

        if (alerta == null) {

            throw new AlertaNoEncontradaError(
                    "No existe una alerta con el id "
                            + idAlerta
            );
        }

        return alerta;
    }

    public boolean asignarAlerta(int idPrestamo, String mensaje, Date fechaInicio, FrecuenciaAlerta frecuencia) {
        Prestamo prestamo = prestamos.get(idPrestamo);

        if (prestamo == null || estaVacio(mensaje) || fechaInicio == null || frecuencia == null) {
            return false;
        }

        Alerta alerta = new Alerta(nextIdAlerta, mensaje, fechaInicio, frecuencia, true, prestamo);

        alertas.put(nextIdAlerta, alerta);
        prestamo.asignarAlerta(alerta);

        nextIdAlerta++;

        return true;
    }

    public boolean activarAlerta(int idAlerta)
    		throws AlertaNoEncontradaError {
        Alerta alerta = alertas.get(idAlerta);

        if (alerta == null) {

            throw new AlertaNoEncontradaError(
                    "No existe una alerta con el id "
                            + idAlerta
            );

        }

        alerta.activar();
        return true;
    }

    public boolean desactivarAlerta(int idAlerta) {
        Alerta alerta = alertas.get(idAlerta);

        if (alerta == null) {
            return false;
        }

        alerta.desactivar();
        return true;
    }

    public String reportePorUsuarios() {
        StringBuilder reporte = new StringBuilder();

        for (Persona persona : personas.values()) {
            reporte.append("Usuario: ")
                    .append(persona.getNombre())
                    .append(" - Identificacion: ")
                    .append(persona.getIdentificacion())
                    .append("\n");

            for (Prestamo prestamo : prestamos.values()) {
                if (prestamo.getPersona() == persona) {
                    reporte.append("  Prestamo ")
                            .append(prestamo.getIdPrestamo())
                            .append(" - Estado: ")
                            .append(prestamo.getEstado())
                            .append("\n");
                }
            }
        }

        return reporte.toString();
    }

    public String reportePorItems() {
        StringBuilder reporte = new StringBuilder();

        for (Item item : items.values()) {
            reporte.append("Item: ")
                    .append(item.getNombre())
                    .append(" - Codigo: ")
                    .append(item.getCodigo())
                    .append(" - Prestado: ")
                    .append(item.isPrestado() ? "Si" : "No")
                    .append("\n");
        }

        return reporte.toString();
    }

    public String reportePorCategorias() {
        StringBuilder reporte = new StringBuilder();

        for (Categoria categoria : categorias.values()) {
            reporte.append("Categoria: ")
                    .append(categoria.getNombre())
                    .append("\n");

            for (Item item : categoria.getItems()) {
                reporte.append("  Item: ")
                        .append(item.getNombre())
                        .append("\n");
            }
        }

        return reporte.toString();
    }

    public String reportePorTipos() {
        StringBuilder reporte = new StringBuilder();

        for (Tipo tipo : tipos.values()) {
            reporte.append("Tipo: ")
                    .append(tipo.getNombre())
                    .append("\n");

            for (Item item : tipo.getItem()) {
                reporte.append("  Item: ")
                        .append(item.getNombre())
                        .append("\n");
            }
        }

        return reporte.toString();
    }

    private Tipo obtenerTipoGenerico() {
        for (Tipo tipo : tipos.values()) {
            if (tipo.isGenerico()) {
                return tipo;
            }
        }

        return null;
    }

    private boolean estaVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}