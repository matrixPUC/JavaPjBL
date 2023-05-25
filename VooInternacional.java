public class VooInternacional extends Viagem {
        private String paisOrigem;
        private String paisDestino;
        private boolean necessitaVisto;

        public VooInternacional(String numeroVoo, String origemVoo, String destinoVoo, String dataPartida, String dataChegada,
                                String companhiaAerea, int capacidade, float tarifa, String paisOrigem, String paisDestino,
                                boolean necessitaVisto) {
            super(numeroVoo, origemVoo, destinoVoo, dataPartida, dataChegada, companhiaAerea, capacidade, tarifa);
            this.paisOrigem = paisOrigem;
            this.paisDestino = paisDestino;
            this.necessitaVisto = necessitaVisto;
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
