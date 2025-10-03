package Intermediario;

public record CadastroRecord(String nome, int idade, String Stack) {
    public String apresentando() {
        return "Olá, meu nome é " + nome + ", tenho " + idade + " anos e minha stack é " + Stack;
    }
}
