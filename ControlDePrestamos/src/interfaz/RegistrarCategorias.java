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
import Modelo.Categoria;

public class RegistrarCategorias extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtNombre;
    private JTextField txtDescripcion;

    public RegistrarCategorias() {

        setTitle("Registrar Categoría");

        setSize(450,250);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4,2,10,10));

        JLabel titulo = new JLabel("Registrar Categoría");

        titulo.setFont(new Font("Arial",Font.BOLD,16));

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Nombre"));

        txtNombre = new JTextField();

        panel.add(txtNombre);

        panel.add(new JLabel("Descripción"));

        txtDescripcion = new JTextField();

        panel.add(txtDescripcion);

        JButton btnGuardar = new JButton("Guardar");

        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.setFocusPainted(false);

        btnCancelar.setFocusPainted(false);

        panel.add(btnGuardar);

        panel.add(btnCancelar);

        btnGuardar.addActionListener(e -> guardarCategoria());

        btnCancelar.addActionListener(e -> dispose());

        add(panel);

        setVisible(true);

    }

    private void guardarCategoria() {

        if(txtNombre.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(this,
                    "Complete el nombre de la categoría.");

            return;

        }

        ControlPrestamos control = ControlPrestamos.getInstancia();

        Categoria categoria = control.crearCategoria(

                txtNombre.getText(),

                txtDescripcion.getText());

        if(categoria==null){

            JOptionPane.showMessageDialog(this,
                    "No fue posible registrar la categoría.");

            return;

        }

        JOptionPane.showMessageDialog(this,
                "Categoría registrada correctamente.");

        txtNombre.setText("");

        txtDescripcion.setText("");

        txtNombre.requestFocus();

    }

}