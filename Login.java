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
        voltar.addActionListener(this);
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

        buttonPanel.add(voltar);
        buttonPanel.add(confirma);

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
        if (e.getSource() == confirma) {
            String email = campoEmail.getText();
            String senha = new String(campoSenha.getPassword());

            for (Conta conta : Cadastro.getCadastros()) {
                if (email.equals(conta.getEmail())) {
                    if (senha.equals(conta.getSenha())) {
                        contaLogada = conta;
                        new ReservaVoo();
                        dispose();
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha Inválida!", "Erro!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Email Inválido!", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == voltar) {
            new FirstFrame();
            dispose();
        }
    }
}
