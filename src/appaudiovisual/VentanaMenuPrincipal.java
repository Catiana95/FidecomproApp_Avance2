package appaudiovisual;

import javax.swing.*;
import java.awt.*;

public class VentanaMenuPrincipal extends JFrame {
    public VentanaMenuPrincipal() {
        setTitle("Menú Principal - Sistema Audiovisual");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lbl = new JLabel("Bienvenido al sistema audiovisual", SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        add(lbl);
    }
}
