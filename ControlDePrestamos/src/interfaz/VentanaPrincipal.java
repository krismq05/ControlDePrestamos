package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;

    public VentanaPrincipal() {

        setTitle("Sistema de Control de Prestamos");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Sistema de Control de Préstamos");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        add(titulo, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BorderLayout());

        JLabel menu = new JLabel("Menú Principal");
        menu.setHorizontalAlignment(SwingConstants.CENTER);
        menu.setFont(new Font("Arial", Font.PLAIN, 18));

        panelCentro.add(menu, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();

        panelBotones.setLayout(new GridLayout(3, 1, 0, 2));

        JButton btnAdministracion = new JButton("Administración");
        btnAdministracion.addActionListener(e -> {

            new VentanaAdministracion();

        });
        
        JButton btnPrestamos = new JButton("Préstamos");
        btnPrestamos.addActionListener(e -> {

            new VentanaPrestamos();

        });
        JButton btnReportes = new JButton("Reportes");

        Dimension tamaño = new Dimension(220, 40);

        btnAdministracion.setPreferredSize(tamaño);
        btnPrestamos.setPreferredSize(tamaño);
        btnReportes.setPreferredSize(tamaño);

        JPanel fila1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel fila2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel fila3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        fila1.add(btnAdministracion);
        fila2.add(btnPrestamos);
        fila3.add(btnReportes);

        panelBotones.add(fila1);
        panelBotones.add(fila2);
        panelBotones.add(fila3);

        panelCentro.add(panelBotones, BorderLayout.CENTER);

        add(panelCentro, BorderLayout.CENTER);

        JLabel pie = new JLabel("Control de Préstamos");
        pie.setHorizontalAlignment(SwingConstants.RIGHT);
        pie.setFont(new Font("Arial", Font.PLAIN, 12));

        add(pie, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {

        new VentanaPrincipal();

    }

}