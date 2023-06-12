import java.util.ArrayList;

public abstract class Voo {
    private String numeroVoo;
    private Aeroporto origemVoo;
    private Aeroporto destinoVoo;
    private String dataPartida;
    private String dataChegada;
    private CompanhiaAerea companhiaAerea;
    private int capacidade;
    private float tarifa;

    public Voo(String numeroVoo, Aeroporto origemVoo, Aeroporto destinoVoo, String dataPartida, String dataChegada, CompanhiaAerea companhiaAerea, int capacidade, float tarifa) {
        this.numeroVoo = numeroVoo;
        this.origemVoo = origemVoo;
        this.destinoVoo = destinoVoo;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.companhiaAerea = companhiaAerea;
        this.capacidade = capacidade;
        this.tarifa = tarifa;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public Aeroporto getOrigemVoo() {
        return origemVoo;
    }

    public void setOrigemVoo(Aeroporto origemVoo) {
        this.origemVoo = origemVoo;
    }

    public Aeroporto getDestinoVoo() {
        return destinoVoo;
    }

    public void setDestinoVoo(Aeroporto destinoVoo) {
        this.destinoVoo = destinoVoo;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public CompanhiaAerea getCompanhiaAerea() {
        return companhiaAerea;
    }

    public void setCompanhiaAerea(CompanhiaAerea companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public abstract void exibirInformacoes();

    public abstract void localizarVoo();
}

