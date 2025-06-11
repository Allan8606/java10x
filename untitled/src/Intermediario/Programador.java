package Intermediario;

public abstract class Programador implements EmpregadoOuNao {


    //TODO: Incluir novos atributos: cidade e estado.
    //TODO: Senioridade é um enum vai informar se o programador eh junior, pleno ou senior. Enum é algo controlado e fixo, ou seja, ele vai ser o mesmo em todos os programas.
    int anosDeExperiencia;
    Senioridade senioridade;

    String nome;
    int idade;

    public Programador(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    //TODO: Sobrecarga do construtor, chamando os novos atributos.
    //Sobrecarga de métodos não precisa redeclarar o construtor, apenas os novos atributos.
    public Programador(int anosDeExperiencia, Senioridade senioridade, String nome, int idade) {
        this.anosDeExperiencia = anosDeExperiencia;
        this.senioridade = senioridade;
        this(nome, idade); // Só é preciso refeenciar desa maneira, pois eles já foram declarados acima no primeiro
        // construtor.
    }


    public void dizendoLinguagem() {
        System.out.println("Meu nome é " + nome + " Estou usando Tal como linguagem " + "e atualmente sou de " +
                "senioridade " + senioridade);
    }

    @Override
    public void tempoQueEstaDesempregado() {
        System.out.println("Você está a muito tempo desempregado");
    }

    @Override
    public void tempoQueEstaDesempregado(int anosDesempregado) {
        if (anosDesempregado > 5) {
            System.out.println("ATENÇÃO, você já está a muito tempo desempregado");
    }else {
            System.out.println(" Vocé tem menos de 5 anos de desemprego");
        }
    }
}
