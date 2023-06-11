import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame implements ActionListener {
    JButton loginButton;
    JButton cadastroButton;
    JFrame frame;

    public FirstFrame() {
        loginButton = new JButton("Login");
        loginButton.setFocusable(false);
        Color buttonColor = new Color(0, 255, 255);
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(200, 100));
        loginButton.addActionListener(this);


        cadastroButton = new JButton("Cadastro");
        cadastroButton.setFocusable(false);
        cadastroButton.setBackground(buttonColor);
        cadastroButton.setForeground(Color.WHITE);
        cadastroButton.setPreferredSize(new Dimension(200, 100));
        cadastroButton.addActionListener(this);


        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new FlowLayout());
        buttonContainer.add(loginButton);
        buttonContainer.add(cadastroButton);

        JLabel mainTitle = new JLabel();
        mainTitle.setText("Sistema de Reserva de Voos");
        mainTitle.setFont(new Font(null, Font.BOLD, 40));
        mainTitle.setVerticalAlignment(JLabel.CENTER);
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setForeground(Color.white);

        frame = new JFrame();
        frame.setTitle("Reserva de Voos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridLayout(2, 1));
        frame.getContentPane().setBackground(Color.CYAN);
        frame.add(mainTitle);
        frame.add(buttonContainer);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            frame.dispose();
            new Login();
        } else if (e.getActionCommand().equals("Cadastro")) {
            frame.dispose();
            new Cadastro();
        }
    }
}