import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Font;


public class Cadastro extends JFrame implements ActionListener {
    private static ArrayList<Conta> cadastros;
    private JButton criar;
    private JButton voltar;
    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoSenha;
    private JTextField campoEndereco;
    private JTextField campoTelefone;
    private JTextField campoPassaporte;
    private JTextField campoCpf;
    private JTextField campoData;

    public Cadastro() {
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Preenche toda a tela
        Color backgroundColor = new Color(214, 255, 255);
        getContentPane().setBackground(backgroundColor);
        cadastros = new ArrayList<>();



        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setFont(nomeLabel.getFont().deriveFont(Font.BOLD, 18));
        nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(nomeLabel.getFont().deriveFont(Font.BOLD, 18));
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel senhaLabel = new JLabel("Senha");
        senhaLabel.setFont(nomeLabel.getFont().deriveFont(Font.BOLD, 18));
        senhaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel enderecoLabel = new JLabel("Endereço");
        enderecoLabel.setFont(nomeLabel.getFont().deriveFont(Font.BOLD, 18));
        enderecoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel telefoneLabel = new JLabel("Telefone");
        telefoneLabel.setFont(nomeLabel.getFont().deriveFont(Font.BOLD, 18));
        telefoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel passaporteLabel = new JLabel("Passaporte");
        passaporteLabel.setFont(nomeLabel.getFont().deriveFont(Font.BOLD, 18));
        passaporteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel cpfLabel = new JLabel("CPF");
        cpfLabel.setFont(nomeLabel.getFont().deriveFont(Font.BOLD, 18));
        cpfLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento");
        dataNascimentoLabel.setFont(nomeLabel.getFont().deriveFont(Font.BOLD, 18));
        dataNascimentoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        campoNome = new JTextField(10);
        campoEmail = new JTextField(10);
        campoSenha = new JPasswordField(10);
        campoEndereco = new JTextField(10);
        campoTelefone = new JTextField(10);
        campoPassaporte = new JTextField(10);
        campoCpf = new JTextField(10);
        campoData = new JTextField(10);


        criar = new JButton("Criar Conta");
        criar.setFocusable(false);
        criar.setVerticalAlignment(JButton.CENTER);
        criar.setHorizontalAlignment(JButton.CENTER);
        criar.addActionListener(this);
        criar.setPreferredSize(new Dimension(300, 50));

        voltar = new JButton("Voltar");
        voltar.setFocusable(false);
        voltar.setVerticalAlignment(JButton.CENTER);
        voltar.setHorizontalAlignment(JButton.CENTER);
        voltar.addActionListener(this);
        voltar.setPreferredSize(new Dimension(300, 50));

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(8, 2, 10, 10));
        container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        container.setBackground(backgroundColor);

        container.add(nomeLabel);
        container.add(campoNome);
        container.add(emailLabel);
        container.add(campoEmail);
        container.add(senhaLabel);
        container.add(campoSenha);
        container.add(enderecoLabel);
        container.add(campoEndereco);
        container.add(telefoneLabel);
        container.add(campoTelefone);
        container.add(passaporteLabel);
        container.add(campoPassaporte);
        container.add(cpfLabel);
        container.add(campoCpf);
        container.add(dataNascimentoLabel);
        container.add(campoData);

        JLabel cadastroTitle = new JLabel();
        cadastroTitle.setFont(new Font(null, Font.BOLD, 40));
        cadastroTitle.setText("Cadastro");
        cadastroTitle.setVerticalAlignment(JLabel.CENTER);
        cadastroTitle.setHorizontalAlignment(JLabel.CENTER);

        setLayout(new BorderLayout());
        setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                new FirstFrame();
                e.getWindow().dispose();
            }
        });
        add(cadastroTitle, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonPanel.add(voltar);
        buttonPanel.add(criar);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static ArrayList<Conta> getCadastros() {
        return cadastros;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == criar) {
            String nome = campoNome.getText();
            String email = campoEmail.getText();
            String senha = campoSenha.getText();
            String endereco = campoEndereco.getText();
            String telefone = campoTelefone.getText();
            String passaporte = campoPassaporte.getText();
            String cpf = campoCpf.getText();
            Date dataNascimento = null;

            try {
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                String dataNascimentoStr = campoData.getText();
                dataNascimento = formatoData.parse(dataNascimentoStr);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de data incorreto!", "Erro!", JOptionPane.WARNING_MESSAGE);
            }

            if (!EmailValidator.isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Email inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!telefone.matches("^\\d+$")) {
                JOptionPane.showMessageDialog(this, "Telefone inválido! Apenas números são permitidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!CPFValidator.isValidCPF(cpf)) {
                JOptionPane.showMessageDialog(this, "CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            cadastros.add(new Conta(nome, email, senha, endereco, telefone, passaporte, cpf, dataNascimento));
            new FirstFrame();
            dispose();
        } else if (e.getSource() == voltar) {
            new FirstFrame();
            dispose();
        }
    }
}
