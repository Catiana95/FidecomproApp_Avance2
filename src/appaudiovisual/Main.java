package appaudiovisual;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaInicioSesion().setVisible(true);
        });
    }
}
