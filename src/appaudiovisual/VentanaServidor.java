package appaudiovisual;

import javax.swing.*;

public class VentanaServidor extends JFrame {
    public VentanaServidor() {
        setTitle("Servidor Audiovisual");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel lbl = new JLabel("Servidor ejecutándose... espere conexiones", SwingConstants.CENTER);
        add(lbl);

        new Thread(() -> Servidor.main(null)).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaServidor().setVisible(true));
    }
}
