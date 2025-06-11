package Introducao;

import java.util.Scanner;

public class LacosDeRepeticoes {
    public static void main(String[] args) {

        /*Laços de Repetições
        int numeroDePassos = 0;


        while (numeroDePassos < 10) {
            System.out.println("estou dando um passo");
            numeroDePassos++;

        }

        System.out.println("---------------");

        for (int i = 0; i < 10; i++) {
            System.out.println("estou dando um passo");
        }
        */


        Scanner scanner = new Scanner(System.in);

        int senha = 1234;
        int numeroMaximoDeTentativas = 5;

        int senhaDigitada;
        boolean senhaCorreta = false;

        for (int i = 0; i < numeroMaximoDeTentativas; i++) {
            System.out.println("Digite sua senha: ");
            senhaDigitada = scanner.nextInt();

            if (senhaDigitada == senha) {
                System.out.println("Senha correta!");
                senhaCorreta = true;
                break;
            } else {
                System.out.println("Senha incorreta!");
            }
        }

        if (!senhaCorreta) {
            System.out.println("Tentativas esgotadas!");
        }


    }
}
