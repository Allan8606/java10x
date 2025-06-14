public class ContaPoupanca extends ContaBancaria {



    @Override
    public void depositar(double valor) {
        double taxaDeposito = valor * 0.01;
        valor = valor - taxaDeposito;
        System.out.println("O valor depositado foi: R$" + valor);
        System.out.println("A taxa de deposito referente ao valor depositado, é de " + "R$" + taxaDeposito);

        saldo += valor;

    }

    @Override
    public void sacar(double valor) {
        if (saldo < 0){
            System.out.println("Atenção, seu saldo está negativo!");
        } else if (saldo == 0) {
            System.out.println("Seu saldo está ZERADO!");
        }else {
            saldo -= valor;
        }
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Seu saldo atual na conta poupança é: R$" + saldo);
    }
}
