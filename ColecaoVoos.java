import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ColecaoVoos {
    private static ArrayList<Voo> voos = new ArrayList<>();

    public ColecaoVoos (String numeroVoo, String origemVoo, String destinoVoo, String dataPartida, String dataChegada, String companhiaAerea, int capacidade, float tarifa, double taxaDomestica) {
        voos.add(new VooNacional(numeroVoo, origemVoo, destinoVoo, dataPartida, dataChegada, companhiaAerea, capacidade, tarifa, taxaDomestica));

    }

    public ColecaoVoos (String numeroVoo, String origemVoo, String destinoVoo, String dataPartida, String dataChegada, String companhiaAerea, int capacidade, float tarifa, String paisOrigem, String paisDestino, boolean necessitaVisto) {
        voos.add(new VooInternacional(numeroVoo, origemVoo, destinoVoo, dataPartida, dataChegada, companhiaAerea, capacidade, tarifa, paisOrigem, paisDestino, necessitaVisto));

    }

    public static ArrayList<Voo> getVoos() {
        return voos;
    }

}
