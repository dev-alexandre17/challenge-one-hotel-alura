package br.com.hotel.alura.api.views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JFrame {

    private Image imagem;

    public MainPanel() {
        super("Menu");

        panel();

        loadBackgroundImage();

        backgroundImageComponent();

        addBackgroundImageComponent();

        dimensionPanel();

    }

    private void loadBackgroundImage() {
        try {
            imagem = ImageIO.read(new File("src/assets/img/menu-img.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JPanel backgroundImageComponent() {
        JPanel painelImagem = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagem, 0, 0, null);
            }
        };
        return painelImagem;
    }

    private void addBackgroundImageComponent() {
        add(backgroundImageComponent());
    }

    private void dimensionPanel() {
        Dimension sizeFrame = new Dimension(1000, 700);
        setPreferredSize(sizeFrame);
        pack();
    }

    private void panel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}


