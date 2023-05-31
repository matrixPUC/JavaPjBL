import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Cadastro extends JFrame implements ActionListener {
    private static ArrayList<Conta> cadastros;
    JButton criar;
    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoSenha;
    private JTextField campoEndereco;
    private JTextField campoTelefone;
    private JTextField campoPassaporte;
    private JTextField campoCpf;
    private JTextField campoData;

    public Cadastro() {
        cadastros = new ArrayList<>();

        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setBounds(100,0,200,60);
        JLabel emailLabel = new JLabel("Email");
        JLabel senhaLabel = new JLabel("Senha");
        JLabel enderecoLabel = new JLabel("Endereço");
        JLabel telefoneLabel = new JLabel("Telefone");
        JLabel passaporteLabel = new JLabel("Passaporte");
        JLabel cpfLabel = new JLabel("CPF");
        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento");

        campoNome = new JTextField(20);
        campoEmail = new JTextField(20);
        campoSenha = new JTextField(20);
        campoEndereco = new JTextField(20);
        campoTelefone = new JTextField(20);
        campoPassaporte = new JTextField(20);
        campoCpf = new JTextField(20);
        campoData = new JTextField(20);

        criar = new JButton("Criar Conta");
        criar.setFocusable(false);
        criar.setBackground(Color.gray);
        criar.setVerticalAlignment(JButton.CENTER);
        criar.setHorizontalAlignment(JButton.CENTER);
        criar.addActionListener(this);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(4,4));
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
        cadastroTitle.setSize(100,100);
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
        String senha = campoSenha.getText();
        String endereco = campoEndereco.getText();
        String telefone = campoTelefone.getText();
        String passaporte = campoPassaporte.getText();
        String cpf = campoCpf.getText();
        int dataNascimento = Integer.parseInt(campoData.getText());

        cadastros.add(new Conta(nome, email, senha, endereco, telefone, passaporte, cpf, dataNascimento));
        new FirstFrame();
        dispose();

    }
}
