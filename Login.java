import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JFrame implements ActionListener {
    JButton confirma;
    JButton voltar;
    private static Conta contaLogada;
    private JTextField campoEmail;
    private JTextField campoSenha;

    public Login () {

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(100,0,250,50);
        JLabel senhaLabel = new JLabel("Senha");

        campoEmail = new JTextField(20);
        campoSenha = new JTextField(20);

        confirma = new JButton("Confirmar");
        confirma.setFocusable(false);
        confirma.setBackground(Color.gray);
        confirma.setVerticalAlignment(JButton.CENTER);
        confirma.setHorizontalAlignment(JButton.CENTER);
        confirma.addActionListener(this);

        voltar = new JButton("Voltar");
        voltar.setFocusable(false);
        voltar.setBackground(Color.gray);
        voltar.setVerticalAlignment(JButton.CENTER);
        voltar.setHorizontalAlignment(JButton.CENTER);
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FirstFrame();
            }
        });

        JPanel buttonContainer = new JPanel();
        buttonContainer.add(confirma);
        buttonContainer.add(voltar);

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

        setLayout(new BorderLayout());
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new FirstFrame();
                e.getWindow().dispose();
            }
        });
        add(loginTitle, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    public Conta getContaLogada() {
        return contaLogada;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String email = campoEmail.getText();
        String senha = campoSenha.getText();

        for (int i = 0; i < Cadastro.getCadastros().size(); i++) {
            if (email.equals(Cadastro.getCadastros().get(i).getEmail())) {
                contaLogada = Cadastro.getCadastros().get(i);
                new ReservaVoo();
                dispose();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Erro!", "Erro!", JOptionPane.WARNING_MESSAGE);

    }

}
