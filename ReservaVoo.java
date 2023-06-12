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
        bemvindo.setSize(200, 100);

        reservasB = new JButton("Minhas Reservas");
        reservasB.addActionListener(this);
        voosB = new JButton("Realizar Reservas");
        voosB.addActionListener(this);

        JPanel sideFrame = new JPanel();
        sideFrame.setSize(200, 600);
        sideFrame.setLayout(new BoxLayout(sideFrame, BoxLayout.Y_AXIS));
        sideFrame.add(bemvindo);
        sideFrame.add(reservasB);
        sideFrame.add(voosB);

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
        mainFrame.add(reserva);
        mainFrame.add(voos);

        JPanel frame = new JPanel();
        frame.setLayout(new BoxLayout(frame, BoxLayout.X_AXIS));
        frame.add(sideFrame);
        frame.add(mainFrame);
        frame.setSize(600,600);

        setTitle("Reserva de Voo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(frame);
        pack();
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
