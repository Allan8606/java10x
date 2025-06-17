package Intermediario;

public class ProgramadorPyton extends Programador {


    public ProgramadorPyton(String nome, int idade) {
        super(nome, idade);
    }

    public ProgramadorPyton(int anosDeExperiencia, Senioridade senioridade, String nome, int idade) {
        super(anosDeExperiencia, senioridade, nome, idade);
    }

    @Override
    public void dizendoLinguagem() {
        System.out.println("Meu nome é " + getNome() + " Estou usando Python como linguagem " + "e atualmente sou de " +
                "senioridade " + senioridade);
    }

    @Override
    public void dizendoSeEstaEmpregado() {
        System.out.println("Não estou empregado");
    }
}
