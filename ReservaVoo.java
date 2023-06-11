import javax.swing.*;
import java.awt.GridLayout;
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
        setTitle("Reserva de Voo");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Preenche toda a tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        setVisible(true);

        // Componentes da interface
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setFont(labelNome.getFont().deriveFont(25f)); // Aumenta o tamanho da fonte
        campoNome = new JTextField(20);
        JLabel labelOrigem = new JLabel("Origem:");
        labelOrigem.setFont(labelOrigem.getFont().deriveFont(25f)); //
        campoOrigem = new JTextField(20);
        JLabel labelDestino = new JLabel("Destino:");
        labelDestino.setFont(labelDestino.getFont().deriveFont(25f)); // Aumenta o tamanho da fonte
        campoDestino = new JTextField(20);
        JLabel labelDataIda = new JLabel("Data de Ida:");
        labelDataIda.setFont(labelDataIda.getFont().deriveFont(25f)); // Aumenta o tamanho da fonte
        campoDataIda = new JTextField(20);
        JLabel labelDataVolta = new JLabel("Data de Volta:");
        labelDataVolta.setFont(labelDataVolta.getFont().deriveFont(25f)); // Aumenta o tamanho da fonte
        campoDataVolta = new JTextField(20);

        JButton botaoVoltar = new JButton("Voltar");
        JButton botaoReservar = new JButton("Reservar");

        // Adiciona os componentes à janela
        add(labelNome);
        add(campoNome);
        add(labelOrigem);
        add(campoOrigem);
        add(labelDestino);
        add(campoDestino);
        add(labelDataIda);
        add(campoDataIda);
        add(labelDataVolta);
        add(campoDataVolta);
        add(botaoVoltar);
        add(botaoReservar);


        // Define o ActionListener para os botões
        botaoReservar.addActionListener(this);
        botaoVoltar.addActionListener(this);
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
