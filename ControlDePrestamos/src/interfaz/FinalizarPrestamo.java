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
import Errores.PrestamoNoEncontradoError;

public class FinalizarPrestamo extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtIdPrestamo;

    public FinalizarPrestamo() {

        setTitle("Finalizar Préstamo");

        setSize(420,200);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3,2,10,10));

        JLabel titulo = new JLabel("Finalizar Préstamo");

        titulo.setFont(new Font("Arial", Font.BOLD,16));

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Id Préstamo"));

        txtIdPrestamo = new JTextField();

        panel.add(txtIdPrestamo);

        JButton btnFinalizar = new JButton("Finalizar");

        JButton btnCancelar = new JButton("Cancelar");

        btnFinalizar.setFocusPainted(false);

        btnCancelar.setFocusPainted(false);

        panel.add(btnFinalizar);

        panel.add(btnCancelar);

        btnFinalizar.addActionListener(e -> finalizarPrestamo());

        btnCancelar.addActionListener(e -> dispose());

        add(panel);

        setVisible(true);

    }

    private void finalizarPrestamo() {

        if (txtIdPrestamo.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese el id del préstamo.");

            return;

        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            control.finalizarPrestamo(
                    Integer.parseInt(txtIdPrestamo.getText()));

            JOptionPane.showMessageDialog(this,
                    "Préstamo finalizado correctamente.");

            txtIdPrestamo.setText("");

            txtIdPrestamo.requestFocus();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "El id debe ser un número.");

        } catch (PrestamoNoEncontradoError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }

}