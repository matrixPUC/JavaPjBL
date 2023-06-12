import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JFrame implements ActionListener {
    private JButton confirma;
    private JButton voltar;
    private static Conta contaLogada;
    private JTextField campoEmail;
    private JPasswordField campoSenha;

    public Login() {
        JLabel emailLabel = new JLabel("Email:");
        JLabel senhaLabel = new JLabel("Senha:");
        Color backgroundColor = new Color(214, 255, 255);
        getContentPane().setBackground(backgroundColor);

        campoEmail = new JTextField(30);
        campoSenha = new JPasswordField(30);
        campoEmail.setPreferredSize(new Dimension(campoEmail.getPreferredSize().width, 40));
        campoSenha.setPreferredSize(new Dimension(campoSenha.getPreferredSize().width, 40));

        confirma = new JButton("Confirmar");
        confirma.setFocusable(false);
        confirma.addActionListener(this);
        confirma.setPreferredSize(new Dimension(150, 50));

        voltar = new JButton("Voltar");
        voltar.setFocusable(false);
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FirstFrame();
                dispose();
            }
        });
        voltar.setPreferredSize(new Dimension(150, 50));

        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        container.add(emailLabel, constraints);

        constraints.gridx = 1;
        container.add(campoEmail, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(senhaLabel, constraints);

        constraints.gridx = 1;
        container.add(campoSenha, constraints);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        buttonPanel.add(voltar);
        buttonPanel.add(confirma);

        constraints.gridx = 0;
        constraints.gridy = 2;

        container.add(buttonPanel, constraints);

        JLabel loginTitle = new JLabel();
        loginTitle.setFont(new Font(null, Font.BOLD, 50));
        loginTitle.setText("Login");
        loginTitle.setForeground(Color.BLACK);
        loginTitle.setVerticalAlignment(JLabel.CENTER);
        loginTitle.setHorizontalAlignment(JLabel.CENTER);

        // Define a cor de fundo do JPanel principal
        container.setBackground(new Color(214, 255, 255));

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
        add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
