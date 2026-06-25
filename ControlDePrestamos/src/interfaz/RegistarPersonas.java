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
import Errores.PersonaDuplicadaError;

public class RegistarPersonas extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtNombre;
    private JTextField txtIdentificacion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;

    public RegistarPersonas() {

        setTitle("Registrar Persona");

        setSize(450, 300);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel titulo = new JLabel("Registrar Persona");

        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Nombre"));

        txtNombre = new JTextField();

        panel.add(txtNombre);

        panel.add(new JLabel("Identificación"));

        txtIdentificacion = new JTextField();

        panel.add(txtIdentificacion);

        panel.add(new JLabel("Teléfono"));

        txtTelefono = new JTextField();

        panel.add(txtTelefono);

        panel.add(new JLabel("Correo"));

        txtCorreo = new JTextField();

        panel.add(txtCorreo);

        JButton btnGuardar = new JButton("Guardar");

        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.setFocusPainted(false);

        btnCancelar.setFocusPainted(false);

        panel.add(btnGuardar);

        panel.add(btnCancelar);

        btnGuardar.addActionListener(e -> guardarPersona());

        btnCancelar.addActionListener(e -> dispose());

        add(panel);

        setVisible(true);

    }

    private void guardarPersona() {

        if (txtNombre.getText().trim().isEmpty()
                || txtIdentificacion.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Complete los campos obligatorios.");

            return;
        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            control.crearPersona(
                    txtNombre.getText(),
                    txtIdentificacion.getText(),
                    txtTelefono.getText(),
                    txtCorreo.getText());

            JOptionPane.showMessageDialog(this,
                    "Persona registrada correctamente.");

            txtNombre.setText("");
            txtIdentificacion.setText("");
            txtTelefono.setText("");
            txtCorreo.setText("");

        } catch (PersonaDuplicadaError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }
}