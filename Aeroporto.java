import java.util.ArrayList;

public class Aeroporto {
    private String nome;
    private String endereco;
    private String codIATAAeroporto;
    private ArrayList<Viagem> lista_voos;

    public Aeroporto(String nome, String endereco, String codIATAAeroporto, ArrayList<Viagem> lista_voos) {
        this.nome = nome;
        this.endereco = endereco;
        this.codIATAAeroporto = codIATAAeroporto;
        this.lista_voos = lista_voos;
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

    public ArrayList<Viagem> getLista_voos() {
        return lista_voos;
    }

    public void setLista_voos(ArrayList<Viagem> lista_voos) {
        this.lista_voos = lista_voos;
    }
}
