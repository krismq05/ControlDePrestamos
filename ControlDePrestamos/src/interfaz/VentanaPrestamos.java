package interfaz;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrestamos extends JFrame {

    private static final long serialVersionUID = 1L;

    public VentanaPrestamos() {

        setTitle("Préstamos");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(20));

        JLabel titulo = new JLabel("Módulo de Préstamos");

        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titulo);

        panel.add(Box.createVerticalStrut(40));

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.addActionListener(e -> {

            new RegistrarPrestamos();

        });

        btnNuevo.setMaximumSize(new Dimension(220, 40));

        btnNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnNuevo.setFocusPainted(false);

        panel.add(btnNuevo);

        panel.add(Box.createVerticalStrut(20));

        JButton btnAgregarItem = new JButton("Agregar Item");
        btnAgregarItem.addActionListener(e -> {

            new AgregarItemPrestamo();

        });
        
        btnAgregarItem.setMaximumSize(new Dimension(220, 40));

        btnAgregarItem.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnAgregarItem.setFocusPainted(false);

        panel.add(btnAgregarItem);

        panel.add(Box.createVerticalStrut(20));

        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.addActionListener(e -> {

            new FinalizarPrestamo();

        });

        btnFinalizar.setMaximumSize(new Dimension(220, 40));

        btnFinalizar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnFinalizar.setFocusPainted(false);

        panel.add(btnFinalizar);

        panel.add(Box.createVerticalStrut(20));

        JButton btnVolver = new JButton("Volver");

        btnVolver.setMaximumSize(new Dimension(220, 40));

        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnVolver.setFocusPainted(false);

        btnVolver.addActionListener(e -> dispose());

        panel.add(btnVolver);

        add(panel);

        setVisible(true);

    }

}