public class Conta {
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String telefone;
    private String passaporte;
    private String cpf;
    private int dataNascimento;
    private double saldo;

    public Conta (String nome, String email, String senha, String endereco, String telefone, String passaporte, String cpf, int dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.passaporte = passaporte;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.saldo = 0;
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

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPassaporte() {return passaporte;}

    public String getCpf() {return cpf;}

    public int getDataNascimento() {
        return dataNascimento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {this.saldo = saldo;}



}
