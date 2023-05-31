
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
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        setVisible(true);

        // Componentes da interface
        JLabel labelNome = new JLabel("Nome:");

        labelNome.setBounds(100, 100, 250, 40);
        campoNome = new JTextField(20);
        JLabel labelOrigem = new JLabel("Origem:");
        campoOrigem = new JTextField(20);
        JLabel labelDestino = new JLabel("Destino:");
        campoDestino = new JTextField(20);
        JLabel labelDataIda = new JLabel("Data de Ida:");
        campoDataIda = new JTextField(20);
        JLabel labelDataVolta = new JLabel("Data de Volta:");
        campoDataVolta = new JTextField(20);
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
        add(botaoReservar);

        // Define o ActionListener para o botão
        botaoReservar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica para lidar com o evento de clique no botão
        String nome = campoNome.getText();
        String origem = campoOrigem.getText();
        String destino = campoDestino.getText();
        String dataIda = campoDataIda.getText();
        String dataVolta = campoDataVolta.getText();

        // Aqui, você pode implementar a lógica de reserva de voo com base nos dados fornecidos


        // Exemplo: exibindo uma mensagem com os detalhes da reserva
        String mensagem = "Reserva de voo para:\nNome: " + nome + "\nOrigem: " + origem + "\nDestino: " + destino + "\nData de ida: " + dataIda + "\nData de volta: " + dataVolta;
        JOptionPane.showMessageDialog(this, mensagem);
    }


}



