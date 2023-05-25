public class CompanhiaAerea {
    private String nome;
    private String codIATACompanhia;

    public CompanhiaAerea(String nome, String codIATACompanhia) {
        this.nome = nome;
        this.codIATACompanhia = codIATACompanhia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodIATACompanhia() {
        return codIATACompanhia;
    }

    public void setCodIATACompanhia(String codIATACompanhia) {
        this.codIATACompanhia = codIATACompanhia;
    }
}
