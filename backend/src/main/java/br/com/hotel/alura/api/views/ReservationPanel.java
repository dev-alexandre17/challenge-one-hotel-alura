package br.com.hotel.alura.api.views;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.Locale;

public class ReservationPanel extends JFrame {

    private JLabel backgroundLabel;
    private JPanel reservationPanel;
    private JFrame frame;
    private JLabel hotelLabel;
    private JLabel textTitleLabel;
    private JLabel textCheckInLabel;
    private JLabel textCheckOutLabel;
    private JXDatePicker dateCheckIn;
    private JXDatePicker dateCheckOut;
    private JFormattedTextField textFieldReservation;
    private JLabel textReservationLabel;
    private JLabel textPaymentLabel;
    private JComboBox comboBoxPaymentLabel;
    private JButton buttonContinue;
    private double valueInput;
    public ReservationPanel() {
        super("Reserva");

        eventFrame();

        addComponents();

        editDimensionFrame();

        editFrame();

        eventButton();

    }

    private JPanel createReservationPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        return panel;
    }

    private JLabel createTitle() {
        textTitleLabel = new JLabel("Sistema de Reservas");
        textTitleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        textTitleLabel.setForeground(Color.decode("#007FFF"));
        return textTitleLabel;
    }

    private JLabel createCheckIn() {
        textCheckInLabel = new JLabel("Data de Check In");
        textCheckInLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textCheckInLabel.setForeground(Color.decode("#007FFF"));
        return textCheckInLabel;
    }

    private JLabel createCheckOut() {
        textCheckOutLabel = new JLabel("Data de Check Out");
        textCheckOutLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textCheckOutLabel.setForeground(Color.decode("#007FFF"));
        return textCheckOutLabel;
    }

    private JLabel createReservation() {
        textReservationLabel = new JLabel("Valor da Reserva");
        textReservationLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textReservationLabel.setForeground(Color.decode("#007FFF"));
        return textReservationLabel;
    }

    private JLabel createPayment() {
        textPaymentLabel = new JLabel("Formas de Pagamento");
        textPaymentLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textPaymentLabel.setForeground(Color.decode("#007FFF"));
        return textPaymentLabel;
    }

    private JButton createButtonContinue() {
        ImageIcon icon = new ImageIcon("src/assets/img/icon-continuar.png");
        Image image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        buttonContinue = new JButton();
        buttonContinue.setPreferredSize(new Dimension(64, 64));
        buttonContinue.setIcon(icon);
        return buttonContinue;
    }

    private JXDatePicker createTextFieldCheckIn() {
        dateCheckIn = new JXDatePicker();
        dateCheckIn.setPreferredSize(new Dimension(200, 30));
        dateCheckIn.getEditor().setForeground(Color.BLACK);
        dateCheckIn.getEditor().setBackground(Color.WHITE);
        dateCheckIn.getEditor().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        String codeColor = "#007FFF";
        Color bordaColor = Color.decode(codeColor);
        dateCheckIn.setBorder(BorderFactory.createLineBorder(bordaColor));
        return dateCheckIn;
    }

    private JXDatePicker createTextFieldCheckOut() {
        dateCheckOut = new JXDatePicker();
        dateCheckOut.setPreferredSize(new Dimension(200, 30));
        dateCheckOut.getEditor().setForeground(Color.BLACK);
        dateCheckOut.getEditor().setBackground(Color.WHITE);
        dateCheckOut.getEditor().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        String codeColor = "#007FFF";
        Color bordaColor = Color.decode(codeColor);
        dateCheckOut.setBorder(BorderFactory.createLineBorder(bordaColor));
        return dateCheckOut;
    }

    private JTextField createTextFieldReservation() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        DecimalFormat format = new DecimalFormat("#,##0.00", symbols);
        textFieldReservation = new JFormattedTextField(format);
        textFieldReservation.setColumns(18);
        textFieldReservation.setHorizontalAlignment(JTextField.CENTER);
        textFieldReservation.setBorder(new LineBorder(Color.decode("#007FFF")));
        textFieldReservation.setPreferredSize(new Dimension(1, 30));
        return textFieldReservation;
    }

    private JComboBox createComboBoxPayment() {
        comboBoxPaymentLabel = new JComboBox<>(new String[]{"Cartão de Crédito", "Cartão de Débito", "Boleto"});
        comboBoxPaymentLabel.setOpaque(true);
        comboBoxPaymentLabel.setBorder(new LineBorder(Color.decode("#007FFF")));
        comboBoxPaymentLabel.setBackground(Color.WHITE);
        comboBoxPaymentLabel.setPreferredSize(new Dimension(200, 30));
        return comboBoxPaymentLabel;
    }

    private void getDateCheckIn() {
        dateCheckIn.addActionListener(e -> {
            Date selectedDate = dateCheckIn.getDate();
        });
    }

    private void getDateCheckOut() {
        dateCheckOut.addActionListener(e -> {
            Date selectedDate = dateCheckOut.getDate();
        });
    }

    private void getValueReservation() {
        buttonContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valueTextField = textFieldReservation.getText();
                try {
                    valueTextField = valueTextField.replace(",", ".");
                    double valueDecimal = Double.parseDouble(valueTextField);
                    valueInput = valueDecimal;
                    System.out.println(valueInput);
                    if (valueInput > 0) {
                        JOptionPane.showMessageDialog(ReservationPanel.this, "Valor válido.");
                    } else {
                        JOptionPane.showMessageDialog(ReservationPanel.this, "Valor inválido");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ReservationPanel.this, "Valor inválido. " +
                            "Por favor, insira somente números.");
                }
            }
        });
    }

    private void getValueOptionComboBox() {
        comboBoxPaymentLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object option = comboBoxPaymentLabel.getSelectedItem();
            }
        });
    }

    private ImageIcon loadBackgroundImage() throws IOException {
        return new ImageIcon("src/assets/img/backgroundReservation.png");
    }

    private ImageIcon loadHotelImage() throws IOException {
        return new ImageIcon("src/assets/img/Ha-100px.png");
    }

    private ImageIcon editBackgroundImage() throws IOException {
        Image editBackgroundImage = loadBackgroundImage().getImage();
        Image scaledBackgroundImage = editBackgroundImage.getScaledInstance(484, 786,
                Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundIcon = new ImageIcon(scaledBackgroundImage);
        return scaledBackgroundIcon;
    }

    private void addComponents() {
        try {
            backgroundLabel = new JLabel(editBackgroundImage());
            hotelLabel = new JLabel(loadHotelImage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o componente: "
                + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        reservationPanel = createReservationPanel();

        reservationPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(-150, 0, 0, -450);
        reservationPanel.add(backgroundLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(-1150, -750, 0, 0);
        reservationPanel.add(hotelLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(-1150, -360, 0, 0);
        reservationPanel.add(createTitle(), c);

        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(-950, -700, 0, 0);
        reservationPanel.add(createCheckIn(), c);

        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(-850, -670, 0, 0);
        reservationPanel.add(createTextFieldCheckIn(), c);

        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(-750, -700, 0, 0);
        reservationPanel.add(createCheckOut(), c);

        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(-650, -670, 0, 0);
        reservationPanel.add(createTextFieldCheckOut(), c);

        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(-550, -712, 0, 0);
        reservationPanel.add(createReservation(), c);

        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(-450, -670, 0, 0);
        reservationPanel.add(createTextFieldReservation(), c);

        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(-350, -675, 0, 0);
        reservationPanel.add(createPayment(), c);

        c.gridx = 0;
        c.gridy = 11;
        c.insets = new Insets(-250, -665, 0, 0);
        reservationPanel.add(createComboBoxPayment(), c);

        c.gridx = 0;
        c.gridy = 12;
        c.insets = new Insets(-575, -225, 0, 0);
        reservationPanel.add(createButtonContinue(), c);

        add(reservationPanel);

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

    private void eventButton() {
        getDateCheckIn();
        getDateCheckOut();
        getValueReservation();
        getValueOptionComboBox();
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
