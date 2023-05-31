import java.util.ArrayList;

public class VooInternacional extends Voo {
    private String paisOrigem;
    private String paisDestino;
    private boolean necessitaVisto;

    public VooInternacional(String numeroVoo, Aeroporto origemVoo, Aeroporto destinoVoo, String dataPartida, String dataChegada, CompanhiaAerea companhiaAerea, int capacidade, float tarifa, String paisOrigem, String paisDestino, boolean necessitaVisto) {
        super(numeroVoo, origemVoo, destinoVoo, dataPartida, dataChegada, companhiaAerea, capacidade, tarifa);
        this.paisOrigem = paisOrigem;
        this.paisDestino = paisDestino;
        this.necessitaVisto = necessitaVisto;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public boolean isNecessitaVisto() {
        return necessitaVisto;
    }

    public void setNecessitaVisto(boolean necessitaVisto) {
        this.necessitaVisto = necessitaVisto;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Número do Voo: " + getNumeroVoo());
        System.out.println("Origem: " + getOrigemVoo());
        System.out.println("Destino: " + getDestinoVoo());
        System.out.println("País de Origem: " + paisOrigem);
        System.out.println("País de Destino: " + paisDestino);
        System.out.println("Data de Partida: " + getDataPartida());
        System.out.println("Data de Chegada: " + getDataChegada());
        System.out.println("Companhia Aérea: " + getCompanhiaAerea());
        System.out.println("Capacidade: " + getCapacidade());
        System.out.println("Tarifa: " + getTarifa());
        if (necessitaVisto) {
            System.out.println("Necessita de visto: Sim");
        } else {
            System.out.println("Necessita de visto: Não");
        }
    }

    @Override
    public void localizarVoo() {
        // quando um novo voo é criado
        // este voo é adicionado à lista de voos do aeroporto de origem
    }
}
