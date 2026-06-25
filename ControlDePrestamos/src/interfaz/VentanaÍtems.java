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

public class VentanaÍtems extends JFrame {

    private static final long serialVersionUID = 1L;

    public VentanaÍtems() {

        setTitle("Gestión de Ítems");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(20));

        JLabel titulo = new JLabel("Gestión de Ítems");

        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titulo);

        panel.add(Box.createVerticalStrut(30));

        JButton btnRegistrar = new JButton("Registrar");

        btnRegistrar.setMaximumSize(new Dimension(220, 40));

        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnRegistrar);

        panel.add(Box.createVerticalStrut(15));

        JButton btnModificar = new JButton("Modificar");

        btnModificar.setMaximumSize(new Dimension(220, 40));

        btnModificar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnModificar);

        panel.add(Box.createVerticalStrut(15));

        JButton btnEliminar = new JButton("Eliminar");

        btnEliminar.setMaximumSize(new Dimension(220, 40));

        btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnEliminar);

        panel.add(Box.createVerticalStrut(15));

        JButton btnBuscar = new JButton("Buscar");

        btnBuscar.setMaximumSize(new Dimension(220, 40));

        btnBuscar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnBuscar);

        panel.add(Box.createVerticalStrut(15));

        JButton btnListar = new JButton("Listar");

        btnListar.setMaximumSize(new Dimension(220, 40));

        btnListar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnListar);

        panel.add(Box.createVerticalStrut(15));

        JButton btnVolver = new JButton("Volver");

        btnVolver.setMaximumSize(new Dimension(220, 40));

        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnVolver.addActionListener(e -> dispose());

        panel.add(btnVolver);

        add(panel);

        setVisible(true);

    }

}