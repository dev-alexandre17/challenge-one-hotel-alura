package br.com.hotel.alura.api.views;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainPanel extends JFrame {

    private JLabel backgroundLabel;
    private JLabel hotelLabel;

    private JLabel loginLabel;

    private JLabel textLoginLabel;

    private JPanel mainPanel;

    private JLabel textCopyrightLabel;
    private JLabel backgroundCopyrightLabel;
    private JLabel exitLabel;

    public MainPanel() {
        super("Menu");

        editFrame();

        addComponents();

        editDimensionFrame();

    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        return panel;
    }

    private JLabel createTextLogin() {
        textLoginLabel = new JLabel("LOGIN");
        textLoginLabel.setForeground(Color.decode("#007FFF"));
        return textLoginLabel;
    }

    private JLabel createTextCopyright() {
        textCopyrightLabel = new JLabel("Desenvolvido por Alexandre Gonçalo © 2023");
        textCopyrightLabel.setForeground(Color.BLACK);
        return textCopyrightLabel;
    }

    private ImageIcon loadBackgroundImage() throws IOException {
        return new ImageIcon("src/assets/img/menu-img.png");
    }

    private ImageIcon loadHotelImage() throws IOException {
        return new ImageIcon("src/assets/img/aH-150px.png");
    }

    private ImageIcon loadLoginImage() throws IOException {
        return new ImageIcon("src/assets/img/login.png");
    }

    private ImageIcon loadbackgroundCopyrightImage() throws IOException {
        return new ImageIcon("src/assets/img/backgroundCopyright.png");
    }

    private ImageIcon loadExitImage() throws IOException {
        return new ImageIcon("src/assets/img/saida.png");
    }

    private ImageIcon editBackgroundImage() throws IOException {
        Image editBackgroundImage = loadBackgroundImage().getImage();
        Image scaledBackgroundImage = editBackgroundImage.getScaledInstance(800, 750,
                Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundIcon = new ImageIcon(scaledBackgroundImage);
        return scaledBackgroundIcon;
    }

    private ImageIcon editBackgroundCopyrightImage() throws IOException {
        Image editBackgroundCopyrightImage = loadbackgroundCopyrightImage().getImage();
        Image scaledBackgroundCopyright = editBackgroundCopyrightImage.getScaledInstance(1000, 40,
                Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundCopyrightIcon = new ImageIcon(scaledBackgroundCopyright);
        return scaledBackgroundCopyrightIcon;
    }

    private void addComponents() {
        try {
            backgroundLabel = new JLabel(editBackgroundImage());
            hotelLabel = new JLabel(loadHotelImage());
            loginLabel = new JLabel(loadLoginImage());
            backgroundCopyrightLabel = new JLabel(editBackgroundCopyrightImage());
            exitLabel = new JLabel(loadExitImage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o componente: "
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        mainPanel = createMainPanel();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(-150, -350, 0, 0);
        mainPanel.add(backgroundLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(-820, 0, 0, -700);
        mainPanel.add(hotelLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(-450, 0, 0, -700);
        mainPanel.add(loginLabel, c);

        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(-550, 0, 0, -700);
        mainPanel.add(createTextLogin(), c);

        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(0, 0, -35, 0);
        mainPanel.add(createTextCopyright(), c);

        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(0,0,0,0);
        mainPanel.add(backgroundCopyrightLabel, c);

        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(-200, 0, 0, -800);
        mainPanel.add(exitLabel, c);

        add(mainPanel);

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