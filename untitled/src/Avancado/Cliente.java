package Avancado;

public class Cliente {
    private String nome;
    private String email;
    private int idade;
    private String telefone;

    public Cliente(String nome, String email, int idade, String telefone) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
    }

    public Cliente() {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", telefone=" + telefone +
                '}';
    }
}
