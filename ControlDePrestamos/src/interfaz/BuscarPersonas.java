package interfaz;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BuscarPersonas extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtIdentificacion;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtCorreo;

    public BuscarPersonas() {

        setTitle("Administrar Personas");

        setSize(450, 300);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(7, 2, 10, 10));

        JLabel titulo = new JLabel("Administrar Personas");

        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Identificación"));

        txtIdentificacion = new JTextField();

        panel.add(txtIdentificacion);

        panel.add(new JLabel("Nombre"));

        txtNombre = new JTextField();

        panel.add(txtNombre);

        panel.add(new JLabel("Teléfono"));

        txtTelefono = new JTextField();

        panel.add(txtTelefono);

        panel.add(new JLabel("Correo"));

        txtCorreo = new JTextField();

        panel.add(txtCorreo);

        JButton btnBuscar = new JButton("Buscar");

        JButton btnModificar = new JButton("Modificar");

        JButton btnEliminar = new JButton("Eliminar");

        panel.add(btnBuscar);

        panel.add(btnModificar);

        panel.add(btnEliminar);

        add(panel);

        setVisible(true);

    }

}