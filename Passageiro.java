import java.util.Date;

public class Passageiro {
    private String nome;
    private String passaporte;
    private String cpf;
    private Date dataNascimento;
    private Conta contaDono;

    public Passageiro(String nome, String passaporte, String cpf, Date dataNascimento, Conta contaDono) {
        this.nome = nome;
        this.passaporte = passaporte;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.contaDono = contaDono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Conta getContaDono() {
        return contaDono;
    }

    public void setContaDono(Conta contaDono) {
        this.contaDono = contaDono;
    }
}