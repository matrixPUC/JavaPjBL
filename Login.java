import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JFrame implements ActionListener {
    JButton confirma;
    private static Conta contaLogada;
    private JTextField campoEmail;
    private JPasswordField campoSenha;

    public Login () {

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(100,0,250,50);
        JLabel senhaLabel = new JLabel("Senha");

        campoEmail = new JTextField(20);
        campoSenha = new JPasswordField(20);

        confirma = new JButton("Confirmar");
        confirma.setFocusable(false);
        confirma.setBackground(Color.green);
        confirma.setVerticalAlignment(JButton.CENTER);
        confirma.setHorizontalAlignment(JButton.CENTER);
        confirma.addActionListener(this);

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

        setLayout(new GridLayout(3, 1));
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new FirstFrame();
                e.getWindow().dispose();
            }
        });
        add(loginTitle);
        add(container);
        add(confirma);
        pack();
        setVisible(true);
    }

    public Conta getContaLogada() {
        return contaLogada;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = campoEmail.getText();
        String senha = new String(campoSenha.getPassword());

        try {
            if (email.isBlank()) {
                throw new AutenticacaoException("Erro de autenticação: email em branco");
            }

            if (senha.isBlank()) {
                throw new AutenticacaoException("Erro de autenticação: senha em branco");
            }

            if (!EmailValidator.isValidEmail(email)) {
                throw new AutenticacaoException("Erro de autenticação: email fora do padrão");
            }

            boolean autenticado = autenticarUsuario(email, senha);

            if (autenticado) {
                new ReservaVoo(this);
                dispose();
            } else {
                throw new AutenticacaoException("Erro de autenticação: email ou senha incorretos");
            }
        } catch (AutenticacaoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de autenticação", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean autenticarUsuario(String email, String senha) throws AutenticacaoException {
        for (Conta conta : Cadastro.getCadastros()) {
            if (email.equals(conta.getEmail())) {
                contaLogada = conta;
                return senha.equals(conta.getSenha());
            }
        }

        throw new AutenticacaoException("Erro de autenticação: email não cadastrado");
    }
}
