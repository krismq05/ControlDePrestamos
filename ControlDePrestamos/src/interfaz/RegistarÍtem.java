package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Control.ControlPrestamos;
import Modelo.Item;

public class RegistarÍtem extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JTextField txtTipo;

    public RegistarÍtem() {

        setTitle("Registrar Ítem");

        setSize(450,320);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(6,2,10,10));

        JLabel titulo = new JLabel("Registrar Ítem");

        titulo.setFont(new Font("Arial",Font.BOLD,16));

        panel.add(titulo);
        panel.add(new JLabel(""));

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

        txtTipo = new JTextField();

        panel.add(txtTipo);

        JButton btnGuardar = new JButton("Guardar");

        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.setFocusPainted(false);

        btnCancelar.setFocusPainted(false);

        panel.add(btnGuardar);

        panel.add(btnCancelar);

        btnGuardar.addActionListener(e -> guardarItem());

        btnCancelar.addActionListener(e -> dispose());

        add(panel);

        setVisible(true);

    }
    private void guardarItem() {

        if (txtCodigo.getText().trim().isEmpty()
                || txtNombre.getText().trim().isEmpty()
                || txtTipo.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Complete los campos obligatorios.");

            return;
        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            Item item = control.crearItem(
                    txtCodigo.getText(),
                    txtNombre.getText(),
                    txtDescripcion.getText(),
                    Integer.parseInt(txtTipo.getText()));

            if (item == null) {

                JOptionPane.showMessageDialog(this,
                        "No se pudo registrar el ítem. Verifique el id del tipo.");

                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Ítem registrado correctamente.");

            txtCodigo.setText("");
            txtNombre.setText("");
            txtDescripcion.setText("");
            txtTipo.setText("");

            txtCodigo.requestFocus();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "El id del tipo debe ser un número.");

        }

    } 
}