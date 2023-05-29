import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Cadastro {
    private static ArrayList<Conta> cadastros;
    JButton criar;
    public Cadastro() {
        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setBounds(100,0,200,60);
        JLabel emailLabel = new JLabel("Email");
        JLabel senhaLabel = new JLabel("Senha");
        JLabel enderecoLabel = new JLabel("Endereço");
        JLabel telefoneLabel = new JLabel("Telefone");
        JLabel passaporteLabel = new JLabel("Passaporte");
        JLabel cpfLabel = new JLabel("CPF");
        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento");

        JTextField campoNome = new JTextField(20);
        JTextField campoEmail = new JTextField(20);
        // Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);

        JTextField campoSenha = new JTextField(20);
        JTextField campoEndereco = new JTextField(20);
        JTextField campoTelefone = new JTextField(20);
        JTextField campoPassaporte = new JTextField(20);
        JTextField campoCpf = new JTextField(20);
        JTextField campoData = new JTextField(20);

        criar = new JButton("Criar Conta");
        criar.setFocusable(false);
        criar.setBackground(Color.gray);
        criar.setVerticalAlignment(JButton.CENTER);
        criar.setHorizontalAlignment(JButton.CENTER);

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

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 1));
        frame.setResizable(false);
        frame.setSize(700,700);
        frame.add(cadastroTitle);
        frame.add(container);
        frame.add(criar);
        frame.pack();
        frame.setVisible(true);
    }
}
