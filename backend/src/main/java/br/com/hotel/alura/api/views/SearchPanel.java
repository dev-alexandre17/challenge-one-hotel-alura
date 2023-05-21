package br.com.hotel.alura.api.views;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JFrame {

    public SearchPanel() {
        super("Buscar");

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
