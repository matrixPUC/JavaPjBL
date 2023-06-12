import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservaVoo extends JFrame implements ActionListener {
    private JTextField campoNome;
    private JTextField campoOrigem;
    private JTextField campoDestino;
    private JTextField campoDataIda;
    private JTextField campoDataVolta;

    public ReservaVoo() {
        // Configurações da janela
        setTitle("Faça sua Reserva!!!!");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Preenche toda a tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(214, 255, 255));
        setLayout(new GridBagLayout());
        setVisible(true);

        // Componentes da interface
        JLabel titulo = new JLabel("Faça sua reserva");
        titulo.setFont(new Font(titulo.getFont().getName(), Font.BOLD, 40));
        titulo.setForeground(Color.BLACK);
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setFont(new Font(labelNome.getFont().getName(), Font.BOLD, 25));
        campoNome = new JTextField(20);
        JLabel labelOrigem = new JLabel("Origem:");
        labelOrigem.setFont(new Font(labelOrigem.getFont().getName(), Font.BOLD, 25));
        campoOrigem = new JTextField(20);
        JLabel labelDestino = new JLabel("Destino:");
        labelDestino.setFont(new Font(labelDestino.getFont().getName(), Font.BOLD, 25));
        campoDestino = new JTextField(20);
        JLabel labelDataIda = new JLabel("Data de Ida:");
        labelDataIda.setFont(new Font(labelDataIda.getFont().getName(), Font.BOLD, 25));
        campoDataIda = new JTextField(20);
        JLabel labelDataVolta = new JLabel("Data de Volta:");
        labelDataVolta.setFont(new Font(labelDataVolta.getFont().getName(), Font.BOLD, 25));
        campoDataVolta = new JTextField(20);

        campoNome.setPreferredSize(new Dimension(campoNome.getPreferredSize().width, 40));
        campoOrigem.setPreferredSize(new Dimension(campoOrigem.getPreferredSize().width, 40));
        campoDestino.setPreferredSize(new Dimension(campoDestino.getPreferredSize().width, 40));
        campoDataIda.setPreferredSize(new Dimension(campoDataIda.getPreferredSize().width, 40));
        campoDataVolta.setPreferredSize(new Dimension(campoDataVolta.getPreferredSize().width, 40));


        JButton botaoReservar = new JButton("Reservar");
        botaoReservar.setPreferredSize(new Dimension(150, 50));


        // Adiciona os componentes à janela
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(labelNome, constraints);

        constraints.gridx = 1;
        add(campoNome, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(labelOrigem, constraints);

        constraints.gridx = 1;
        add(campoOrigem, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(labelDestino, constraints);

        constraints.gridx = 1;
        add(campoDestino, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(labelDataIda, constraints);

        constraints.gridx = 1;
        add(campoDataIda, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(labelDataVolta, constraints);

        constraints.gridx = 1;
        add(campoDataVolta, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;


        constraints.gridx = 1;
        add(botaoReservar, constraints);

        // Define o ActionListener para os botões
        botaoReservar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reservar")) {
            // Lógica para lidar com o evento de clique no botão "Reservar"
            String nome = campoNome.getText();
            String origem = campoOrigem.getText();
            String destino = campoDestino.getText();
            String dataIda = campoDataIda.getText();
            String dataVolta = campoDataVolta.getText();

            // Lógica


            // Exemplo: exibindo uma mensagem com os detalhes da reserva
            String mensagem = "Reserva de voo para:\nNome: " + nome + "\nOrigem: " + origem + "\nDestino: " + destino + "\nData de ida: " + dataIda + "\nData de volta: " + dataVolta;
            JOptionPane.showMessageDialog(this, mensagem);
        }

    }
}
