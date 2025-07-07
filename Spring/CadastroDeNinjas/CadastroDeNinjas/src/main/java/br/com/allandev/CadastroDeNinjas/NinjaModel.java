package br.com.allandev.CadastroDeNinjas;


import jakarta.persistence.*;


//Entity trasforma a classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro_ninjas") // Define o nome da tabela no banco de dados
public class NinjaModel {

    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que o valor será gerado automaticamente pelo banco de dados
    Long id;

    private String nome;
    private String email;
    private int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
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
}
