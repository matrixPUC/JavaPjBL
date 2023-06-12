import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReservaVoo extends JFrame implements ActionListener {
    private static CardLayout card = new CardLayout(0, 0);
    private JPanel mainFrame = new JPanel();
    JButton reservasB, voosB;
    JPanel voos, reserva;
    Voo vooAtual;

    public ReservaVoo() {
        JLabel bemvindo = new JLabel("Bem-vindo, " + Login.getContaLogada().getNome());
        bemvindo.setFont(bemvindo.getFont().deriveFont(40f)); // Define o tamanho da fonte como 20
        bemvindo.setSize(200, 100);
        mainFrame.setBackground(new Color(214, 255, 255)); //




        reservasB = new JButton("Minhas Reservas");
        reservasB.addActionListener(this);
        reservasB.setFont(reservasB.getFont().deriveFont(20f)); // Define o tamanho da fonte do botão como 16
        voosB = new JButton("Realizar Reservas");
        voosB.addActionListener(this);
        voosB.setFont(voosB.getFont().deriveFont(20f)); // Define o tamanho da fonte do botão como 16


        JPanel sideFrame = new JPanel();
        sideFrame.setSize(200, 600);
        sideFrame.setLayout(new BoxLayout(sideFrame, BoxLayout.Y_AXIS));
        sideFrame.add(Box.createVerticalGlue()); // Adiciona espaço vertical flexível
        sideFrame.add(bemvindo);
        bemvindo.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza horizontalmente
        sideFrame.add(Box.createVerticalGlue()); // Adiciona espaço vertical flexível
        sideFrame.add(reservasB);
        reservasB.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza horizontalmente
        sideFrame.add(Box.createVerticalGlue()); // Adiciona espaço vertical flexível
        sideFrame.add(voosB);
        voosB.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza horizontalmente
        sideFrame.add(Box.createVerticalGlue()); // Adiciona espaço vertical flexível

        reserva = new JPanel();
        reserva.setLayout(new BoxLayout(reserva, BoxLayout.Y_AXIS));
        reserva.setSize(400, 600);
        construirPanelReservas();

        voos = new JPanel();
        voos.setLayout(card);
        voos.setSize(400, 600);
        for (Voo voo : ColecaoVoos.getVoos()) {
            vooAtual = voo;
            JPanel panelVoo = new JPanel();
            panelVoo.setLayout(new BoxLayout(panelVoo, BoxLayout.Y_AXIS));
            JTextArea info = new JTextArea();
            info.setSize(300, 300);
            JPanel botoes = new JPanel();
            JButton ant = new JButton("Anterior");
            ant.addActionListener(this);
            JButton prox = new JButton("Próximo");
            prox.addActionListener(this);
            JButton criar = new JButton("Criar Reserva");
            criar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Login.getContaLogada().getReservas().contains(voo)) {
                        JOptionPane.showMessageDialog(null, "Uma reserva nesse voo já foi efetuada", "Erro!", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Login.getContaLogada().addReserva(voo);
                        JOptionPane.showMessageDialog(null, "Reserva realizada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        construirPanelReservas();
                    }
                }
            });
            if (voo instanceof VooInternacional) {
                info.setText("Número do Voo: " + voo.getNumeroVoo());
                info.append("\nOrigem: " + ((VooInternacional) voo).getPaisOrigem() + ", " + voo.getOrigemVoo());
                info.append("\nDestino: " + ((VooInternacional) voo).getPaisDestino() + ", " + voo.getDestinoVoo());
                info.append("\nCompanhia: " + voo.getCompanhiaAerea() + " | Capacidade: " + voo.getCapacidade() + " | Tarifa: " + voo.getTarifa());
                info.append("\nData de Partida: " + voo.getDataPartida() + " | Data de Chegada: " + voo.getDataChegada());
                if (((VooInternacional) voo).isNecessitaVisto()) {
                    info.append("\nVisto Necessário");
                }

            }
            else {
                info.setText("Número do Voo: " + voo.getNumeroVoo());
                info.append("\nOrigem: " + voo.getOrigemVoo());
                info.append("\nDestino: " + voo.getDestinoVoo());
                info.append("\nCompanhia: " + voo.getCompanhiaAerea() + " | Capacidade: " + voo.getCapacidade());
                info.append("\nTarifa: " + voo.getTarifa() + " | Taxa Doméstica: " + ((VooNacional) voo).getTaxaDomestica());
                info.append("\nData de Partida: " + voo.getDataPartida() + " | Data de Chegada: " + voo.getDataChegada());
            }
            botoes.setLayout(new BoxLayout(botoes, BoxLayout.X_AXIS));
            botoes.add(ant);
            botoes.add(prox);
            info.setEditable(false);
            panelVoo.add(info);
            panelVoo.add(criar);
            panelVoo.add(botoes);
            voos.add(panelVoo);
        }

        mainFrame.setLayout(card);
        mainFrame.setBackground(new Color(214, 255, 255));
        mainFrame.add(reserva);
        mainFrame.add(voos);

        JPanel frame = new JPanel(new GridBagLayout());
        frame.setBackground(new Color(214, 255, 255)); // Define a cor de fundo do painel frame
        frame.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Define margens

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.3;
        constraints.fill = GridBagConstraints.VERTICAL;
        frame.add(sideFrame, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.7;
        constraints.fill = GridBagConstraints.BOTH;
        frame.add(mainFrame, constraints);


        setTitle("Reserva de Voo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(frame);
        setVisible(true);

        reservasB.setEnabled(false);

    }


    private void construirPanelReservas() {
        reserva.removeAll();
        for (Voo voo : Login.getContaLogada().getReservas()) {
            JPanel reservasCriadas = new JPanel();
            reservasCriadas.setLayout(new BorderLayout());
            JTextArea infoReserva = new JTextArea();
            if (voo instanceof VooInternacional) {
                infoReserva.setText("Número do Voo: " + voo.getNumeroVoo());
                infoReserva.append("\nOrigem: " + voo.getOrigemVoo());
                infoReserva.append("\nDestino: " + ((VooInternacional) voo).getPaisDestino() + ", " + voo.getDestinoVoo());
                infoReserva.append("\nData de Partida: " + voo.getDataPartida() + " | Data de Chegada: " + voo.getDataChegada());
            }
            else {
                infoReserva.setText("Número do Voo: " + voo.getNumeroVoo());
                infoReserva.append("\nOrigem: " + voo.getOrigemVoo());
                infoReserva.append("\nDestino: " + voo.getDestinoVoo());
                infoReserva.append("\nData de Partida: " + voo.getDataPartida() + " | Data de Chegada: " + voo.getDataChegada());
            }
            infoReserva.setEditable(false);
            reservasCriadas.add(infoReserva, BorderLayout.WEST);
            reserva.add(reservasCriadas);
        }
        reserva.revalidate();
        reserva.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Minhas Reservas")) {
            card.first(mainFrame);
            reservasB.setEnabled(false);
            voosB.setEnabled(true);
        }
        if (e.getActionCommand().equals("Realizar Reservas")) {
            card.last(mainFrame);
            voosB.setEnabled(false);
            reservasB.setEnabled(true);
        }
        if (e.getActionCommand().equals("Anterior")) {
            card.previous(voos);
        }
        if (e.getActionCommand().equals("Próximo")) {
            card.next(voos);
        }
    }
}
