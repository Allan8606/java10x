package Avancado;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("João", "joao@joao.com", 19, "8591234-5678"));
        clientes.add(new Cliente("Jose", "jose@jose.com", 17, "8591234-5678"));
        clientes.add(new Cliente("Maria", "maria@maria.com", 22, "8591234-5678"));
        clientes.add(new Cliente("Theo", "teho@theo.com", 16, "8591234-5678"));

        //Jeito com mais código, sem Streams
        for(int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getNome().equals("João")) {
                System.out.println(clientes.get(i));
            }
       }

        //Usando Streams
        //Filtrar
        clientes.stream()
                .filter(cliente -> cliente.getNome().equals("João"))
                .forEach(System.out::println); //Atalho soutc


        System.out.println("-------------------");


        //Ordenar
        clientes.stream()
                .sorted((cliente1, cliente2) -> Integer.compare(cliente1.getIdade(), cliente2.getIdade()))
                .forEach(System.out::println);

        System.out.println("-------------------");


        clientes.stream()
                .sorted((cliente1, cliente2) -> cliente1.getNome().compareTo(cliente2.getNome()))
                .forEach(System.out::println);

        System.out.println("-------------------");

        //Mapear
        clientes.stream().map(Cliente::getNome)
                .forEach(System.out::println);


        System.out.println("-------------------");

        //Usanod MAX
        Cliente clientesFiltrados = clientes.stream()
                .max((cliente1, cliente2) -> Integer.compare(cliente1.getIdade(), cliente2.getIdade()))
                .orElse(null);

        System.out.println("Cliente mais velho: " + clientesFiltrados);

    }
}
