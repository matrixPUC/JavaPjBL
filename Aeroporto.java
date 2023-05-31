import java.util.ArrayList;

public class Aeroporto {
    private String nome;
    private String endereco;
    private String codIATAAeroporto;
    private ArrayList<VooNacional> voosNacionais;
    private ArrayList<VooInternacional> voosInternacionais;

    public Aeroporto(String nome, String endereco, String codIATAAeroporto, ArrayList<VooNacional> voosNacionais, ArrayList<VooInternacional> voosInternacionais) {
        this.nome = nome;
        this.endereco = endereco;
        this.codIATAAeroporto = codIATAAeroporto;
        this.voosNacionais = voosNacionais;
        this.voosInternacionais = voosInternacionais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCodIATAAeroporto() {
        return codIATAAeroporto;
    }

    public void setCodIATAAeroporto(String codIATAAeroporto) {
        this.codIATAAeroporto = codIATAAeroporto;
    }

    public ArrayList<VooNacional> getVoosNacionais() {
        return voosNacionais;
    }

    public void setVoosNacionais(ArrayList<VooNacional> voosNacionais) {
        this.voosNacionais = voosNacionais;
    }

    public ArrayList<VooInternacional> getVoosInternacionais() {
        return voosInternacionais;
    }

    public void setVoosInternacionais(ArrayList<VooInternacional> voosInternacionais) {
        this.voosInternacionais = voosInternacionais;
    }

    public void inserirVooNacional (VooNacional vooNacional) {
        voosNacionais.add(vooNacional);
    }
    public void inserirVooInternacional (VooInternacional vooInternacional) {
        voosInternacionais.add(vooInternacional);
    }
}
