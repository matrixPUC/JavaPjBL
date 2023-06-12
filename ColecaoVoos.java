import java.util.ArrayList;

public class ColecaoVoos {
    private static ArrayList<Voo> voos = new ArrayList<>();

    public ColecaoVoos (String numeroVoo, Aeroporto origemVoo, Aeroporto destinoVoo, String dataPartida, String dataChegada, CompanhiaAerea companhiaAerea, int capacidade, float tarifa, double taxaDomestica) {
        voos.add(new VooNacional(numeroVoo, origemVoo, destinoVoo, dataPartida, dataChegada, companhiaAerea, capacidade, tarifa, taxaDomestica));
    }

    public ColecaoVoos (String numeroVoo, Aeroporto origemVoo, Aeroporto destinoVoo, String dataPartida, String dataChegada, CompanhiaAerea companhiaAerea, int capacidade, float tarifa, String paisOrigem, String paisDestino, boolean necessitaVisto) {
        voos.add(new VooInternacional(numeroVoo, origemVoo, destinoVoo, dataPartida, dataChegada, companhiaAerea, capacidade, tarifa, paisOrigem, paisDestino, necessitaVisto));
    }

    public static ArrayList<Voo> getVoos() {
        return voos;
    }
}
