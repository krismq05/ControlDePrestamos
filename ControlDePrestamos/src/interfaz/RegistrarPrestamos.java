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
import Errores.PersonaNoEncontradaError;


public class RegistrarPrestamos extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtIdentificacion;

    public RegistrarPrestamos() {

        setTitle("Registrar Préstamo");

        setSize(420,200);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3,2,10,10));

        JLabel titulo = new JLabel("Registrar Préstamo");

        titulo.setFont(new Font("Arial", Font.BOLD,16));

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Identificación"));

        txtIdentificacion = new JTextField();

        panel.add(txtIdentificacion);

        JButton btnGuardar = new JButton("Guardar");

        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.setFocusPainted(false);

        btnCancelar.setFocusPainted(false);

        panel.add(btnGuardar);

        panel.add(btnCancelar);

        btnGuardar.addActionListener(e -> guardarPrestamo());

        btnCancelar.addActionListener(e -> dispose());

        add(panel);

        setVisible(true);

    }

    private void guardarPrestamo() {

        if(txtIdentificacion.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(this,
                    "Ingrese la identificación.");

            return;

        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

                    control.crearPrestamo(
                    txtIdentificacion.getText());

            JOptionPane.showMessageDialog(this,
                    "Préstamo registrado correctamente.");

            txtIdentificacion.setText("");

            txtIdentificacion.requestFocus();

        } catch (PersonaNoEncontradaError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }

}
