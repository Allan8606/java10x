package br.com.allandev.CadastroDeNinjas.Ninjas;

import br.com.allandev.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity trasforma a classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro_ninjas") // Define o nome da tabela no banco de dados
@NoArgsConstructor // cria um construtor sem argumentos.
@AllArgsConstructor // cria um construtor com todos os argumentos.
@Data // Gera os métodos getters, setters, equals, hashCode e toString automaticamente
public class NinjaModel {

    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que o valor será gerado automaticamente pelo banco de dados
    Long id;

    private String nome;
    private String email;
    private int idade;

    //Um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;
}
