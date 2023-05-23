public class VooInternacional extends Voo {
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
}
