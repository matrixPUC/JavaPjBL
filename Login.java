import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login {
    JButton confirma;

    public Login () {

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(100,0,250,50);
        JLabel senhaLabel = new JLabel("Senha");

        JTextField campoEmail = new JTextField(20);
        JTextField campoSenha = new JTextField(20);


        confirma = new JButton("Confirmar");
        confirma.setFocusable(false);
        confirma.setBackground(Color.gray);
        confirma.setVerticalAlignment(JButton.CENTER);
        confirma.setHorizontalAlignment(JButton.CENTER);

        JLabel buttonContainer = new JLabel();
        buttonContainer.add(confirma);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2,2));
        container.add(emailLabel);
        container.add(campoEmail);
        container.add(senhaLabel);
        container.add(campoSenha);

        JLabel loginTitle = new JLabel();
        loginTitle.setFont(new Font(null, Font.BOLD, 20));
        loginTitle.setText("Login");
        loginTitle.setSize(100,100);
        loginTitle.setVerticalAlignment(JLabel.CENTER);
        loginTitle.setHorizontalAlignment(JLabel.CENTER);

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 1));
        frame.setResizable(false);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new FirstFrame();
                e.getWindow().dispose();
            }
        });
        frame.add(loginTitle);
        frame.add(container);
        frame.add(confirma);
        frame.pack();
        frame.setVisible(true);

    }
}
