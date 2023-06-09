import java.util.ArrayList;
import java.util.Date;

public class Conta {
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String telefone;
    private String passaporte;
    private String cpf;
    private Date dataNascimento;
    private double saldo;
    private ArrayList<Voo> reservas = new ArrayList<>();

    public Conta (String nome, String email, String senha, String endereco, String telefone, String passaporte, String cpf, Date dataNascimento) {
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

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {this.saldo = saldo;}
    public ArrayList<Voo> getReservas() {
        return reservas;
    }
    public void addReserva(Voo voo) {
        reservas.add(voo);
    }



}
