import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame implements ActionListener {
    JButton loginButton;
    JButton cadastroButton;
    JFrame frame;

    public FirstFrame() {
        // Definir cores personalizadas
        Color backgroundColor = new Color(240,248,255);
        Color buttonColor = new Color(64, 128, 191);
        Color titleColor = new Color(64, 64, 64);

        loginButton = new JButton("Login");
        loginButton.setFocusable(false);
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(Color.white);
        loginButton.setBorder(BorderFactory.createLineBorder(buttonColor, 8));
        loginButton.addActionListener(this);

        cadastroButton = new JButton("Cadastro");
        cadastroButton.setFocusable(false);
        cadastroButton.setBackground(buttonColor);
        cadastroButton.setForeground(Color.white);
        cadastroButton.setBorder(BorderFactory.createLineBorder(buttonColor, 8));
        cadastroButton.addActionListener(this);

        // Painel do título
        JLabel mainTitle = new JLabel();
        mainTitle.setText("Sistema de Reserva de Voos");
        mainTitle.setFont(new Font("Arial", Font.BOLD, 25));
        mainTitle.setForeground(titleColor);

        JPanel titleContainer = new JPanel(new BorderLayout());
        titleContainer.setBorder(BorderFactory.createEmptyBorder(20, 100,100,100));
        titleContainer.setBackground(backgroundColor);
        titleContainer.add(mainTitle, BorderLayout.CENTER);

        // Painel dos botões
        JPanel buttonContainer = new JPanel(new FlowLayout());
        buttonContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonContainer.setBackground(backgroundColor);
        buttonContainer.add(loginButton);
        buttonContainer.add(cadastroButton);

        // Configurações do frame
        frame = new JFrame();
        frame.setTitle("Reserva de Voos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(backgroundColor);
        frame.add(titleContainer, BorderLayout.NORTH);
        frame.add(buttonContainer, BorderLayout.CENTER);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FirstFrame());
    }
}
