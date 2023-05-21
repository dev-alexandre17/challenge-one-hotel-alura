package br.com.hotel.alura.api.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Base64;

public class LoginPanel extends JFrame {

    private JPanel mainPanel;
    private JLabel hotelLabel;
    private JLabel backgroundLabel;
    private JLabel textTitleLabel;
    private JLabel textLoginLabel;
    private JLabel textPasswordLabel;
    private JTextField textFieldLogin;
    private JPasswordField textFieldPassword;
    private JButton signIn;
    private JFrame frame;
    private static final String API_URL = "http://localhost:8080/desenvolvedores/login";

    public LoginPanel() {
        super("Login");

        editFrame();

        eventFrame();

        addComponents();

        editDimensionFrame();

        eventButton();

    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        return panel;
    }

    private JLabel createTitle() {
        textTitleLabel = new JLabel("LOGIN");
        textTitleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        textTitleLabel.setForeground(Color.decode("#007FFF"));
        return textTitleLabel;
    }

    private JLabel createLogin() {
        textLoginLabel = new JLabel("Usuario");
        textLoginLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        textLoginLabel.setForeground(Color.decode("#007FFF"));
        return textLoginLabel;
    }

    private JLabel createPassword() {
        textPasswordLabel = new JLabel("Senha");
        textPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        textPasswordLabel.setForeground(Color.decode("#007FFF"));
        return textPasswordLabel;
    }

    private JTextField createTextFieldLogin() {
        textFieldLogin = new JTextField(25);
        Border borderPersonalized = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#007FFF"));
        textFieldLogin.setBorder(borderPersonalized);
        return textFieldLogin;
    }

    private JPasswordField createTextFieldPassword() {
        textFieldPassword = new JPasswordField(25);
        Border borderPersonalized = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#007FFF"));
        textFieldPassword.setBorder(borderPersonalized);
        return textFieldPassword;
    }

    private JButton createButtonSignIn() {
        signIn = new JButton("ENTRAR");
        signIn.setBackground(Color.decode("#007FFF"));
        signIn.setForeground(Color.WHITE);
        return signIn;
    }

    private ImageIcon loadBackgroundImage() throws IOException {
        return new ImageIcon("src/assets/img/hotel-login.png");
    }

    private ImageIcon loadHotelImage() throws IOException {
        return new ImageIcon("src/assets/img/lOGO-50PX.png");
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
            JOptionPane.showMessageDialog(this, "Erro ao carregar o componente" + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

        mainPanel = createMainPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(-150, 0, 0, -450);
        mainPanel.add(backgroundLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(-1100, -700, 0, 0);
        mainPanel.add(hotelLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(-930, -400, 0, 100);
        mainPanel.add(createTitle(), c);

        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(-750, -690, 0, 0);
        mainPanel.add(createLogin(), c);

        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(-550, -705, 0, 0);
        mainPanel.add(createPassword(), c);

        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(-660, -485, 0, 0);
        mainPanel.add(createTextFieldLogin(), c);

        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(-475, -485, 0, 0);
        mainPanel.add(createTextFieldPassword(), c);

        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(-300, -485, 0, 0);
        mainPanel.add(createButtonSignIn(), c);

        add(mainPanel);

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
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldLogin.getText();
                String password = new String(textFieldPassword.getPassword());

                try {
                    URL url = new URL(API_URL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setDoOutput(true);

                    String credentials = name + ":" + password;
                    String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes("utf-8"));
                    connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);

                    String jsonInputString = "{\"name\": \"" + name + "\", \"password\": \"" + password + "\"}";

                    try (OutputStream outputStream = connection.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes("utf-8");
                        outputStream.write(input, 0, input.length);
                    }

                    try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                            "utf-8"))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }

                        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                            System.out.println(response.toString());
                            changeFrame();
                            dispose();
                        } else if (connection.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                            System.out.println(response.toString());
                            JOptionPane.showMessageDialog(LoginPanel.this,
                                    "Credenciais inválidas");
                        }
                    }

                    connection.disconnect();

                } catch (ProtocolException ex) {
                    throw new RuntimeException(ex);
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private static void changeFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuPanel menuPanel = new MenuPanel();
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


