public class VooNacional extends Voo {
    public VooNacional(String numeroVoo, String origemVoo, String destivoVoo, String dataPartida, String dataChegada, CompanhiaAerea companhiaAerea, int capacidade, float tarifa) {
        super(numeroVoo, origemVoo, destivoVoo, dataPartida, dataChegada, companhiaAerea, capacidade, tarifa);
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
