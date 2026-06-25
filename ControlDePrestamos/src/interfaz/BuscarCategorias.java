package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Control.ControlPrestamos;
import Errores.CategoriaNoEncontradaError;
import Modelo.Categoria;

public class BuscarCategorias extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtIdCategoria;
    private JTextField txtNombre;
    private JTextField txtDescripcion;

    public BuscarCategorias() {

        setTitle("Administrar Categorías");

        setSize(450, 320);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(8, 2, 10, 10));

        JLabel titulo = new JLabel("Administrar Categorías");

        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Id"));

        txtIdCategoria = new JTextField();

        panel.add(txtIdCategoria);

        panel.add(new JLabel("Nombre"));

        txtNombre = new JTextField();

        panel.add(txtNombre);

        panel.add(new JLabel("Descripción"));

        txtDescripcion = new JTextField();

        panel.add(txtDescripcion);

        JButton btnBuscar = new JButton("Buscar");

        JButton btnModificar = new JButton("Modificar");

        JButton btnEliminar = new JButton("Eliminar");

        JButton btnListar = new JButton("Listar");

        JButton btnCerrar = new JButton("Cerrar");

        btnBuscar.setFocusPainted(false);

        btnModificar.setFocusPainted(false);

        btnEliminar.setFocusPainted(false);

        btnListar.setFocusPainted(false);

        btnCerrar.setFocusPainted(false);

        panel.add(btnBuscar);

        panel.add(btnModificar);

        panel.add(btnEliminar);

        panel.add(btnListar);

        panel.add(btnCerrar);

        panel.add(new JLabel(""));

        btnBuscar.addActionListener(e -> buscarCategoria());

        btnModificar.addActionListener(e -> modificarCategoria());

        btnEliminar.addActionListener(e -> eliminarCategoria());

        btnListar.addActionListener(e -> listarCategorias());

        btnCerrar.addActionListener(e -> dispose());

        add(panel);

        setVisible(true);
    }

        	private void buscarCategoria() {

        	    if (txtIdCategoria.getText().trim().isEmpty()) {

        	        JOptionPane.showMessageDialog(this,
        	                "Ingrese el id de la categoría.");

        	        return;

        	    }

        	    try {

        	        ControlPrestamos control = ControlPrestamos.getInstancia();

        	        int idCategoria = Integer.parseInt(txtIdCategoria.getText());

        	        Categoria categoria = control.obtenerCategoria(idCategoria);

        	        txtNombre.setText(categoria.getNombre());

        	        txtDescripcion.setText(categoria.getDescripcion());

        	    } catch (NumberFormatException e) {

        	        JOptionPane.showMessageDialog(this,
        	                "El id debe ser un número.");

        	    } catch (CategoriaNoEncontradaError e) {

        	        JOptionPane.showMessageDialog(this,
        	                e.getMessage());

        	    }

        }

        	private void modificarCategoria() {

        	    if (txtIdCategoria.getText().trim().isEmpty()
        	            || txtNombre.getText().trim().isEmpty()) {

        	        JOptionPane.showMessageDialog(this,
        	                "Complete los campos obligatorios.");

        	        return;

        	    }

        	    try {

        	        ControlPrestamos control = ControlPrestamos.getInstancia();

        	        boolean resultado = control.modificarCategoria(
        	                Integer.parseInt(txtIdCategoria.getText()),
        	                txtNombre.getText(),
        	                txtDescripcion.getText());

        	        if (resultado) {

        	            JOptionPane.showMessageDialog(this,
        	                    "Categoría modificada correctamente.");

        	        }

        	    } catch (NumberFormatException e) {

        	        JOptionPane.showMessageDialog(this,
        	                "El id debe ser un número.");

        	    } catch (CategoriaNoEncontradaError e) {

        	        JOptionPane.showMessageDialog(this,
        	                e.getMessage());

        	    }

        	}

        	private void eliminarCategoria() {

        	    if (txtIdCategoria.getText().trim().isEmpty()) {

        	        JOptionPane.showMessageDialog(this,
        	                "Ingrese el id de la categoría.");

        	        return;

        	    }

        	    try {

        	        ControlPrestamos control = ControlPrestamos.getInstancia();

        	        boolean resultado = control.eliminarCategoria(
        	                Integer.parseInt(txtIdCategoria.getText()));

        	        if (resultado) {

        	            JOptionPane.showMessageDialog(this,
        	                    "Categoría eliminada correctamente.");

        	            txtIdCategoria.setText("");
        	            txtNombre.setText("");
        	            txtDescripcion.setText("");

        	        }

        	    } catch (NumberFormatException e) {

        	        JOptionPane.showMessageDialog(this,
        	                "El id debe ser un número.");

        	    } catch (CategoriaNoEncontradaError e) {

        	        JOptionPane.showMessageDialog(this,
        	                e.getMessage());

        	    }

        	}

        	private void listarCategorias() {

        	    ControlPrestamos control = ControlPrestamos.getInstancia();

        	    Collection<Categoria> categorias = control.listarCategorias();

        	    String texto = "";

        	    for (Categoria categoria : categorias) {

        	        texto += "Id: " + categoria.getIdCategoria() + "\n";
        	        texto += "Nombre: " + categoria.getNombre() + "\n";
        	        texto += "Descripción: " + categoria.getDescripcion() + "\n";
        	        texto += ",,,,,,,,,,,,,,,,,,,,,,,,,,\n";

        	    }

        	    if (texto.isEmpty()) {

        	        texto = "No hay categorías registradas.";

        	    }

        	    JTextArea area = new JTextArea(texto);

        	    area.setEditable(false);

        	    JScrollPane scroll = new JScrollPane(area);

        	    JOptionPane.showMessageDialog(this,
        	            scroll,
        	            "Categorías Registradas",
        	            JOptionPane.INFORMATION_MESSAGE);

        	}
    }

   