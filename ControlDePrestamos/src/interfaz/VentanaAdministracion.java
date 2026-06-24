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

public class VentanaAdministracion extends JFrame {

    private static final long serialVersionUID = 1L;

    public VentanaAdministracion() {

        setTitle("Administración");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(20));

        JLabel titulo = new JLabel("Administración");

        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titulo);

        panel.add(Box.createVerticalStrut(20));

        JButton btnPersonas = new JButton("Personas");
        btnPersonas.addActionListener(e -> {

            new VentanaPersonas();

        });

        btnPersonas.setMaximumSize(new Dimension(220, 40));

        btnPersonas.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnPersonas);

        panel.add(Box.createVerticalStrut(15));

        JButton btnItems = new JButton("Ítems");

        btnItems.setMaximumSize(new Dimension(220, 40));

        btnItems.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnItems);

        panel.add(Box.createVerticalStrut(15));

        JButton btnCategorias = new JButton("Categorías");

        btnCategorias.setMaximumSize(new Dimension(220, 40));

        btnCategorias.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnCategorias);

        panel.add(Box.createVerticalStrut(15));

        JButton btnTipos = new JButton("Tipos");

        btnTipos.setMaximumSize(new Dimension(220, 40));

        btnTipos.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnTipos);

        add(panel);

        setVisible(true);

    }

}