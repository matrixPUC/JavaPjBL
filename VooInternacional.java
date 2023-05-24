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
            System.out.println("Número do Voo: " + getNumero_Voo());
            System.out.println("Origem: " + getOrigem_Voo());
            System.out.println("Destino: " + getDestino_Voo());
            System.out.println("Data de Partida: " + getData_Partida());
            System.out.println("Data de Chegada: " + getData_Chegada());
            System.out.println("Companhia Aérea: " + getCompanhia_Aerea());
            System.out.println("Capacidade: " + getCapacidade());
            System.out.println("Tarifa: " + getTarifa());
        }
}
