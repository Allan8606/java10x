package Desafios.heranca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lendoDados = new Scanner(System.in);
        Ninja ninja = new Ninja();
        TipoDeNinja ninja1 = new TipoDeNinja();

        System.out.println("Deseja criar um ninja? (Sim - Para criar um ninja / Não - Para sair): ");
        var escolhaUsuario = lendoDados.nextLine();

        ninja.escolha(escolhaUsuario);


        while (escolhaUsuario.equalsIgnoreCase("Sim")) {
            System.out.println("Você pode digitar sair a qualquer momento.");
            System.out.println("---------------------------");

            System.out.println("Qual o nome do seu ninja: ");
            ninja1.nome = lendoDados.nextLine();
            ninja1.confereNome(ninja1);

            System.out.println("Qual a missão do seu ninja: ");
            ninja1.missao = lendoDados.nextLine();
            ninja1.confereMissao(ninja1);

            System.out.println("Qual o nivel de dificuldade da missão: ");
            ninja1.nivelDificuldade = lendoDados.nextLine();
            ninja1.confereNivelDificuldade(ninja1);

            System.out.println("Qual o status da missão do seu ninja: ");
            ninja1.statusMissao = lendoDados.nextLine();
            ninja1.confereStatus(ninja1);

            ninja1.confereIdade();

            System.out.println("Seu ninja tem alguma habilidade especial? (Sim / Não): ");
            ninja1.escolhaSeTemHabilidadeEspecial = lendoDados.nextLine();
            ninja1.confereEscolhaHabilidade();


            System.out.println("---------------------------");

            System.out.println("Deseja criar outro ninja? (Sim - Para criar um ninja / Não - Para sair): ");
            escolhaUsuario = lendoDados.nextLine();
            ninja1.escolha(escolhaUsuario);


            System.out.println("---------------------------");

            ninja1.mostrarInformacoes();
        }
    }
}
