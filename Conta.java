public class Conta {
    private String nome;
    private String email;
    private String endereço;
    private String telefone;
    private String passaporte;
    private String cpf;
    private int dataNascimento;
    private double saldo;

    public String getPassaporte() {
        return passaporte;
    }

    public String getCpf() {
        return cpf;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



}
