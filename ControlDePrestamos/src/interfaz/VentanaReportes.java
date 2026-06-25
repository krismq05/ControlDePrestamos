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

public class VentanaReportes extends JFrame {

    private static final long serialVersionUID = 1L;

    public VentanaReportes() {

        setTitle("Reportes");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(20));

        JLabel titulo = new JLabel("Módulo de Reportes");

        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titulo);

        panel.add(Box.createVerticalStrut(30));

        JButton btnUsuarios = new JButton("Reporte por Usuarios");

        btnUsuarios.setMaximumSize(new Dimension(250, 40));

        btnUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnUsuarios.setFocusPainted(false);

        panel.add(btnUsuarios);

        panel.add(Box.createVerticalStrut(15));

        JButton btnItems = new JButton("Reporte por Ítems");

        btnItems.setMaximumSize(new Dimension(250, 40));

        btnItems.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnItems.setFocusPainted(false);

        panel.add(btnItems);

        panel.add(Box.createVerticalStrut(15));

        JButton btnCategorias = new JButton("Reporte por Categorías");

        btnCategorias.setMaximumSize(new Dimension(250, 40));

        btnCategorias.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnCategorias.setFocusPainted(false);

        panel.add(btnCategorias);

        panel.add(Box.createVerticalStrut(15));

        JButton btnTipos = new JButton("Reporte por Tipos");

        btnTipos.setMaximumSize(new Dimension(250, 40));

        btnTipos.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnTipos.setFocusPainted(false);

        panel.add(btnTipos);

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