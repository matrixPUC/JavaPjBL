import java.util.ArrayList;

public class VooNacional extends Voo {
    private double taxaDomestica;

    public VooNacional(String numeroVoo, Aeroporto origemVoo, Aeroporto destinoVoo, String dataPartida, String dataChegada, CompanhiaAerea companhiaAerea, int capacidade, float tarifa, double taxaDomestica) {
        super(numeroVoo, origemVoo, destinoVoo, dataPartida, dataChegada, companhiaAerea, capacidade, tarifa);
        this.taxaDomestica = taxaDomestica;
    }

    public double getTaxaDomestica() {
        return taxaDomestica;
    }

    public void setTaxaDomestica(double taxaDomestica) {
        this.taxaDomestica = taxaDomestica;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Número do Voo: " + getNumeroVoo());
        System.out.println("Origem: " + getOrigemVoo());
        System.out.println("Destino: " + getDestinoVoo());
        System.out.println("Data de Partida: " + getDataPartida());
        System.out.println("Data de Chegada: " + getDataChegada());
        System.out.println("Companhia Aérea: " + getCompanhiaAerea());
        System.out.println("Capacidade: " + getCapacidade());
        System.out.println("Tarifa: " + getTarifa());
    }
}
