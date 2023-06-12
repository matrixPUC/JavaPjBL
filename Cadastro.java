import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.text.MaskFormatter;

public class Cadastro extends JFrame implements ActionListener {
    private static ArrayList<Conta> cadastros = new ArrayList<>();
    JButton criar;
    private JTextField campoNome;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JTextField campoEndereco;
    private JTextField campoTelefone;
    private JTextField campoPassaporte;
    private JTextField campoCpf;
    private JFormattedTextField campoData;

    public Cadastro() {
        cadastros = new ArrayList<>();

        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setBounds(100, 0, 200, 60);
        JLabel emailLabel = new JLabel("Email");
        JLabel senhaLabel = new JLabel("Senha");
        JLabel enderecoLabel = new JLabel("Endereço");
        JLabel telefoneLabel = new JLabel("Telefone");
        JLabel passaporteLabel = new JLabel("Passaporte");
        JLabel cpfLabel = new JLabel("CPF");
        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento");

        campoNome = new JTextField(20);
        campoEmail = new JTextField(20);
        campoSenha = new JPasswordField(20);
        campoEndereco = new JTextField(20);
        campoTelefone = new JTextField(20);
        campoPassaporte = new JTextField(20);
        campoCpf = new JTextField(20);
        campoData = new JFormattedTextField(createMaskFormatter("##-##-####"));
        campoData.setColumns(20);

        criar = new JButton("Criar Conta");
        criar.setFocusable(false);
        criar.setBackground(Color.gray);
        criar.setVerticalAlignment(JButton.CENTER);
        criar.setHorizontalAlignment(JButton.CENTER);
        criar.addActionListener(this);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(4, 4));
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
        cadastroTitle.setFont(new Font(null, Font.BOLD, 20));
        cadastroTitle.setText("Cadastro");
        cadastroTitle.setSize(100, 100);
        cadastroTitle.setVerticalAlignment(JLabel.CENTER);
        cadastroTitle.setHorizontalAlignment(JLabel.CENTER);

        setLayout(new GridLayout(3, 1));
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new FirstFrame();
                e.getWindow().dispose();
            }
        });
        add(cadastroTitle);
        add(container);
        add(criar);
        pack();
        setVisible(true);
    }

    public static ArrayList<Conta> getCadastros() {
        return cadastros;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = campoNome.getText();
        String email = campoEmail.getText();
        String senha = new String(campoSenha.getPassword());
        String endereco = campoEndereco.getText();
        String telefone = campoTelefone.getText();
        String passaporte = campoPassaporte.getText();
        String cpf = campoCpf.getText();
        String dataNascimentoString = campoData.getText();

        if (!EmailValidator.isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!telefone.matches("^\\d+$")) {
            JOptionPane.showMessageDialog(this, "Telefone inválido! Apenas números são permitidos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!CPFValidator.isValidCPF(cpf)) {
            JOptionPane.showMessageDialog(this, "CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(dataNascimentoString);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Data de Nascimento inválida! Digite uma data válida no formato DD-MM-AAAA.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        java.util.Date dataNascimento = null;

        try {
            dataNascimento = dateFormat.parse(dataNascimentoString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        // Restrição de idade
        int anoAtual = 2022; // Ano atual
        int anoNascimento = Integer.parseInt(dateFormat.format(dataNascimento).substring(6));
        int idade = anoAtual - anoNascimento;

        if (idade > 120) {
            JOptionPane.showMessageDialog(this, "Idade inválida! A idade máxima permitida é de 120 anos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } else if (idade < 18) {
            JOptionPane.showMessageDialog(this, "Idade inválida! É necessário ter no mínimo 18 anos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        cadastros.add(new Conta(nome, email, senha, endereco, telefone, passaporte, cpf, dataNascimento));
        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
        new FirstFrame();
        dispose();
    }

    private void limparCampos() {
        campoNome.setText("");
        campoEmail.setText("");
        campoSenha.setText("");
        campoEndereco.setText("");
        campoTelefone.setText("");
        campoPassaporte.setText("");
        campoCpf.setText("");
        campoData.setText("");
    }

    private MaskFormatter createMaskFormatter(String mask) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(mask);
            formatter.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }
}
