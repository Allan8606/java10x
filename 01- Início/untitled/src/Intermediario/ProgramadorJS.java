package Intermediario;

public class ProgramadorJS extends Programador implements EstaEmpregado{


    public ProgramadorJS() {
    }

    public ProgramadorJS(Senioridade senioridade, String nome, int anosDeExperiencia, int idade) {
        super(senioridade, nome, anosDeExperiencia, idade);
    }


    /*
    * Método:
    * Implementa a Interface EstaEmpregado
    * */
    @Override
    public void dizendoSeEstaEmpregado() {
        System.out.println("Sim, estou empregado como Programador JS");
    }
}
