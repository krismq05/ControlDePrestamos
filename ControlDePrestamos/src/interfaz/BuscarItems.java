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
import Errores.ItemNoEncontradoError;
import Modelo.Item;

public class BuscarItems extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtIdItem;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JTextField txtIdTipo;

    public BuscarItems() {

        setTitle("Administrar Ítems");

        setSize(500, 380);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(9, 2, 10, 10));

        JLabel titulo = new JLabel("Administrar Ítems");

        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Id Ítem"));

        txtIdItem = new JTextField();

        panel.add(txtIdItem);

        panel.add(new JLabel("Código"));

        txtCodigo = new JTextField();

        panel.add(txtCodigo);

        panel.add(new JLabel("Nombre"));

        txtNombre = new JTextField();

        panel.add(txtNombre);

        panel.add(new JLabel("Descripción"));

        txtDescripcion = new JTextField();

        panel.add(txtDescripcion);

        panel.add(new JLabel("Id Tipo"));

        txtIdTipo = new JTextField();

        panel.add(txtIdTipo);

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

        btnBuscar.addActionListener(e -> buscarItem());

        btnModificar.addActionListener(e -> modificarItem());

        btnEliminar.addActionListener(e -> eliminarItem());

        btnListar.addActionListener(e -> listarItems());

        btnCerrar.addActionListener(e -> dispose());

        add(panel);

        setVisible(true);

    }

    private void buscarItem() {

        if (txtIdItem.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese el id del ítem.");

            return;
        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            int idItem = Integer.parseInt(txtIdItem.getText());

            Item item = control.obtenerItem(idItem);

            if (item == null) {

                JOptionPane.showMessageDialog(this,
                        "No existe un ítem con ese id.");

                return;
            }

            txtCodigo.setText(item.getCodigo());

            txtNombre.setText(item.getNombre());

            txtDescripcion.setText(item.getDescripcion());

            if (item.getTipo() != null) {

                txtIdTipo.setText(String.valueOf(item.getTipo().getIdTipo()));

            } else {

                txtIdTipo.setText("");

            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "El id del ítem debe ser un número.");

        }

    }

    private void modificarItem() {

        if (txtIdItem.getText().trim().isEmpty()
                || txtCodigo.getText().trim().isEmpty()
                || txtNombre.getText().trim().isEmpty()
                || txtIdTipo.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Complete los campos obligatorios.");

            return;
        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            boolean resultado = control.modificarItem(
                    Integer.parseInt(txtIdItem.getText()),
                    txtCodigo.getText(),
                    txtNombre.getText(),
                    txtDescripcion.getText(),
                    Integer.parseInt(txtIdTipo.getText()));

            if (resultado) {

                JOptionPane.showMessageDialog(this,
                        "Ítem modificado correctamente.");

            } else {

                JOptionPane.showMessageDialog(this,
                        "No se pudo modificar el ítem. Verifique el tipo.");

            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Los identificadores deben ser numéricos.");

        } catch (ItemNoEncontradoError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }

    private void eliminarItem() {

        if (txtIdItem.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese el id del ítem.");

            return;
        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            boolean resultado = control.eliminarItem(
                    Integer.parseInt(txtIdItem.getText()));

            if (resultado) {

                JOptionPane.showMessageDialog(this,
                        "Ítem eliminado correctamente.");

                limpiarCampos();

            } else {

                JOptionPane.showMessageDialog(this,
                        "No se puede eliminar el ítem porque está prestado.");

            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "El id del ítem debe ser un número.");

        } catch (ItemNoEncontradoError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }

    private void listarItems() {

        ControlPrestamos control = ControlPrestamos.getInstancia();

        Collection<Item> items = control.listarItems();

        String texto = "";

        for (Item item : items) {

            texto += "Id: " + item.getIdItem() + "\n";
            texto += "Código: " + item.getCodigo() + "\n";
            texto += "Nombre: " + item.getNombre() + "\n";
            texto += "Descripción: " + item.getDescripcion() + "\n";
            texto += "Prestado: " + (item.isPrestado() ? "Sí" : "No") + "\n";

            if (item.getTipo() != null) {

                texto += "Tipo: " + item.getTipo().getNombre() + "\n";

            }

            texto += ",,,,,,,,,,,,,,,,,,,,,,,,,,,,\n";

        }

        if (texto.isEmpty()) {

            texto = "No hay ítems registrados.";

        }

        JTextArea area = new JTextArea(texto);

        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);

        scroll.setPreferredSize(new java.awt.Dimension(400, 250));

        JOptionPane.showMessageDialog(this,
                scroll,
                "Lista de Ítems",
                JOptionPane.INFORMATION_MESSAGE);

    }

    private void limpiarCampos() {

        txtIdItem.setText("");
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtIdTipo.setText("");

    }

}