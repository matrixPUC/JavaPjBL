public class Voo {
    private String numero_Voo;
    private String origem_Voo;
    private String destino_Voo;
    private String data_Partida;
    private String data_Chegada;
    private String companhia_Aerea;
    private int capacidade;
    private float tarifa;

    public Voo(String numero_Voo, String origem_Voo, String destivo_Voo, String data_Partida, String data_Chegada, String companhia_Aerea, int capacidade, float tarifa){
        this.numero_Voo = numero_Voo;
        this.origem_Voo = origem_Voo;
        this. destino_Voo = destivo_Voo;
        this. data_Partida = data_Partida;
        this. data_Chegada = data_Chegada;
        this. companhia_Aerea = companhia_Aerea;
        this.capacidade = capacidade;
        this.tarifa = tarifa;
    }

    // Métodos getters e setters

    public String getNumero_Voo() {
        return numero_Voo;
    }

    public void setNumero_Voo(String numero_Voo) {
        this.numero_Voo = numero_Voo;
    }

    public String getOrigem_Voo() {
        return origem_Voo;
    }

    public void setOrigem_Voo(String origem_Voo) {
        this.origem_Voo = origem_Voo;
    }

    public String getDestino_Voo() {
        return destino_Voo;
    }

    public void setDestino_Voo(String destino_Voo) {
        this.destino_Voo = destino_Voo;
    }

    public String getData_Partida() {
        return data_Partida;
    }

    public void setData_Partida(String data_Partida) {
        this.data_Partida = data_Partida;
    }

    public String getData_Chegada() {
        return data_Chegada;
    }

    public void setData_Chegada(String data_Chegada) {
        this.data_Chegada = data_Chegada;
    }

    public String getCompanhia_Aerea() {
        return companhia_Aerea;
    }

    public void setCompanhia_Aerea(String companhia_Aerea) {
        this.companhia_Aerea = companhia_Aerea;
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

    // Outros métodos da classe

    public void exibirInformacoes() {
        System.out.println("Número do Voo: " + numero_Voo);
        System.out.println("Origem: " + origem_Voo);
        System.out.println("Destino: " + destino_Voo);
        System.out.println("Data de Partida: " + data_Partida);
        System.out.println("Data de Chegada: " + data_Chegada);
        System.out.println("Companhia Aérea: " + companhia_Aerea);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Tarifa: " + tarifa);
    }
}

