package br.com.hotel.alura.api.views;

import javax.swing.*;
import java.awt.*;

public class ReservationPanel extends JFrame {

    public ReservationPanel() {
        super("Reserva");

        editDimensionFrame();

        editFrame();

    }

    private void editDimensionFrame() {
        setPreferredSize(new Dimension(950, 675));
        pack();
    }

    private void editFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
