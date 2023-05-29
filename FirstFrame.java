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
        loginButton.setBackground(Color.gray);
        loginButton.addActionListener(this);

        cadastroButton = new JButton("Cadastro");
        cadastroButton.setFocusable(false);
        cadastroButton.setBackground(Color.gray);
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

        frame = new JFrame();
        frame.setTitle("Reserva de Voos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(2, 1));
        frame.setBackground(Color.lightGray);
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
