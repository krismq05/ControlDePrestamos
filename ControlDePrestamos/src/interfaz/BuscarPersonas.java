package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import Control.ControlPrestamos;
import Errores.PersonaNoEncontradaError;
import Modelo.Persona;
import java.util.Collection;

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
        btnBuscar.addActionListener(e -> buscarPersona());

        btnModificar.addActionListener(e -> modificarPersona());

        btnEliminar.addActionListener(e -> eliminarPersona());

        panel.add(btnBuscar);

        panel.add(btnModificar);

        panel.add(btnEliminar);

        add(panel);

        setVisible(true);

    }
    private void buscarPersona() {

        if (txtIdentificacion.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese la identificación.");

            return;
        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            Persona persona = control.obtenerPersona(
                    txtIdentificacion.getText());

            txtNombre.setText(persona.getNombre());

            txtTelefono.setText(persona.getTelefono());

            txtCorreo.setText(persona.getCorreo());

        } catch (PersonaNoEncontradaError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }
    private void modificarPersona() {

        if (txtIdentificacion.getText().trim().isEmpty()
                || txtNombre.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Complete la identificación y el nombre.");

            return;
        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            boolean resultado = control.modificarPersona(
                    txtIdentificacion.getText(),
                    txtNombre.getText(),
                    txtTelefono.getText(),
                    txtCorreo.getText());

            if (resultado) {

                JOptionPane.showMessageDialog(this,
                        "Persona modificada correctamente.");

            } else {

                JOptionPane.showMessageDialog(this,
                        "No se pudo modificar la persona.");

            }

        } catch (PersonaNoEncontradaError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }
    private void eliminarPersona() {

        if (txtIdentificacion.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese la identificación.");

            return;
        }

        try {

            ControlPrestamos control = ControlPrestamos.getInstancia();

            boolean resultado = control.eliminarPersona(
                    txtIdentificacion.getText());

            if (resultado) {

                JOptionPane.showMessageDialog(this,
                        "Persona eliminada correctamente.");

                limpiarCampos();

            } else {

                JOptionPane.showMessageDialog(this,
                        "No se puede eliminar la persona porque tiene préstamos activos.");

            }

        } catch (PersonaNoEncontradaError e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }

    }
    private void listarPersonas() {

        ControlPrestamos control = ControlPrestamos.getInstancia();

        Collection<Persona> personas = control.listarPersonas();

        String texto = "";

        for (Persona persona : personas) {

            texto += "Nombre: " + persona.getNombre() + "\n";
            texto += "Identificación: " + persona.getIdentificacion() + "\n";
            texto += "Teléfono: " + persona.getTelefono() + "\n";
            texto += "Correo: " + persona.getCorreo() + "\n";
            texto += ",,,,,,,,,,,,,,,,,,,,,,,,,,,\n";

        }

        if (texto.isEmpty()) {

            texto = "No hay personas registradas.";

        }

        JTextArea area = new JTextArea(texto);

        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);

        scroll.setPreferredSize(new java.awt.Dimension(400, 250));

        JOptionPane.showMessageDialog(this,
                scroll,
                "Lista de Personas",
                JOptionPane.INFORMATION_MESSAGE);

    }
    private void limpiarCampos() {

        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");

    }

}