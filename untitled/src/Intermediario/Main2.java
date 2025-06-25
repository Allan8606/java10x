package Intermediario;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        //Sem usar Records.
        CadastroDeProgramador cadastro1 = new CadastroDeProgramador("Jose Arthur", 18, "Java");
        System.out.println(cadastro1.apresentando());

        //Usando Records.
        CadastroRecord cadastro2 = new CadastroRecord("Allan Isaac", 32, "JavaScript");
        System.out.println(cadastro2.apresentando());


        //Array
        //São estaticos e tem referencia de memoria.
        String[] nomesProgramdoresArray = new String[3];
        nomesProgramdoresArray[0] = "Jose Arthur"; // adicionando o nome do programador

        //List
        //São dinamicos, crescem conforme a necessidade.
        List<String> nomesProgramadoresList = new ArrayList<>();
        nomesProgramadoresList.add("Allan Isaac"); // adicionando o nome do programador

        //Stack
        // O ultimo elemento adicionado é o primeiro a ser removido.
        Stack<String> nomesProgramadoresStack = new Stack<>();
        nomesProgramadoresStack.push("Allan Isaac"); // adicionando o nome do programador
        nomesProgramadoresStack.push("Jose Arthur"); // adicionando o nome do programador
        nomesProgramadoresStack.push("Theo");

        nomesProgramadoresStack.pop();//Vai retirar o ultimo elemento adicionado, que é o "Theo"
        System.out.println(nomesProgramadoresStack.peek());//vai mostrar o ultumo elemento adicionado, que é o "Jose
        // Arthur", pois o Theo foi retirado com o pop.
        System.out.println(nomesProgramadoresStack.size());// vai mostrar o tamanho da pilha, que é 2, pois o Theo foi retirado.


        //Queue
        //O primeiro a chegar é o primeiro a sair.
        Queue<String> nomesProgramadoresQueue = new LinkedList<>();
        nomesProgramadoresQueue.add("Jose Arthur"); // adicionando o nome do programador
        nomesProgramadoresQueue.add("Allan Isaac"); // adicionando o nome do programador
        nomesProgramadoresQueue.add("Theo");
        System.out.println(nomesProgramadoresQueue);
        nomesProgramadoresQueue.poll();//Vai retirar o primeiro elemento adicionado, que é o "Jose Arthur".
        System.out.println(nomesProgramadoresQueue);
        System.out.println(nomesProgramadoresQueue.peek());

        if (nomesProgramadoresQueue.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("A fila não está vazia.");
        }


    }
}
