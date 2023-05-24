public class Passageiro {
    private String nome;
    private String sobrenome;
    private int cpf;
    private int data_Nascimento;
    private double saldo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getCpf() {
        return cpf;
    }

    public int getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(int data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}