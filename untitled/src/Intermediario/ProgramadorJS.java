package Intermediario;

public class ProgramadorJS extends Programador implements BomEmFrontEnd {

    public ProgramadorJS(String nome, int idade) {
        super(nome, idade);
    }

    public ProgramadorJS(int anosDeExperiencia, Senioridade senioridade, String nome, int idade) {
        super(anosDeExperiencia, senioridade, nome, idade);
    }

    @Override
    public void bomEmDesigner() {
        System.out.println("Eu sou bom em Designer");
    }
    //TODO:Sobrecarga de método
    @Override
    public void bomEmDesigner(String habilidade) {
        if (habilidade == "Ux/UI"){
            System.out.println("Você é bom em Designer de Ux/UI");
        }else {
            System.out.println("Eu sou bom em Designer");
        }
    }


    @Override
    public void dizendoLinguagem() {
        System.out.println("Meu nome é " + nome + " Estou usando Java Script como linguagem " + "e atualmente sou de " +
                "senioridade " + senioridade);
    }

    @Override
    public void dizendoSeEstaEmpregado() {
        System.out.println("Estou empregado");
    }


    @Override
    public void habilidadeFontEnd() {
        System.out.println("Eu sou bom em FrontEnd");

    }


}
