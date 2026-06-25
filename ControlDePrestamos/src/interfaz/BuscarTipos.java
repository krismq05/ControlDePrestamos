package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Control.ControlPrestamos;
import Errores.TipoNoEncontradoError;
import Modelo.Tipo;

public class BuscarTipos extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtIdTipo;
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JCheckBox chkGenerico;

    public BuscarTipos() {

        setTitle("Administrar Tipos");

        setSize(500, 330);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(8, 2, 10, 10));

        JLabel titulo = new JLabel("Administrar Tipos");

        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Id"));

        txtIdTipo = new JTextField();

        panel.add(txtIdTipo);

        panel.add(new JLabel("Nombre"));

        txtNombre = new JTextField();

        panel.add(txtNombre);

        panel.add(new JLabel("Descripción"));

        txtDescripcion = new JTextField();

        panel.add(txtDescripcion);

        panel.add(new JLabel("Genérico"));

        chkGenerico = new JCheckBox();

        panel.add(chkGenerico);

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

        btnBuscar.addActionListener(e -> buscarTipo());

        btnModificar.addActionListener(e -> modificarTipo());

        btnEliminar.addActionListener(e -> eliminarTipo());

        btnListar.addActionListener(e -> listarTipos());

        btnCerrar.addActionListener(e -> dispose());

        add(panel);

        setVisible(true);

    }

    private void buscarTipo() {

        if (txtIdTipo.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese el id del tipo.");

            return;

        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            Tipo tipo = control.obtenerTipo(
                    Integer.parseInt(txtIdTipo.getText()));

            txtNombre.setText(tipo.getNombre());

            txtDescripcion.setText(tipo.getDescripcion());

            chkGenerico.setSelected(tipo.isGenerico());

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "El id debe ser un número.");

        } catch (TipoNoEncontradoError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }

    private void modificarTipo() {

        if (txtIdTipo.getText().trim().isEmpty()
                || txtNombre.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Complete los campos obligatorios.");

            return;

        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            boolean resultado = control.modificarTipo(
                    Integer.parseInt(txtIdTipo.getText()),
                    txtNombre.getText(),
                    txtDescripcion.getText(),
                    chkGenerico.isSelected());

            if (resultado) {

                JOptionPane.showMessageDialog(this,
                        "Tipo modificado correctamente.");

            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "El id debe ser un número.");

        } catch (TipoNoEncontradoError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }

    private void eliminarTipo() {

        if (txtIdTipo.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese el id del tipo.");

            return;

        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            boolean resultado = control.eliminarTipo(
                    Integer.parseInt(txtIdTipo.getText()));

            if (resultado) {

                JOptionPane.showMessageDialog(this,
                        "Tipo eliminado correctamente.");

                txtIdTipo.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                chkGenerico.setSelected(false);

            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "El id debe ser un número.");

        } catch (TipoNoEncontradoError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }

    private void listarTipos() {

        ControlPrestamos control = ControlPrestamos.getInstancia();

        Collection<Tipo> tipos = control.listarTipos();

        String texto = "";

        for (Tipo tipo : tipos) {

            texto += "Id: " + tipo.getIdTipo() + "\n";
            texto += "Nombre: " + tipo.getNombre() + "\n";
            texto += "Descripción: " + tipo.getDescripcion() + "\n";
            texto += "Genérico: " + (tipo.isGenerico() ? "Sí" : "No") + "\n";
            texto += "-----------------------------\n";

        }

        if (texto.isEmpty()) {

            texto = "No hay tipos registrados.";

        }

        JTextArea area = new JTextArea(texto);

        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);

        scroll.setPreferredSize(new java.awt.Dimension(400, 250));

        JOptionPane.showMessageDialog(this,
                scroll,
                "Lista de Tipos",
                JOptionPane.INFORMATION_MESSAGE);

    }

}