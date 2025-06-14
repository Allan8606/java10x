import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();
        Scanner scanner = new Scanner(System.in);
        TipoConta tipoConta = null;





        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("Depositar");
            System.out.println("Sacar");
            System.out.println("Transferir");
            System.out.println("Saldo");
            System.out.println("Sair");

            String opcao = scanner.nextLine().trim();


            if (opcao.equalsIgnoreCase("sair")) {
                System.out.println("Obrigado por utilizar nossos serviços!");
                System.out.println("Saindo...");
                break;


            } else if (opcao.equalsIgnoreCase("depositar")) {
                try {
                System.out.println("Em qual conta deseja depositar? ");
                System.out.println("Conta Corrente");
                System.out.println("Conta Poupança");
                String escolhaDaConta = scanner.nextLine().trim().toUpperCase();
                tipoConta = TipoConta.valueOf(escolhaDaConta);

                    if (tipoConta == TipoConta.CORRENTE) {
                        System.out.println("Digite o valor que deseja depositar: ");
                        double valorDoDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        cc.depositar(valorDoDeposito);
                        System.out.println("----------------------");
                    }
                    if (tipoConta == TipoConta.POUPANCA) {
                        System.out.println("Digite o valor que deseja depositar: ");
                        double valorDoDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        cp.depositar(valorDoDeposito);
                        System.out.println("----------------------");
                    }
                }catch (IllegalArgumentException e) {
                        System.out.println("Opção inválida!");
                        System.out.println("----------------------");
                }

            } else if (opcao.equalsIgnoreCase("sacar")) {
                try{
                    System.out.println("Em qual conta deseja sacar? ");
                    System.out.println("Conta Corrente");
                    System.out.println("Conta Poupança");
                    String escolhaDaConta = scanner.nextLine().trim().toUpperCase();
                    tipoConta = TipoConta.valueOf(escolhaDaConta);

                    if (tipoConta == TipoConta.CORRENTE) {
                        System.out.println("Digite o valor que deseja sacar: ");
                        double valorDoSaque = scanner.nextDouble();
                        scanner.nextLine();
                        cc.sacar(valorDoSaque);
                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("----------------------");
                    }
                    if (tipoConta == TipoConta.POUPANCA) {
                        System.out.println("Digite o valor que deseja sacar: ");
                        double valorDoSaque = scanner.nextDouble();
                        scanner.nextLine();
                        cp.sacar(valorDoSaque);
                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("----------------------");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Opção inválida!");
                    System.out.println("----------------------");
                }

            } else if (opcao.equalsIgnoreCase("saldo")) {

                try{
                    System.out.println("Em qual conta deseja ver o saldo? ");
                    System.out.println("Conta Corrente");
                    System.out.println("Conta Poupança");
                    String escolhaDaConta = scanner.nextLine().trim().toUpperCase();
                    tipoConta = TipoConta.valueOf(escolhaDaConta);

                    if (tipoConta == TipoConta.CORRENTE){
                        cc.consultarSaldo();
                    }
                    if (tipoConta == TipoConta.POUPANCA) {
                        cp.consultarSaldo();
                        System.out.println("----------------------");
                    }

                }catch (IllegalArgumentException e) {
                    System.out.println("Opção inválida!");
                    System.out.println("----------------------");
                }
            } else if (opcao.equalsIgnoreCase("transferir")) {
                try {
                    System.out.println("Escolha a conta de origem: ");
                    System.out.println("Conta Corrente");
                    System.out.println("Conta Poupança");
                    String escolhaDaConta = scanner.nextLine().trim().toUpperCase();
                    tipoConta = TipoConta.valueOf(escolhaDaConta);

                    if (tipoConta == TipoConta.CORRENTE) {
                        System.out.println("Qual o valor que deseja transferir? ");
                        double valorDaTransferencia = scanner.nextDouble();
                        scanner.nextLine();
                        cc.saldo -= valorDaTransferencia;
                        System.out.println("Transferência realizada com sucesso!");
                        cp.saldo += valorDaTransferencia;
                        System.out.println("----------------------");
                    }
                    if (tipoConta == TipoConta.POUPANCA) {
                        System.out.println("Qual o valor que deseja transferir? ");
                        double valorDaTransferencia = scanner.nextDouble();
                        scanner.nextLine();
                        cp.saldo -= valorDaTransferencia;
                        System.out.println("Transferência realizada com sucesso!");
                        cc.saldo += valorDaTransferencia;
                        System.out.println("----------------------");
                    }


                }catch (IllegalArgumentException e) {
                    System.out.println("Opção inválida!");
                    System.out.println("----------------------");
                }

            }
        }
    }
}