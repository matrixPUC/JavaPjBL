import java.util.ArrayList;

public class Aeroporto {
    private String nome;
    private String endereco;
    private String codIATAAeroporto;

    public Aeroporto(String nome, String endereco, String codIATAAeroporto) {
        this.nome = nome;
        this.endereco = endereco;
        this.codIATAAeroporto = codIATAAeroporto;
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
}
