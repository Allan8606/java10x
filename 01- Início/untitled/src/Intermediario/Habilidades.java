package Intermediario;

public class Habilidades {
    private String nomeDaHabilidade;


    //Construtor
    public Habilidades(String nomeDaHabilidade) {
        this.nomeDaHabilidade = nomeDaHabilidade;
    }

    //getters e setters
    public String getNomeDaHabilidade() {
        return nomeDaHabilidade;
    }

    public void setNomeDaHabilidade(String nomeDaHabilidade) {
        this.nomeDaHabilidade = nomeDaHabilidade;
    }

    //ToString
    @Override
    public String toString() {
        return nomeDaHabilidade;
    }
}
