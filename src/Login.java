import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Login {
    static final String PANEL_NAME = "SCREEN_1";
    private final JPanel panel;

    public Login(JPanel cardPanel) {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("D:\\second year\\llll.PNG");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        JTextField textUsername = new JTextField();
        Font customFont = new Font("Arial", Font.PLAIN, 20);
        textUsername.setFont(customFont);
        textUsername.setToolTipText("Enter your Name here");
        textUsername.setBounds(559, 169, 300, 50);
        textUsername.setOpaque(false);
        textUsername.setBorder(null);

        JPasswordField textPass = new JPasswordField();
        textPass.setFont(customFont);
        textPass.setToolTipText("Enter your password");
        textPass.setBounds(586, 250, 290, 50);
        textPass.setOpaque(false);
        textPass.setBorder(null);

        textUsername.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textUsername.getText();
                JOptionPane.showMessageDialog(null, "Entered Text: " + text);
            }
        });

        textPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = new String(textPass.getPassword());
                JOptionPane.showMessageDialog(null, "Entered Text: " + text);
            }
        });

        textPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore the input
                }
            }
        });

        panel.add(textUsername);
        panel.add(textPass);

        JRadioButton radioButton = new JRadioButton("General");
        boolean isSelected = radioButton.isSelected();
        // Set the selection state
        radioButton.setSelected(true); // to select
        radioButton.setSelected(false); // to deselect
        radioButton.setBounds(550,295,100,40);
        radioButton.setOpaque(false);


        JRadioButton radioButton2 = new JRadioButton("Formal");
        boolean isSelected2 = radioButton.isSelected();
        // Set the selection state
        radioButton2.setSelected(true); // to select
        radioButton2.setSelected(false); // to deselect
        radioButton2.setBounds(625,295,100,40);
        radioButton2.setOpaque(false);

        JRadioButton radioButton3 = new JRadioButton("Instractor");
        boolean isSelected3 = radioButton.isSelected();
        // Set the selection state
        radioButton3.setSelected(true); // to select
        radioButton3.setSelected(false); // to deselect
        radioButton3.setBounds(690,295,100,40);
        radioButton3.setOpaque(false);



        radioButton2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton);
        group.add(radioButton2);
        group.add(radioButton3);



        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the radio button is clicked
            }
        });


        JButton switchButton = new JButton("<html><u>Register</u></html>");
        switchButton.setBounds(700, 412, 79, 15);
        switchButton.setToolTipText("Register");
        switchButton.setForeground(new Color(0x124D3f));

        switchButton.setBorderPainted(false);
        switchButton.setFocusPainted(false);
        switchButton.setContentAreaFilled(false);

        JButton loginButton = new JButton();
        loginButton.setBounds(580, 370, 169, 40);
        loginButton.setToolTipText("Login");
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Log In button clicked!");
            }
        });

        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.next(cardPanel);
            }
        });

        panel.add(switchButton);
        panel.add(loginButton);
        panel.add(radioButton);
        panel.add(radioButton2);
        panel.add(radioButton3);
    }

    public JPanel getPanel() {
        return panel;
    }
}