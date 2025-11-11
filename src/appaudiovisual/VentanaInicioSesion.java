package appaudiovisual;

import javax.swing.*;
import java.awt.*;

public class VentanaInicioSesion extends JFrame {
    private JTextField txtEmail;
    private JPasswordField txtContrasena;

    public VentanaInicioSesion() {
        setTitle("Inicio de Sesión");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setLayout(new GridLayout(4, 2));

        txtEmail = new JTextField();
        txtContrasena = new JPasswordField();
        JButton btnLogin = new JButton("Iniciar Sesión");
        JButton btnCrear = new JButton("Crear Usuario");

        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Contraseña:"));
        add(txtContrasena);
        add(btnLogin);
        add(btnCrear);

        // Acción del botón Iniciar Sesión
        btnLogin.addActionListener(e -> {
            String email = txtEmail.getText().trim();
            String contrasena = new String(txtContrasena.getPassword()).trim();

            if (email.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos.");
                return;
            }

            String respuesta = Cliente.iniciarSesion(email, contrasena);
            JOptionPane.showMessageDialog(this, respuesta);

            if (respuesta != null && respuesta.startsWith("BIENVENIDO")) {
                new VentanaMenuPrincipal().setVisible(true);
                dispose();
            }
        });

        // Acción del botón Crear Usuario
        btnCrear.addActionListener(e -> {
            new VentanaCrearUsuario().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaInicioSesion().setVisible(true));
    }
}
