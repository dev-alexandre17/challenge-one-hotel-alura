package br.com.hotel.alura.api.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class MenuPanel extends JFrame {

    private JLabel backgroundLabel;
    private JLabel hotelLabel;
    private JPanel menuPanel;
    private JLabel textCopyrightLabel;
    private JLabel backgroundCopyrightLabel;
    private JFrame frame;
    private JLabel textReservationLabel;
    private JLabel textSearchLabel;
    private JLabel reservationLabel;
    private JLabel searchLabel;

    public MenuPanel() {
        super("Menu Principal");

        editFrame();

        addComponents();

        eventFrame();

        editDimensionFrame();

        reservationFrame();

        searchFrame();

    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        return panel;
    }

    private JLabel createTextReservation() {
        textReservationLabel = new JLabel("Reservas");
        textReservationLabel.setForeground(Color.decode("#007FFF"));
        textReservationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        return textReservationLabel;
    }

    private JLabel createTextSearch() {
        textSearchLabel = new JLabel("Buscar");
        textSearchLabel.setForeground(Color.decode("#007FFF"));
        textSearchLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        return textSearchLabel;
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

    private ImageIcon loadBackgroundCopyrightImage() throws IOException {
        return new ImageIcon("src/assets/img/backgroundCopyright.png");
    }

    private ImageIcon loadReservationImage() throws IOException {
        return new ImageIcon("src/assets/img/icon-reservas.png");
    }

    private ImageIcon loadSearchImage() throws IOException {
        return new ImageIcon("src/assets/img/icon-buscar.png");
    }

    private ImageIcon editBackgroundImage() throws IOException {
        Image editBackgroundImage = loadBackgroundImage().getImage();
        Image scaledBackgroundImage = editBackgroundImage.getScaledInstance(800, 750,
                Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundIcon = new ImageIcon(scaledBackgroundImage);
        return scaledBackgroundIcon;
    }

    private ImageIcon editBackgroundCopyrightImage() throws IOException {
        Image editBackgroundCopyrightImage = loadBackgroundCopyrightImage().getImage();
        Image scaledBackgroundCopyright = editBackgroundCopyrightImage.getScaledInstance(1000, 40,
                Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundCopyrightIcon = new ImageIcon(scaledBackgroundCopyright);
        return scaledBackgroundCopyrightIcon;
    }

    private void addComponents() {
        try {
            backgroundLabel = new JLabel(editBackgroundImage());
            hotelLabel = new JLabel(loadHotelImage());
            backgroundCopyrightLabel = new JLabel(editBackgroundCopyrightImage());
            reservationLabel = new JLabel(loadReservationImage());
            searchLabel = new JLabel(loadSearchImage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o componente: "
                + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        menuPanel = createMenuPanel();

        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(-150, -350, 0, 0);
        menuPanel.add(backgroundLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(-970, 0, 0, -700);
        menuPanel.add(hotelLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0, 0, -35, 0);
        menuPanel.add(createTextCopyright(), c);

        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 0, 0);
        menuPanel.add(backgroundCopyrightLabel, c);

        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(-800, 0, 0, -700);
        menuPanel.add(createTextReservation(), c);

        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(-500, 0, 0, -700);
        menuPanel.add(createTextSearch(), c);

        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(-680, 0, 0, -700);
        menuPanel.add(reservationLabel, c);

        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(-370, 0, 0, -700);
        menuPanel.add(searchLabel, c);

        add(menuPanel);

    }

    private void eventFrame() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(frame, "Deseja fechar a aplicação?",
                        "Messagem de confirmação", JOptionPane.YES_NO_CANCEL_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    e.getWindow().dispose();
                } else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    private void reservationFrame() {
        reservationLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reservationLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reservationLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                ReservationPanel reservationPanel = new ReservationPanel();
                dispose();
            }
        });
    }

    private void searchFrame() {
        searchLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                searchLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                SearchPanel searchPanel = new SearchPanel();
                dispose();
            }
        });
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

