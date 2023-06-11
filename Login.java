import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private static Conta contaLogada;
    private JTextField campoEmail;
    private JTextField campoSenha;

    public Login() {
        JLabel emailLabel = new JLabel("Email");
        JLabel senhaLabel = new JLabel("Senha");

        campoEmail = new JTextField(20);
        campoSenha = new JPasswordField(20);

        JButton entrar = new JButton("Entrar");
        JButton voltar = new JButton("Voltar");

        entrar.setFocusable(false);
        voltar.setFocusable(false);

        entrar.setBackground(Color.gray);
        voltar.setBackground(Color.gray);

        entrar.addActionListener(this);
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FirstFrame();
            }
        });

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2, 2));
        container.add(emailLabel);
        container.add(campoEmail);
        container.add(senhaLabel);
        container.add(campoSenha);

        JLabel loginTitle = new JLabel();
        loginTitle.setFont(new Font(null, Font.BOLD, 20));
        loginTitle.setText("Login");
        loginTitle.setVerticalAlignment(JLabel.CENTER);
        loginTitle.setHorizontalAlignment(JLabel.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(loginTitle, BorderLayout.NORTH);
        mainPanel.add(container, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(entrar);
        buttonPanel.add(voltar);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(mainPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
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
                if (senha.equals(Cadastro.getCadastros().get(i).getSenha())) {
                    contaLogada = Cadastro.getCadastros().get(i);
                    new ReservaVoo();
                    dispose();
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Senha Inválida!", "Erro!", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Email Inválido!", "Erro!", JOptionPane.WARNING_MESSAGE);
    }
}
