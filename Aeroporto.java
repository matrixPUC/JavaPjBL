import java.util.ArrayList;

public class Aeroporto {
    private String nome;
    private ArrayList<Viagem> lista_voos;

    public Aeroporto(String nome, ArrayList<Viagem> listaVoos) {
        this.nome = nome;
        lista_voos = listaVoos;
    }
}
