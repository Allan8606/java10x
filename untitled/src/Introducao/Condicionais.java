package Introducao;

import java.util.Scanner;

public class Condicionais {
    public static void main(String[] args) {

        Scanner lerUsuario = new Scanner(System.in);
        System.out.println("Diga seu nome: ");
        String nome = lerUsuario.nextLine();

        System.out.println("Diga sua idade: ");
        int idade = lerUsuario.nextInt();

        System.out.println("Você é um programador? (use apenas true ou false)");
        boolean programador = lerUsuario.nextBoolean();

        System.out.println("Você tem experiência? (use apenas true ou false)");
        boolean experiencia = lerUsuario.nextBoolean();



        /* Essa condicional vai dizer se a pessoa for programador e tiver
         * experiência. Vai ou não precisar de estágio.

        if (experiencia && programador) {
            System.out.println("Parabéns, " + nome + "! Você pode ser contratado, sem precisar passar por um estágio!");
        } else if (!programador) {
            System.out.println(nome + ", você vai precisar virar um programador primeiro.");

        } else {
            System.out.println(nome + ", você vai precisar passar por um estágio.");
        }
        */

        //Ternario
        String menssagem = experiencia && programador ? "Parabéns, " + nome + "! Vocé pode ser contratado, sem precisar passar por um estágio!" : "Vocé vai precisar passar por um estágio.";
        System.out.println(menssagem);





        System.out.println("--------------------------------");

        //Switch case
        System.out.println("Diga sua linguagem favorita: ");
        System.out.println("1 - Java");
        System.out.println("2 - Python");
        System.out.println("3 - C++");

        int linguagem = lerUsuario.nextInt();

        switch (linguagem) {
            case 1:
                System.out.println("Voce escolheu Java");
                break;
            case 2:
                System.out.println("Voce escolheu Python");
                break;
            case 3:
                System.out.println("Voce escolheu C++");
                break;
            default:
                System.out.println("Linguagem inválida");
                break;

        }
        lerUsuario.close();
    }
}
