package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Control.ControlPrestamos;
import Modelo.Tipo;

public class RegistrarTipos extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JCheckBox chkGenerico;

    public RegistrarTipos() {

        setTitle("Registrar Tipo");

        setSize(450,300);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5,2,10,10));

        JLabel titulo = new JLabel("Registrar Tipo");

        titulo.setFont(new Font("Arial", Font.BOLD,16));

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Nombre"));

        txtNombre = new JTextField();

        panel.add(txtNombre);

        panel.add(new JLabel("Descripción"));

        txtDescripcion = new JTextField();

        panel.add(txtDescripcion);

        panel.add(new JLabel("Genérico"));

        chkGenerico = new JCheckBox();

        panel.add(chkGenerico);

        JButton btnGuardar = new JButton("Guardar");

        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.setFocusPainted(false);

        btnCancelar.setFocusPainted(false);

        panel.add(btnGuardar);

        panel.add(btnCancelar);

        btnGuardar.addActionListener(e -> guardarTipo());

        btnCancelar.addActionListener(e -> dispose());

        add(panel);

        setVisible(true);

    }

    private void guardarTipo() {

        if(txtNombre.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(this,
                    "Complete el nombre del tipo.");

            return;

        }

        ControlPrestamos control = ControlPrestamos.getInstancia();

        Tipo tipo = control.crearTipo(

                txtNombre.getText(),

                txtDescripcion.getText(),

                chkGenerico.isSelected());

        if(tipo==null){

            JOptionPane.showMessageDialog(this,
                    "No fue posible registrar el tipo.");

            return;

        }

        JOptionPane.showMessageDialog(this,
                "Tipo registrado correctamente.");

        txtNombre.setText("");

        txtDescripcion.setText("");

        chkGenerico.setSelected(false);

        txtNombre.requestFocus();

    }

}