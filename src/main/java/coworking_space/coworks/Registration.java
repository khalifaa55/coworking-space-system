/*package coworking_space.coworks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Registration {
    static final String PANEL_NAME = "SCREEN_2";
    private final JPanel panel;

    public Registration(JPanel cardPanel) {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("D:\\second year\\regisScreen.PNG");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        JTextField textName = new JTextField();
        textName.setBounds(540, 146, 330, 47);
        textName.setOpaque(false);
        textName.setBorder(null);

        JTextField textemail = new JTextField();
        textemail.setBounds(540, 200, 330, 47);
        textemail.setOpaque(false);
        textemail.setBorder(null);

        JTextField textphone = new JTextField();
        textphone.setBounds(622, 258, 247, 47);
        textphone.setOpaque(false);
        textphone.setBorder(null);

        JPasswordField textPass2 = new JPasswordField();
        textPass2.setBounds(568, 320, 305, 47);
        textPass2.setOpaque(false);
        textPass2.setBorder(null);

        JPasswordField textPass3 = new JPasswordField();
        textPass3.setBounds(654, 375, 240, 47);
        textPass3.setOpaque(false);
        textPass3.setBorder(null);


        panel.setLayout(null);
        panel.add(textName);
        panel.add(textPass2);
        panel.add(textemail);
        panel.add(textPass3);
        panel.add(textphone);

        textphone.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore the input if it's not a digit
                }
            }
        });

        JButton regbutton = new JButton();
        regbutton.setBounds(580, 440, 169, 40);
        regbutton.setToolTipText("Register");
        regbutton.setContentAreaFilled(false);
        regbutton.setBorderPainted(false);

        regbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                String userEmail = textemail.getText();
                String userPhone = textphone.getText();
                char[] password2 = textPass2.getPassword();
                char[] password3 = textPass3.getPassword();
                    JOptionPane.showMessageDialog(panel, "coworking_space.coworks.Registration button clicked!");
            }
        });

        panel.add(regbutton);

        JButton backButton = new JButton("<html><u>Back to coworking_space.coworks.Login</u></html>");
        backButton.setBounds(580, 490, 169, 15);
        backButton.setToolTipText("Back to coworking_space.coworks.Login");
        backButton.setForeground(new Color(0x124D3f));
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.previous(cardPanel);
            }
        });

        panel.add(backButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}*/