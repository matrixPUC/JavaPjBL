public class Passageiro {
    private String nome;
    private String passaporte;
    private String cpf;
    private int dataNascimento;
    private Conta contaDono;

    public Passageiro(String nome, String email, String endereco, String telefone,String passaporte, String cpf, int dataNascimento, double saldo) {
        this.nome = nome;
        this.passaporte = passaporte;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getContaDono() {
        return contaDono;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}