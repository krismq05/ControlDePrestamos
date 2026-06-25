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
import Errores.ItemNoEncontradoError;
import Errores.ItemYaPrestadaError;
import Errores.PrestamoFinalizadoError;
import Errores.PrestamoNoEncontradoError;

public class AgregarItemPrestamo extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtIdPrestamo;
    private JTextField txtIdItem;

    public AgregarItemPrestamo() {

        setTitle("Agregar Ítem al Préstamo");

        setSize(450,250);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4,2,10,10));

        JLabel titulo = new JLabel("Agregar Ítem al Préstamo");

        titulo.setFont(new Font("Arial", Font.BOLD,16));

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Id Préstamo"));

        txtIdPrestamo = new JTextField();

        panel.add(txtIdPrestamo);

        panel.add(new JLabel("Id Ítem"));

        txtIdItem = new JTextField();

        panel.add(txtIdItem);

        JButton btnGuardar = new JButton("Guardar");

        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.setFocusPainted(false);

        btnCancelar.setFocusPainted(false);

        panel.add(btnGuardar);

        panel.add(btnCancelar);

        btnGuardar.addActionListener(e -> agregarItem());

        btnCancelar.addActionListener(e -> dispose());

        add(panel);

        setVisible(true);

    }

    private void agregarItem() {

        if (txtIdPrestamo.getText().trim().isEmpty()
                || txtIdItem.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Complete todos los campos.");

            return;

        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            control.agregarItemPrestamo(
                    Integer.parseInt(txtIdPrestamo.getText()),
                    Integer.parseInt(txtIdItem.getText()));

            JOptionPane.showMessageDialog(this,
                    "Ítem agregado correctamente.");

            txtIdPrestamo.setText("");
            txtIdItem.setText("");

            txtIdPrestamo.requestFocus();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Los identificadores deben ser numéricos.");

        } catch (PrestamoNoEncontradoError
                | ItemNoEncontradoError
                | ItemYaPrestadaError
                | PrestamoFinalizadoError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }

}