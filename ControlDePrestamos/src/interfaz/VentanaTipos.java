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

public class VentanaTipos extends JFrame {

    private static final long serialVersionUID = 1L;

    public VentanaTipos() {

        setTitle("Gestión de Tipos");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(20));

        JLabel titulo = new JLabel("Gestión de Tipos");

        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titulo);

        panel.add(Box.createVerticalStrut(30));

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setMaximumSize(new Dimension(220, 40));
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistrar.setFocusPainted(false);
        panel.add(btnRegistrar);

        panel.add(Box.createVerticalStrut(15));

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setMaximumSize(new Dimension(220, 40));
        btnModificar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnModificar.setFocusPainted(false);
        panel.add(btnModificar);

        panel.add(Box.createVerticalStrut(15));

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setMaximumSize(new Dimension(220, 40));
        btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEliminar.setFocusPainted(false);
        panel.add(btnEliminar);

        panel.add(Box.createVerticalStrut(15));

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setMaximumSize(new Dimension(220, 40));
        btnBuscar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBuscar.setFocusPainted(false);
        panel.add(btnBuscar);

        panel.add(Box.createVerticalStrut(15));

        JButton btnListar = new JButton("Listar");
        btnListar.setMaximumSize(new Dimension(220, 40));
        btnListar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnListar.setFocusPainted(false);
        panel.add(btnListar);

        panel.add(Box.createVerticalStrut(15));

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