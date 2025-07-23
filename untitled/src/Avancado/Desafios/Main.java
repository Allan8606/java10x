package Avancado.Desafios;

import Avancado.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("João", "joao@joao.com", 19, "8591234-5678"));
        clientes.add(new Cliente("Jose", "jose@jose.com", 17, "8591234-5678"));
        clientes.add(new Cliente("Maria", "maria@maria.com", 22, "8591234-5678"));
        clientes.add(new Cliente("Theo", "teho@theo.com", 16, "8591234-5678"));


        clientes.stream()
                .filter(clienteMaior -> clienteMaior.getIdade() >= 18)
                .map(Cliente::getNome)
                .forEach(System.out::println);

        System.out.println("-------------------");

        clientes.stream()
                .sorted((c1, c2) -> c1.getNome().compareTo(c2.getNome()))
                .map(Cliente::getNome)
                .forEach(System.out::println);


        System.out.println("-------------------");

        Cliente clientesFiltrados = clientes.stream()
                .min((c1, c2) -> Integer.compare(c1.getIdade(), c2.getIdade()))
                .orElse(null);

        System.out.println("Cliente mais novo: " + clientesFiltrados.getNome() + " - " + clientesFiltrados.getIdade() + " anos");

        System.out.println("-------------------");

        clientes.stream()
                .filter(clienteMaior -> clienteMaior.getIdade() < 18)
                .forEach(cliente -> System.out.println("Cliente menor de idade: " + cliente.getNome() + " - " + cliente.getIdade()));




    }

}
