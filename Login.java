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

        campoEmail = new JTextField(10);
        campoSenha = new JPasswordField(10);

        confirma = new JButton("Confirmar");
        confirma.setFocusable(false);
        confirma.addActionListener(this);
        confirma.setPreferredSize(new Dimension(100, 70));

        voltar = new JButton("Voltar");
        voltar.setFocusable(false);
        voltar.addActionListener(this);
        voltar.setPreferredSize(new Dimension(120, 30));

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2, 2));
        container.add(emailLabel);
        container.add(campoEmail);
        container.add(senhaLabel);
        container.add(campoSenha);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(voltar);
        buttonPanel.add(confirma);

        JLabel loginTitle = new JLabel();
        loginTitle.setFont(new Font(null, Font.BOLD, 50));
        loginTitle.setText("Login");
        loginTitle.setForeground(Color.black);
        loginTitle.setVerticalAlignment(JLabel.CENTER);
        loginTitle.setHorizontalAlignment(JLabel.CENTER);

        Font labelFont = new Font(null, Font.PLAIN, 30);
        emailLabel.setFont(labelFont);
        senhaLabel.setFont(labelFont);

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
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Aumenta a tela para ocupar toda a tela do computador
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
