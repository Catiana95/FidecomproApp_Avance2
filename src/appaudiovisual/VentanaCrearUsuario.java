package appaudiovisual;

import javax.swing.*;
import java.awt.*;

public class VentanaCrearUsuario extends JFrame {
    private JTextField txtNombre, txtEmail, txtContrasena;

    public VentanaCrearUsuario() {
        setTitle("Crear Usuario");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        txtNombre = new JTextField();
        txtEmail = new JTextField();
        txtContrasena = new JTextField();
        JButton btnGuardar = new JButton("Guardar");
        JButton btnVolver = new JButton("Volver");

        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Contraseña:"));
        add(txtContrasena);
        add(btnGuardar);
        add(btnVolver);

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String email = txtEmail.getText();
            String contrasena = txtContrasena.getText();

            String respuesta = Cliente.crearUsuario(nombre, email, contrasena);
            JOptionPane.showMessageDialog(this, respuesta);

            if (respuesta.contains("EXITOSAMENTE")) {
                new VentanaInicioSesion().setVisible(true);
                dispose();
            }
        });
    }
}
