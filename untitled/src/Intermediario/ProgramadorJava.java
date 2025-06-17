package Intermediario;

public class ProgramadorJava extends Programador implements BomEmPOO{

    public ProgramadorJava(String nome, int idade) {
        super(nome, idade);
    }

    //Novo construtor atualizado.



    public ProgramadorJava(int anosDeExperiencia, Senioridade senioridade, String nome, int idade) {
        super(anosDeExperiencia, senioridade, nome, idade);
    }

    @Override
    public void dizendoSeEstaEmpregado() {
        System.out.println("Estou empregado");
    }

    @Override
    public void dizendoLinguagem() {
        System.out.println("Meu nome é " + getNome() + " Estou usando JAVA como linguagem " + "e atualmente sou de " +
                "senioridade " + senioridade);
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println("Eu sou bom em POO");
    }
}
