package Introducao;

public class Arrays {
    public static void main(String[] args) {

        //Quando sei a quantidade de elementos que vou ter no meu array
        String [][] profisoesNomes = new String[3][3];

        profisoesNomes[0][0] = "Programador";
        profisoesNomes[0][1] = "Allan";
        profisoesNomes[0][2] = "Alguem";

        profisoesNomes[1][0] = "Estudante";
        profisoesNomes[1][1] = "Jose Arthur";
        profisoesNomes[1][2] = "Alguem";

        profisoesNomes[2][0] = "Estagiario";
        profisoesNomes[2][1] = "Theo";
        profisoesNomes[2][2] = "Alguem";

        System.out.println(profisoesNomes[0][1]);


        for (int i = 0; i < profisoesNomes.length; i++) {
            System.out.println(profisoesNomes[i][0]);
            System.out.println(profisoesNomes[i][1]);
            System.out.println(profisoesNomes[i][2]);
        }




    }
}
